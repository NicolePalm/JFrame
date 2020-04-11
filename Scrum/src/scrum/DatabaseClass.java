package scrum;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danie
 */
public class DatabaseClass {
    public DatabaseClass() throws SQLException
    {
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/ScrumProjektDB","ScrumAdmin","masterkey");
        System.out.println("Connected");
         
    }
}
