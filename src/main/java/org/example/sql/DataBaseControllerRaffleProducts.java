package org.example.sql;

import org.example.raffle.RaffleActivity;
import org.example.raffle.RaffleInfo;
import org.example.raffle.RaffleSelectSizesStock;
import org.example.raffle.RaffleSizesStock;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseControllerRaffleProducts  {
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
//    public List<RaffleInfo> displayDataBaseRAFFLEPRODUCTS(){
//        List<RaffleInfo> raffleList = new ArrayList<>();
//        String sqlCMD = "SELECT * FROM raffleProducts";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sqlCMD);
//            while (resultSet.next()) {
//                raffleList.add(new RaffleInfo(
//                        resultSet.getString("productName"),
//                        resultSet.getString("productSKU"),
//                        resultSet.getString("productPrice"),
//                        resultSet.getInt("productStock"),
//                        resultSet.getDate("startRaffleDate").toLocalDate(),
//                        resultSet.getDate("endRaffleDate").toLocalDate()
//                ));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return raffleList;
//    }
    public void AddRaffle(RaffleInfo raffleInfo, RaffleActivity raffleActivity, RaffleSizesStock raffleSizesStock){
        String sqlCMD = "INSERT INTO raffleProducts (productName, productSKU, productPrice, productStock, startRaffleDate, endRaffleDate, isActive,stockSize4,stockSize45,stockSize5,stockSize55,stockSize6,stockSize65,stockSize7,stockSize75,stockSize8,stockSize85,stockSize9,stockSize95,stockSize10,stockSize105,stockSize11,stockSize115,stockSize12,stockSize125,stockSize13,stockSize135,stockSize14) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Date startDate = Date.valueOf(raffleInfo.getStartRaffleDate());
        Date endDate = Date.valueOf(raffleInfo.getEndRaffleDate());
        System.out.println(raffleSizesStock.getProductStockList().get(0));
        System.out.println(raffleSizesStock.getProductStockList().get(20));
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCMD);
            preparedStatement.setString(1, raffleInfo.getProductName().toLowerCase());
            preparedStatement.setString(2, raffleInfo.getProductSKU().toUpperCase());
            preparedStatement.setDouble(3, raffleInfo.getProductPrice());
            preparedStatement.setInt(4,raffleSizesStock.totalStock());
            preparedStatement.setDate(5, startDate);
            preparedStatement.setDate(6, endDate);
            preparedStatement.setBoolean(7, raffleActivity.isActive());
            preparedStatement.setInt(8,raffleSizesStock.getProductStockList().get(0));
            preparedStatement.setInt(9,raffleSizesStock.getProductStockList().get(1));
            preparedStatement.setInt(10,raffleSizesStock.getProductStockList().get(2));
            preparedStatement.setInt(11,raffleSizesStock.getProductStockList().get(3));
            preparedStatement.setInt(12,raffleSizesStock.getProductStockList().get(4));
            preparedStatement.setInt(13,raffleSizesStock.getProductStockList().get(5));
            preparedStatement.setInt(14,raffleSizesStock.getProductStockList().get(6));
            preparedStatement.setInt(15,raffleSizesStock.getProductStockList().get(7));
            preparedStatement.setInt(16,raffleSizesStock.getProductStockList().get(8));
            preparedStatement.setInt(17,raffleSizesStock.getProductStockList().get(9));
            preparedStatement.setInt(18,raffleSizesStock.getProductStockList().get(10));
            preparedStatement.setInt(19,raffleSizesStock.getProductStockList().get(11));
            preparedStatement.setInt(20,raffleSizesStock.getProductStockList().get(12));
            preparedStatement.setInt(21,raffleSizesStock.getProductStockList().get(13));
            preparedStatement.setInt(22,raffleSizesStock.getProductStockList().get(14));
            preparedStatement.setInt(23,raffleSizesStock.getProductStockList().get(15));
            preparedStatement.setInt(24,raffleSizesStock.getProductStockList().get(16));
            preparedStatement.setInt(25,raffleSizesStock.getProductStockList().get(17));
            preparedStatement.setInt(26,raffleSizesStock.getProductStockList().get(18));
            preparedStatement.setInt(27,raffleSizesStock.getProductStockList().get(19));
            preparedStatement.setInt(28,raffleSizesStock.getProductStockList().get(20));

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
                "  addressIP varchar(45) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `email_UNIQUE` (`email`),\n" +
                "  UNIQUE KEY `phoneNumber_UNIQUE` (`phoneNumber`),\n" +
                "  UNIQUE KEY `instagramHandle_UNIQUE` (`instagramHandle`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;\n";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlCMD);
        }catch (Exception e){
            System.out.println("Problem z tworzeniem nowej tabeli pod raffle");
            e.printStackTrace();
        }
    }
    public List<RaffleSelectSizesStock> getStockPerSize(Integer id){
        String SQLcmd = "SELECT * FROM raffleProducts \n" +
                        "WHERE id="+id;
        List<RaffleSelectSizesStock> stockPerSize = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLcmd);
            while (resultSet.next()){
                stockPerSize.add(new RaffleSelectSizesStock(
                        resultSet.getInt("stockSize4"),
                        resultSet.getInt("stockSize45"),
                        resultSet.getInt("stockSize5"),
                        resultSet.getInt("stockSize55"),
                        resultSet.getInt("stockSize6"),
                        resultSet.getInt("stockSize65"),
                        resultSet.getInt("stockSize7"),
                        resultSet.getInt("stockSize75"),
                        resultSet.getInt("stockSize8"),
                        resultSet.getInt("stockSize85"),
                        resultSet.getInt("stockSize9"),
                        resultSet.getInt("stockSize95"),
                        resultSet.getInt("stockSize10"),
                        resultSet.getInt("stockSize105"),
                        resultSet.getInt("stockSize11"),
                        resultSet.getInt("stockSize115"),
                        resultSet.getInt("stockSize12"),
                        resultSet.getInt("stockSize125"),
                        resultSet.getInt("stockSize13"),
                        resultSet.getInt("stockSize135"),
                        resultSet.getInt("stockSize14")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockPerSize;
    }
}
