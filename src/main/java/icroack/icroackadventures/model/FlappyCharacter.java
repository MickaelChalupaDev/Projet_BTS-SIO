/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author FroggyTeam
 * Cette classe définit tout ce qui est relatif au personnage 
 * du mini jeu FlappyFrogg
 * Ici sont chargées les images et les positions en X et Y.
 */
public class FlappyCharacter {
    // Attributs de la classe 
    private int width ;
    private int height ;
    private int xPos;
    private int yPos;
    private int travelYPos ;
    private String strImg ;
    
    private ImageIcon icoCharacter;
    private Image imgCharacter;
    
    private final int HALT = 10;
    
    // Constructeur
    public FlappyCharacter(int x, int y, String strImg){
        this.width = 34;
        this.height = 24;
        this.xPos = x;
        this.yPos = y;
        this.strImg = strImg;
        this.icoCharacter = new ImageIcon(this.strImg);
        this.imgCharacter = this.icoCharacter.getImage();
        
    }
    
    // Getters & Setters 

    public int getWidth() {return width;}

    public void setWidth(int width) {this.width = width;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}

    public int getxPos() {return xPos;}

    public void setxPos(int xPos) {this.xPos = xPos;}

    public int getyPos() {return yPos;}

    public void setyPos(int yPos) {this.yPos = yPos;}

    public Image getImgCharacter() {return imgCharacter;}

    public void setImgCharacter(Image imgCharacter) {this.imgCharacter = imgCharacter;}
    
    
    // Méthodes 
    
    // Permet de faire monter le personnage
    public void up(){
        this.travelYPos = 50;
        this.yPos = this.yPos - this.travelYPos;
    }
    
    // Détecte les collisions
    public boolean collide(FlappyTubes fpt){
        //RAPPEL : y et x pour une image sont situés dans le coin supérieur gauche
        if(fpt.getY() < 50){//Test collision avec un tuyaux haut
            /* Si la position en y du perso et inf ou egale à la pos en y + la haut du tuyaux 
             * ET que la position en x du perso + la larg du perso et sup ou égale à la pos en X du tuyaux
             * ET que la position en y du person est inf ou égale à la position en x du tuyaux + la largeur du tuyaux
             * Renvoie collision à vraie
             */
            if(this.yPos <= fpt.getY() + fpt.getHeight() && this.xPos + this.width >= fpt.getX() && this.yPos <= fpt.getX() + fpt.getWidth()){  
                return true; // retourne collision à vraie
            }else return false; // retourne collision à faux
        }else{ //sinon test avec un tuyaux bas
            if(this.yPos + this.height >= fpt.getY() && this.xPos + this.width >= fpt.getX() && this.xPos <= fpt.getX() + fpt.getWidth()){
                return true; 
            }else{return false;}
        } 
    }

    //@Override
    /*public void run() {
        while(true){
            this.fly(this.travelYPos);
            this.travelYPos--;
            try {
                Thread.sleep(HALT);
            } catch (InterruptedException ex) {}
            
        }
    }
    
    /*private void fly(int travelYpos){
       String strBird1 = "C:\\Users\\Pierre\\OneDrive\\#4_ProjetPerso\\IcroackAdventures\\IcroackAdventures\\src\\main\\java\\resource\\bird1.png" ;
       String strBird2 = "C:\\Users\\Pierre\\OneDrive\\#4_ProjetPerso\\IcroackAdventures\\IcroackAdventures\\src\\main\\java\\resource\\bird2.png" ;
       if(travelYpos > 10){
           this.icoCharacter = new ImageIcon(strBird2);
           this.imgCharacter = this.icoCharacter.getImage();
           this.travelYPos = this.yPos - 3;
       }else if(travelYpos > 5){
           this.yPos = this.yPos - 2;
       }else if(travelYpos > 1){
           this.yPos = this.yPos - 1;
       }else if(travelYpos == 1){
           this.icoCharacter = new ImageIcon(strBird1);
           this.imgCharacter = this.icoCharacter.getImage();
       }
    }*/
}
