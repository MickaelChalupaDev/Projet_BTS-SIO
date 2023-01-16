/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author FroggyTeam
 * Cette classe permet de changer le curseur de la souris afin d'en charger un
 * personnalisé (grenouille).
 * Elle doit être instancié dans chaque fenêtre où l'on souhaite changer le curseur
 * Le constructeur prend la frame dans laquelle elle est instnciée afin d'en modifier 
 * le curseur.
 */
public class FroggCursor {
    String cursorNeutral;
    Image imgNeutral;
    Cursor cNeutral;
    public FroggCursor(Frame f) throws IOException{
        
        this.cursorNeutral="resource/cursor.png";
        this.imgNeutral= ImageIO.read(new File(cursorNeutral));
        this.cNeutral = Toolkit.getDefaultToolkit().createCustomCursor(imgNeutral,new Point(0,0),"custom cursor");
        f.setCursor(cNeutral);
        
    }
}
