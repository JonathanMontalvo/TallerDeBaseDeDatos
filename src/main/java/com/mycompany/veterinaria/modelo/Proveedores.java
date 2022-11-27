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
public class Proveedores
{

    private int idproveedor;
    private String nombre;
    private long telefono;
    private String correo;

    public Proveedores()
    {
    }

    public Proveedores(int idproveedor, String nombre, long telefono, String correo)
    {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * @return the idproveedor
     */
    public int getIdproveedor()
    {
        return idproveedor;
    }

    /**
     * @param idproveedor the idproveedor to set
     */
    public void setIdproveedor(int idproveedor)
    {
        this.idproveedor = idproveedor;
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

    @Override
    public String toString()
    {
        //Si es 0 regresa el id
        if (Principal.cadenaProveedor == 0)
        {
            return String.valueOf(getIdproveedor());
        }
        //Si es 1 regresa el nombre
        return getNombre();
    }

    public int insertar(String nombre, long telefono, String correo)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into Proveedores (idproveedor, nombre, telefono, correo) values (idProveedores.nextval,?,?,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setLong(2, telefono);
            ps.setString(3, correo);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDPROVEEDOR", "NOMBRE", "TELEFONO", "CORREO"
        };
        String[] registro = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Proveedores order by idproveedor";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idproveedor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("correo");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(String nombre, long telefono, String correo, int idproveedor)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update Proveedores set nombre = ?, telefono = ?, correo = ? where idproveedor = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setLong(2, telefono);
            ps.setString(3, correo);
            ps.setInt(4, idproveedor);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idproveedor)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete Proveedores where idproveedor = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idproveedor);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_Proveedores()
    {
        ArrayList listaproveedores = new ArrayList();

        Proveedores obj_proveedores = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Proveedores order by idproveedor";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_proveedores = new Proveedores();
                obj_proveedores.setIdproveedor(rs.getInt("idproveedor"));
                obj_proveedores.setNombre(rs.getString("nombre"));
                obj_proveedores.setTelefono(rs.getLong("telefono"));
                obj_proveedores.setCorreo(rs.getString("correo"));
                listaproveedores.add(obj_proveedores);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaproveedores;
    }
}
