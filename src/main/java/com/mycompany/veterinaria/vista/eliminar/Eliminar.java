/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.veterinaria.vista.eliminar;

import com.mycompany.veterinaria.modelo.*;
import com.mycompany.veterinaria.vista.Entidad;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class Eliminar extends javax.swing.JFrame
{

    /**
     * Creates new form Eliminar
     */
    public Eliminar()
    {
        initComponents();
        combo_Eliminar.setVisible(false);
        btn_Eliminar.setVisible(false);
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
        combo_Eliminar = new javax.swing.JComboBox();
        btn_Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargando...");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("Cargando...");

        combo_Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N

        btn_Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        // TODO add your handling code here:
        switch (Entidad.eliminar)
        {
            case 1:
                this.setTitle("Eliminar Cita");
                llenarCombo_IdCita();
                jLabel1.setText("Seleccione el id de la cita a eliminar: ");
                break;
            case 2:
                this.setTitle("Eliminar Consultas");
                llenarCombo_IdConsultas();
                jLabel1.setText("Seleccione el id de la consulta a eliminar: ");
                break;
            case 3:
                this.setTitle("Eliminar Empleados");
                llenarCombo_IdEmpleado();
                jLabel1.setText("Seleccione el id del empleado a eliminar: ");
                break;
            case 4:
                this.setTitle("Eliminar Inventario");
                llenarCombo_IdArticulo();
                jLabel1.setText("Seleccione el id del artículo a eliminar: ");
                break;
            case 5:
                this.setTitle("Eliminar Mascota");
                llenarCombo_IdMascota();
                jLabel1.setText("Seleccione el id de la mascota a eliminar: ");
                break;
            case 6:
                this.setTitle("Eliminar Proveedores");
                llenarCombo_IdProveedor();
                jLabel1.setText("Seleccione el id del proveedor a eliminar: ");
                break;
            case 7:
                this.setTitle("Eliminar Tipo de servicio");
                llenarCombo_IdServicio();
                jLabel1.setText("Seleccione el id del tipo de servicio a eliminar: ");
                break;
            case 8:
                this.setTitle("Eliminar Tutor");
                llenarCombo_IdTutor();
                jLabel1.setText("Seleccione el id del tutor a eliminar: ");
                break;
            case 9:
                this.setTitle("Eliminar Ventas");
                llenarCombo_IdVentas();
                jLabel1.setText("Selecciona el id de la venta a eliminar: ");
                break;
            default:
                JOptionPane.showMessageDialog(this, "OCURRIO UN ERROR 6" + Entidad.eliminar, "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        combo_Eliminar.setVisible(true);
        btn_Eliminar.setVisible(true);
    }//GEN-LAST:event_formWindowActivated

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_EliminarActionPerformed
    {//GEN-HEADEREND:event_btn_EliminarActionPerformed
        // TODO add your handling code here:
        int r = 0;
        btn_Eliminar.setVisible(false);
        combo_Eliminar.setVisible(false);
        jLabel1.setText("Cargando...");

        switch (Entidad.eliminar)
        {
            case 1:
                Cita cita = new Cita();
                r = cita.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdCita();
                    JOptionPane.showMessageDialog(null, "Cita eliminada");
                    jLabel1.setText("Seleccione el id de la cita a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                            "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                Consultas consultas = new Consultas();
                r = consultas.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdCita();
                    JOptionPane.showMessageDialog(null, "Consulta eliminada");
                    jLabel1.setText("Seleccione el id de la consulta a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                            "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3:
                Empleados empleados = new Empleados();
                r = empleados.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdEmpleado();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado");
                    jLabel1.setText("Seleccione el id del empleado a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                            "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 4:
                Inventario inventario = new Inventario();
                r = inventario.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdArticulo();
                    JOptionPane.showMessageDialog(null, "Artículo eliminado");
                    jLabel1.setText("Seleccione el id del artículo a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                            "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 5:
                Mascota mascota = new Mascota();
                r = mascota.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdMascota();
                    JOptionPane.showMessageDialog(null, "Mascota eliminada");
                    jLabel1.setText("Seleccione el id de la mascota a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                            "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 6:
                Proveedores proveedores = new Proveedores();
                r = proveedores.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdProveedor();
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado");
                    jLabel1.setText("Seleccione el id del proveedor a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                            "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 7:
                TipoDeServicio tipodeservicio = new TipoDeServicio();
                r = tipodeservicio.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdServicio();
                    JOptionPane.showMessageDialog(null, "Servicio eliminado");
                    jLabel1.setText("Seleccione el id del tipo de servicio a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                             "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 8:
                Tutor tutor = new Tutor();
                r = tutor.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdTutor();
                    JOptionPane.showMessageDialog(null, "Tutor eliminado");
                    jLabel1.setText("Seleccione el id del tutor a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                             "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 9:
                Ventas ventas = new Ventas();
                r = ventas.eliminar((int) combo_Eliminar.getSelectedItem());
                if (r != 0)
                {
                    llenarCombo_IdVentas();
                    JOptionPane.showMessageDialog(null, "Venta eliminada");
                    jLabel1.setText("Selecciona el id de la venta a eliminar: ");
                } else
                {
                    JOptionPane.showMessageDialog(this, "Restricción de integridad violada",
                             "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "OCURRIO UN ERROR 7" + Entidad.eliminar, "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        combo_Eliminar.setVisible(true);
        btn_Eliminar.setVisible(true);
    }//GEN-LAST:event_btn_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JComboBox combo_Eliminar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void llenarCombo_IdCita()
    {
        combo_Eliminar.removeAllItems();
        Cita obj_cita = new Cita();
        ArrayList listacita = obj_cita.combo_Cita();
        Iterator iter = listacita.iterator();
        while (iter.hasNext())
        {
            Cita cita = (Cita) iter.next();
            combo_Eliminar.addItem(cita.getIdcita());
        }
    }

    public void llenarCombo_IdConsultas()
    {
        combo_Eliminar.removeAllItems();
        Consultas obj_consultas = new Consultas();
        ArrayList listaconsultas = obj_consultas.combo_Consultas();
        Iterator iter = listaconsultas.iterator();
        while (iter.hasNext())
        {
            Consultas consultas = (Consultas) iter.next();
            combo_Eliminar.addItem(consultas.getIdconsulta());
        }
    }

    public void llenarCombo_IdEmpleado()
    {
        combo_Eliminar.removeAllItems();
        Empleados obj_empleados = new Empleados();
        ArrayList listaempleados = obj_empleados.combo_Empleados();
        Iterator iter = listaempleados.iterator();
        while (iter.hasNext())
        {
            Empleados empleados = (Empleados) iter.next();
            combo_Eliminar.addItem(empleados.getIdempleado());
        }
    }

    public void llenarCombo_IdArticulo()
    {
        combo_Eliminar.removeAllItems();
        Inventario obj_inventario = new Inventario();
        ArrayList listainventario = obj_inventario.combo_Inventario();
        Iterator iter = listainventario.iterator();
        while (iter.hasNext())
        {
            Inventario inventario = (Inventario) iter.next();
            combo_Eliminar.addItem(inventario.getIdarticulo());
        }
    }

    public void llenarCombo_IdMascota()
    {
        combo_Eliminar.removeAllItems();
        Mascota obj_mascota = new Mascota();
        ArrayList listamascota = obj_mascota.combo_Mascota();
        Iterator iter = listamascota.iterator();
        while (iter.hasNext())
        {
            Mascota mascota = (Mascota) iter.next();
            combo_Eliminar.addItem(mascota.getIdmascota());
        }
    }

    public void llenarCombo_IdProveedor()
    {
        combo_Eliminar.removeAllItems();
        Proveedores obj_proveedores = new Proveedores();
        ArrayList listaproveedores = obj_proveedores.combo_Proveedores();
        Iterator iter = listaproveedores.iterator();
        while (iter.hasNext())
        {
            Proveedores proveedores = (Proveedores) iter.next();
            combo_Eliminar.addItem(proveedores.getIdproveedor());
        }
    }

    public void llenarCombo_IdServicio()
    {
        combo_Eliminar.removeAllItems();
        TipoDeServicio obj_servicio = new TipoDeServicio();
        ArrayList listaservicio = obj_servicio.combo_TipoDeServicio();
        Iterator iter = listaservicio.iterator();
        while (iter.hasNext())
        {
            TipoDeServicio servico = (TipoDeServicio) iter.next();
            combo_Eliminar.addItem(servico.getIdservicio());
        }
    }

    public void llenarCombo_IdTutor()
    {
        combo_Eliminar.removeAllItems();
        Tutor obj_tutor = new Tutor();
        ArrayList listatutor = obj_tutor.combo_Tutor();
        Iterator iter = listatutor.iterator();
        while (iter.hasNext())
        {
            Tutor tutor = (Tutor) iter.next();
            combo_Eliminar.addItem(tutor.getIdtutor());
        }
    }

    public void llenarCombo_IdVentas()
    {
        combo_Eliminar.removeAllItems();
        Ventas obj_ventas = new Ventas();
        ArrayList listaventas = obj_ventas.combo_Ventas();
        Iterator iter = listaventas.iterator();
        while (iter.hasNext())
        {
            Ventas ventas = (Ventas) iter.next();
            combo_Eliminar.addItem(ventas.getIdventa());
        }
    }
}
