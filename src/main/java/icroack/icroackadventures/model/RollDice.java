/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import icroack.icroackadventures.view.Game;
import icroack.icroackadventures.view.ViewTimer;
import javax.swing.ImageIcon;


/**
 *
 * @author FroggyTeam
 * Cette classe permet de générer un lancement de dé à 6 faces 
 * Elle permet également de définir l'image qui sera affichée sur la Frame Game
 * dans le JLabel contenant le dernier résultat du lancer.
 */
public class RollDice {
    boolean firstRoll ;
    int resultDice;
    
    //Constructeur
    public RollDice() { 
        this.firstRoll = true;
        this.resultDice = 0;
    }

    public int getResultDice() {return resultDice;}
    public void setResultDice(int resultDice) {this.resultDice = resultDice;}

    //Méthode du dé en ramdom*/
    public int random() {
        resultDice = (int) (Math.random() * 6) + 1;
        return resultDice;
    }
    
    // Cette méthode permet de mettre à jour l'image du dé en fonction du résultat 
    /*
     * Elle prend un entier en paramètre correspondant au résultat du dé
     * Selon le résultat du dé telle ou telle image sera ajoutée.
     */
    public void SetIconDice(int resultRoll){
        int result = resultRoll;
        switch(result){
            case 1 -> Game.lastRollIco.setIcon(new ImageIcon("resource/d1r.png"));
            case 2 -> Game.lastRollIco.setIcon(new ImageIcon("resource/d2r.png"));
            case 3 -> Game.lastRollIco.setIcon(new ImageIcon("resource/d3r.png"));
            case 4 -> Game.lastRollIco.setIcon(new ImageIcon("resource/d4r.png"));
            case 5 -> Game.lastRollIco.setIcon(new ImageIcon("resource/d5r.png"));
            case 6 -> Game.lastRollIco.setIcon(new ImageIcon("resource/d6r.png"));
        }
       //jLabel3.setText(String.valueOf(result));
    }

}
    
