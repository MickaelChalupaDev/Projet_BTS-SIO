/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author FroggyTeam
 */
public class Audio {
    // Déclaration des attributs de la classe
    /*
     * L'objet clip de la classe Clip permet de travailler sur des sons
     * String son est le chemin du son à jouer
     */
    
    private static Clip clip;
    private String son;
    
    // Constructeur
    /*
     * Ce constructeur prend en paramètre une String song qui est le chemin du 
     * son à jouer.
     * 
     * L'objet audio de la classe AudioInputStream va charger le fichier donné 
     * en paramètre puis l'ouvre.
     * 
     */
    public Audio(String song) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        
        this.son=song;
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File(son));
        this.clip = AudioSystem.getClip();
        this.clip.open(audio);
    }
    //Getter
    public Clip getClip(){return this.clip;}
    
    // Cette méthode permet de lancer la lecture du fichier 
    public void play(){clip.start();}
    
    // Cette méthode permet de stopper la lecture du son en cours 
    public static void stop(){clip.stop();}
    
    /* Dans cette méthode on prend en paramètre le son à jouer, on crée un nouvel objet Audio 
     * puis on execute la méthode play() afin de jouer le son/musique 
     */
    public static void playSound(String song) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        Audio s = new Audio(song);
        s.play();
    }
}
