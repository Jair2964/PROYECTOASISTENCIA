/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenine.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class Conexion {
    public Statement stm = null;
    ResultSet rs = null;
    Connection conect = null;
        public Connection conexion ()
        {       
        try {
            
            Class.forName ("org.gjt.mm.mysql.Driver");
           conect = DriverManager.getConnection ("jdbc:mysql://localhost/controlasistencia","root","20Peru20");
           stm = conect.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null,"Error "+e);
            
        }
        return conect;
        
    }
       public ResultSet getDatos(String com) {
        try {
            this.conexion();
            rs = stm.executeQuery(com);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error getDatos: " + e);
        }
        return rs;
    }

     
}

        