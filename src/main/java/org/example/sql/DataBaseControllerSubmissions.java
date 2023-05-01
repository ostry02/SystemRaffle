package org.example.sql;

import org.example.user.UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseControllerSubmissions {
    private Connection connection;

    public DataBaseControllerSubmissions(){
        String url = "jdbc:mysql://localhost:3306/RaffleProjekt";
        String user = "root";
        String password = "qwerty1";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Udalo sie polaczyc z Baza Danych SUBMISSIONS");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Nie udalo sie polaczyc z Baza Danych");
        }
    }
    public List<UserInfo> displayDataBaseSUBMISSIONS(){
        List<UserInfo> usersList = new ArrayList<>();
        String sqlCMD = "SELECT * FROM submissions";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCMD);
            while (resultSet.next()) {
                usersList.add(new UserInfo(
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("addressStreet"),
                        resultSet.getString("addressNumber"),
                        resultSet.getString("addressPostCode"),
                        resultSet.getString("country"),
                        resultSet.getString("ProductSize"),
                        resultSet.getString("instagramHandle")
                ));
            }
        }catch (Exception e){
            System.out.println("nie mozna tak");
            e.printStackTrace();
        }
        return usersList;
    }
//    public void createTableForRaffle(){
//        String sqlCMD = "CREATE TABLE IF NOT EXISTS submissions (\n" +
//                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
//                "  `firstName` varchar(45) DEFAULT NULL,\n" +
//                "  `lastName` varchar(45) DEFAULT NULL,\n" +
//                "  `email` varchar(45) DEFAULT NULL,\n" +
//                "  `phoneNumber` varchar(45) DEFAULT NULL,\n" +
//                "  `addressStreet` varchar(45) DEFAULT NULL,\n" +
//                "  `addressNumber` varchar(45) DEFAULT NULL,\n" +
//                "  `addressPostCode` varchar(45) DEFAULT NULL,\n" +
//                "  `country` varchar(45) DEFAULT NULL,\n" +
//                "  `productSize` varchar(45) DEFAULT NULL,\n" +
//                "  `instagramHandle` varchar(45) DEFAULT NULL,\n" +
//                "  PRIMARY KEY (`id`),\n" +
//                "  UNIQUE KEY `email_UNIQUE` (`email`),\n" +
//                "  UNIQUE KEY `phoneNumber_UNIQUE` (`phoneNumber`),\n" +
//                "  UNIQUE KEY `instagramHandle_UNIQUE` (`instagramHandle`)\n" +
//                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;\n";
//        try {
//            Statement statement = connection.createStatement();
//            statement.execute(sqlCMD);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
