/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.model.DAOIcare;
import icroack.icroackadventures.view.Game;
import icroack.icroackadventures.view.Home;
import icroack.icroackadventures.view.LogError;
import icroack.icroackadventures.view.Login;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FroggyTeam
 * Cette classe permet la connexion à l'application, elle vérifie
 * qu'un utilisateur soit présent dans la DB et si cet utilisateur
 * est administrateur ou non.
 */
public class ControlerConnection {
    // Déclaration des attributs
    private DAOIcare DAOicare;
    private String nickname;
    private String passwd;
    private Boolean isAdmin;
    private Game g;

    private ConfigReader cf = new ConfigReader();

    /*
     * Constructeur ControlerConnection
     * Prend en @params :
     * nickname = String fournie par l'utilisateur correspond au JTextField de Login
     * passwd = String fournie par l'utilisateur correspond au JPasswordField de Login
     * Objet log de type Login correspond à la vue
     */
    public ControlerConnection(String nickname, String passwd, Login log) throws ClassNotFoundException, SQLException, IOException {
        this.DAOicare = new DAOIcare(cf.getDbName(),cf.getLogin(),cf.getPassword());

        this.nickname = nickname;
        this.passwd = passwd;
        this.isAdmin = false;

        /*
         * Vérification de l'existence d'un login dans la DB
         * + vérification de la corrspondance des données (login, password)
         * Si il existe une correspondance :
         *  On ferme cette fenêtre
         *  -> Si l'utilisateur en cours est marqué comme administrateur
         *   -> l'attribut isAdmin passe à true.
         * S'il n'existe pas de correspondance :
         *  -> Affichage de l'erreur de connexion (LogError)
         * On appelle alors dans Log la méthode checkAdmin qui affichera
         * la fenêtre Home avec le bouton d'administration visible ou non.
         */

        if (isEmpty()) {
            String strCheck1 ="SELECT login, password,isAdmin FROM player WHERE login='" + this.nickname
                    + "' AND password = '" + this.passwd +"'";

            ResultSet rsUsers = this.DAOicare.getStUser().executeQuery(strCheck1);

            boolean found=false;
            while (rsUsers.next()) {
                if (rsUsers.getString("login").equals(nickname) && rsUsers.getString("password").equals(passwd)) {
                    found=true;
                    log.dispose();

                    if(rsUsers.getString("isAdmin").equals("1")){
                        isAdmin = true;
                        checkAdmin();
                    }else{
                        isAdmin = false ;
                        checkAdmin();
                    }
                }
            }
            /* Si aucune correspondances alors on renvoie
             * un message d'erreur à l'utilisateur
             */
            if(found==false){
                System.out.println("too");
                LogError lg = new LogError();
                lg.setVisible(true);
                this.DAOicare.getConn().close();
            }


        }
    }

    // Méthode permettant d'interrompre la connexion à la DB
    public void closeConnection() throws SQLException{this.DAOicare.getConn().close();}

    public boolean isEmpty(){
        boolean empty = true;
        if (this.nickname.equals("") || this.passwd.equals("")){
            LogError lg = new LogError();
            lg.setVisible(true);
            empty = false;
        }
        return empty;
    }

    // Méthode check Admin
    public void checkAdmin(){
        Home h = null;
        try {
            h = new Home();
            if (isAdmin) Home.btnAdmin.setVisible(true);
            else Home.btnAdmin.setVisible(false);
            h.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // GETTER & SETTER
    public Boolean getAdmin() {return isAdmin;}

    public String getNickname() {return nickname;}
}
