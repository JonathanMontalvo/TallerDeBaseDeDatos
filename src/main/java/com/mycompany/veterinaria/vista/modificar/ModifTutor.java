/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.veterinaria.vista.modificar;

import com.mycompany.veterinaria.modelo.Tutor;
import com.mycompany.veterinaria.vista.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class ModifTutor extends javax.swing.JFrame
{

    /**
     * Creates new form ModifTutor
     */
    public ModifTutor()
    {
        Principal.cadenaTutor = 0;
        initComponents();
        llenarCombo_IdTutor();
        combo_Tutor.setSelectedIndex(0);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel0 = new javax.swing.JLabel();
        combo_Tutor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        txt_Direccion = new javax.swing.JTextField();
        btn_Modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Tutor");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Seleccione los campos que desea modificar: ");

        jLabel0.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel0.setText("Seleccione el Tutor a editar: ");

        combo_Tutor.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combo_Tutor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                combo_TutorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Cambie el nombre: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Cambie el teléfono: ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Cambie el correo: ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Cambie la dirección: ");

        txt_Nombre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        txt_Telefono.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        txt_Correo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        txt_Direccion.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        btn_Modificar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_Modificar.setText("Modificar");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(combo_Tutor, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_Tutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_TutorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_combo_TutorActionPerformed
    {//GEN-HEADEREND:event_combo_TutorActionPerformed
        // TODO add your handling code here:
        String nombre = "";
        String telefono = "";
        String correo = "";
        String direccion = "";
        Tutor obj_tutor = (Tutor) combo_Tutor.getSelectedItem();

        nombre = obj_tutor.getNombre();
        telefono = obj_tutor.getTelefono();
        correo = obj_tutor.getCorreo();
        direccion = obj_tutor.getDireccion();

        txt_Nombre.setText(nombre);
        txt_Telefono.setText(telefono);
        txt_Correo.setText(correo);
        txt_Direccion.setText(direccion);
    }//GEN-LAST:event_combo_TutorActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_ModificarActionPerformed
    {//GEN-HEADEREND:event_btn_ModificarActionPerformed
        // TODO add your handling code here:
        String nombre = "";
        String telefono = "";
        String correo = "";
        String direccion = "";
        int idtutor = 0;
        Tutor tutor = (Tutor) combo_Tutor.getSelectedItem();

        if (txt_Nombre.getText().equals("") || txt_Telefono.getText().equals("") || txt_Correo.getText().equals("") || txt_Direccion.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Favor de capturar los datos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else
        {
            try
            {
                nombre = txt_Nombre.getText();
                telefono = txt_Telefono.getText();
                Double.parseDouble(txt_Telefono.getText());
                correo = txt_Correo.getText();
                direccion = txt_Direccion.getText();
                idtutor = tutor.getIdtutor();

                Tutor obj_tutor = new Tutor();
                int r = obj_tutor.actualizar(nombre, telefono, correo, direccion, idtutor);
                if (r != 0)
                {
                    JOptionPane.showMessageDialog(this, "El tutor fue actualizado correctamente");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error");
                }
            } catch (NumberFormatException nFE)
            {
                JOptionPane.showMessageDialog(this, "Favor de solo capturar números reales y no cadenas de texto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ModifTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ModifTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ModifTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ModifTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ModifTutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JComboBox<Tutor> combo_Tutor;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Direccion;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
    public void llenarCombo_IdTutor()
    {
        combo_Tutor.removeAllItems();
        Tutor obj_tutor = new Tutor();
        ArrayList listatutor = obj_tutor.combo_Tutor();
        Iterator iter = listatutor.iterator();
        while (iter.hasNext())
        {
            Tutor tutor = (Tutor) iter.next();
            combo_Tutor.addItem(tutor);
        }
    }
}
