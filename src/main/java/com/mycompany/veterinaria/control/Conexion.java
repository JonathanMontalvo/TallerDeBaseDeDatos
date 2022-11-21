/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hernánez Vázquez Bryan, Montalvo Pérez Jonathan, Peña Reynoso Jesús
 */
public class Conexion
{

    public static Connection Conectar()
    {

        Connection con = null;

        //String sid = "ORCL";//Bryan
        String sid = "JONATHAN";//Jonathan
        //String sid = "xe";//Jesús
        String url = "jdbc:oracle:thin:@localhost:1521:" + sid;
        String usuario = "Veterinaria";
        String password = "perros01";

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try
            {
                con = (Connection) DriverManager.getConnection(url, usuario, password);
            } catch (SQLException ex)
            {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }
}
