/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.modelo;

import com.mycompany.veterinaria.control.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class FuncionProcedimiento
{

    public FuncionProcedimiento()
    {
    }

    public String consultarProcedimientoSinIVA(int idarticulo)
    {
        String respuesta = "";
        Connection conect = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try
        {
            String sql = "{call totalsin (?)}";
            conect = Conexion.Conectar();
            cs = conect.prepareCall(sql);
            cs.setInt(1, idarticulo);
            cs.executeQuery();
            
            rs = (ResultSet)cs.getObject(1);
            
            respuesta = cs.getString(1);
        } catch (SQLException ex)
        {
            Logger.getLogger(FuncionProcedimiento.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                if (cs != null)
                {
                    cs.close();
                }
                if (conect != null)
                {
                    conect.close();
                }

            } catch (SQLException ex)
            {
                Logger.getLogger(FuncionProcedimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
}
