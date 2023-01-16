/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;


import icroack.icroackadventures.controler.ControlerQuizz;
import icroack.icroackadventures.controler.TimerTime;
import icroack.icroackadventures.view.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author FroggyTeam
 * Cette classe est propre au personnage :
 * L'image du personnage est un JLabel chargé dans la classe
 * ViewBoard, à travers cette classe on va influencer directement sur la position 
 * du JLabel en X et Y en fonction du résultat du dés.
 * 
 */
// images à jour ;
public class Character {
    /*
     * Déclaration des attributs de la classe Character
     * xPosCharacter : position en X du JLabel character
     * yPosCharacter : position en Y du JLabel character
     * oldXPosCharacter : ancienne position en X du character
     * oldYPosCharacter : ancienne positione en Y du character
     * moveCounter : définit le numéro de case sur laquelle se trouve le personnage
     */
    
    public static int xPosCharacter;
    public static int yPosCharacter;
    public static int oldXPosCharacter;
    public static int oldYPosCharacter;
    static int moveCounter;

    private boolean alreadyPassed;


    // Constructeur de la classe Charachter
    public Character(){
        /*
         * La position de départ du personnage est initialisée dans le
         * constructeur, elle correspond à x = 262 et y = 30
         */
        this.xPosCharacter = 263;
        this.yPosCharacter =  30;
        this.oldXPosCharacter = 0;
        this.oldYPosCharacter = 0;
        this.moveCounter = 0;
        this.alreadyPassed = false;
    }

    // Getters & Setters
    public static int getxPosCharacter() {return xPosCharacter;}

    public static void setxPosCharacter(int xPosCharacter) {Character.xPosCharacter = xPosCharacter;}

    public static int getyPosCharacter() {return yPosCharacter;}

    public static void setyPosCharacter(int yPosCharacter) {Character.yPosCharacter = yPosCharacter;}
    
    
    // Méthodes de la classe :
    
    /*
     * Cette méthode permet de déplacer le personnage sur la board
     * en réalité le personnage se déplace en X et Y sur l'ensemble de la Frame générée par
     * la classe Game.
     * Elle prend en paramétre : 
     * -> int diceResult : un entier correspondant au score du dés
     * -> TimerTime tt : le thread principal correspondant au chrono général
     * -> JLabel jb : qui correspond au JLabel du lancement de dés
     * -> Game g : la Frame Game afin d'interagir avec le plateau
     * 
     * A l'appel de la méthode un nombre compris entre 1 et 10 est généré, il permet
     * de déterminer le mini-jeu qui sera lancé au passage sur une case mini-jeu
     * 
     * A chaque appel on récupérer le résultat du dés que l'on incrémente à l'ancienne
     * valeur de moveCounter afin de déterminer le numéro de la case sur laquelle se trouve le personnage
     * et ainsi défnir la position en X et Y
     * 
     * A l'arrivée sur la dernière case on arrête le chrono principal
     */
    public void moveCharacter(int diceResult, TimerTime tt, JLabel jb, Game g) throws IOException, SQLException, ClassNotFoundException{
        int randMin = 1 ;
        int randMax = 100;

        Random rand = new Random();

        int chooseGame = rand.nextInt(randMax - randMin + 1) + randMin;

        System.out.println("Rand = "+ Integer.valueOf(chooseGame));
        moveCounter = moveCounter + diceResult;
        
            if(moveCounter == 1){
                Character.xPosCharacter= 353;
                Character.yPosCharacter = 30;
            }
            if(moveCounter == 2){
                RollUp rp = new RollUp();
                rp.setVisible(true);
                if(chooseGame <=33){
                    FlappyFrog ff = new FlappyFrog();
                    ff.setVisible(true);
                }else if( chooseGame >33 && chooseGame <= 66){
                    ControlerQuizz cq = new ControlerQuizz();
                    cq.start();
                }else{
                    ViewTicTacToe vt = new ViewTicTacToe();
                    vt.fenetre();
                }
                moveCounter = 5;
                Character.xPosCharacter = 623;
                Character.yPosCharacter = 120;
            }
            if(moveCounter == 3){
                RollBack rb = new RollBack();
                rb.setVisible(true);
                moveCounter = 1;
                Character.xPosCharacter = 263;
                Character.yPosCharacter = 30;
            }
            if(moveCounter == 4){
                Character.xPosCharacter = 623;
                Character.yPosCharacter = 30;
            }
            if(moveCounter == 5){
                if(chooseGame <=33){
                    FlappyFrog ff = new FlappyFrog();
                    ff.setVisible(true);
                }else if( chooseGame >33 && chooseGame <= 66){
                    ControlerQuizz cq = new ControlerQuizz();
                    cq.start();
                }else{
                    ViewTicTacToe vt = new ViewTicTacToe();
                    vt.fenetre();
                }
                Character.xPosCharacter = 623;
                Character.yPosCharacter = 120;

            }
            if(moveCounter == 6){
                Character.xPosCharacter = 623;
                Character.yPosCharacter = 210;
            }
            if(moveCounter == 7){
                RollBack rb = new RollBack();
                rb.setVisible(true);
                moveCounter = 5;
                Character.xPosCharacter = 623;
                Character.yPosCharacter = 30;
            }
            if(moveCounter == 8){
                Character.xPosCharacter = 533;
                Character.yPosCharacter = 300;
            }
            if(moveCounter == 9){
                RollUp rp = new RollUp();
                rp.setVisible(true);
                if(chooseGame <=33){
                    FlappyFrog ff = new FlappyFrog();
                    ff.setVisible(true);
                }else if( chooseGame >33 && chooseGame <= 66){
                    ControlerQuizz cq = new ControlerQuizz();
                    cq.start();
                }else{
                    ViewTicTacToe vt = new ViewTicTacToe();
                    vt.fenetre();
                }
                moveCounter = 12;
                Character.xPosCharacter = 263;
                Character.yPosCharacter = 390;
            }
            if(moveCounter == 10){
                Character.xPosCharacter = 353;
                Character.yPosCharacter = 300;
            }
            if(moveCounter == 11){
                RollBack rb = new RollBack();
                rb.setVisible(true);
                moveCounter = 8;
                Character.xPosCharacter = 533;
                Character.yPosCharacter = 300;
            }
            if(moveCounter == 12){
                if(chooseGame <=33){
                    FlappyFrog ff = new FlappyFrog();
                    ff.setVisible(true);
                }else if( chooseGame >33 && chooseGame <= 66){
                    ControlerQuizz cq = new ControlerQuizz();
                    cq.start();
                }else{
                    ViewTicTacToe vt = new ViewTicTacToe();
                    vt.fenetre();
                }
                Character.xPosCharacter = 263;
                Character.yPosCharacter = 390;
            }
            if(moveCounter == 13){
                moveCounter = 16;
                Character.xPosCharacter = 443;
                Character.yPosCharacter = 570;
            }
            if(moveCounter == 14){
                Character.xPosCharacter = 263;
                Character.yPosCharacter = 570;
            }
            if(moveCounter == 15){
                RollBack rb = new RollBack();
                rb.setVisible(true);
                moveCounter = 12;
                Character.xPosCharacter = 263;
                Character.yPosCharacter = 390;
            }
            if(moveCounter == 16){
                Character.xPosCharacter = 443;
                Character.yPosCharacter = 570;
            }
            if(moveCounter == 17){
                moveCounter = 20;
                Character.xPosCharacter = 803;
                Character.yPosCharacter = 570;
            }
            if(moveCounter == 18){
                Character.xPosCharacter = 623;
                Character.yPosCharacter = 570;
            }
            if(moveCounter == 19){
                if(chooseGame <=33){
                    FlappyFrog ff = new FlappyFrog();
                    ff.setVisible(true);
                }else if( chooseGame >33 && chooseGame <= 66){
                    ControlerQuizz cq = new ControlerQuizz();
                    cq.start();
                }else{
                    ViewTicTacToe vt = new ViewTicTacToe();
                    vt.fenetre();
                }
                Character.xPosCharacter = 713;
                Character.yPosCharacter = 570;

            }
            if(moveCounter == 20){
                Character.xPosCharacter = 803;
                Character.yPosCharacter = 570;
            }
            if(moveCounter == 21){
                if(chooseGame <=33){
                    FlappyFrog ff = new FlappyFrog();
                    ff.setVisible(true);
                }else if( chooseGame >33 && chooseGame <= 66){
                    ControlerQuizz cq = new ControlerQuizz();
                    cq.start();
                }else{
                    ViewTicTacToe vt = new ViewTicTacToe();
                    vt.fenetre();
                }
                Character.xPosCharacter = 803;
                Character.yPosCharacter = 480;
            }
            if(moveCounter == 22){
                Character.xPosCharacter = 803;
                Character.yPosCharacter = 390;
            }
            if(moveCounter == 23){
                RollBack rb = new RollBack();
                rb.setVisible(true);
                moveCounter = 20;
                Character.xPosCharacter = 803;
                Character.yPosCharacter = 570;
            }
            if(moveCounter >= 24){
                Character.xPosCharacter = 893;
                Character.yPosCharacter = 300;
                jb.setVisible(false);
                tt.stop();
                Player.sendToDB(Player.connectedUser);
            }
        
    }
}   

