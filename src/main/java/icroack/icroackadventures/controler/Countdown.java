/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.view.ViewQuizzII;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author FroggyTeam
 */
public class Countdown{
    ControlerQuizz cq;
    ViewQuizzII vue;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private int countdownStarter = 15;
    public Runnable runnable;

    public Countdown(ControlerQuizz cq, ViewQuizzII vue){
        this.cq = cq;
        this.vue = vue;
        
        this.runnable = new Runnable() {

            public void run() {
               // System.out.println("DECOMPTE :" + getCountdownStarter());
                vue.count.setText(String.valueOf(countdownStarter));
                countdownStarter--;

                if (countdownStarter < 0) { // SI LE COMPTE A REBOURD EST ECOULE ALORS QUESTION SUIVANTE
                    countdownStarter = 15;
                    cq.cpt++;
                }
            }
        };
        this.start();
    }

    public void start(){
        scheduler.scheduleAtFixedRate(this.runnable, 0, 1, SECONDS);
    }

    public void reset(){
        this.setCountdownStarter(15);
    }
    
    public void stop(){
        scheduler.shutdownNow();
        scheduler = null;
        this.runnable = null;
        //this.stop();
    }

    public int getCountdownStarter() {return countdownStarter;}
    public void setCountdownStarter(int countdownStarter) {this.countdownStarter = countdownStarter;}
}

