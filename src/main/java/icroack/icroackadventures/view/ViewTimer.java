/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.view;

import icroack.icroackadventures.controler.TimerTime;

/**
 *
 * @author FroggyTeam
 */
public class ViewTimer {
    public static TimerTime tt;
    
    public ViewTimer(){
        this.tt = new TimerTime();
    }
    public static void startTimer(){
        tt.start();
    }
    public static void restart(){
        tt.notify();
    }
    public void stopTimer() throws InterruptedException{
        tt.wait();
    }
}
