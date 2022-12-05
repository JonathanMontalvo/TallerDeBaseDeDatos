/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.veterinaria.vista.consultar;

import com.mycompany.veterinaria.modelo.Subquery;
import com.mycompany.veterinaria.vista.Subquerys;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class ConsultarSubquery extends javax.swing.JFrame
{

    private static boolean bandera;

    /**
     * Creates new form ConsultarSubquery
     */
    public ConsultarSubquery()
    {
        bandera = true;
        initComponents();
        jScrollPane1.setVisible(false);
        datos.setVisible(false);
        this.setExtendedState(MAXIMIZED_BOTH);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Subquery");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });

        datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(datos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        // TODO add your handling code here:
        Subquerys.tipoSubquery = 0;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        // TODO add your handling code here:
        Subquery obj_Subquery = new Subquery();
        switch (Subquerys.tipoSubquery)
        {
            case 0:
                datos.setModel(obj_Subquery.subqueryMayorPromedioPrecio());
                this.setTitle("Subquery de mayor al promedio de precio del Inventario");
                break;
            case 1:
                if (bandera)
                {
                    String nombre = "";
                    nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la Mascota: ", "Capturar Datos", JOptionPane.QUESTION_MESSAGE);
                    datos.setModel(obj_Subquery.subqueryCitaPorNombreMascota(nombre));
                    this.setTitle("Subquery de cita por el nombre de la Mascota");
                    this.hide();
                    this.show();
                    bandera = false;
                }
                break;
            case 2:
                if (bandera)
                {
                    String nombre = "";
                    nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del Tutor: ", "Capturar Datos", JOptionPane.QUESTION_MESSAGE);
                    datos.setModel(obj_Subquery.subqueryMascotaPorNombreTutor(nombre));
                    this.setTitle("Subquery de mascota por el nombre del Tutor");
                    this.hide();
                    this.show();
                    bandera = false;
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "OCURRIO UN ERROR 130" + Subquerys.tipoSubquery, "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        jScrollPane1.setVisible(true);
        datos.setVisible(true);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(ConsultarSubquery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConsultarSubquery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConsultarSubquery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConsultarSubquery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConsultarSubquery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
