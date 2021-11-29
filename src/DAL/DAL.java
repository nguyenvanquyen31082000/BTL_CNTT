/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Audd
 */
public class DAL {
    public static Connection getConnection() throws SQLException{
        Connection conn = null;
        try (FileInputStream f = new FileInputStream("db.properties")) {
            
            Properties pros = new Properties();
            pros.load(f);
            
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String passWord = pros.getProperty("password");
            
            conn = DriverManager.getConnection(url, user, passWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
