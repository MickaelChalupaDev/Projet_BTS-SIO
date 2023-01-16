/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.model.FlappyScene;
import icroack.icroackadventures.view.FlappyFrog;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FroggyTeam
 * Cette classe permet le déplacement du fond d'écran du mini-jeu
 * il s'agit d'un thread.
 */

public class ChronoFlappy implements Runnable{
    
    /*Déclaration des attributs de la classe :
     * Cet attribut final correspond au temps de rafraichissement de l'écran 
     * plus il est élevé, plus le jeu sera lent et inverssement
     */
    
    private final int HALT = 5;
    
    /*
     *
     * Override de la méthode run() hérité de Runnable
     * Tant que l'attribut endGame est à false on 
     * diminue la valeur de xBG => Déplacement
     * on redessine l'image
     *
     */
    @Override
    public void run() {
        while(FlappyFrog.fScene.endGame == false){ 
            FlappyFrog.fScene.xBG--; //Accés à xBG en static
            FlappyFrog.fScene.repaint(); //Permet l'actualisation du fond
            
            try {
                Thread.sleep(this.HALT);
            } catch (InterruptedException ex) {}
        }
    }
    
}
