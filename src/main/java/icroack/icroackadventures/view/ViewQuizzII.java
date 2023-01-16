/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icroack.icroackadventures.view;

import icroack.icroackadventures.controler.ControlerQuizz;
import icroack.icroackadventures.model.FroggCursor;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author FroggyTeam
 */
public class ViewQuizzII extends javax.swing.JFrame {

    /**
     * Creates new form ViewQuizzII
     */
    private ControlerQuizz cq;
    private FroggCursor fc;
    public ViewQuizzII(ControlerQuizz cq) throws IOException {
        this.setUndecorated(true);
        initComponents();
        this.cq = cq;
        this.setSize(701, 300);
        
        getContentPane().setBackground(new Color(13,94,13));
        this.setLocationRelativeTo(null);
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

        btn_false = new javax.swing.JButton();
        btn_true = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        labQuizzClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_false.setBackground(new java.awt.Color(0, 153, 0));
        btn_false.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        btn_false.setForeground(new java.awt.Color(255, 255, 255));
        btn_false.setText("Faux");
        btn_false.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_falseActionPerformed(evt);
            }
        });

        btn_true.setBackground(new java.awt.Color(0, 153, 0));
        btn_true.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        btn_true.setForeground(new java.awt.Color(255, 255, 255));
        btn_true.setText("Vrai");
        btn_true.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trueActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Temps restant : ");

        count.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        count.setForeground(new java.awt.Color(255, 255, 255));

        txtQuestion.setEditable(false);
        txtQuestion.setBackground(new java.awt.Color(0, 102, 0));
        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 16)); // NOI18N
        txtQuestion.setForeground(new java.awt.Color(255, 255, 255));
        txtQuestion.setLineWrap(true);
        txtQuestion.setRows(5);
        txtQuestion.setBorder(null);
        txtQuestion.setCaretColor(new java.awt.Color(0, 102, 0));
        txtQuestion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtQuestion.setFocusable(false);
        jScrollPane1.setViewportView(txtQuestion);

        labQuizzClose.setIcon(new javax.swing.ImageIcon("resource/close.png")); // NOI18N
        labQuizzClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labQuizzCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_true, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_false, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21)
                .addComponent(labQuizzClose))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labQuizzClose)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_true, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btn_false, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTextArea getTxtQuestion() {
        return txtQuestion;
    }

    private void btn_falseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_falseActionPerformed
        // TODO add your handling code here:
                        int answer_true = 0;
                try {
                    cq.verify_answers(answer_true);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();}
    }//GEN-LAST:event_btn_falseActionPerformed

    private void btn_trueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trueActionPerformed
        // TODO add your handling code here:
                int answer_true = 1;
                try {
                    cq.verify_answers(answer_true);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();}
    }//GEN-LAST:event_btn_trueActionPerformed

    private void labQuizzCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labQuizzCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
        this.cq.stop();
    }//GEN-LAST:event_labQuizzCloseMouseClicked

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
            java.util.logging.Logger.getLogger(ViewQuizzII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQuizzII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQuizzII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQuizzII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_false;
    public static javax.swing.JButton btn_true;
    public javax.swing.JLabel count;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labQuizzClose;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}