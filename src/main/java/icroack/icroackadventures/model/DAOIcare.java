/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FroggyTeam
 * La classe DAO du jeu, elle permet de se connecter à a base de donnée
 */
public class DAOIcare {
    private String dbName;
    private String login;
    private String mdp;
    private String strUrl ="jdbc:mysql://localhost:3306/";
    private String strClassName ="com.mysql.cj.jdbc.Driver";



    Connection conn;
    static Statement stUser;


    // CONSTRUCTEUR
    public DAOIcare(String dbName, String login, String mdp) throws SQLException, ClassNotFoundException {
        this.dbName = dbName;
        this.login = login;
        this.mdp = mdp;


        // LOG BDD
        Class.forName(strClassName);
        this.conn = DriverManager.getConnection(this.strUrl + this.dbName+"?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ,login,mdp);
        stUser = conn.createStatement();
        // LOG BDD
    }
    


    public static Statement getStUser() {return stUser;}
    public Connection getConn() {return conn;}
    
    // Méthode de récupération des identifiants 
}
