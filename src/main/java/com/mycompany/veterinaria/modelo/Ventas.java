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
public class Ventas
{

    private int idventa;
    private int idarticulo;
    private int idservicio;
    private String formapago;
    private String detalles;
    private double total;

    public Ventas()
    {
    }

    public Ventas(int idventa, int idarticulo, int idservicio, String formapago, String detalles, double total)
    {
        this.idventa = idventa;
        this.idarticulo = idarticulo;
        this.idservicio = idservicio;
        this.formapago = formapago;
        this.detalles = detalles;
        this.total = total;
    }

    /**
     * @return the idventa
     */
    public int getIdventa()
    {
        return idventa;
    }

    /**
     * @param idventa the idventa to set
     */
    public void setIdventa(int idventa)
    {
        this.idventa = idventa;
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
     * @return the formapago
     */
    public String getFormapago()
    {
        return formapago;
    }

    /**
     * @param formapago the formapago to set
     */
    public void setFormapago(String formapago)
    {
        this.formapago = formapago;
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

    /**
     * @return the total
     */
    public double getTotal()
    {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total)
    {
        this.total = total;
    }

    @Override
    public String toString()
    {
        return String.valueOf(getIdventa());
    }

    public int insertar(int idarticulo, int idservicio, String formapago, String detalles)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into Ventas (idventa, idarticulo, idservicio, formapago, detalles, total) values (idVenta.nextval,?,?,?,?,(select precio from Inventario where idarticulo = ?)+(select precio from Tiposervicio where idservicio = ?))";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idarticulo);
            ps.setInt(2, idservicio);
            ps.setString(3, formapago);
            ps.setString(4, detalles);
            ps.setInt(5, idarticulo);
            ps.setInt(6, idservicio);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDVENTA", "IDARTICULO", "IDSERVICIO", "FORMAPAGO", "DETALLES", "TOTAL"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Ventas order by idventa";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("idarticulo");
                registro[2] = rs.getString("idservicio");
                registro[3] = rs.getString("formapago");
                registro[4] = rs.getString("detalles");
                registro[5] = rs.getString("total");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel consultaEspecifica(int idventa)
    {
        String[] campos =
        {
            "IDVENTA", "IDARTICULO", "IDSERVICIO", "FORMAPAGO", "DETALLES", "TOTAL"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Ventas where idventa = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idventa);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("idarticulo");
                registro[2] = rs.getString("idservicio");
                registro[3] = rs.getString("formapago");
                registro[4] = rs.getString("detalles");
                registro[5] = rs.getString("total");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(int idarticulo, int idservicio, String formapago, String detalles, double total, int idventa)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update Ventas set idarticulo = ?, idservicio = ?, formapago = ?, detalles = ?, total = ? where idventa = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idarticulo);
            ps.setInt(2, idservicio);
            ps.setString(3, formapago);
            ps.setString(4, detalles);
            ps.setDouble(5, total);
            ps.setInt(6, idventa);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idventa)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete Ventas where idventa = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idventa);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_Ventas()
    {
        ArrayList listaventas = new ArrayList();

        Ventas obj_ventas = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Ventas order by idventa";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_ventas = new Ventas();
                obj_ventas.setIdventa(rs.getInt("idventa"));
                obj_ventas.setIdarticulo(rs.getInt("idarticulo"));
                obj_ventas.setIdservicio(rs.getInt("idservicio"));
                obj_ventas.setFormapago(rs.getString("formapago"));
                obj_ventas.setDetalles(rs.getString("detalles"));
                obj_ventas.setTotal(rs.getDouble("total"));
                listaventas.add(obj_ventas);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaventas;
    }
}
