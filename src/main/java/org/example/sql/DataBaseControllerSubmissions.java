package org.example.sql;

import org.example.user.UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseControllerUser {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public DataBaseControllerUser(){
        String url = "jdbc:mysql://localhost:3306/RaffleProjekt";
        String user = "root";
        String password = "Gargu3366";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Udalo sie polaczyc z Baza Danych");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Nie udalo sie polaczyc z Baza Danych");
        }
    }
    public List<UserInfo> displayDataBase(){
        List<UserInfo> usersList = new ArrayList<>();
        String sqlCMD = "SELECT * FROM submissions";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
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
            e.printStackTrace();
        }
        return usersList;
    }
}
