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
public class Vista
{

    public Vista()
    {
    }

    public boolean crearVistaPerros()
    {
        boolean respuesta = false;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "create or replace view perros as "
                    + "select "
                    + "idmascota, "
                    + "nombre, "
                    + "tipo, "
                    + "raza, "
                    + "sexo, "
                    + "peso, "
                    + "medida, "
                    + "fechanacimiento, "
                    + "detalles "
                    + "from Mascota "
                    + "where tipo = 'Perro' "
                    + "with read only";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            respuesta = ps.execute();
        } catch (SQLException ex)
        {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
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
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultarVistaPerros()
    {
        String[] campos =
        {
            "IDMASCOTA", "NOMBRE", "TIPO", "RAZA", "SEXO", "PESO", "MEDIDA", "FECHANACIMIENTO", "DETALLES"
        };
        String[] registro = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from perros order by idmascota";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDMASCOTA");
                registro[1] = rs.getString("NOMBRE");
                registro[2] = rs.getString("TIPO");
                registro[3] = rs.getString("RAZA");
                registro[4] = rs.getString("SEXO");
                registro[5] = rs.getString("PESO");
                registro[6] = rs.getString("MEDIDA");
                registro[7] = rs.getString("FECHANACIMIENTO");
                if (registro[7] != null)
                {
                    registro[7] = registro[7].substring(8, 10)
                            + "/" + registro[7].substring(5, 7)
                            + "/" + registro[7].substring(0, 4);
                } else
                {
                    registro[7] = "Desconocida";
                }
                registro[8] = rs.getString("DETALLES");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
}
