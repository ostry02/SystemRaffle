package org.example.sql;

import org.example.user.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
    public void addSubmission(UserInfo userInfo, Integer id){
        String sqlCMD = "INSERT INTO RaffleProjekt."+id+" (firstName, lastName, email, phoneNumber, addressStreet, addressNumber, addressPostCode, country, productSize, instagramHandle) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String countryUpper = userInfo.getCountry().substring(0,1)+userInfo.getCountry().substring(1);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCMD);
            preparedStatement.setString(1, userInfo.getFirstName().toLowerCase());
            preparedStatement.setString(2, userInfo.getLastName().toLowerCase());
            try {
                preparedStatement.setString(3, userInfo.getEmail().toLowerCase());
            }catch (Exception e){
                System.out.println("Juz taki mail jest");
            }
            try {
                preparedStatement.setString(4, userInfo.getPhoneNumber().toLowerCase());
            }catch (Exception e){
                System.out.println("Juz taki telefon juz jest");
            }
            preparedStatement.setString(5, userInfo.getAddressStreet().toLowerCase());
            preparedStatement.setString(6, userInfo.getAddressNumber().toLowerCase());
            preparedStatement.setString(7, userInfo.getAddressPostCode().toLowerCase());
            preparedStatement.setString(8, countryUpper);
            preparedStatement.setString(9, userInfo.getProductSize().toLowerCase());
            try {
                preparedStatement.setString(10, userInfo.getInstagramHandle().toLowerCase());
            }catch (Exception e){
                System.out.println("Już taki instagram jest");
            }
            preparedStatement.executeUpdate();
            System.out.println("Dodano do listy uczestnika");
        } catch (SQLSyntaxErrorException exception){
            System.out.println("Nie ma takiego raffle, sprobój inny ID");
        } catch (Exception e){
            System.out.println("Taki submission juz jest, nie dodano uczestnika");
        }
    }

    public List<Integer> displayIDRaffle(Integer id){
        List<Integer> listIDraffle = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM RaffleProjekt."+id);
            while (resultSet.next()){
                listIDraffle.add(resultSet.getInt("id"));
            }
            Collections.sort(listIDraffle);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listIDraffle;
    }



}
