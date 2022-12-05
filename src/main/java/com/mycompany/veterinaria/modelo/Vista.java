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
            String sql = "create or replace view Perros as "
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
            String sql = "select * from Perros order by idmascota";
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

    public boolean crearVistaAlimentos()
    {
        boolean respuesta = false;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "create or replace view Alimentos as "
                    + "select "
                    + "tipo, "
                    + "idarticulo, "
                    + "nombre, "
                    + "cantidad, "
                    + "precio, "
                    + "idproveedor "
                    + "from Inventario "
                    + "where tipo = 'Alimento' "
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

    public DefaultTableModel consultarVistaAlimentos()
    {
        String[] campos =
        {
            "TIPO", "IDARTICULO", "NOMBRE", "CANTIDAD", "PRECIO", "IDPROVEEDOR"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Alimentos order by idarticulo";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("TIPO");
                registro[1] = rs.getString("IDARTICULO");
                registro[2] = rs.getString("NOMBRE");
                registro[3] = rs.getString("CANTIDAD");
                registro[4] = rs.getString("PRECIO");
                registro[5] = rs.getString("IDPROVEEDOR");
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

    public boolean crearVistaEmpleados35()
    {
        boolean respuesta = false;
        Connection conect = null;
        PreparedStatement ps = null;

        try
        {
            String sql = "create or replace view Empleados35 as "
                    + "select "
                    + "idempleado, "
                    + "concat(nombre,concat(' ', concat(apellidopa, concat(' ',apellidoma )))) as \"NOMBRE COMPLETO\", "
                    + "areatrabajo as \"AREA DE TRABAJO\", "
                    + "telefono, "
                    + "correo, "
                    + "trunc((to_number(to_char(sysdate,'yyyymmdd'))-to_number(to_char(fechanacimiento,'yyyymmdd')))/10000) EDAD "
                    + "from Empleados "
                    + "where trunc((to_number(to_char(sysdate,'yyyymmdd'))-to_number(to_char(fechanacimiento,'yyyymmdd')))/10000) >= 35 "
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

    public DefaultTableModel consultarVistaEmpleados35()
    {
        String[] campos =
        {
            "IDEMPLEADO", "NOMBRE COMPLETO", "AREA DE TRABAJO", "TELEFONO", "CORREO", "EDAD"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select * from Empleados35 idempleado";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDEMPLEADO");
                registro[1] = rs.getString("NOMBRE COMPLETO");
                registro[2] = rs.getString("AREA DE TRABAJO");
                registro[3] = rs.getString("TELEFONO");
                registro[4] = rs.getString("CORREO");
                registro[5] = rs.getString("EDAD");
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
