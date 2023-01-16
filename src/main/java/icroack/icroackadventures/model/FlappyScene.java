/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import icroack.icroackadventures.controler.ChronoFlappy;
import icroack.icroackadventures.view.FlappyFrog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author FroggyTeam
 */

public class FlappyScene extends JPanel{
    // Attributs de la classe
    // Permet de charger l'image du fond 
    private ImageIcon icoBG ;
    private Image imgBG ;
    private FlappyFrog ffg;
    // Constante pour définir la taille en h & l de l'image de fond
    private final int WIDTH_BG = 140 ;
    private final int HEIGTH_BG = 400 ;
    
    // Permet de connaitre la position en x du fond
    public int xBG;
    
    // Nouveaux objets tuyaux(tubes) 
    public FlappyTubes tubeUpOne;
    public FlappyTubes tubeUpTwo;
    public FlappyTubes tubeUpThree;
    
    public FlappyTubes tubeDownOne;
    public FlappyTubes tubeDownTwo;
    public FlappyTubes tubeDownThree;
    
    // Constante permettant de définir la distance entre chaque tuyaux
    private final int SPACE_BETWEEN_TUBES = 250 ;
    
    // Constante permettant de définir l'espace de passage du personnage
    private final int TUBES_SEPARATOR = 100 ;
    
    private int dxTubes; //gère le déplacement des tuyaux
    private int xTubes; // gère la position des tuyaux dans la fenêtre
    
    private Random hazard;
    
    
    public FlappyCharacter fCharacter;
    
    public int score ;
    public static int fIngameScore;
    private Font font;
    
    
    public boolean endGame;
    
    private JLabel close;

    private JLabel pressE;
    
    
    // Constructeur
    public FlappyScene(FlappyFrog ffp) throws IOException{
        this.setLayout(null);
        this.icoBG = new ImageIcon("resource/bgFlappy.png");
        this.imgBG = this.icoBG.getImage();
        
        this.xBG = 0;
        
        // Code relatif aux tuyaux : 
        
        String strTubeUp = "resource/tubeUp.png" ;
        String strTubeDown = "resource/tubeDown.png" ;
        
        this.xTubes = 400;
        this.dxTubes = 0;
        
        this.tubeUpOne = new FlappyTubes(this.xTubes, -150, strTubeUp);
        this.tubeUpTwo = new FlappyTubes(this.xTubes + this.SPACE_BETWEEN_TUBES, -100, strTubeUp);
        this.tubeUpThree = new FlappyTubes(this.xTubes + this.SPACE_BETWEEN_TUBES * 2, -120, strTubeUp );
        
        this.tubeDownOne = new FlappyTubes(this.xTubes, 250, strTubeDown);
        this.tubeDownTwo = new FlappyTubes(this.xTubes + this.SPACE_BETWEEN_TUBES, 300, strTubeDown);
        this.tubeDownThree = new FlappyTubes(this.xTubes + this.SPACE_BETWEEN_TUBES * 2, 280, strTubeDown);
        
        this.hazard = new Random();
        
        // Code relatif au personnage
        String strCharacter1 = "resource/bird1.png" ;
        
        this.fCharacter = new FlappyCharacter(100,150, strCharacter1);
        
        this.score = 0 ;
        this.font = new Font("Gill Sans Ultra Bold", Font.PLAIN, 14 );

        
        this.endGame = false;
        this.close = new JLabel();
        this.close.setIcon(new ImageIcon("resource/close.png"));
        this.close.setBounds(250,5,50,50);
        this.close.setVisible(false);
        this.close.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeFrame(evt, ffp);
            }
        });
        this.add(close);


        this.pressE = new JLabel("Smash E !");
        pressE.setFont(font);
        pressE.setBounds(100,275,100,70);
        this.add(pressE);

        this.fIngameScore = 0;
        
        // Dépalecement du background
        Thread chronoBG = new Thread(new ChronoFlappy());
        chronoBG.start();
    }
    
    // Méthodes de la classe : 
        
           public void closeFrame(MouseEvent evt, FlappyFrog ffp){ffp.dispose();}
    
    // Méthode a appelée dans paintComponent : gère le déplacment du fond d'écran
    public void travelBG(Graphics g){
        
        if(this.xBG == -this.WIDTH_BG){this.xBG = 0;}
        
        // dessine l'img (imgBG) à l'emplacement x = 0 et y = 0
        g.drawImage(this.imgBG, this.xBG, 0, null);
        
        // dessine un double de l'image à coté de la première img
        g.drawImage(this.imgBG, this.xBG + this.WIDTH_BG, 0, null);
        g.drawImage(this.imgBG, this.xBG + this.WIDTH_BG * 2, 0, null);
        g.drawImage(this.imgBG, this.xBG + this.WIDTH_BG * 3, 0, null);
    }
    
    // Méthode de déplacement des tuyaux
    public void travelTubes(Graphics g){
        // Pour les tuyaux 1 
        this.tubeUpOne.setX(this.tubeUpOne.getX() - 1); // Tuyaux haut décallé vers la gauche
        this.tubeDownOne.setX(this.tubeUpOne.getX()); // Prend l'abscisse du tuyaux haut
        
        if(this.tubeUpOne.getX() == -100){ // Lorsque abcisse du tuyaux 1 égal à -100
            this.tubeUpOne.setX(this.tubeUpThree.getX() + this.SPACE_BETWEEN_TUBES); // est placé à l'abcisse du tuyaux 3 
            this.tubeUpOne.setY(-100 - 10 * this.hazard.nextInt(18)); // permet de définir la hauteur des tuyaux
            this.tubeDownOne.setY(this.tubeUpOne.getY() + this.tubeUpOne.getHeight() + this.TUBES_SEPARATOR);
        }
        g.drawImage(this.tubeUpOne.getImgTubes(), this.tubeUpOne.getX(), this.tubeUpOne.getY(), null); //On dessine les images des tuyaux up et down
        g.drawImage(this.tubeDownOne.getImgTubes(), this.tubeDownOne.getX(), this.tubeDownOne.getY(), null);
        
        // Pour les tuyaux 2 
        this.tubeUpTwo.setX(this.tubeUpTwo.getX() - 1);
        this.tubeDownTwo.setX(this.tubeUpTwo.getX());
        
        if(this.tubeUpTwo.getX() == -100){
            this.tubeUpTwo.setX(this.tubeUpOne.getX() + this.SPACE_BETWEEN_TUBES);
            this.tubeUpTwo.setY(-100 - 10 * this.hazard.nextInt(18));
            this.tubeDownTwo.setY(this.tubeUpTwo.getY() + this.tubeUpTwo.getHeight() + this.TUBES_SEPARATOR);
        }
        g.drawImage(this.tubeUpTwo.getImgTubes(), this.tubeUpTwo.getX(), this.tubeUpTwo.getY(), null);
        g.drawImage(this.tubeDownTwo.getImgTubes(), this.tubeDownTwo.getX(), this.tubeDownTwo.getY(), null);
        
        // Pour les tuyaux 3 
        this.tubeUpThree.setX(this.tubeUpThree.getX() - 1);
        this.tubeDownThree.setX(this.tubeUpThree.getX());
        
        if(this.tubeUpThree.getX() == -100){
            this.tubeUpThree.setX(this.tubeUpTwo.getX() + this.SPACE_BETWEEN_TUBES);
            this.tubeUpThree.setY(-100 - 10 * this.hazard.nextInt(18));
            this.tubeDownThree.setY(this.tubeUpThree.getY() + this.tubeUpThree.getHeight() + this.TUBES_SEPARATOR);
        }
        g.drawImage(this.tubeUpThree.getImgTubes(), this.tubeUpThree.getX(), this.tubeUpThree.getY(), null);
        g.drawImage(this.tubeDownThree.getImgTubes(), this.tubeDownThree.getX(), this.tubeDownThree.getY(), null);
    }
    private boolean flappyCollided(){
       boolean endGame = false;
		// proche tuyau1
		if(this.fCharacter.getxPos() + this.fCharacter.getWidth() > this.tubeDownOne.getX() - 20 && 
				this.fCharacter.getxPos() < this.tubeDownOne.getX() + this.tubeDownOne.getWidth() + 20){
			endGame = this.fCharacter.collide(this.tubeDownOne);
			if(endGame == false){endGame = this.fCharacter.collide(this.tubeUpOne);}
		}else{
			// proche tuyau2
			if(this.fCharacter.getxPos() + this.fCharacter.getWidth() > this.tubeDownTwo.getX() - 20 && 
				this.fCharacter.getxPos() < this.tubeDownTwo.getX() + this.tubeDownTwo.getWidth() + 20){
				endGame = this.fCharacter.collide(this.tubeDownTwo);
				if(endGame == false){endGame = this.fCharacter.collide(this.tubeUpTwo);}			
		    }else{
				// proche tuyau3
			    if(this.fCharacter.getxPos() + this.fCharacter.getWidth() > this.tubeDownThree.getX() - 20 && 
				this.fCharacter.getxPos() < this.tubeDownThree.getX() + this.tubeDownThree.getWidth() + 20){
			    	endGame = this.fCharacter.collide(this.tubeDownThree);
				    if(endGame == false){endGame = this.fCharacter.collide(this.tubeUpThree);}
			}else{
				// contact avec le plafond ou le sol
				if(this.fCharacter.getyPos() < 0 || this.fCharacter.getyPos() + this.fCharacter.getHeight() > 355){endGame = true;}else{endGame = false;}
		        }
		    }
	    }
		return endGame;
        
    }
    
    private void score(){
        if(this.tubeDownOne.getX() + this.tubeDownOne.getWidth() == 95 || this.tubeDownTwo.getX() + this.tubeDownTwo.getWidth() == 95 
                || this.tubeDownThree.getX() + this.tubeDownThree.getWidth() == 95){
            this.fIngameScore = fIngameScore + 100;
            this.score++;
        }
    }

    public static int getfIngameScore() {
        return fIngameScore;
    }

    // Méthode paintComponent : permet de dessiner une image sur un JPanel
    public void paintComponent(Graphics g){
       
       this.endGame = this.flappyCollided();
       this.travelBG(g);
       this.travelTubes(g);
       this.score();
       
       g.setFont(font);
       g.drawString(""+score, 140, 50);
       
       this.fCharacter.setyPos(this.fCharacter.getyPos() + 1);
       g.drawImage(this.fCharacter.getImgCharacter(), this.fCharacter.getxPos(), this.fCharacter.getyPos(), null);
       if(this.endGame == true){g.drawString("Fin du jeu", 100, 200); this.close.setVisible(true);}
    }
    
}
