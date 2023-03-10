/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icroack.icroackadventures.view;

import icroack.icroackadventures.model.FroggCursor;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FroggyTeam
 */
public class LeaderBoard extends javax.swing.JFrame {

    /**
     * Creates new form LeaderBoard
     */
    FroggCursor fc;
    public LeaderBoard() throws IOException {
        this.setUndecorated(true);
        initComponents();
        this.setSize(450, 510);
        this.getContentPane().setBackground(new Color(58,171,88));
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.fc = new FroggCursor(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ldBTitle = new javax.swing.JLabel();
        ldBGold = new javax.swing.JLabel();
        ldBSilver = new javax.swing.JLabel();
        ldBCopper = new javax.swing.JLabel();
        ldbFour = new javax.swing.JLabel();
        lbDFive = new javax.swing.JLabel();
        ldbLabGold = new javax.swing.JLabel();
        ldbLabSilver = new javax.swing.JLabel();
        ldbLabCopper = new javax.swing.JLabel();
        ldbLabFour = new javax.swing.JLabel();
        ldbLabFive = new javax.swing.JLabel();
        labName1 = new javax.swing.JLabel();
        labName2 = new javax.swing.JLabel();
        labName3 = new javax.swing.JLabel();
        labName4 = new javax.swing.JLabel();
        labName5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ldBTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldBTitle.setIcon(new javax.swing.ImageIcon("resource/leaderboardTitle.png")); // NOI18N
        getContentPane().add(ldBTitle);
        ldBTitle.setBounds(6, 6, 444, 60);

        ldBGold.setIcon(new javax.swing.ImageIcon("resource/medalGold.png")); // NOI18N
        getContentPane().add(ldBGold);
        ldBGold.setBounds(6, 86, 60, 64);

        ldBSilver.setIcon(new javax.swing.ImageIcon("resource/medalSilver.png")); // NOI18N
        getContentPane().add(ldBSilver);
        ldBSilver.setBounds(6, 160, 60, 60);

        ldBCopper.setIcon(new javax.swing.ImageIcon("resource/medalCopper.png")); // NOI18N
        getContentPane().add(ldBCopper);
        ldBCopper.setBounds(6, 236, 60, 64);

        ldbFour.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        ldbFour.setForeground(new java.awt.Color(255, 255, 255));
        ldbFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldbFour.setText("4");
        getContentPane().add(ldbFour);
        ldbFour.setBounds(6, 310, 60, 60);

        lbDFive.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        lbDFive.setForeground(new java.awt.Color(255, 255, 255));
        lbDFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDFive.setText("5");
        getContentPane().add(lbDFive);
        lbDFive.setBounds(6, 380, 60, 60);

        ldbLabGold.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        ldbLabGold.setForeground(new java.awt.Color(255, 255, 255));
        ldbLabGold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldbLabGold.setText("Score1");
        getContentPane().add(ldbLabGold);
        ldbLabGold.setBounds(72, 86, 150, 64);

        ldbLabSilver.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        ldbLabSilver.setForeground(new java.awt.Color(255, 255, 255));
        ldbLabSilver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldbLabSilver.setText("Score2");
        getContentPane().add(ldbLabSilver);
        ldbLabSilver.setBounds(72, 160, 150, 66);

        ldbLabCopper.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        ldbLabCopper.setForeground(new java.awt.Color(255, 255, 255));
        ldbLabCopper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldbLabCopper.setText("Score3");
        getContentPane().add(ldbLabCopper);
        ldbLabCopper.setBounds(72, 236, 150, 64);

        ldbLabFour.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        ldbLabFour.setForeground(new java.awt.Color(255, 255, 255));
        ldbLabFour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldbLabFour.setText("Score4");
        getContentPane().add(ldbLabFour);
        ldbLabFour.setBounds(72, 310, 150, 60);

        ldbLabFive.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        ldbLabFive.setForeground(new java.awt.Color(255, 255, 255));
        ldbLabFive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ldbLabFive.setText("Score5");
        getContentPane().add(ldbLabFive);
        ldbLabFive.setBounds(72, 380, 150, 60);

        labName1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labName1.setForeground(new java.awt.Color(255, 255, 255));
        labName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labName1.setText("Name1");
        getContentPane().add(labName1);
        labName1.setBounds(228, 86, 222, 64);

        labName2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labName2.setForeground(new java.awt.Color(255, 255, 255));
        labName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labName2.setText("Name2");
        getContentPane().add(labName2);
        labName2.setBounds(228, 160, 222, 66);

        labName3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labName3.setForeground(new java.awt.Color(255, 255, 255));
        labName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labName3.setText("Name3");
        getContentPane().add(labName3);
        labName3.setBounds(228, 236, 222, 64);

        labName4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labName4.setForeground(new java.awt.Color(255, 255, 255));
        labName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labName4.setText("Name4");
        getContentPane().add(labName4);
        labName4.setBounds(228, 310, 222, 60);

        labName5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labName5.setForeground(new java.awt.Color(255, 255, 255));
        labName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labName5.setText("Name5");
        getContentPane().add(labName5);
        labName5.setBounds(228, 380, 222, 60);

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Quitter");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 458, 150, 46);

        jLabel6.setIcon(new javax.swing.ImageIcon("resource/ldbBG.png")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 450, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LeaderBoard().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel labName1;
    public static javax.swing.JLabel labName2;
    public static javax.swing.JLabel labName3;
    public static javax.swing.JLabel labName4;
    public static javax.swing.JLabel labName5;
    private javax.swing.JLabel lbDFive;
    private javax.swing.JLabel ldBCopper;
    private javax.swing.JLabel ldBGold;
    private javax.swing.JLabel ldBSilver;
    private javax.swing.JLabel ldBTitle;
    private javax.swing.JLabel ldbFour;
    public static javax.swing.JLabel ldbLabCopper;
    public static javax.swing.JLabel ldbLabFive;
    public static javax.swing.JLabel ldbLabFour;
    public static javax.swing.JLabel ldbLabGold;
    public static javax.swing.JLabel ldbLabSilver;
    // End of variables declaration//GEN-END:variables
}
