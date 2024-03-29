/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClockPanel.java
 *
 * Created on 14-04-2009, 12:18:22 PM
 */
package com.leopard2av.clock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.DateFormatter;
import org.openide.util.Exceptions;

/**
 * A simple clock/calendar plugin for Netbeans 6.5 / 6.7
 *
 * @author leopard (aka leopard2av on some places) pedro.oyarce@gmail.com
 */
public class ClockPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = -5149030714157897159L;
    public static final String VERSION = "1.0.1";

    /** Creates new form ClockPanel */
    public ClockPanel() {
        initComponents();
        comenzar();
    }

    /**
     * Start the timer
     */
    private void comenzar() {
        Runnable timer = new Runnable() {

            public void run() {
                while (true) {
                    SwingUtilities.invokeLater(new Runnable() {

                        public void run() {
                            mostrarHora();
                        }
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
            }
        };
        new Thread(timer).start();

    }

    /**
     * Show hour & time in JLabels
     */
    private void mostrarHora() {
        try {
            dateLbl.setText(new DateFormatter().valueToString(new Date()));
        } catch (ParseException ex) {
            Exceptions.printStackTrace(ex);
        }
        hourLbl.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        hourLbl = new javax.swing.JLabel();

        setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/leopard2av/clock/fecha.png"))); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(ClockPanel.class, "ClockPanel.jLabel1.text")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showReminderWindow(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/leopard2av/clock/hora.png"))); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(ClockPanel.class, "ClockPanel.jLabel2.text")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                about(evt);
            }
        });

        dateLbl.setText(org.openide.util.NbBundle.getMessage(ClockPanel.class, "ClockPanel.dateLbl.text")); // NOI18N

        hourLbl.setText(org.openide.util.NbBundle.getMessage(ClockPanel.class, "ClockPanel.hourLbl.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hourLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hourLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dateLbl.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ClockPanel.class, "ClockPanel.jLabel3.AccessibleContext.accessibleName")); // NOI18N
        hourLbl.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ClockPanel.class, "ClockPanel.jLabel4.AccessibleContext.accessibleName")); // NOI18N
    }//GEN-END:initComponents

    private void about(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_about
        if (evt.getClickCount() == 2) {
            JOptionPane.showMessageDialog(dateLbl, "NetBeans Clock ... A simple clock for NetBeans\nv" + VERSION + "\n(c) 2009 by leopard (aka leopard2av)\nhttp://netbeansclock.googlecode.com", "About", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_about

    private void showReminderWindow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showReminderWindow
        /*
        if (evt.getClickCount() == 2) {
        Dialog d =DialogDisplayer.getDefault().createDialog(new DialogDescriptor(new AddReminderPanel(), "Add Reminder..."));
        d.setVisible(true);
        }
         */
    }//GEN-LAST:event_showReminderWindow
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel hourLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
