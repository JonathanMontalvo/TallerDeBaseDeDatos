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
public class Empleados
{

    private int idempleado;
    private String nombre;
    private String apellidopa;
    private String apellidoma;
    private String areatrabajo;
    private long telefono;
    private String correo;
    private String fechanacimiento;

    public Empleados()
    {
    }

    public Empleados(int idempleado, String nombre, String apellidopa, String apellidoma, String areatrabajo, long telefono, String correo, String fechanacimiento)
    {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.apellidopa = apellidopa;
        this.apellidoma = apellidoma;
        this.areatrabajo = areatrabajo;
        this.telefono = telefono;
        this.correo = correo;
        this.fechanacimiento = fechanacimiento;
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
     * @return the areatrabajo
     */
    public String getAreatrabajo()
    {
        return areatrabajo;
    }

    /**
     * @param areatrabajo the areatrabajo to set
     */
    public void setAreatrabajo(String areatrabajo)
    {
        this.areatrabajo = areatrabajo;
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
     * @return the fechanacimiento
     */
    public String getFechanacimiento()
    {
        return fechanacimiento;
    }

    /**
     * @param fechanacimiento the fechanacimiento to set
     */
    public void setFechanacimiento(String fechanacimiento)
    {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public String toString()
    {
        //Si es 0 regresa el id
        if (Principal.cadenaEmpleado == 0)
        {
            return String.valueOf(getIdempleado());
        }
        //Si es 1 regresa el nombre completo
        return getNombre() + " " + getApellidopa() + " " + getApellidoma();
    }

    public int insertar(String nombre, String apellidopa, String apellidoma, String areatrabajo, long telefono, String correo, String fechanacimiento)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "insert into Empleados (idempleado, nombre, apellidopa, apellidoma, areatrabajo, telefono, correo, fechanacimiento) values (2077011,?,?,?,?,?,?,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellidopa);
            ps.setString(3, apellidoma);
            ps.setString(4, areatrabajo);
            ps.setLong(5, telefono);
            ps.setString(6, correo);
            ps.setString(7, fechanacimiento);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDEMPLEADO", "NOMBRE", "APELLIDOPA", "APELLIDOMA", "AREATRABAJO", "TELEFONO", "CORREO", "FECHANACIMIENTO"
        };
        String[] registro = new String[8];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            String sql = "select * from Empleados order by idempleado";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idempleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidopa");
                registro[3] = rs.getString("apellidoma");
                registro[4] = rs.getString("areatrabajo");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("correo");
                registro[7] = rs.getString("fechanacimiento");
                if (registro[7] != null)
                {
                    registro[7] = registro[7].substring(8, 10)
                            + "/" + registro[7].substring(5, 7)
                            + "/" + registro[7].substring(0, 4);
                } else
                {
                    registro[7] = "Desconocida";
                }
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel consultaEspecifica(int idempleado)
    {
        String[] campos =
        {
            "IDEMPLEADO", "NOMBRE", "APELLIDOPA", "APELLIDOMA", "AREATRABAJO", "TELEFONO", "CORREO", "FECHANACIMIENTO"
        };
        String[] registro = new String[8];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            String sql = "select * from Empleados where idempleado = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idempleado);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idempleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidopa");
                registro[3] = rs.getString("apellidoma");
                registro[4] = rs.getString("areatrabajo");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("correo");
                registro[7] = rs.getString("fechanacimiento");
                if (registro[7] != null)
                {
                    registro[7] = registro[7].substring(8, 10)
                            + "/" + registro[7].substring(5, 7)
                            + "/" + registro[7].substring(0, 4);
                } else
                {
                    registro[7] = "Desconocida";
                }
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public int actualizar(String nombre, String apellidopa, String apellidoma, String areatrabajo, long telefono, String correo, String fechanacimiento, int idempleado)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "update Empleados set nombre = ?, apellidopa = ?, apellidoma = ?, areatrabajo = ?, telefono = ?, correo = ?, fechanacimiento = ? where idempleado = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellidopa);
            ps.setString(3, apellidoma);
            ps.setString(4, areatrabajo);
            ps.setLong(5, telefono);
            ps.setString(6, correo);
            ps.setString(7, fechanacimiento);
            ps.setInt(8, idempleado);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public int eliminar(int idempleado)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "delete Empleados where idempleado = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idempleado);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }

    public ArrayList combo_Empleados()
    {
        ArrayList listaempleados = new ArrayList();

        Empleados obj_empleados = null;

        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Empleados order by idempleado";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_empleados = new Empleados();
                obj_empleados.setIdempleado(rs.getInt("idempleado"));
                obj_empleados.setNombre(rs.getString("nombre"));
                obj_empleados.setApellidopa(rs.getString("apellidopa"));
                obj_empleados.setApellidoma(rs.getString("apellidoma"));
                obj_empleados.setAreatrabajo(rs.getString("areatrabajo"));
                obj_empleados.setTelefono(rs.getLong("telefono"));
                obj_empleados.setCorreo(rs.getString("correo"));
                obj_empleados.setFechanacimiento(rs.getString("fechanacimiento"));
                listaempleados.add(obj_empleados);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaempleados;
    }
}
