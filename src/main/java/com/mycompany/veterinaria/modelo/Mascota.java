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
public class Mascota
{
    
    private int idmascota;
    private int idtutor;
    private String tipo;
    private String raza;
    private String sexo;
    private double peso;
    private double medida;
    private String fechanacimiento;
    private String detalles;
    private String nombre;
    
    public Mascota()
    {
    }
    
    public Mascota(int idmascota, int idtutor, String tipo, String raza, String sexo, double peso, double medida, String fechanacimiento, String detalles, String nombre)
    {
        this.idmascota = idmascota;
        this.idtutor = idtutor;
        this.tipo = tipo;
        this.raza = raza;
        this.sexo = sexo;
        this.peso = peso;
        this.medida = medida;
        this.fechanacimiento = fechanacimiento;
        this.detalles = detalles;
        this.nombre = nombre;
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
     * @return the idtutor
     */
    public int getIdtutor()
    {
        return idtutor;
    }

    /**
     * @param idtutor the idtutor to set
     */
    public void setIdtutor(int idtutor)
    {
        this.idtutor = idtutor;
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
     * @return the raza
     */
    public String getRaza()
    {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza)
    {
        this.raza = raza;
    }

    /**
     * @return the sexo
     */
    public String getSexo()
    {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    /**
     * @return the peso
     */
    public double getPeso()
    {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    /**
     * @return the medida
     */
    public double getMedida()
    {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(double medida)
    {
        this.medida = medida;
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
    
    @Override
    public String toString()
    {
        return String.valueOf(getIdmascota());
    }
    
    public int insertar(int idtutor, String tipo, String raza, String sexo, double peso, double medida, String fechanacimiento, String detalles, String nombre)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;
        
        try
        {
            String sql = "insert into Mascota (idmascota, idtutor, tipo, raza, sexo, peso, medida, fechanacimiento, detalles, nombre) values (idMascota.nextval,?,?,?,?,?,?,?,?,?)";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idtutor);
            ps.setString(2, tipo);
            ps.setString(3, raza);
            ps.setString(4, sexo);
            ps.setDouble(5, peso);
            ps.setDouble(6, medida);
            ps.setString(7, fechanacimiento);
            ps.setString(8, detalles);
            ps.setString(9, nombre);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    
    public DefaultTableModel consultar()
    {
        String[] campos =
        {
            "IDMASCOTA", "IDTUTOR", "TIPO", "RAZA", "SEXO", "PESO", "MEDIDA", "FECHANACIMIENTO", "DETALLES", "NOMBRE"
        };
        String[] registro = new String[10];
        DefaultTableModel modelo = new DefaultTableModel(null, campos);
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "select * from Mascota order by idmascota";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                registro[0] = rs.getString("idmascota");
                registro[1] = rs.getString("idtutor");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("raza");
                registro[4] = rs.getString("sexo");
                registro[5] = rs.getString("peso");
                registro[6] = rs.getString("medida");
                registro[7] = rs.getString("fechanacimiento");
                registro[8] = rs.getString("detalles");
                registro[9] = rs.getString("nombre");
                modelo.addRow(registro);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }
    
    public int actualizar(int idtutor, String tipo, String raza, String sexo, double peso, double medida, String fechanacimiento, String detalles, String nombre, int idmascota)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;
        
        try
        {
            String sql = "update Mascota set idtutor = ?, tipo = ?, raza = ?, sexo = ?, peso = ?, medida = ?, fechanacimiento = ?, detalles = ?, nombre = ? where idmascota = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idtutor);
            ps.setString(2, tipo);
            ps.setString(3, raza);
            ps.setString(4, sexo);
            ps.setDouble(5, peso);
            ps.setDouble(6, medida);
            ps.setString(7, fechanacimiento);
            ps.setString(8, detalles);
            ps.setString(9, nombre);
            ps.setInt(10, idmascota);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    
    public int eliminar(int idmascota)
    {
        int respuesta = 0;
        Connection conect = null;
        PreparedStatement ps = null;
        
        try
        {
            String sql = "delete Mascota where idmascota = ?";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            ps.setInt(1, idmascota);
            respuesta = ps.executeUpdate();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    
    public ArrayList combo_Mascota()
    {
        ArrayList listamascota = new ArrayList();
        
        Mascota obj_mascota = null;
        
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "select * from Mascota order by idmascota";
            conect = Conexion.Conectar();
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                obj_mascota = new Mascota();
                obj_mascota.setIdmascota(rs.getInt("idmascota"));
                obj_mascota.setIdtutor(rs.getInt("idtutor"));
                obj_mascota.setTipo(rs.getString("tipo"));
                obj_mascota.setRaza(rs.getString("raza"));
                obj_mascota.setSexo(rs.getString("sexo"));
                obj_mascota.setPeso(rs.getDouble("peso"));
                obj_mascota.setMedida(rs.getDouble("medida"));
                obj_mascota.setFechanacimiento(rs.getString("fechanacimiento"));
                obj_mascota.setDetalles(rs.getString("detalles"));
                obj_mascota.setNombre(rs.getString("nombre"));
                listamascota.add(obj_mascota);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Mascota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listamascota;
    }
}
