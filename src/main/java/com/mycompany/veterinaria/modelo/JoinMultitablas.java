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
public class JoinMultitablas
{

    public JoinMultitablas()
    {
    }

    public DefaultTableModel joinTutorMascota()
    {
        String[] campos =
        {
            "IDTUTOR", "NOMBRE TUTOR", "TELEFONO", "DIRECCION", "NOMBRE MASCOTA", "TIPO", "RAZA", "SEXO", "PESO", "DETALLES"
        };
        String[] registro = new String[10];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "t.idtutor, "
                    + "t.nombre as \"NOMBRE TUTOR\", "
                    + "t.telefono, "
                    + "t.direccion, "
                    + "m.nombre as \"NOMBRE MASCOTA\", "
                    + "m.tipo, "
                    + "m.raza, "
                    + "m.sexo, "
                    + "m.peso, "
                    + "m.detalles "
                    + "from Tutor t "
                    + "join "
                    + "Mascota m "
                    + "on t.idtutor = m.idtutor "
                    + "order by t.idtutor asc";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDTUTOR");
                registro[1] = rs.getString("NOMBRE TUTOR");
                registro[2] = rs.getString("TELEFONO");
                registro[3] = rs.getString("DIRECCION");
                registro[4] = rs.getString("NOMBRE MASCOTA");
                registro[5] = rs.getString("TIPO");
                registro[6] = rs.getString("RAZA");
                registro[7] = rs.getString("SEXO");
                registro[8] = rs.getString("PESO");
                registro[9] = rs.getString("DETALLES");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
}
