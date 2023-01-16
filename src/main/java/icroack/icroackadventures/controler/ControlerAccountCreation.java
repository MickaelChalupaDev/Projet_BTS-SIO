/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

/**
 *
 * @author FroggyTeam
 * Cette classe permet de créer un compte, elle 
 * a accès à la BDD et va y ajouter de nouveaux utilisateurs
 * elle vérifie également si le nom d'utilisateur renseigné 
 * existe déjà ou non.
 */

import icroack.icroackadventures.model.DAOIcare;
import icroack.icroackadventures.view.AccountCreation;
import icroack.icroackadventures.view.Login;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ControlerAccountCreation {
    // Déclaration des attributs de la classe
    private DAOIcare DAOicare;
    private String login;
    private String password;
    private String passwordConfirmation;

    private ConfigReader cf = new ConfigReader();

    // Contructeur de la classe 
    /*
     * Prend en paramètre : 
     * pseudo = Pseudonyme renseigné par l'utilisateur dans le JTextField de la vue AccountCreation
     * mdp = Mot de passe renseigné par l'utilisateur dans le JPasswordField de la vue AccountCreation
     * pwdconfirmation = Confirmation du mot de passe renseigné par l'utilisateur dans le JPasswordField de la vue AccountCreation
     * ac = Objet AccountCreation -> La vue de création des comptes
     */
    
    public ControlerAccountCreation(String pseudo, String mdp,String pwdConfirmation, AccountCreation ac) throws ClassNotFoundException, SQLException {

        this.DAOicare = new DAOIcare(cf.getDbName(),cf.getLogin(),cf.getPassword());

        // récupération du pseudo
        this.login = pseudo;
        // récupération du password
        this.password = mdp;
        // récupération du mdp de confirmation
        this.passwordConfirmation = pwdConfirmation ;

       if (!isEmpty()) {


           /*------------------------ REQUETE PREPARE : récupération et insertion  --------------------------*/

           // query pour vérifier si un pseudo est déja existant
           String strCheck = "SELECT login FROM player WHERE login = ?";
           // query pour insérer les nouvelle données à la BDD
           String strInsert = "INSERT INTO player(login,password) VALUES(? , ? );";

           // Prepare la requête de sélection des comptes
           PreparedStatement myQuery_select = this.DAOicare.getConn().prepareStatement(strCheck);
           myQuery_select.setString(1,this.login);
           ResultSet rsUsers = myQuery_select.executeQuery();

           // Prepare la requête d'insertion
           PreparedStatement myQuery_insert = this.DAOicare.getConn().prepareStatement(strInsert);
           myQuery_insert.setString(1,this.login);
           myQuery_insert.setString(2,this.password);




           /*------------------------ REQUETE PREPARER --------------------------*/

           // Parcours du ResultSet rsUsers
           while (rsUsers.next()){
               
               /* Dans le cas où une correspondance est trouvée : 
                * 
                * On affiche un JOptionPane contenant un message à l'attention de l'utilisateur 
                * On ferme la connection à la DB
                */
               if(rsUsers.getString("login").equals(this.login)) {
                   JOptionPane.showMessageDialog(null, "Ce pseudo existe déjà, merci d'en utiliser un autre.");
                   this.DAOicare.getConn().close();
               }
            }
            /*
             * Dans le cas où les mot de passe fournis par l'utilisateur correspondent (mdp + vérif.)
             * on execute la requête d'insertion 
             * on affcihe un message à l'attention de l'utilisateur
             * on crée ensuite un nouvel objet l de type Login => Vue connexion
             * on ferme en libérant la mémoire l'objet ac (AccountCreation)
             * on rend visite l'objet l (Login)
             * on tue la connexion à la DB
             * Si les deux mots de passe ne correspondent pas on affiche un message à l'attention de l'utilisateur
             */
            
            if(Objects.equals(this.password, this.passwordConfirmation)) {    // si les deux password sont identiques, alors insertion à la BDD
                try {
                    
                    myQuery_insert.executeUpdate(); // Execution de la requête
                    JOptionPane.showMessageDialog(null, "Création du compte validée, Bon jeu!");
                    Login l = new Login();
                    ac.dispose();
                    l.setVisible(true);
                    
                }catch (SQLException e) {
                       e.printStackTrace();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                this.DAOicare.getConn().close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Les deux mots de passe ne sont pas les mêmes, merci de renseigner des mots de passe identiques.");
            }
        }
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    //Cette méthode permet de vérifier si un des champs est vide 
    public boolean isEmpty(){
        boolean empty=false;
        if (this.login.equals("") || this.password.equals("") || this.passwordConfirmation.equals("")){
            JOptionPane.showMessageDialog(null,"Au moins un des champs n'est pas renseigné, merci de remplir tous les champs");
            empty=true;
        }

        return empty;
    }
}
 

