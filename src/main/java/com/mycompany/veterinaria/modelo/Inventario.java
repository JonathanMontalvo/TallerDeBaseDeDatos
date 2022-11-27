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
public class Inventario
{

    private int idarticulo;
    private int idproveedor;
    private String tipo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Inventario()
    {
    }

    public Inventario(int idarticulo, int idproveedor, String tipo, String nombre, int cantidad, double precio)
    {
        this.idarticulo = idarticulo;
        this.idproveedor = idproveedor;
        this.tipo = tipo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * @return the idarticulo
     */
    public int getIdarticulo()
    {
        return idarticulo;
    }

    /**
     * @param idarticulo the idarticulo to set
     */
    public void setIdarticulo(int idarticulo)
    {
        this.idarticulo = idarticulo;
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
     * @return the cantidad
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
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
        if (Principal.cadenaInventario == 0)
        {
            return String.valueOf(getIdarticulo());
        }
        //si es 1 regresa el nombre
        return getNombre();
    }

    public int insertar(int idproveedor, String tipo, String nombre, int cantidad, double precio)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into Inventario (idarticulo, idproveedor, tipo, nombre, cantidad, precio) values (idArticulo.nextval,?,?,?,?,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idproveedor);
            ps.setString(2, tipo);
            ps.setString(3, nombre);
            ps.setInt(4, cantidad);
            ps.setDouble(5, precio);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDARTICULO", "IDPROVEEDOR", "TIPO", "NOMBRE", "CANTIDAD", "PRECIO"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Inventario order by idarticulo";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idarticulo");
                registro[1] = rs.getString("idproveedor");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(int idproveedor, String tipo, String nombre, int cantidad, double precio, int idarticulo)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update Inventario set idproveedor = ?, tipo = ?, nombre = ?, cantidad = ?, precio = ? where idarticulo = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idproveedor);
            ps.setString(2, tipo);
            ps.setString(3, nombre);
            ps.setInt(4, cantidad);
            ps.setDouble(5, precio);
            ps.setInt(6, idarticulo);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idarticulo)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete Inventario where idarticulo = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idarticulo);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_Inventario()
    {
        ArrayList listainventario = new ArrayList();

        Inventario obj_inventario = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Inventario order by idarticulo";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_inventario = new Inventario();
                obj_inventario.setIdarticulo(rs.getInt("idarticulo"));
                obj_inventario.setIdproveedor(rs.getInt("idproveedor"));
                obj_inventario.setTipo(rs.getString("tipo"));
                obj_inventario.setNombre(rs.getString("nombre"));
                obj_inventario.setCantidad(rs.getInt("cantidad"));
                obj_inventario.setPrecio(rs.getDouble("precio"));
                listainventario.add(obj_inventario);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listainventario;
    }
}
