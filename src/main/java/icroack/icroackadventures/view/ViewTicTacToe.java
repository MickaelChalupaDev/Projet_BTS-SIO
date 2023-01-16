package icroack.icroackadventures.view;
/**
 * @author FroggyTeam
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class ViewTicTacToe extends JPanel implements ActionListener {

    JFrame frame = new JFrame("Tic Tac Toe");

    // variables logic
    public boolean Firstgame;
    public boolean playerX;
    public int playerIA = 2;
    public boolean IA = false;
    public boolean gameDone = false;
    public int winner = -1;

    //compteur de partie
    public int nbPartie = 0;
    public static int cptTotal = 0;
    public int player1wins = 0;
    public int player2wins = 0;

    //declaration de partie
    public int[][] board = new int[3][3];

    // variables pour dessin
    public int lineWidth = 5;
    public int lineLength = 270;
    public int x = 15, y = 100; // location of first line
    public int offset = 95; // square width
    public int a = 0;
    public int b = 5;
    public int selX = 0;
    public int selY = 0;

    // Couleurs
    Color turtle = new Color(0x80bdab);
    Color orange = new Color(0xfdcb9e);
    Color offwhite = new Color(0xf7f7f7);
    Color darkgray = new Color(0x3f3f44);

    // COMPONENTS
    JButton jButton;
    JButton buttonEndGame ;

    // CONSTRUCTEUR
    public ViewTicTacToe() throws IOException {
        Dimension size = new Dimension(420, 300);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        /* CREATION DU BOUTON REJOUER */
        addMouseListener(new XOListener());
        jButton = new JButton("Rejouer ?");
        jButton.addActionListener(this);
        jButton.setBounds(615, 210, 100, 30);
        add(jButton);
        this.resetGame();

    }

    /* METHODE POUR LA JFRAME */
    public void fenetre() throws IOException {

        //ViewGame view = new ViewGame();
        frame.getContentPane();

        ViewTicTacToe gamePanel = new ViewTicTacToe();
        frame.add(gamePanel);

        /* AJOUT DE SCORE EN FICHIER TEXTE */ //voir si c'est util pour la BDD (à modifier évidemment)
        /*frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                try {
                    File file = new File("score.txt");
                    Scanner sc = new Scanner(file);
                    gamePanel.setPlayerXWins(Integer.parseInt(sc.nextLine()));
                    gamePanel.setPlayerOWins(Integer.parseInt(sc.nextLine()));
                    sc.close();
                } catch (IOException io) {
                    // file doesnt exist
                    File file = new File("score.txt");
                }
            }

            public void windowClosing(WindowEvent e) {
                try {
                    PrintWriter pw = new PrintWriter("score.txt");
                    pw.write("");
                    pw.write(gamePanel.player1wins + "\n");
                    pw.write(gamePanel.player2wins + "\n");
                    pw.close();
                } catch (FileNotFoundException e1) { }
            }
        });*/
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //récuperer la taille de l'écran
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;
        //taille est un demi la longueur et l'hauteur
        frame.setSize(width/3, height/3);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);

    }

    /* METHODE POUR LA REMISE A ZERO DU PLATEAU */
    public void resetGame() {
        playerX = true;
        winner = -1;
        gameDone = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0; // toues les case sont vidées
            }
        }
        getJButton().setVisible(false);
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        drawBoard(page);
        drawUI(page);

        try {
            this.drawGame(page);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* METHODE POUR DESSINER LA GRILLE DE JEU */
    public void drawBoard(Graphics page) {
        setBackground(turtle);
        page.setColor(darkgray);
        page.fillRoundRect(x, y, lineLength, lineWidth, 5, 30);
        page.fillRoundRect(x, y + offset, lineLength, lineWidth, 5, 30);
        page.fillRoundRect(y, x, lineWidth, lineLength, 30, 5);
        page.fillRoundRect(y + offset, x, lineWidth, lineLength, 30, 5);
    }

    /* METHODE POUR CREER LA PARTIE DE DROITE */
    public void drawUI(Graphics page) {
        // def des couleurs et de la police d'écriture
        page.setColor(darkgray);
        page.fillRect(300, 0, 120, 300);
        Font font = new Font("Helvetica", Font.PLAIN, 20);
        page.setFont(font);

        // COMPTEUR DE POINTS
        page.setColor(offwhite);
        page.drawString("Points", 330, 30);
        page.drawString(": " + player1wins * 100, 362, 70);
        page.drawString(": " + player2wins * 100, 362, 105);

        //score X
        ImageIcon xIcon = new ImageIcon("resource/orangex.png");
        Image xImg = xIcon.getImage();
        Image newXImg = xImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon newXIcon = new ImageIcon(newXImg);
        page.drawImage(newXIcon.getImage(), 44 + offset * 1 + 190, 47 + offset * 0, null);

        //score O
        page.setColor(offwhite);
        page.fillOval(43 + 190 + offset, 80, 30, 30);
        page.setColor(darkgray);
        page.fillOval(49 + 190 + offset, 85, 19, 19);

        // a qui le tour ou vainqueur
        page.setColor(offwhite);
        Font font1 = new Font("Serif", Font.ITALIC, 18);
        page.setFont(font1);

        if (gameDone) {
            if (winner == 1) { //  JOUEUR x
                page.drawString("Le gagnant est", 310, 150);
                page.drawImage(xImg, 335, 160, null);
            } else if (winner == 2) { //  IA
                page.drawString("Le gagnant est", 310, 150);
                page.setColor(offwhite);
                page.fillOval(332, 160, 50, 50);
                page.setColor(darkgray);
                page.fillOval(342, 170, 30, 30);
            } else if (winner == 3) { // MATCH NULL
                page.drawString("Match null", 320, 178);
            }
        } else {
            if (playerX) {
                Font font2 = new Font("Serif", Font.ITALIC, 20);
                page.setFont(font2);
                page.drawString("C'est a ", 335, 160);
                page.drawString("X de jouer", 320, 180);

            } else {
                page.drawString("O de jouer", 320, 180);
            }

        }
        // LOGO
        Image froggy = Toolkit.getDefaultToolkit().getImage("resource/logo.png");
        page.drawImage(froggy, 335, 225, 50, 50, this);
        Font c = new Font("Courier", Font.BOLD + Font.CENTER_BASELINE, 13);
        page.setFont(c);
        page.drawString("ICROAK", 335, 280);
    }

    /* METHODE QUI DESSINE LES JOUEURS */
    public void drawGame(Graphics page) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {

                } else if (board[i][j] == 1) {
                    ImageIcon xIcon = new ImageIcon("resource/orangex.png");
                    Image xImg = xIcon.getImage();
                    page.drawImage(xImg, 30 + offset * i, 30 + offset * j, null);
                } else if (board[i][j] == playerIA) {
                    IA = true;
                    page.setColor(offwhite);
                    page.fillOval(30 + offset * i, 30 + offset * j, 50, 50);
                    page.setColor(turtle);
                    page.fillOval(40 + offset * i, 40 + offset * j, 30, 30);
                }
            }
        }
        repaint();
    }

    /* METHODE QUI VERIFIE SI IL Y A UN GAGNANT */
    public void checkWinner() throws InterruptedException, IOException {
        if (gameDone) {
            System.out.print("gameDone");
            return;
        }
        // vertical
        int temp = -1;
        if ((board[0][0] == board[0][1])
                && (board[0][1] == board[0][2])
                && (board[0][0] != 0)) {
            temp =  board[0][0];
        } else if ((board[1][0] == board[1][1])
                && (board[1][1] == board[1][2])
                && (board[1][0] != 0)) {
            temp = board[1][1];
        } else if ((board[2][0] == board[2][1])
                && (board[2][1] == board[2][2])
                && (board[2][0] != 0)) {
            temp = board[2][1];

            // horizontal
        } else if ((board[0][0] == board[1][0])
                && (board[1][0] == board[2][0])
                && (board[0][0] != 0)) {
            temp = board[0][0];
        } else if ((board[0][1] == board[1][1])
                && (board[1][1] == board[2][1])
                && (board[0][1] != 0)) {
            temp = board[0][1];
        } else if ((board[0][2] == board[1][2])
                && (board[1][2] == board[2][2])
                && (board[0][2] != 0)) {
            temp = board[0][2];

            // diagonal
        } else if ((board[0][0] == board[1][1])
                && (board[1][1] == board[2][2])
                && (board[0][0] != 0)) {
            temp = board[0][0];
        } else if ((board[0][2] == board[1][1])
                && (board[1][1] == board[2][0])
                && (board[0][2] != 0)) {
            temp = board[0][2];
        } else {

            // CHECK FOR A TIE
            boolean notDone = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        notDone = true;
                        break;
                    }
                }
            }
            if (notDone == false) {
                temp = 3;
            }
        }
        if (temp > 0) {
            winner = temp;
            if (winner == 1) {
                player1wins++;
                nbPartie++;
                System.out.println("Joueur gagne");
            } else if (winner == playerIA) {
                player2wins++;
                nbPartie++;
                System.out.println("IA gagne ");
            } else if (winner == 3) {
                System.out.println("Match null");
                nbPartie++;
            }
            gameDone = true;
            getJButton().setVisible(true);
        }

        //condition de fin de partie
        if (nbPartie == 3){
            getJButton().setVisible(false);
            buttonEndGame().setVisible(true);

            if((player1wins > player2wins) && (player1wins >=2)){
                cptTotal = player1wins * 100 ;
                //System.out.println("Vous avez gagne");
            }else if((player2wins > player1wins) && (player2wins >= 2)){
                cptTotal = player2wins * 100 ;
                //System.out.println("IA vous a battu");
            }else if(player2wins == player1wins){
                //System.out.println("Match null");
            }
        }
    }

    /* METHODE POUR L'IA */
    public void IA(){
        /* declaration d'un random pour l'IA */ //à voir si il est réellement fontionnel
        Random rand = new Random();
        int min = 1, max = 100;
        int random = rand.nextInt(max - min + 1) + min;
        //System.out.println(random);
        IA = true;
        if (!gameDone) {
            int degre = 0; // degré max
            int pos = 0; // condition de victoir du degré
            for (int i = 0; i < 8; i++) {
                int e = 0; // nombres d'ennemis
                int a = 0; // nombres d'alliés
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        e++; // incrémentation d'ennemis
                    } else if (board[i][j] == 2) {
                        a++; // incrémentation d'allié
                    }

                    /* CALCUL DU DEGRE */
                    int d = 0; // degré courant

                    if (e == 2 && a == 2) {d = 5;} // attaque la plus forte
                    else if (e == 2 && a == 0) {d = 4;} // defence la plus forte
                    else if (e == 0 && a == 2) {d = 3;} // attaque un peu moins forte
                    else if (e == 1 && a == 1) {d = 2;} // defence un peu moins forte
                    else if (e == 0 && a == 0) {d = 1;} // et rien du tout

                    if (d > degre) { // calcul du degré courant
                        degre = d;
                        pos = i;
                    } else if (d == degre) {
                        if (random > 1) {
                            pos = i;
                        }
                    }
                }

                /* CALCUL DU CAS OU IL N'Y A QU'UNE SEULE CASE A CHANGER */
                if (degre == 5 || degre == 4 || degre == 0) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 0) { // cas ou si c'est vide
                            board[i][j] = playerIA; // placement du rond
                            return;
                        }
                    }
                }
                /* CALCUL DU CAS OU IL Y A DEUX CASES A CHOISIR */
                else if (degre == 3 || degre == 2) {
                    boolean passed = false;
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 0) {
                            if (!passed) { // on a passé une des cases
                                if (random < 100) {
                                    board[i][j] = playerIA;
                                    return;
                                } else
                                    passed = true; // cas ou si on a passé le premier
                            } else {
                                board[selX][selY] = playerIA;
                                return;
                            }
                        }
                    }
                } else {
                    /* CAS OU IL Y A TROIS CASES A VERIFIER */
                    int passed = 0;
                    for (int j = 0; j < 3; j++) {
                        if (board[selX][selY] == 0) {
                            if (passed != 2) {
                                if (random < 50) {
                                    board[selX][selY] = playerIA;
                                    return;
                                } else
                                    passed++;
                            } else {
                                board[selX][selY] = playerIA;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public JButton getJButton() { return jButton; }

    /* METHODE CREATION DU BOUTON FIN DE PARTIE */
    public JButton buttonEndGame() throws IOException {
        /* CREATION DU BOUTON ENDGAME */
        buttonEndGame = new JButton("Quitter");
        buttonEndGame.setBounds(615, 210, 100, 30);
        add(buttonEndGame);
        buttonEndGame.setVisible(false);
        buttonEndGame.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });
        return buttonEndGame;
    }

    public void setPlayerXWins(int a) {
        player1wins = a;
    }

    public void setPlayerOWins(int a) {
        player2wins = a;

    }

    /* METHODE POUR L' ECOUTE DES ACTIONS DE LA SOURIS */
    public class XOListener implements MouseListener {
        public void mouseClicked(MouseEvent event) {
            selX = -1;
            selY = -1;
            if (!gameDone) {
                //IA();
                a = event.getX();
                b = event.getY();
                int selX = 0, selY = 0;
                if (a > 12 && a < 99) {
                    selX = 0;
                } else if (a > 103 && a < 195) {
                    selX = 1;
                } else if (a > 200 && a < 287) {
                    selX = 2;
                } else {
                    selX = -1;

                }

                if (b > 12 && b < 99) {
                    selY = 0;
                } else if (b > 103 && b < 195) {
                    selY = 1;
                } else if (b > 200 && b < 287) {
                    selY = 2;
                } else {
                    selY = -1;

                }

                if (selX != -1 && selY != -1) {
                    if (board[selX][selY] == 0) {
                        if (playerX) {
                            board[selX][selY] = 1;
                            try {
                                checkWinner();
                                IA();
                                checkWinner();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    //System.out.println(" CLICK= x:" + a + ",y: " + b + "; selX,selY: " + selX + "," + selY);
                } else {
                    System.out.println("invalid click");
                }
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        resetGame();
    }
}