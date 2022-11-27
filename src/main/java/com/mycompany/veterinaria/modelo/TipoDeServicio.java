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
public class TipoDeServicio
{

    private int idservicio;
    private int idempleado;
    private String nombre;
    private String tipo;
    private double precio;

    public TipoDeServicio()
    {
    }

    public TipoDeServicio(int idservicio, int idempleado, String nombre, String tipo, double precio)
    {
        this.idservicio = idservicio;
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
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
     * @return the idempleado
     */
    public int getIdempleado()
    {
        return idempleado;
    }

    /**
     * @param idempleado the idempleado to set
     */
    public void setIdempleado(int idempleado)
    {
        this.idempleado = idempleado;
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
     * @return the tipo
     */
    public String getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    /**
     * @return the precio
     */
    public double getPrecio()
    {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    @Override
    public String toString()
    {
        //Si es 0 regresa el id
        if (Principal.cadenaTipoDeServicio == 0)
        {
            return String.valueOf(getIdservicio());
        }
        //Si es 1 regresa el nombre
        return getNombre();
    }

    public int insertar(int idempleado, String nombre, String tipo, double precio)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into TipoServicio (idservicio, idempleado, nombre, tipo, precio) values (idServicio.nextval,?,?,?,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idempleado);
            ps.setString(2, nombre);
            ps.setString(3, tipo);
            ps.setDouble(4, precio);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDSERVICIO", "IDEMPLEADO", "NOMBRE", "TIPO", "PRECIO"
        };
        String[] registro = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from TipoServicio order by idservicio";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idservicio");
                registro[1] = rs.getString("idempleado");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("tipo");
                registro[4] = rs.getString("precio");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(int idempleado, String nombre, String tipo, double precio, int idservicio)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update TipoServicio set idempleado = ?, nombre = ?, tipo = ?, precio = ? where idservicio = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idempleado);
            ps.setString(2, nombre);
            ps.setString(3, tipo);
            ps.setDouble(4, precio);
            ps.setInt(5, idservicio);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idservicio)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete TipoServicio where idservicio = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idservicio);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_TipoDeServicio()
    {
        ArrayList listatiposervicio = new ArrayList();

        TipoDeServicio obj_tiposervicio = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from TipoServicio order by idservicio";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_tiposervicio = new TipoDeServicio();
                obj_tiposervicio.setIdservicio(rs.getInt("idservicio"));
                obj_tiposervicio.setIdempleado(rs.getInt("idempleado"));
                obj_tiposervicio.setNombre(rs.getString("nombre"));
                obj_tiposervicio.setTipo(rs.getString("tipo"));
                obj_tiposervicio.setPrecio(rs.getDouble("precio"));
                listatiposervicio.add(obj_tiposervicio);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TipoDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listatiposervicio;
    }
}
