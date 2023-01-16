/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import icroack.icroackadventures.controler.ConfigReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author FroggyTeam
 * Cette classe permet de se connecter à la BDD et de récupérer l'ensemble des
 * questions utilisées par la suite dans le QCM
 */
public class DAOQuizz {

    Question question; // instance de la class Question
    private DAOIcare DAOicare;
    private java.util.ArrayList ArrayList;
    private ConfigReader cf;

    // ATTRIBUT

    // CONSTRUCTEUR
    public DAOQuizz() throws SQLException, ClassNotFoundException {
        this.cf = new ConfigReader();
      this.DAOicare = new DAOIcare(cf.getDbName(), cf.getLogin(), cf.getPassword());
    }
    // CONSTRUCTEUR

    //  METHODE

    /*------------------------------- RECUPERATION DES OBJETS QUESTIONS -----------------------------------*/

    public java.util.ArrayList<Question> listerDAO() throws SQLException, ClassNotFoundException {

        java.util.ArrayList<Question> tab_objet_question = new ArrayList<Question>(); // LISTE DE OBJET QUESTION
        java.util.ArrayList<Question> tab_question = new ArrayList<Question>(); // LISTE DES QUESTION DE l'OBJET QUESTION

        String strQuery = "SELECT question,quizzAnswers FROM quizz";
        ResultSet rsUsers = this.DAOicare.getStUser().executeQuery(strQuery); // EXECUTE LA REQUETE


        while (rsUsers.next()) { // PARCOURIR LES CHAMPS
            Question question = new Question(rsUsers.getString("question"),rsUsers.getInt("quizzAnswers")); // Nouvelle instance de QUESTION(ID,QUESTION,ANWERS) via la BDD
            tab_objet_question.add(question); // INSERTION DES OBJETS QUESTIONS DANS LA LISTE
        }

        Collections.shuffle(tab_objet_question); // MELANGER ORDRE DES OBJETS QUESTIONS DANS LA LISTE

        for(int i = 0; i < 6; i++){
            tab_question.add(tab_objet_question.get(i)); //  J'INSERE 5 OBJETS QUESTIONS DANS MA LISTE VIDE
        }

        return tab_question;
    }
}
