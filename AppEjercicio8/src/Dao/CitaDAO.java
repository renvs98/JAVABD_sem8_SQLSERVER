/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.*;
import Util.Conexion;
import Entity.Cita;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author renvs
 */
public class CitaDAO {
    Connection cn=Conexion.conectar();
    
    //DATO AUTOGENERADO MYSQL=NULL
    //SQL SERVER NUNCA PONER NULL EN AUTOGENERADO. SE IGNORA
    public void guardar(Cita cita){
        try {
            String sql="INSERT INTO Cita VALUES(?,?,?,?)";
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, cita.getPaciente());
            pstm.setDate(2, cita.getFechaAtencion());
            pstm.setString(3, cita.getDoctor());
            pstm.setString(4, cita.getEspecialidad());
            
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //guardar datos 
    public ArrayList<Cita>listar(){
        ArrayList<Cita> lstCitas=new ArrayList();
        try {
            String sql="SELECT*FROM Cita";
            PreparedStatement pstm=cn.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String paciente=rs.getString(2);
                Date fecha=rs.getDate(3);
                String doctor=rs.getString(4);
                String especialidad=rs.getString(5);
                
                Cita cita=new Cita (codigo, paciente, fecha, doctor, especialidad);
                lstCitas.add(cita);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lstCitas;
    }
    
    public void eliminar(int codigo){
        try {
            String sql="DELETE FROM Cita WHERE Codigo=?";
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
