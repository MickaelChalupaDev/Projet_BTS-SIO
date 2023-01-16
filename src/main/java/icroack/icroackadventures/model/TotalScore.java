/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import icroack.icroackadventures.controler.ConfigReader;
import icroack.icroackadventures.controler.ControlerQuizz;
import icroack.icroackadventures.view.Game;
import icroack.icroackadventures.view.ViewTicTacToe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pierre
 * Cette classe permet le calcul du score et l'envoi à la BDD
 * elle comprend 3 méthodes + les getters & setters
 *
 */
public class TotalScore {

    /* totalScore est une variable static, elle est appelée
     * à chaque action modifiant sa valeur.
     */
    public static int totalScore;
    private static ConfigReader cf = new ConfigReader();
    /*
     * Constructeur de la classe
     */
    public TotalScore() throws IOException {
        this.totalScore = 0;
    }

    // Getters & Setters
    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    // Méthode defineScore, calcul le score du joueur
    public void defineScore(Game g){
            totalScore = FlappyScene.getfIngameScore() + ControlerQuizz.getqIngameScore() + ViewTicTacToe.cptTotal;
    }

    // Méthode setLabelScore : définit le score dans un JLabel présent sur la frame Game
    // elle est appelée à chaque appui du bouton rollDice
    public void setLabelScore(Game g){
        g.labScore.setText(""+this.totalScore);
    }

    // Méthode d'envoi du score à la BDD, elle est appelée lorsque le personnage arrive sur la
    // dernière case
    public static void sendToDB(String login) throws SQLException, ClassNotFoundException{
        String driverLoad = "com.mysql.cj.jdbc.Driver";
        String dbName = cf.getDbName();
        String dbLogin = cf.getLogin();
        String dbPassword = cf.getPassword();
        String url = "jdbc:mysql://localhost:3306/"+dbName;
        
        // Création de la requête 
        String query = "UPDATE player SET score_game = "+totalScore+" WHERE login = '"+login+"';";
        
        // Execution de la requête
        Class.forName(driverLoad);
        Connection connection = DriverManager.getConnection(url, dbLogin, dbPassword);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
    
    
}
