/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author renvs
 */
//CLASE UTIL PRIMER PASO
//clase Entidad se llama igual al nombre tabla. SEGUNDO PASO
public class Conexion {
    public static Connection conectar(){
        Connection cn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433; DataBaseName=ejercicio8_JAVADB;","sa","sqladmin");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }
}
