package org.example.sql;

import org.example.raffle.RaffleInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseControllerRaffleProducts {
    private Connection connection;
    public DataBaseControllerRaffleProducts(){
        String url = "jdbc:mysql://localhost:3306/RaffleProjekt";
        String user = "root";
        String password = "abc";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Udalo sie polaczyc z Baza Danych RAFFLEPRODUCTS");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<RaffleInfo> displayDataBaseRAFFLEPRODUCTS(){
        List<RaffleInfo> raffleList = new ArrayList<>();
        String sqlCMD = "SELECT * FROM raffleProducts";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCMD);
            while (resultSet.next()) {
                raffleList.add(new RaffleInfo(
                        resultSet.getString("productName"),
                        resultSet.getString("productSKU"),
                        resultSet.getString("productPrice"),
                        resultSet.getDate("startRaffleDate").toLocalDate(),
                        resultSet.getDate("endRaffleDate").toLocalDate()
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return raffleList;
    }
}
