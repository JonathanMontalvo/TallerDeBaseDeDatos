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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class Cita
{

    private int idcita;
    private int idservicio;
    private int idmascota;
    private int idconsulta;
    private String fecha;
    private double hora;

    public Cita()
    {
    }

    public Cita(int idcita, int idservicio, int idmascota, int idconsulta, String fecha, double hora)
    {
        this.idcita = idcita;
        this.idservicio = idservicio;
        this.idmascota = idmascota;
        this.idconsulta = idconsulta;
        this.fecha = fecha;
        this.hora = hora;
    }

    /**
     * @return the idcita
     */
    public int getIdcita()
    {
        return idcita;
    }

    /**
     * @param idcita the idcita to set
     */
    public void setIdcita(int idcita)
    {
        this.idcita = idcita;
    }

    /**
     * @return the idservicio
     */
    public int getIdservicio()
    {
        return idservicio;
    }

    /**
     * @param idservicio the idservicio to set
     */
    public void setIdservicio(int idservicio)
    {
        this.idservicio = idservicio;
    }

    /**
     * @return the idmascota
     */
    public int getIdmascota()
    {
        return idmascota;
    }

    /**
     * @param idmascota the idmascota to set
     */
    public void setIdmascota(int idmascota)
    {
        this.idmascota = idmascota;
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
     * @return the fecha
     */
    public String getFecha()
    {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public double getHora()
    {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(double hora)
    {
        this.hora = hora;
    }

    @Override
    public String toString()
    {
        return String.valueOf(getIdcita());
    }

    public int insertar(int idservicio, int idmascota, int idconsulta, String fecha, double hora)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into Cita (idcita, idservicio, idmascota, idconsulta, fecha, hora) values (idCita.nextval,?,?,?,?,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idservicio);
            ps.setInt(2, idmascota);
            ps.setInt(3, idconsulta);
            ps.setString(4, fecha);
            ps.setDouble(5, hora);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDCITA", "IDSERVICIO", "IDMASCOTA", "IDCONSULTA", "FECHA", "HORA"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Cita order by idcita";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idcita");
                registro[1] = rs.getString("idservicio");
                registro[2] = rs.getString("idmascota");
                registro[3] = rs.getString("idconsulta");
                registro[4] = rs.getString("fecha");
                registro[4] = registro[4].substring(8, 10) + "/"
                        + registro[4].substring(5, 7) + "/"
                        + registro[4].substring(0, 4);
                registro[5] = rs.getString("hora");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(int idservicio, int idmascota, int idconsulta, String fecha, double hora, int idcita)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update Cita set idservicio = ?, idmascota = ?, idconsulta = ?, fecha = ?, hora = ? where idcita = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idservicio);
            ps.setInt(2, idmascota);
            ps.setInt(3, idconsulta);
            ps.setString(4, fecha);
            ps.setDouble(5, hora);
            ps.setInt(6, idcita);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idcita)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete Cita where idcita = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idcita);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_Cita()
    {
        ArrayList listacita = new ArrayList();

        Cita obj_cita = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Cita order by idcita";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_cita = new Cita();
                obj_cita.setIdcita(rs.getInt("idcita"));
                obj_cita.setIdservicio(rs.getInt("idservicio"));
                obj_cita.setIdmascota(rs.getInt("idmascota"));
                obj_cita.setIdconsulta(rs.getInt("idconsulta"));
                obj_cita.setFecha(rs.getString("fecha"));
                obj_cita.setHora(rs.getDouble("hora"));
                listacita.add(obj_cita);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listacita;
    }
}
