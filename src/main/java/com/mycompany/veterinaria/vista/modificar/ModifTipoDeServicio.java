/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.veterinaria.vista.modificar;

import com.mycompany.veterinaria.modelo.Empleados;
import com.mycompany.veterinaria.modelo.TipoDeServicio;
import com.mycompany.veterinaria.vista.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class ModifTipoDeServicio extends javax.swing.JFrame
{

    /**
     * Creates new form ModifTipoDeServicio
     */
    public ModifTipoDeServicio()
    {
        Principal.cadenaTipoDeServicio = 0;
        Principal.cadenaEmpleado = 0;
        initComponents();
        llenarCombo_IdServicio();
        llenarCombo_IdEmpleado();
        combo_Servicio.setSelectedIndex(0);
    }
    
    public void llenarCombo_IdServicio()
    {
        combo_Servicio.removeAllItems();
        TipoDeServicio obj_servicio = new TipoDeServicio();
        ArrayList listaservicio = obj_servicio.combo_TipoDeServicio();
        Iterator iter = listaservicio.iterator();
        while (iter.hasNext())
        {
            TipoDeServicio servico = (TipoDeServicio) iter.next();
            combo_Servicio.addItem(servico);
        }
    }
    
    public void llenarCombo_IdEmpleado()
    {
        combo_Empleado.removeAllItems();
        Empleados obj_empleados = new Empleados();
        ArrayList listaempleados = obj_empleados.combo_Empleados();
        Iterator iter = listaempleados.iterator();
        while (iter.hasNext())
        {
            Empleados empleados = (Empleados) iter.next();
            combo_Empleado.addItem(empleados);
        }
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
        combo_Servicio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_Empleado = new javax.swing.JComboBox<>();
        txt_EmpleadoNombre = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        combo_Tipo = new javax.swing.JComboBox<>();
        txt_Precio = new javax.swing.JTextField();
        btn_Modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Tipo de Servicio");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Seleccione los campos que desea modificar: ");

        jLabel0.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel0.setText("Seleccione el  Servicio a editar: ");

        combo_Servicio.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combo_Servicio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                combo_ServicioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Seleccione al empleado: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Cambie el nombre: ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Seleccione el tipo: ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Cambie el precio: ");

        combo_Empleado.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combo_Empleado.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                combo_EmpleadoActionPerformed(evt);
            }
        });

        txt_EmpleadoNombre.setEditable(false);
        txt_EmpleadoNombre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        txt_Nombre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        combo_Tipo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        combo_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T", "R" }));

        txt_Precio.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Nombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Precio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combo_Servicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_EmpleadoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_Servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_EmpleadoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_ServicioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_combo_ServicioActionPerformed
    {//GEN-HEADEREND:event_combo_ServicioActionPerformed
        // TODO add your handling code here:}
        int idempleado = 0;
        String nombre = "";
        String tipo = "";
        double precio = 0.0;
        TipoDeServicio servicio = (TipoDeServicio) combo_Servicio.getSelectedItem();
        
        idempleado = servicio.getIdempleado();
        nombre = servicio.getNombre();
        tipo = servicio.getTipo();
        precio = servicio.getPrecio();
        
        for (int i = 0; i < combo_Empleado.getItemCount(); i++)
        {
            combo_Empleado.setSelectedIndex(i);
            Empleados empleado = (Empleados) combo_Empleado.getSelectedItem();
            if (empleado.getIdempleado() == idempleado)
            {
                break;
            }
        }
        txt_Nombre.setText(nombre);
        combo_Tipo.setSelectedItem(tipo);
        txt_Precio.setText(String.valueOf(precio));
    }//GEN-LAST:event_combo_ServicioActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_ModificarActionPerformed
    {//GEN-HEADEREND:event_btn_ModificarActionPerformed
        // TODO add your handling code here:
        int idservicio = 0;
        int idempleado = 0;
        String nombre = "";
        String tipo = "";
        double precio = 0.0;
        
        TipoDeServicio servicio = (TipoDeServicio) combo_Servicio.getSelectedItem();
        Empleados empleado = (Empleados) combo_Empleado.getSelectedItem();
        
        if (txt_Nombre.getText().equals("") || txt_Precio.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Favor de capturar los datos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else
        {
            try
            {
                idempleado = empleado.getIdempleado();
                nombre = txt_Nombre.getText();
                tipo = (String) combo_Tipo.getSelectedItem();
                precio = Double.parseDouble(txt_Precio.getText());
                idservicio = servicio.getIdservicio();
                
                TipoDeServicio obj_servicio = new TipoDeServicio();
                int r = obj_servicio.actualizar(idempleado, nombre, tipo, precio, idservicio);
                if (r != 0)
                {
                    JOptionPane.showMessageDialog(this, "La venta fue actualizada correctamente");
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

    private void combo_EmpleadoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_combo_EmpleadoActionPerformed
    {//GEN-HEADEREND:event_combo_EmpleadoActionPerformed
        // TODO add your handling code here:
        Empleados empleados = (Empleados) combo_Empleado.getSelectedItem();
        txt_EmpleadoNombre.setText(empleados.getNombre() + " " + empleados.getApellidopa() + " " + empleados.getApellidoma());
    }//GEN-LAST:event_combo_EmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(ModifTipoDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ModifTipoDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ModifTipoDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ModifTipoDeServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ModifTipoDeServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JComboBox<Empleados> combo_Empleado;
    private javax.swing.JComboBox<TipoDeServicio> combo_Servicio;
    private javax.swing.JComboBox<String> combo_Tipo;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_EmpleadoNombre;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables
}
