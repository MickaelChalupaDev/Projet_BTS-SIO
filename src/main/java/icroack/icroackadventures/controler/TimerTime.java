/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.view.Game;

/**
 *
 * @author FroggyTeam
 * Cette classe correspond au timer général du jeu
 * Il s'agit d'un thread qui compte les secondes passées, 
 * convertie les secondes en minutes puis les minutes en heure.
 * 
 */
public class TimerTime extends Thread{
    // Déclaration des attributs 
    public static int second = 0;
    public static int minutes = 0;
    public int hours = 0;
    public String t;
    public boolean launch = false;
    
    // Constructeur vide (par défaut)
    public TimerTime(){
    }
    
    // Getters & Setters
    public int getS() {return second;}
    public static void setS(int s) {TimerTime.second = s;}
    public int getM() {return minutes;}
    public static void setM(int m) {TimerTime.minutes = m;}
    
    // Méthode run() permet le lancement du thread
    /*
     * Tant que l'attribut minutes est inf. à 3600 (une heure)
     *  minutes s'incrémente de 1 à chaque passage de boucle
     *     Si second passe à 60 alors on incrémente minutes de 1
     *        on repasse second à 0 
     *     On met à jour en static le label du chrono
     *  On endort le thread pendant 1000 milliseconds => Une minute
     *
     */
    public void run(Game g){
        while(second<3600){
            
            second++;
            if(second > 59){
                second = 0;
                minutes++;
            }if(second < 10){
                //Game.chronoLabel.setText(hours+":"+minutes+":"+second);
                g.chronoLabel.setText(hours+":"+minutes+":"+second);
            }else{
                //Game.chronoLabel.setText(hours+":"+minutes+":"+second);
                g.chronoLabel.setText(hours+":"+minutes+":"+second);
            }if(minutes>60){
                minutes=0;
                hours++;
                //Game.chronoLabel.setText(hours+":"+minutes+":"+second);
                g.chronoLabel.setText(hours+":"+minutes+":"+second);
            }try{
                sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    
}
