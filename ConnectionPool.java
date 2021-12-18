package com.hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kise
 */
public class ConnectionPool {
    
    String db_username;
    String db_password;
    String db_host = "127.0.0.1";
    String db_name;
    Connection con;

    public ConnectionPool() {
        
    }
    
     public ConnectionPool(String username, String password) {
        
         this.db_username = username;
         this.db_password = password;
         
    }
     
     public ConnectionPool(String username, String password, String database_name) {
        
          this.db_username = username;
          this.db_password = password;
          this.db_name = database_name;
         
    }
     
     
     public Connection createCon(){
         
         String url = "jdbc:mysql://"+db_host+":3306/"+db_name;
         
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, db_username, db_password);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return con;
     }
     
     
     public boolean createCon2(){
         
         String url = "jdbc:mysql://"+db_host+":3306/"+db_name;
         
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, db_username, db_password);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return true;
     }
     
    
    
    
}
