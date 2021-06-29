/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan;

import java.sql.*;

public class Connectdb {
    //String url = "jdbc:mysql://localhost/coba_jdbc";
    String url = "jdbc:mysql://localhost/inventaris";
    String username = "root";
    String password = "";
    Connection connection;
    Statement statement;
    public Connectdb() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
