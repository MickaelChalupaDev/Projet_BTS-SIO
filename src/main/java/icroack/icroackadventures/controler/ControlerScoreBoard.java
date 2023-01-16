/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.view.LeaderBoard;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author FroggyTeam
 *
 */
public class ControlerScoreBoard {
    
    // Déclaration des attributs
    String query;
    String driverLoad;
    String url ;
    String dbName ;
    String dbLogin ;
    String dbPassword ;
    Connection connection ;
    Statement statement;
    ResultSet resultSet;

    private ConfigReader cf = new ConfigReader();
    static ArrayList<LinkedList> rankList;



    
    public ControlerScoreBoard(LeaderBoard lb) throws ClassNotFoundException, SQLException{
        // Début de la connection à la DB
        this.driverLoad = "com.mysql.cj.jdbc.Driver";
        this.dbName = cf.getDbName();
        this.dbLogin = cf.getLogin();
        this.dbPassword = cf.getPassword();
        this.url = "jdbc:mysql://localhost:3306/"+this.dbName;
        
        // Création de la requête 
        this.query = "SELECT login, score_game FROM player ORDER BY score_game DESC";
        
        // Execution de la requête
        Class.forName(this.driverLoad);
        this.connection = DriverManager.getConnection(url, dbLogin, dbPassword);
        this.statement = connection.createStatement();
        this.resultSet = statement.executeQuery(query);
        
        // Mise en place des résultats dans une LinkedList : Correspond à un tableaux à deux dimensions
        int cpt = 0;
        this.rankList = new ArrayList<LinkedList>();

        while(resultSet.next()){
            this.rankList.add(new LinkedList());  // Création d'une nouvelle LinkedList pour chaque itération du resultSet
            this.rankList.get(cpt).add(cpt + 1); // Placement du numéro 1, puis 2, puis 3, etc.
            this.rankList.get(cpt).add(resultSet.getString("login")); // Stockage à l'index 1 de la LinkedList du login
            this.rankList.get(cpt).add(resultSet.getInt("score_game")); // Stockage à l'index 2 de la LinkedList du score
            cpt++;
        }
        
        // Définition du texte dans les JLabel de LeaderBoard (objet lb)
        // pour les noms
        lb.labName1.setText(rankList.get(0).get(1).toString());
        lb.labName2.setText(rankList.get(1).get(1).toString());
        lb.labName3.setText(rankList.get(2).get(1).toString());
        lb.labName4.setText(rankList.get(3).get(1).toString());
        lb.labName5.setText(rankList.get(4).get(1).toString());
        
        // pour les scores
        lb.ldbLabGold.setText(rankList.get(0).get(2).toString());
        lb.ldbLabSilver.setText(rankList.get(1).get(2).toString());
        lb.ldbLabCopper.setText(rankList.get(2).get(2).toString());
        lb.ldbLabFour.setText(rankList.get(3).get(2).toString());
        lb.ldbLabFive.setText(rankList.get(4).get(2).toString());
    }
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
 
        LeaderBoard lb = new LeaderBoard();
        ControlerScoreBoard csb = new ControlerScoreBoard(lb);
        lb.setVisible(true);

    }
}
