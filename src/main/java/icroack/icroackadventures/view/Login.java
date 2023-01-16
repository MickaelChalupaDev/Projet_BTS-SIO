/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icroack.icroackadventures.view;


import icroack.icroackadventures.controler.ControlerConnection;
import icroack.icroackadventures.model.Player;

import javax.swing.*;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FroggyTeam
 */
public class Login extends javax.swing.JFrame {

    /**
     * Création d'une nouvelle frame Log :
     * Cette classe est le point d'entrée de l'application,
     * elle récupére les entrées utilisateurs pour les envoyer au
     * ControlerConnection qui va déterminer si l'utilisateur est
     * présent dans la BDD ou non.
     * Elle permet également de créer une nouvelle vue permettant la création
     * d'un nouveau compte.
     */

    /*
     * Attribut de la classe (part1)
     */
    private Player p ;

    /* Constructeur de la classe
    *   -> La frame est en undecorated ;
    *   -> initComponent() définit le design de cette frame ;
    *   -> On ajoute une bordure noire à la frame (setBorder)
    *   -> On définit la couleur du ContentPane ;
    *   -> On centre la frame ;
    *   -> On crée un nouvelobjet Player ;
    *   -> On rend la frame visible ;
    * */
    public Login() throws IOException {

        setUndecorated(true);
        initComponents();
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0,0,0)));
        getContentPane().setBackground(new Color(13,94,13));
        setLocationRelativeTo(null);
        this.p = new Player();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        labTitleLog = new javax.swing.JLabel();
        txtFieldLogin = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        labIconLog = new javax.swing.JLabel();
        labIconPass = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Icroak's Adventures");
        setBackground(new java.awt.Color(6, 142, 232));

        labTitleLog.setBackground(new java.awt.Color(6, 142, 232));
        labTitleLog.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labTitleLog.setForeground(new java.awt.Color(255, 255, 255));
        labTitleLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitleLog.setText("Icroack's Adventure !");

        txtFieldLogin.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtFieldLogin.setForeground(new java.awt.Color(8, 60, 8));
        txtFieldLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(8, 60, 8));
        btnLogin.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Connexion");
        btnLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.setBorderPainted(false);
        btnLogin.setName("ConnectButton"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt, p);
            }
        });

        btnCreateAccount.setBackground(new java.awt.Color(8, 60, 8));
        btnCreateAccount.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateAccount.setText("Créer un compte");
        btnCreateAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateAccount.setBorderPainted(false);
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });
        //"C:\\Users\\Pierre\\Desktop\\froglog.png"
        labIconLog.setIcon(new javax.swing.ImageIcon("resource/froglog.png")); // NOI18N

        labIconPass.setIcon(new javax.swing.ImageIcon("resource/logPass.png")); // NOI18N

        passField.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        passField.setForeground(new java.awt.Color(8, 60, 8));
        passField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passField.setToolTipText("");

        btnExit.setBackground(new java.awt.Color(8, 60, 8));
        btnExit.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Quitter");
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitleLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labIconLog, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labIconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passField))
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(labTitleLog, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labIconLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labIconPass, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(passField))
                .addGap(38, 38, 38)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtLogActionPerformed(java.awt.event.ActionEvent evt) {}

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        // A l'appui sur ce bouton, le programme s'arrête
        System.exit(0);
    }

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt, Player p) {
        /*
        * Cette méthode est appelée à l'appui sur le bouton de log :
        *
        * Elle récupére les entrées de l'utilisateur (login, pass)
        * et les envoie au controleur. (ControlerConnection)
        *
        * Elle est ensuite chargée une fois la connexion effectuée
        * de transférer à la classe Player le log du player connecté
        * ainsi que son statut (admin ou non).
        */

        try {
            Boolean isAdmin ;

            //Récupération du contenu des jTextField
            String id = txtFieldLogin.getText().toString();
            String pwd = passField.getText().toString();

            ControlerConnection contConn = new ControlerConnection(id, pwd, this);
            isAdmin = contConn.getAdmin();
            p.setConnectedUser(contConn.getNickname());
            p.setAdmin(isAdmin);

        }
        catch (ClassNotFoundException ex) {ex.printStackTrace();}
        catch (SQLException ex) {ex.printStackTrace();}
        catch (IOException ex) {ex.printStackTrace();}
    }

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {
        /*
        * A l'appui du bouton creation de compte :
        * -> On dispose la frame Log
        * -> On crée une nouvelle frame AccountCreation
        * -> On rend visible la frame AccountCreation
        */

        this.dispose();
        AccountCreation ac = new AccountCreation();
        ac.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /*
    * Déclaration des attributs (part2)
    * Ces attributs sont propres au éléments
    * swing utilisés dans la frame.
    */
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel labTitleLog;
    private javax.swing.JLabel labIconLog;
    private javax.swing.JLabel labIconPass;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField txtFieldLogin;

}
