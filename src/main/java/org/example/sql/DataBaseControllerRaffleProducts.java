package org.example.sql;

import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseControllerRaffleProducts {
    private Connection connection;
    public DataBaseControllerRaffleProducts(){
        String url = "jdbc:mysql://localhost:3306/RaffleProjekt";
        String user = "root";
        String password = "qwerty1";
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
    public void AddRaffle(RaffleInfo raffleInfo, RaffleActivity raffleActivity){
        String sqlCMD = "INSERT INTO raffleProducts (productName, productSKU, productPrice, startRaffleDate, endRaffleDate, isActive) VALUES (?,?,?,?,?,?)";
        Date startDate = Date.valueOf(raffleInfo.getStartRaffleDate());
        Date endDate = Date.valueOf(raffleInfo.getEndRaffleDate());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCMD);
            preparedStatement.setString(1, raffleInfo.getProductName());
            preparedStatement.setString(2, raffleInfo.getProductSKU());
            preparedStatement.setString(3, raffleInfo.getProductPrice());
            preparedStatement.setDate(4, startDate);
            preparedStatement.setDate(5, endDate);
            preparedStatement.setBoolean(6, raffleActivity.isActive());
            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException exception){
            System.out.println("Prawodopodnie produkt jest już w Bazie Danych RAFFLEPRODUCTS");
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}
