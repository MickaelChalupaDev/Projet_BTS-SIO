/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.view;

import icroack.icroackadventures.controler.InputKeyBoard;
import icroack.icroackadventures.model.FlappyCharacter;
import icroack.icroackadventures.model.FlappyScene;
import icroack.icroackadventures.model.FroggCursor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author FroggyTeam
 */
public class FlappyFrog extends JFrame {
    //Déclaration des variables :
    public static FlappyScene fScene;
    public int finalScore ;
    private JLabel closeFlappy;
    private FroggCursor fc;
    public FlappyFrog() throws IOException {
        // Instance des différents attributs : 
        this.fScene = new FlappyScene(this);
        // Caracteristiques de la fenêtre principale
        //this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0,0,0)));
        this.setUndecorated(true);
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setContentPane(fScene);
        this.addKeyListener(new InputKeyBoard());
        this.finalScore = fScene.score;
        this.fc = new FroggCursor(this);
    }

    //Main 
    public static void main(String[] args) throws IOException{
        FlappyFrog ffg = new FlappyFrog();
        ffg.setVisible(true);
    }
    
}
