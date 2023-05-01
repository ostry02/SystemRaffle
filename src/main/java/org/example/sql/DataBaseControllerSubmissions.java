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
}
