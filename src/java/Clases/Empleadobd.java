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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urban
 */
public class Empleadobd extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    //1.1 Cree una consulta que muestre todos los empleados.
    public ArrayList<Empleado> mostarTodosEmpleados(){
        Connection con = null;
        ArrayList<Empleado> alR = new ArrayList<Empleado>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM empleado INNER JOIN departamentos ON departamentos.dept_no = empleado.dept_no;");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setEmp_no(rs.getInt("emp_no"));
                emp.setApellido(rs.getString("apellido"));
                emp.setOficio(rs.getString("oficio"));
                emp.setDir(rs.getString("dir"));
                
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(rs.getString("fecha_alt"));
                emp.setFecha_alt(date);
                
                emp.setSalario(rs.getDouble("salario"));
                emp.setComision(rs.getDouble("comision"));
                
                Departamento dep = new Departamento();
                dep.setDept_no(rs.getInt("dept_no"));
                dep.setDnombre(rs.getString("dnombre"));
                dep.setLoc(rs.getString("loc"));
                
                emp.setDepartamento(dep);
                
                alR.add(emp);
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
    
    //1.2 Filtre la consulta por departamento.
    public ArrayList<Empleado> mostarPorDepartamento(String departamento){
        Connection con = null;
        ArrayList<Empleado> alR = new ArrayList<Empleado>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM empleado INNER JOIN departamentos ON departamentos.dept_no = empleado.dept_no WHERE LOWER(departamentos.dnombre) = LOWER('"+departamento+"')");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Empleado emp = new Empleado();
                emp.setEmp_no(rs.getInt("emp_no"));
                emp.setApellido(rs.getString("apellido"));
                emp.setOficio(rs.getString("oficio"));
                emp.setDir(rs.getString("dir"));
                
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(rs.getString("fecha_alt"));
                emp.setFecha_alt(date);
                
                emp.setSalario(rs.getDouble("salario"));
                emp.setComision(rs.getDouble("comision"));
                
                Departamento dep = new Departamento();
                dep.setDept_no(rs.getInt("dept_no"));
                dep.setDnombre(rs.getString("dnombre"));
                dep.setLoc(rs.getString("loc"));
                
                emp.setDepartamento(dep);
                
                alR.add(emp);
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
    
    //<!-- 1.3 Calcula el salario medio de todos los empleados. -->
    public double salarioMedioTodos(){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT CAST((SUM(salario)/COUNT(salario)) AS DECIMAL(10,2)) FROM empleado;");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
            
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    //<!-- 1.4 Muestre el salario mayor de los empleados. -->
    public double salarioMaximoTodos(){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT CAST(MAX(salario) AS DECIMAL(10,2)) FROM empleado;");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getDouble(1);
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    //<!-- 1.5 Muestre el salario menor de los empleados. -->
    public double salarioMenorTodos(){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT CAST(MIN(salario) AS DECIMAL(10,2)) FROM empleado;");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getDouble(1);
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    //<!-- 1.6 El formulario debe mostrar además una consulta de la cantidad de empleados por departamento y salario promedio.
    public double nEmpleadosDepartamento(String departamento){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT COUNT(empleado.apellido) FROM empleado INNER JOIN departamentos ON empleado.dept_no = departamentos.dept_no WHERE LOWER(departamentos.dnombre) = LOWER('"+departamento+"');");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getDouble(1);
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    public double salarioMedioEmpleadosDepartamento(String departamento){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT CAST((SUM(salario)/COUNT(salario)) AS DECIMAL(10,2)) FROM empleado INNER JOIN departamentos ON empleado.dept_no = departamentos.dept_no WHERE LOWER(departamentos.dnombre) = LOWER('"+departamento+"');");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getDouble(1);
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleadobd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
