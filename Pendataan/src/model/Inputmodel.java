package model;

import pendataan.Connectdb;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import view.Databarangview;

public class Inputmodel extends Barangmodel{
    private Connection connection;
    private Statement statement;

    public Inputmodel(){
        Connectdb dbConnect = new Connectdb();
        connection = dbConnect.getConnection();
    }

  
    public void createBarang(String [] data){
        try{
            String query = " insert into barang (nama, massa, harga) values (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, data[0]);
            preparedStmt.setString (2, data[1]);
            preparedStmt.setString (3, data[2]);
            preparedStmt.execute();
            connection.close();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[][] readBarang() {
        try{
            int row = 0;
            int numRows = numRows("barang");
            if(numRows==0){
                return null;
            }
            String[][] data = new String[numRows][8];
            statement = connection.createStatement();
            String query = "select * from barang";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[row][0] = resultSet.getString("id");
                data[row][1] = resultSet.getString("nama");
                data[row][2] = resultSet.getString("massa");
                data[row][3] = resultSet.getString("harga");
                row++;
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String[] readBarang(String id) {
                try{
            String[] data = new String[9];
            statement = connection.createStatement();
            String query = "select * from barang";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama");
                data[2] = resultSet.getString("massa");
                data[3] = resultSet.getString("harga");
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    @Override
    public void updateData(String[] data) {
        super.updateData(data);
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

}

