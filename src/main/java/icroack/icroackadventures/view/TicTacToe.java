package icroack.icroackadventures.view;


import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PSurface;

import javax.swing.*;

public class TicTacToe extends PApplet {
    /* VERSION SIMPLE DU JEUX DE MORPION */

    int victoryCpt[][][] = new int[8][3][2]; // tableau de condition de victoires
    int plateau[][] = new int[3][3];         // tableau 2d de 3X3 cases
    int winner = 0;                          // 0= match null, 1= joueur1 a gagné, 2=joueur2 à gagné

    int cptGame = 0;   //compteur pour le nombre de parties maximum de 3
    int cptPlayer = 0; //compteur pour connaître le nombre de parties gagnées du joueur
    int cptIA = 0;     //compteur pour connaître le nombre de parties gagnées par l'IA
    int cptCount = 0;  //compteur pour connaître le score final et de pouvoir s'en servir sur le jeu de l'oie

    boolean over = false; // partie n'est pas perdue de base

    /* METHODE POUR PARAMETRER LA TAILLE DU JEUX */
    public void settings() {
        size(300, 300);
    }

    /* INITIALISATION DES PARAMETRES DU JEUX */
    public void setup() {
        textAlign(CENTER, CENTER);
        textFont(createFont("Arial", 30));

        /* CONDITIONS VERTICALES */
        int c = 0;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                victoryCpt[c][b][0] = a;
                victoryCpt[c][b][1] = b;
                victoryCpt[c + 1][b][0] = b;
                victoryCpt[c + 1][b][1] = a;
            }
            c += 2;
        }

        /* CONDITIONS HORIZONTALES ET OBLIQUES */
        for (int a = 0; a < 3; a++) {
            victoryCpt[6][a][0] = a;
            victoryCpt[6][a][1] = a;
            victoryCpt[7][a][0] = 2 - a;// 2 les 2 obliques
            victoryCpt[7][a][1] = a;
        }
        noLoop(); // empêche le traitement d'exécuter le code en continu
    }

    /* METHODE POUR RECUPERER MA POSITION ET LES CLICS DE LA SOURIS */
    public void mousePressed() {
        if (!over) {
            int X;
            int Y;
            X = (mouseX / 100); // position de la souris sur le plateau
            Y = (mouseY / 100); // position de la souris sur le plateau
            if (plateau[X][Y] == 0) {
                plateau[X][Y] = 1;
                testWin();
                IA();
                testWin();
            }
        }
        /* REMISE A ZERO DU PLATEAU */
        else {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    plateau[x][y] = 0;
                }
            }
            over = false;
            winner = 0;
        }
        redraw();
    }

    /* METHODE DE L'IA */
    public void IA() {
        if (!over) {
            int degre = 0; // degre max
            int pos = 0;    // condition de victoir du degre
            for (int i = 0; i < 8; i++) {
                int e = 0; // nombres d'ennemis
                int a = 0; // nombres d'alliés

                for (int j = 0; j < 3; j++) {
                    if (plateau[victoryCpt[i][j][0]][victoryCpt[i][j][1]] == 1) {
                        e ++; // incrementation d'ennemie

                    } else if (plateau[victoryCpt[i][j][0]][victoryCpt[i][j][1]] == 2) {
                        a ++; // incrementation d'allié
                    }

                    /* CALCUL DU DEGRE */
                    int d = 0; // degré courant
                    if (e == 2 && a == 2) { d = 5; }        // attaque la plus forte
                    else if (e == 2 && a == 0) { d = 4; }   // defence la plus forte
                    else if (e == 1 && a == 0) { d = 3; }   // attaque un peu moins forte
                    else if (e == 1 && a == 1) { d = 2; }   // defence un peu moins forte
                    else if (e == 0 && a == 0) { d = 1; }   // et rien du tout

                    if (d > degre) { // calcul du degré courant
                        degre = d;
                        pos = i;
                    } else if (d == degre) {
                        if (random(100) > 1) {
                            pos = i;
                        }
                    }
                }

                /* CALCUL DU CAS OU IL N'Y A QU'UNE SEULE CASE A CHOISIR */
                if (degre == 5 || degre == 4 || degre == 0) {
                    for (int j = 0; j < 3; j++) {
                        if (plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] == 0) {  // cas ou si c'est vide
                            plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] = 2;     // placement du rond
                            return;
                        }
                    }
                }

                /* CALCUL DU CAS OU IL Y A DEUX CASES A CHOISIR */
                else if (degre == 3 || degre == 2) {
                    boolean passed = false;
                    for (int j = 0; j < 3; j++) {
                        if (plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] == 0) {
                            if (!passed) { // on a passé une des cases
                                if (random(100) < 100) {
                                    plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] = 2;
                                    return;
                                } else passed = true; // cas ou si on a passé le premier
                            } else {
                                plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] = 2;
                                return;
                            }
                        }
                    }
                }

                /* CAS OU IL A TROIS CASES A VERIFIER */
                else {
                    int passed = 0;
                    for (int j = 0; j < 3; j++) {
                        if (plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] == 0) {
                            if (passed != 2) {
                                if (random(100) < 50) {
                                    plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] = 2;
                                    return;
                                } else passed += 1;
                            } else {
                                plateau[victoryCpt[pos][j][0]][victoryCpt[pos][j][1]] = 2;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* METHODE POUR TESTER LES VAINQUEURS */
    public void testWin() {
        for (int i = 0; i < 8; i++) {
            int c = 0;  // compte cumulé des cases
            for (int j = 0; j < 3; j++) {
                if (plateau[victoryCpt[i][j][0]][victoryCpt[i][j][1]] == 1) { // cumule des CROIX
                    c += 1;
                } else if (plateau[victoryCpt[i][j][0]][victoryCpt[i][j][1]] == 2) {  // cumule des RONDS
                    c -= 1;
                }
            }

            /* CONDITION POUR LES CROIX */
            if (c == 3) { // CROIX qui gagne
                over = true;
                winner = 1;
                return;
            }

            /* CONDITION POUR LES RONDS */
            else if (c == -3) { // ROND qui gagne
                over = true;
                winner = 2;
                return;
            }

        }

        /* CONDITION DU MATCH NULL */
        boolean c = true; // onreinitialise le plateau
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (plateau[x][y] == 0){
                    c = false; // partie pas terminée
                    break;
                }
            }
        }
        if (c) over = true; // partie finie
    }

    /* METHODE DE LA PARTIE VISUEL */
    public void draw() {
        background(800); //coulor du background
        noFill();
        stroke(100); // defini la couleur des lignes du plateau de jeu
        strokeWeight(3); // defini  la largeur du trait
        line(100, 10, 100, height - 10); // dessine les lignes
        line(200, 10, 200, height - 10); // dessine les lignes
        line(10, 100, width - 10, 100);  // dessine les lignes
        line(10, 200, width - 10, 200);  // dessine les lignes

        for (int x = 0; x < 3; x++) { // parcourt des X du plateau
            for (int y = 0; y < 3; y++) { // parcourt des Y du plateau
                if (plateau[x][y] == 1) { // 1 = dessin une croix rouge
                    stroke(200, 0, 0);
                    line(20 + x * 100, 20 + y * 100, 80 + x * 100, 80 + y * 100); //dessine de la première diagonale de la croix
                    line(20 + x * 100, 80 + y * 100, 80 + x * 100, 20 + y * 100); //dessine de la seconde diagonale de la croix

                } else if (plateau[x][y] == 2) { // 2 = dessin d'un rond
                    stroke(0, 0, 200);
                    ellipse(50 + x * 100, 50 + y * 100, 60, 60); // dessine un rond
                    noStroke();
                }
            }
        }
        noStroke();


        if(cptGame != 3) {
            if (over) {
                fill(0, 0); // couleur de fond quand un joueur gagne
                rect(0, 0, width, height); // dessine un rectangle

                if (winner == 1) { // victoire du joueur
                    cptPlayer++; //compteur du nombre de partie gagnée par le joueur
                    cptGame++;   // compteur du nombre de partie total jouée

                    fill(255, 0, 0, 0);
                    rect(0, 0, width, height);
                    fill(250);
                    text("Vous avez gagné ! ", width / 2, height / 2); // affichage du message

                } else if (winner == 2) { // victoire de l'IA
                    cptIA++; //compteur du nombre de partie gagnée par l'IA
                    cptGame++;// compteur du nombre de partier total jouée

                    fill(0, 0, 255, 0);
                    rect(0, 0, width, height);
                    fill(250);
                    text("Vous avez perdu... ", width / 2, height / 2); // affichage du message

                } else { // Match Null
                    fill(255);
                    text("Match nul... ", width / 2, height / 2); // affichage du message
                    cptGame++;
                }
            }
        }

        /* CONDITION DE FIN DE PARTIE */
        else{
            over = false;
            background(800); // couleur de fond de la fin de partie
            fill(200); // couleur du message
            partie(); // appel de la méthode "partie"
        }
    }

    /* METHODE DE FIN PARTIE */
    public void partie() {
        if(cptPlayer >=2) {
            delay(500);
            text("Vous avez gagné : ", width / 2, height / 4);
            text(cptPlayer + " parties sur 3", width / 2, height / 2); // texte de fin de partie
            score();  //implémentation de la méthode score
            noLoop(); //implémentation dela méthode noLoop
        }
        else{
            delay(500);
            text("l'IA à gagné : ", width /2 , height /4 );
            text(cptIA+" parties sur 3" , width /2, height / 2); // texte de fin de partie
            score();  //implémentation de la méthode score
            noLoop(); //implémentation dela méthode noLoop
        }
    }

    /* METHODE POUR RECUPERER LE SCORE */ //à confirmer si util pour l'avancement du jeu de l'oie
    public void score() {
        if(cptPlayer >=2){
            cptCount = cptPlayer; // Bonus avance de 2 cases
            //System.out.println(cptCount);
        }
        else{
            cptCount = cptIA; // Malus recule de 2 cases
            //System.out.println(cptCount);
        }
    }

    public void fenetre(){
        // créer votre JFrame
        JFrame frame = new JFrame("TIC TAC TOE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // créer votre croquis
        TicTacToe pt = new TicTacToe();

        // récupère la PSurface à partir de l'esquisse
        PSurface ps = pt.initSurface();

        // initialise la PSurface
        ps.setSize(330, 330);

        // récupère le SmoothCanvas qui contient la PSurface
        PSurfaceAWT.SmoothCanvas smoothCanvas = (PSurfaceAWT.SmoothCanvas)ps.getNative();

        //SmoothCanvas peut être utilisé comme composant
        frame.add(smoothCanvas);

        // rend votre JFrame visible
        frame.setSize(315, 340);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //commence ton croquis
        ps.startThread();

    }

}