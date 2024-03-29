package org.example.sql;


import org.example.user.UserInfo;

import java.sql.*;
import java.util.*;

import static org.example.user.UserIP.collectIP;

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
//    public List<UserInfo> displayDataBaseSUBMISSIONS(){
//        List<UserInfo> usersList = new ArrayList<>();
//        String sqlCMD = "SELECT * FROM submissions";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sqlCMD);
//            while (resultSet.next()) {
//                usersList.add(new UserInfo(
//                        resultSet.getString("firstname"),
//                        resultSet.getString("lastname"),
//                        resultSet.getString("email"),
//                        resultSet.getString("phoneNumber"),
//                        resultSet.getString("addressStreet"),
//                        resultSet.getString("addressNumber"),
//                        resultSet.getString("addressPostCode"),
//                        resultSet.getString("country"),
//                        resultSet.getString("ProductSize"),
//                        resultSet.getString("instagramHandle")
//                ));
//            }
//        }catch (Exception e){
//            System.out.println("nie mozna tak");
//            e.printStackTrace();
//        }
//        return usersList;
//    }
    public void addSubmission(UserInfo userInfo, Integer id){
        String sqlCMD = "INSERT INTO RaffleProjekt."+id+" (firstName, lastName, email, phoneNumber, addressStreet, addressNumber, addressPostCode, country, productSize, instagramHandle, addressIP) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        String countryUpper = userInfo.getCountry().substring(0,1).toUpperCase()+userInfo.getCountry().substring(1);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCMD);
            preparedStatement.setString(1, userInfo.getFirstName().toLowerCase());
            preparedStatement.setString(2, userInfo.getLastName().toLowerCase());
            try {
                preparedStatement.setString(3, userInfo.getEmail().toLowerCase());
            }catch (SQLIntegrityConstraintViolationException e){
                System.out.println("Juz taki mail jest");
            }
            try {
                preparedStatement.setString(4, userInfo.getPhoneNumber());
            }catch (SQLIntegrityConstraintViolationException e){
                System.out.println("Juz taki telefon juz jest");
            }
            preparedStatement.setString(5, userInfo.getAddressStreet().toLowerCase());
            preparedStatement.setString(6, userInfo.getAddressNumber());
            preparedStatement.setString(7, userInfo.getAddressPostCode());
            preparedStatement.setString(8, countryUpper);
            preparedStatement.setString(9, userInfo.getUserSelectedSize().toString().replace("[", "").replace("]",""));
            try {
                preparedStatement.setString(10, userInfo.getInstagramHandle().toLowerCase());
            }catch (SQLIntegrityConstraintViolationException e){
                System.out.println("Już taki instagram jest");
            }
            preparedStatement.setString(11,collectIP());
            preparedStatement.executeUpdate();
            System.out.println("Dodano do listy uczestnika");
        } catch (SQLSyntaxErrorException exception){
            System.out.println("Nie ma takiego raffle, sprobój inny ID");
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Taki email, telefon lub intagram został juz uzyty");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Taki submission juz jest, nie dodano uczestnika");
        }
    }

    public List<Integer> displayALLIDsRaffle(Integer id){
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
    public List<Double> displayALLSelectedSizes(Integer id){
        List<Double> ListSizeRaffle = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM RaffleProjekt."+id);
            while (resultSet.next()){
                ListSizeRaffle.add(resultSet.getDouble("productSize"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ListSizeRaffle;
    }

        public List<UserInfo> displayAllUsersFromRaffle(Integer id){
        List<UserInfo> usersList = new ArrayList<>();
        String sqlCMD = "SELECT * FROM RaffleProjekt."+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCMD);
            while (resultSet.next()) {
                usersList.add(new UserInfo(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("addressStreet"),
                        resultSet.getString("addressNumber"),
                        resultSet.getString("addressPostCode"),
                        resultSet.getString("country"),
                        resultSet.getDouble("productSize"),
                        resultSet.getString("instagramHandle")
                        ));
            }
        } catch (SQLFeatureNotSupportedException exception){
            exception.printStackTrace();
        } catch (Exception e){
            System.out.println("nie mozna tak");
            e.printStackTrace();
        }
            return usersList;
    }

    public List<UserInfo> displayAllUsersFromRaffleSpecSize(Integer id, Double size){
        List<UserInfo> usersList = new ArrayList<>();
        String sqlCMD = "SELECT * FROM RaffleProjekt."+id+
                        " WHERE productSize="+size;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCMD);
            while (resultSet.next()) {
                usersList.add(new UserInfo(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("addressStreet"),
                        resultSet.getString("addressNumber"),
                        resultSet.getString("addressPostCode"),
                        resultSet.getString("country"),
                        resultSet.getDouble("productSize"),
                        resultSet.getString("instagramHandle")
                ));
            }
        } catch (SQLFeatureNotSupportedException exception){
            exception.printStackTrace();
        } catch (Exception e){
            System.out.println("nie mozna tak");
            e.printStackTrace();
        }
        return usersList;
    }






}
