/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

/**
 *
 * @author FroggyTeam
 * Meh ? Demandez à @Thurston, j'ai pas compris.
 */
public class Question {
    private String question;
    private int anwers;

        public Question(String question, int anwers) {
            this.question = question;
            this.anwers = anwers;
        }

        // ATTRIBUT

        public String getQuestion() {return question;}
        public int getAnwers() {return anwers;}
    
}
