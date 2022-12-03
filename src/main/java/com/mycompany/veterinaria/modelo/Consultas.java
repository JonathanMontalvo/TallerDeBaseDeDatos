/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.modelo;

import com.mycompany.veterinaria.control.Conexion;
import com.mycompany.veterinaria.vista.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class Consultas
{

    private int idconsulta;
    private String detalles;

    public Consultas()
    {
    }

    public Consultas(int idconsulta, String detalles)
    {
        this.idconsulta = idconsulta;
        this.detalles = detalles;
    }

    /**
     * @return the idconsulta
     */
    public int getIdconsulta()
    {
        return idconsulta;
    }

    /**
     * @param idconsulta the idconsulta to set
     */
    public void setIdconsulta(int idconsulta)
    {
        this.idconsulta = idconsulta;
    }

    /**
     * @return the detalles
     */
    public String getDetalles()
    {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles)
    {
        this.detalles = detalles;
    }

    @Override
    public String toString()
    {
        //Si es 0 regresa el id
        if (Principal.cadenaConsulta == 0)
        {
            return String.valueOf(getIdconsulta());
        }
        //Si es 1 regresa los detalles
        return getDetalles();
    }

    public int insertar(String detalles)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into Consultas (idconsulta, detalles) values (idConsulta.nextval,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setString(1, detalles);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDCONSULTA", "DETALLES"
        };
        String[] registro = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Consultas order by idconsulta";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idconsulta");
                registro[1] = rs.getString("detalles");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel consultaEspecifica(int idconsulta)
    {
        String[] campos =
        {
            "IDCONSULTA", "DETALLES"
        };
        String[] registro = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Consultas where idconsulta = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idconsulta);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idconsulta");
                registro[1] = rs.getString("detalles");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(String detalles, int idconsulta)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update Consultas set detalles = ? where idconsulta = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setString(1, detalles);
            ps.setInt(2, idconsulta);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idconsulta)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete Consultas where idconsulta = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idconsulta);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_Consultas()
    {
        ArrayList listaconsultas = new ArrayList();

        Consultas obj_consultas = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Consultas order by idconsulta";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_consultas = new Consultas();
                obj_consultas.setIdconsulta(rs.getInt("idconsulta"));
                obj_consultas.setDetalles(rs.getString("detalles"));
                listaconsultas.add(obj_consultas);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaconsultas;
    }
}
