/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icroack.icroackadventures.view;

import icroack.icroackadventures.model.Audio;
import icroack.icroackadventures.model.Character;
import icroack.icroackadventures.controler.TimerTime;
import icroack.icroackadventures.model.FroggCursor;
import icroack.icroackadventures.model.RollDice;
import icroack.icroackadventures.model.Player;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 *
 * @author FroggyTeam
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    private int counter;
    public static ViewTimer vt;
    public static TimerTime tt;
    public Character ch;
    public ViewBoard vb;
    private FroggCursor fc;
    private Player tts ;
    
    public Game() throws IOException{
        this.counter = 0;
        this.setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0,0,0)));
        initComponents();
        this.setSize(1197, 933);
        this.setLocationRelativeTo(null);
        this.tt = new TimerTime();
        this.vt = new ViewTimer();
        tt.start();
        this.ch = new Character();
        froggyIcon.setIcon(new ImageIcon("resource/froggyVictory.gif")); //image mv
        this.tts = new Player();
        this.fc = new FroggCursor(this);
        String song = "resource/coffindance.wav";
        try {
            Audio.playSound(song);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // GETTERS & SETTERS
    public int getCounter() {
        return counter;
    }
    public JLabel getChronoLabel() {return chronoLabel;}
    public void setChronoLabel(JLabel chronoLabel) {this.chronoLabel = chronoLabel;}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {

        froggyIcon = new javax.swing.JLabel();
        try {
            viewBoard2 = new icroack.icroackadventures.view.ViewBoard();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        chronoLabel = new javax.swing.JLabel();
        rolledDice = new javax.swing.JLabel();
        iconRolledDice = new javax.swing.JLabel();
        labScore = new javax.swing.JLabel();
        closeGame = new javax.swing.JLabel();
        iconChrono = new javax.swing.JLabel();
        lastRollIco = new javax.swing.JLabel();
        labTotalScore = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonRoll = new javax.swing.JLabel();
        transPan = new javax.swing.JLabel();
        bgGame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        froggyIcon.setIcon(new javax.swing.ImageIcon("resource/froggyVictory.gif")); // NOI18N
        getContentPane().add(froggyIcon);
        froggyIcon.setBounds(260, 30, 80, 80);

        viewBoard2.setOpaque(false);
        getContentPane().add(viewBoard2);
        viewBoard2.setBounds(260, 20, 710, 640);

        chronoLabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        chronoLabel.setForeground(new java.awt.Color(111, 178, 200));
        getContentPane().add(chronoLabel);
        chronoLabel.setBounds(180, 820, 150, 50);

        rolledDice.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        rolledDice.setForeground(new java.awt.Color(111, 178, 198));
        rolledDice.setText("0");
        getContentPane().add(rolledDice);
        rolledDice.setBounds(940, 800, 80, 70);

        iconRolledDice.setIcon(new javax.swing.ImageIcon("resource/LabelDiceRolled[1].png")); // NOI18N
        getContentPane().add(iconRolledDice);
        iconRolledDice.setBounds(860, 710, 300, 200);

        labScore.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        labScore.setForeground(new java.awt.Color(0, 102, 0));
        labScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labScore);
        labScore.setBounds(50, 240, 170, 110);

        closeGame.setIcon(new javax.swing.ImageIcon("resource/closeGame.png")); // NOI18N
        closeGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeGameMouseClicked(evt);
            }
        });
        getContentPane().add(closeGame);
        closeGame.setBounds(1090, 10, 91, 91);

        iconChrono.setIcon(new javax.swing.ImageIcon("resource/LabelChrono[2].png")); // NOI18N
        getContentPane().add(iconChrono);
        iconChrono.setBounds(60, 720, 300, 200);
        getContentPane().add(lastRollIco);
        lastRollIco.setBounds(100, 50, 80, 80);

        labTotalScore.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        labTotalScore.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labTotalScore);
        labTotalScore.setBounds(50, 250, 170, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("resource/lastRollLabel.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 210, 210);

        buttonRoll.setIcon(new javax.swing.ImageIcon("resource/buttonRoll_r.png")); // NOI18N
        buttonRoll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRollMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonRollMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonRollMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonRollMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonRollMouseReleased(evt);
            }
        });
        buttonRoll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buttonRollKeyTyped(evt);
            }
        });
        getContentPane().add(buttonRoll);
        buttonRoll.setBounds(520, 710, 200, 200);

        transPan.setIcon(new javax.swing.ImageIcon("resource/TranparentLayer.png")); // NOI18N
        transPan.setToolTipText("");
        getContentPane().add(transPan);
        transPan.setBounds(260, 20, 710, 640);

        bgGame.setIcon(new javax.swing.ImageIcon("resource/backgroundGame.png")); // NOI18N
        bgGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgGameMouseEntered(evt);
            }
        });
        getContentPane().add(bgGame);
        bgGame.setBounds(0, -20, 1200, 970);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRollMouseClicked
        // TODO add your handling code here:

            //ResultDice rsd = new ResultDice();
            String rollDiceSong = "resource/diceroll.wav";
        try {
            Audio.playSound(rollDiceSong);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
            RollDice rd = new RollDice();
            ImageIcon btnClick = new ImageIcon("resource/rdb_press.gif");
            int result = rd.random();   
            buttonRoll.setIcon(btnClick);
            this.counter++;
            rolledDice.setText(String.valueOf(counter));
            rd.SetIconDice(result);
        try {
                try {
                    //rsd.SetIconDice(result);
                    ch.moveCharacter(result, tt, buttonRoll, this);
                } catch (SQLException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
            froggyIcon.setBounds(ch.getxPosCharacter(), ch.getyPosCharacter(),80,80);
            

            System.out.println(ch.getxPosCharacter());
            System.out.println(ch.getyPosCharacter());
            tts.defineScore();
            tts.setLabelScore(this);
            System.out.println(tts.getTotalScore());
            //rsd.setVisible(true);
            froggyIcon.repaint();
            froggyIcon.revalidate();

    }//GEN-LAST:event_buttonRollMouseClicked

    private void buttonRollMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRollMouseEntered
        // TODO add your handling code here:
        ImageIcon btnEnter = new ImageIcon("resource/rdb2.gif"); //img OK
        buttonRoll.setIcon(btnEnter);
    }//GEN-LAST:event_buttonRollMouseEntered

    private void buttonRollMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRollMouseExited
        // TODO add your handling code here:
        ImageIcon btnExited = new ImageIcon("resource/buttonRoll_r.png"); //img OK
        buttonRoll.setIcon(btnExited);
    }//GEN-LAST:event_buttonRollMouseExited

    private void buttonRollMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRollMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonRollMousePressed

    private void buttonRollMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRollMouseReleased
        // TODO add your handling code here:
        ImageIcon btnExited = new ImageIcon("resource/buttonRoll_r.png");//img OK
        buttonRoll.setIcon(btnExited);
    }//GEN-LAST:event_buttonRollMouseReleased

    private void closeGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeGameMouseClicked
        // TODO add your handling code here:
        MenuPause mp = new MenuPause(this);
        mp.setVisible(true);
        this.tt.suspend();
    }//GEN-LAST:event_closeGameMouseClicked

    private void buttonRollKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonRollKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRollKeyTyped

    private void bgGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgGameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bgGameMouseEntered

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Game().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgGame;
    private javax.swing.JLabel buttonRoll;
    //public static javax.swing.JLabel chronoLabel;
    public javax.swing.JLabel chronoLabel;
    private javax.swing.JLabel closeGame;
    public javax.swing.JLabel froggyIcon;
    private javax.swing.JLabel iconChrono;
    private javax.swing.JLabel iconRolledDice;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel labScore;
    public static javax.swing.JLabel labTotalScore;
    public static javax.swing.JLabel lastRollIco;
    private javax.swing.JLabel rolledDice;
    private javax.swing.JLabel transPan;
    private icroack.icroackadventures.view.ViewBoard viewBoard2;
    // End of variables declaration//GEN-END:variables
}
