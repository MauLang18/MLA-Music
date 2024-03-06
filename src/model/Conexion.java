/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author maula
 */
public class Conexion {
    private final String base="DB_MLAMUSIC";
    private final String url="jdbc:mysql://190.113.124.155:3306/"+base;
    private final String user="root";
    private final String password="S0port3.";
    private Connection con=null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(this.url,this.user,this.password);
            
        }catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
