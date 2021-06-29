package model;

import controller.Inputcontroller;
import pendataan.Connectdb;

import javax.swing.*;
import java.sql.*;

public class Barangmodel {
    private Connection connection;
    private Statement statement;

    public Barangmodel(){
        Connectdb Connect = new Connectdb();
        connection = Connect.getConnection();
    }

    public String getData(String column, String table, String where, String value){
        try{
            String data = new String();
            statement = connection.createStatement();
            String query = "select "+column+" from "+table+" where "+where+" = '" + value + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data = resultSet.getString(column);
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String[] getData(String column, String table){
        try{
            int row = 1;
            String[] data = new String[numRows("barang")+1];
            statement = connection.createStatement();
            String query = "select "+column+" from "+table;
            ResultSet resultSet = statement.executeQuery(query);
            data[0] = "";
            while (resultSet.next()){
                data[row] = resultSet.getString(column);
                row++;
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public int numRows(String table){
        int jmlData = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from " + table;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public void updateData(String[] data){
        try{
            statement = connection.createStatement();
            String query = "update barang set nama = ?, massa = ?, harga = ? where id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, data[0]);
            preparedStmt.setString (2, data[1]);
            preparedStmt.setString (3, data[2]);
            preparedStmt.setString (4, data[3]);
            preparedStmt.execute();
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void delete(String id){
        try {
            String query = " delete from barang where id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, id);
            preparedStmt.execute();

            query = " delete from barang where id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, id);
            preparedStmt.execute();
            connection.close();

            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal! silakan hapus data barang dengan id = " + id);
        }
        Inputcontroller Inputcontroller = new Inputcontroller();
        Inputcontroller.readBarang();
    }

    public int numRows(String table, String where, String value){
        int jmlData = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from " + table + " where " + where + " = '" + value + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

}
