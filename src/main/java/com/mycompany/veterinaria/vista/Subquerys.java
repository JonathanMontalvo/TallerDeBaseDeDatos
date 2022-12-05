/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.veterinaria.vista;

import com.mycompany.veterinaria.vista.consultar.ConsultarSubquery;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class Subquerys extends javax.swing.JFrame
{

    private boolean bandera;
    public static int tipoSubquery;

    /**
     * Creates new form ConsultarSubquery
     */
    public Subquerys()
    {
        bandera = true;
        tipoSubquery = 0;
        this.setContentPane(new ImagenFondo());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        combo_Subquerys = new javax.swing.JComboBox<>();
        btn_Aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Subquery");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });

        combo_Subquerys.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        combo_Subquerys.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mayor al promedio de precio del Inventario", "Cita por nombre de la Mascota", "Mascota por el nombre del Tutor" }));

        btn_Aceptar.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.setContentAreaFilled(false);
        btn_Aceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Aceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptarM.png"))); // NOI18N
        btn_Aceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btn_Aceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_AceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_Subquerys, 0, 615, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(btn_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_Subquerys, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_AceptarActionPerformed
    {//GEN-HEADEREND:event_btn_AceptarActionPerformed
        // TODO add your handling code here:
        bandera = false;
        LookandFeelFrames.lFMint();
        SwingUtilities.updateComponentTreeUI(this);
        tipoSubquery = combo_Subquerys.getSelectedIndex();
        ConsultarSubquery cS = new ConsultarSubquery();

        switch (tipoSubquery)
        {
            case 0:
                cS.setVisible(true);
                break;
            case 1:
                cS.setVisible(true);
                break;
            case 2:
                cS.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "OCURRIO UN ERROR 130" + tipoSubquery, "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        this.dispose();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        // TODO add your handling code here:
        if (bandera)
        {
            Principal.activarBotones();
        }
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Subquerys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Subquerys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Subquerys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Subquerys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Subquerys().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JComboBox<String> combo_Subquerys;
    // End of variables declaration//GEN-END:variables

    public class ImagenFondo extends JPanel
    {

        @Override
        public void paint(Graphics g)
        {
            //ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo1.png"));
            ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo2.png"));
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
