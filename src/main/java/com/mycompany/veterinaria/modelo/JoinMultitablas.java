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
public class JoinMultitablas
{

    public JoinMultitablas()
    {
    }

    public DefaultTableModel joinTutorMascota()
    {
        String[] campos =
        {
            "IDTUTOR", "NOMBRE TUTOR", "TELEFONO", "DIRECCION", "NOMBRE MASCOTA", "TIPO", "RAZA", "SEXO", "PESO", "DETALLES"
        };
        String[] registro = new String[10];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "t.idtutor, "
                    + "t.nombre as \"NOMBRE TUTOR\", "
                    + "t.telefono, "
                    + "t.direccion, "
                    + "m.nombre as \"NOMBRE MASCOTA\", "
                    + "m.tipo, "
                    + "m.raza, "
                    + "m.sexo, "
                    + "m.peso, "
                    + "m.detalles "
                    + "from Tutor t "
                    + "join "
                    + "Mascota m "
                    + "on t.idtutor = m.idtutor "
                    + "order by t.idtutor asc";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDTUTOR");
                registro[1] = rs.getString("NOMBRE TUTOR");
                registro[2] = rs.getString("TELEFONO");
                registro[3] = rs.getString("DIRECCION");
                registro[4] = rs.getString("NOMBRE MASCOTA");
                registro[5] = rs.getString("TIPO");
                registro[6] = rs.getString("RAZA");
                registro[7] = rs.getString("SEXO");
                registro[8] = rs.getString("PESO");
                registro[9] = rs.getString("DETALLES");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel leftJoinEmpleadosServicios()
    {
        String[] campos =
        {
            "IDEMPLEADO", "NOMBRE COMPLETO", "IDSERVICIO", "NOMBRE SERVICIO", "TIPO", "PRECIO", "AREATRABAJO"
        };
        String[] registro = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "e.idempleado, "
                    + "concat(e.nombre,concat(' ', concat(e.apellidopa, concat(' ',e.apellidoma )))) as \"NOMBRE COMPLETO\", "
                    + "t.idservicio, "
                    + "t.nombre as \"NOMBRE SERVICIO\", "
                    + "t.tipo, "
                    + "t.precio, "
                    + "e.areatrabajo "
                    + "from Tiposervicio t left outer join Empleados e "
                    + "on(t.idempleado = e.idempleado) "
                    + "order by t.idservicio";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDEMPLEADO");
                registro[1] = rs.getString("NOMBRE COMPLETO");
                registro[2] = rs.getString("IDSERVICIO");
                registro[3] = rs.getString("NOMBRE SERVICIO");
                registro[4] = rs.getString("TIPO");
                registro[5] = rs.getString("PRECIO");
                registro[6] = rs.getString("AREATRABAJO");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel joinCitaConsultas()
    {
        String[] campos =
        {
            "IDCITA", "IDCONSULTA", "IDMASCOTA", "FECHA", "DETALLES"
        };
        String[] registro = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "c.idcita, "
                    + "c.idconsulta, "
                    + "c.idmascota, "
                    + "c.fecha, "
                    + "detalles "
                    + "from Cita c right outer join Consultas s "
                    + "on(c.idconsulta = s.idconsulta) "
                    + "intersect "
                    + "select "
                    + "c.idcita, "
                    + "c.idconsulta, "
                    + "c.idmascota, "
                    + "c.fecha, "
                    + "detalles "
                    + "from Cita c  join Consultas s "
                    + "on(c.idconsulta = s.idconsulta) "
                    + "order by idcita asc";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDCITA");
                registro[1] = rs.getString("IDCONSULTA");
                registro[2] = rs.getString("IDMASCOTA");
                registro[3] = rs.getString("FECHA");
                if (registro[3] != null)
                {
                    registro[3] = registro[3].substring(8, 10)
                            + "/" + registro[3].substring(5, 7)
                            + "/" + registro[3].substring(0, 4);
                } else
                {
                    registro[3] = "Desconocida";
                }
                registro[4] = rs.getString("DETALLES");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel multitablaVentasServicioInventarioProveedor()
    {
        String[] campos =
        {
            "IDVENTA", "ARTICULO", "NOMBRE PROVEEDOR", "SERVICIO", "FORMAPAGO", "TOTAL"
        };
        String[] registro = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "v.idventa, "
                    + "i.nombre ARTICULO, "
                    + "p.nombre as \"NOMBRE PROVEEDOR\", "
                    + "t.nombre SERVICIO, "
                    + "v.formapago, "
                    + "v.total "
                    + "from Proveedores p, Inventario i, Ventas v, Tiposervicio t "
                    + "where p.idproveedor = i.idproveedor "
                    + "and i.idarticulo = v.idarticulo "
                    + "and v.idservicio = t.idservicio "
                    + "order by v.idventa";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDVENTA");
                registro[1] = rs.getString("ARTICULO");
                registro[2] = rs.getString("NOMBRE PROVEEDOR");
                registro[3] = rs.getString("SERVICIO");
                registro[4] = rs.getString("FORMAPAGO");
                registro[5] = rs.getString("TOTAL");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public DefaultTableModel multitablaCitaServicioConsultasMascotaTutor()
    {
        String[] campos =
        {
            "IDCITA", "SERVICIO", "NOMBRE MASCOTA", "NOMBRE TUTOR", "CONSULTA", "FECHA", "HORA"
        };
        String[] registro = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            String sql = "select "
                    + "c.idcita, "
                    + "ts.nombre SERVICIO, "
                    + "m.nombre as \"NOMBRE MASCOTA\", "
                    + "t.nombre as \"NOMBRE TUTOR\", "
                    + "cs.detalles CONSULTA, "
                    + "c.fecha, "
                    + "c.hora "
                    + "from Cita c, TipoServicio ts, Consultas cs, Mascota m, Tutor t "
                    + "where c.idservicio = ts.idservicio "
                    + "and cs.idconsulta = c.idconsulta "
                    + "and m.idmascota = c.idmascota "
                    + "and t.idtutor = m.idtutor "
                    + "order by c.idcita ";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("IDCITA");
                registro[1] = rs.getString("SERVICIO");
                registro[2] = rs.getString("NOMBRE MASCOTA");
                registro[3] = rs.getString("NOMBRE TUTOR");
                registro[4] = rs.getString("CONSULTA");
                registro[5] = rs.getString("FECHA");
                if (registro[5] != null)
                {
                    registro[5] = registro[5].substring(8, 10)
                            + "/" + registro[5].substring(5, 7)
                            + "/" + registro[5].substring(0, 4);
                } else
                {
                    registro[5] = "Desconocida";
                }
                registro[6] = rs.getString("HORA");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(JoinMultitablas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
}
