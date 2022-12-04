/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.modelo;

import com.mycompany.veterinaria.control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class Subquery
{

    public Subquery()
    {
    }

    public DefaultTableModel subqueryMayorPromedioPrecio()
    {
        String[] campos =
        {
            "IDARTICULO", "TIPO", "NOMBRE", "PRECIO"
        };
        String[] registro = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "idarticulo, "
                    + "tipo, "
                    + "nombre, "
                    + "precio "
                    + "from Inventario "
                    + "where precio > "
                    + "(select "
                    + "avg (precio) "
                    + "from Inventario) "
                    + "order by precio ";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDARTICULO");
                registro[1] = rs.getString("TIPO");
                registro[2] = rs.getString("NOMBRE");
                registro[3] = rs.getString("PRECIO");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Subquery.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (conect != null)
                {
                    conect.close();
                }

            } catch (SQLException ex)
            {
                Logger.getLogger(Subquery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
}
