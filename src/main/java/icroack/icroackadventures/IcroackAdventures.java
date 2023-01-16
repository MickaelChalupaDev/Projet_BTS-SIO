/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package icroack.icroackadventures;

import icroack.icroackadventures.view.Login;

import java.io.IOException;

/**
 *
 * @author FroggyTeam
 */
public class IcroackAdventures {
    
    public IcroackAdventures(){}

    public static void main(String[] args) {
        Login l = null;
        try {
            l = new Login();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l.setVisible(true);
    }
}
