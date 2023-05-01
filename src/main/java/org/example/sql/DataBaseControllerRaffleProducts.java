package org.example.sql;

import org.example.product.ProductInfo;
import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseControllerRaffleProducts extends DataBaseControllerSubmissions {
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
            preparedStatement.setString(1, raffleInfo.getProductName().toLowerCase());
            preparedStatement.setString(2, raffleInfo.getProductSKU().toUpperCase());
            preparedStatement.setString(3, raffleInfo.getProductPrice().toLowerCase());
            preparedStatement.setDate(4, startDate);
            preparedStatement.setDate(5, endDate);
            preparedStatement.setBoolean(6, raffleActivity.isActive());
            preparedStatement.executeUpdate();
            createTableForRaffle();
        } catch (SQLIntegrityConstraintViolationException exception){
            System.out.println("Prawodopodnie produkt jest już w Bazie Danych RAFFLEPRODUCTS");
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
    public List<Integer> displayID(){
        List<Integer> listID = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM raffleProducts");
            while (resultSet.next()){
                listID.add(resultSet.getInt("id"));
            }
            Collections.sort(listID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listID;
    }
    public Integer getLastID(){
        return displayID().get(displayID().size()-1);
    }
    public void createTableForRaffle(){
        String sqlCMD = "CREATE TABLE IF NOT EXISTS RaffleProjekt."+getLastID()+" (\n" +
                "  id int NOT NULL AUTO_INCREMENT,\n" +
                "  firstName varchar(45) DEFAULT NULL,\n" +
                "  lastName varchar(45) DEFAULT NULL,\n" +
                "  email varchar(45) DEFAULT NULL,\n" +
                "  phoneNumber varchar(45) DEFAULT NULL,\n" +
                "  addressStreet varchar(45) DEFAULT NULL,\n" +
                "  addressNumber varchar(45) DEFAULT NULL,\n" +
                "  addressPostCode varchar(45) DEFAULT NULL,\n" +
                "  country varchar(45) DEFAULT NULL,\n" +
                "  productSize varchar(45) DEFAULT NULL,\n" +
                "  instagramHandle varchar(45) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `email_UNIQUE` (`email`),\n" +
                "  UNIQUE KEY `phoneNumber_UNIQUE` (`phoneNumber`),\n" +
                "  UNIQUE KEY `instagramHandle_UNIQUE` (`instagramHandle`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;\n";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlCMD);
        }catch (Exception e){
            System.out.println("tutaj jest cos nie tak");
            e.printStackTrace();
        }
    }

}
