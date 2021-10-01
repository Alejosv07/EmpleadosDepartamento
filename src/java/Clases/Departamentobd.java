/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urban
 */
public class Departamentobd extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    //Consulta departamentos
    public ArrayList<Departamento> mostarDepartamentos(){
        Connection con = null;
        ArrayList<Departamento> alR = new ArrayList<Departamento>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM departamentos;");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Departamento dep = new Departamento();
                dep.setDept_no(rs.getInt("dept_no"));
                dep.setDnombre(rs.getString("dnombre"));
                dep.setLoc(rs.getString("loc"));
                alR.add(dep);
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alR;
    }
    
    //Agregar
    public void Agregar(Departamento departamento){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO ... query de insertar");
            
            //Recorda que los mandamos como ? o podes concatenar 
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
