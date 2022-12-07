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
public class Despidos
{

    private int iddespido;
    private String nombre;
    private String apellidopa;
    private String apellidoma;
    private long telefono;
    private String correo;
    private String fechadespido;

    public Despidos()
    {
    }

    public Despidos(int iddespido, String nombre, String apellidopa, String apellidoma, long telefono, String correo, String fechadespido)
    {
        this.iddespido = iddespido;
        this.nombre = nombre;
        this.apellidopa = apellidopa;
        this.apellidoma = apellidoma;
        this.telefono = telefono;
        this.correo = correo;
        this.fechadespido = fechadespido;
    }

    /**
     * @return the iddespido
     */
    public int getIddespido()
    {
        return iddespido;
    }

    /**
     * @param iddespido the iddespido to set
     */
    public void setIddespido(int iddespido)
    {
        this.iddespido = iddespido;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the apellidopa
     */
    public String getApellidopa()
    {
        return apellidopa;
    }

    /**
     * @param apellidopa the apellidopa to set
     */
    public void setApellidopa(String apellidopa)
    {
        this.apellidopa = apellidopa;
    }

    /**
     * @return the apellidoma
     */
    public String getApellidoma()
    {
        return apellidoma;
    }

    /**
     * @param apellidoma the apellidoma to set
     */
    public void setApellidoma(String apellidoma)
    {
        this.apellidoma = apellidoma;
    }

    /**
     * @return the telefono
     */
    public long getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the fechadespido
     */
    public String getFechadespido()
    {
        return fechadespido;
    }

    /**
     * @param fechadespido the fechadespido to set
     */
    public void setFechadespido(String fechadespido)
    {
        this.fechadespido = fechadespido;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDDESPIDO", "NOMBRE", "APELLIDOPA", "APELLIDOMA", "TELEFONO", "CORREO", "FECHADESPIDO"
        };
        String[] registro = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            String sql = "select * from Despidos order by iddespido";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("iddespido");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidopa");
                registro[3] = rs.getString("apellidoma");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("correo");
                registro[6] = rs.getString("fechadespido");
                if (registro[6] != null)
                {
                    registro[6] = registro[6].substring(8, 10)
                            + "/" + registro[6].substring(5, 7)
                            + "/" + registro[6].substring(0, 4);
                } else
                {
                    registro[6] = "Desconocida";
                }
                modelo.addRow(registro);
            }
            if (modelo.getRowCount() == 0)
            {
                String[] registroVacio =
                {
                    "Ninguna fila seleccionada", "Ninguna fila seleccionada",
                    "Ninguna fila seleccionada", "Ninguna fila seleccionada",
                    "Ninguna fila seleccionada", "Ninguna fila seleccionada",
                    "Ninguna fila seleccionada"
                };
                modelo.addRow(registroVacio);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Despidos.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Despidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
}
