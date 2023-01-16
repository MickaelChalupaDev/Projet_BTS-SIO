/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;


import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author FroggyTeam
 * Dans cette classe les obstacles sont définis pour le
 * mini-jeu flappyfrogg
 */
public class FlappyTubes {
    // Attributs 
    private int width;
    private int height;
    private int x;
    private int y;
    private String strImg;
    private ImageIcon icoTubes ;
    private Image imgTubes;
    
    // Constructeur
    public FlappyTubes(int x, int y, String strImg){
        this.width = 50 ;
        this.height = 300 ;
        this.x = x ;
        this.y = y ;
        this.strImg = strImg ;
        this.icoTubes = new ImageIcon(strImg);
        this.imgTubes = this.icoTubes.getImage();
    }
    
    // Getters & Setters

    public int getWidth() {return width;}

    public void setWidth(int width) {this.width = width;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public Image getImgTubes() {return imgTubes;}

    public void setImgTubes(Image imgTubes) {this.imgTubes = imgTubes;}
    
}
