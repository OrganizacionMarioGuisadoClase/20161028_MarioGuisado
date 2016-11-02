/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.conexion;

import es.albarregas.beans.Ave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Mario
 */
public class Conexion {
        
        DataSource ds;
        private Connection conexion = null;
        private Statement sentencia = null;
        private PreparedStatement preparada = null;
        private ResultSet resultado = null;
        
        public Conexion(){
            try{
                InitialContext initialContext = new InitialContext();
                ds = (DataSource) initialContext.lookup("java:/comp/env/jdbc/Pool");
            }catch(NamingException e){
                System.out.println("Error al acceder a la base de datos");
                e.printStackTrace();
            }
        }
        
        public String insertar(Ave ave){
            String error = "-1";
            String sql = "insert into aves values (?,?,?,?)";
            try{
                
                conexion = ds.getConnection();
                preparada = conexion.prepareStatement(sql);
                preparada.setString(1, ave.getAnilla());
                preparada.setString(2, ave.getEspecie());
                preparada.setString(3, ave.getLugar());
                preparada.setString(4, ave.getFecha());
                try{
                    preparada.executeUpdate();
                }catch(SQLException ex){
                    if(ex.getErrorCode()==1062){
                        error = "Anilla duplicada";
                    }else{
                        error = "Error al introducir los datos";
                    }                    
                }
            }catch(SQLException ex){
                error = "Error al crear la conexion";
                System.out.println("Error al crear la conexion");
                ex.printStackTrace();
            }finally{
                try{
                    if(conexion != null)
                        conexion.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
                try{
                    if(preparada != null)
                        preparada.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }   
            }/*finally*/
            
            return error;
            
        }/*insertar*/
        
        public ArrayList<Ave> todaTabla(){
            ArrayList<Ave> aves = new ArrayList();
            Ave ave;
            String sql = "select * from aves;";
            try{                
                conexion = ds.getConnection();
                System.out.println("estamos aqui");
                sentencia = conexion.createStatement();                
                resultado = sentencia.executeQuery(sql);
                
                while(resultado.next()){
                    ave = new Ave();
                    ave.setAnilla(resultado.getString("anilla"));
                    ave.setEspecie(resultado.getString("especie"));
                    ave.setLugar(resultado.getString("lugar"));
                    ave.setFecha(resultado.getString("fecha"));
                    aves.add(ave);
                }
            }catch(SQLException ex){
                System.out.println("Error al crear la conexion");
                ex.printStackTrace();
            }finally{
                try{
                    if(conexion != null)
                        conexion.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
                try{
                    if(preparada != null)
                        preparada.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }   
            }/*finally*/
            return aves;
        }
        
}/*class*/
