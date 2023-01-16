/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.model.DAOIcare;
import icroack.icroackadventures.view.AdminView;

import java.sql.*;


/**
 *
 * @author FroggyTeam
 */
public class AdminControler {
    // Déclaration des attributs de la classe
    DAOIcare daoIcare ;
    String queryLogin ;
    ConfigReader cf ;
    
    /*
     * Constructeur d'AdminControler :
    
     * Appel de la classe DAOIcare où l'on passe en @param
     * la DB, le login, le mot de passe
     * 
     * String queryLogin => Correspond à la requête à executer
     */
    public AdminControler() throws SQLException, ClassNotFoundException{
        this.cf = new ConfigReader();
        this.daoIcare = new DAOIcare(cf.getDbName(),cf.getLogin(),cf.getPassword());
        this.queryLogin = "SELECT login FROM player;";
    }
    
    /*
     * Méthode getAllLog : 
     * Prend en paramètre la vue administrateur (AdminView) nommé adV (objet)
     *
     * Prépare et execute une requête visant à récupérer l'ensemble des logins
     * des joueurs
     * 
     * Actualise pour chaque passage dans le tableau ResultSet rs les éléments 
     * du JComboBox d'AdminView
     */
    public void getAllLog(AdminView adV) throws SQLException{
        
        PreparedStatement ps_select =  this.daoIcare.getConn().prepareStatement(this.queryLogin);
        ResultSet rs = ps_select.executeQuery();
        
        while(rs.next()){
            String log = rs.getString("login").toString();
            adV.jCBAccountList.addItem(log);
        }   
    }
    
    /*
     * Méthode deleteAccount :
     * Prend en paramètre le compte sélectionné dans le JComboBox et la vue administrateur  
     *
     * Prépare et execute une requête visant à supprimer le login selectionné 
     *
     * Une fois que la requête est executée et réussie on transforme le texte du boutton 
     * "supprimer" de l'AdminView à "done !"
     *
     */
    public void deleteAccount(String selectedAccount, AdminView adV) throws SQLException{
        String queryDelete = "DELETE FROM player WHERE login = '" + selectedAccount + "';";
        PreparedStatement ps_delete = this.daoIcare.getConn().prepareStatement(queryDelete);
        ps_delete.executeUpdate();
        adV.btnDeleteAccount.setText("done !");
    }

    //Méthode renameUser :
    /*
     * Cette méhode permet à un administrateur de renommer le compte d'un autre utilisateur
     * elle prend en paramètre le compte sélectionné dans le JOptionPane, le texte rentré dans
     * le JTextField correspondand et la vue administrateur.
     * On execute ensuite une requête préparée afin d'updater la BDD
     * Pour signifier que l'action a fonctionnée, on définit le texte du dit boutton à "done !"
     */
    public void renameUser(String selectedAccount, String newUpdatedLogin ,AdminView adV) throws SQLException {
        String queryRename = "UPDATE player SET login = '"+ newUpdatedLogin +"' WHERE login = '"+ selectedAccount + "';";
        PreparedStatement ps_renameUser = this.daoIcare.getConn().prepareStatement(queryRename);
        ps_renameUser.executeUpdate();
        adV.btnExecRename.setText("done !");
    }

    //Méthode defineNewPass :
    /*
     * Cette méhode permet à un administrateur de modifier le mot de passe d'un autre utilisateur
     * elle prend en paramètre le compte sélectionné dans le JOptionPane, le texte rentré dans
     * le JTextField correspondand et la vue administrateur.
     * On execute ensuite une requête préparée afin d'updater la BDD
     * Pour signifier que l'action a fonctionnée, on définit le texte du dit boutton à "done !"
     */
    public void defineNewPass(String selectedAccount, String newUpdatedPass, AdminView adV) throws SQLException {
        String queryDefineNewPass = "UPDATE player SET password = '"+ newUpdatedPass+"' WHERE login = '"+ selectedAccount+"';" ;
        PreparedStatement ps_defineNewPass = this.daoIcare.getConn().prepareStatement(queryDefineNewPass);
        ps_defineNewPass.executeUpdate();
        adV.btnExecSetPass.setText("done !");
    }

    //Méthode listAccount :
    /*
    * Cette méthode se contente de lister l'ensemble des comptes présent sur la BDD
    * */
    public String listAccount() throws SQLException {
        String accountNumber;
        int counter = 0;
        String queryCount = "SELECT count(*) FROM player;";
        ResultSet rs1= this.daoIcare.getStUser().executeQuery(queryCount);
        rs1.next();
        counter = rs1.getInt(1);
        accountNumber = String.valueOf(counter);
        return accountNumber;
    }

    public static void main(String[] args) {}
}
