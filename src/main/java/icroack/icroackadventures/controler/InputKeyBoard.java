/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.view.FlappyFrog;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author FroggyTeam
 * Cette classe controle les inputs utilisateurs 
 * afin d'interagir sur le mini-jeu FlappyFrogg
 * à l'appui de la touche E la méthode keyPressed 
 * va appeler la méthode up de la classe FlappyCharacter
 * qui permet d'élever la position en Y du personnage
 */
public class InputKeyBoard implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        // Ces méthodes ne sont pas implémentées mais nécessaire 
        // car elles doivent être surchargées
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_E){ //Lors de l'appui sur la touche e
            System.out.println("appui sur e");
            FlappyFrog.fScene.fCharacter.up(); //appel de la méthode up => le personnage monte de 50 px de hauteur
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
