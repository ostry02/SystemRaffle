package org.example;

import org.example.sql.DataBaseControllerRaffleProducts;
import org.example.sql.DataBaseControllerSubmissions;

public class Main {
    public static void main(String[] args) {
        DataBaseControllerSubmissions dBCSub = new DataBaseControllerSubmissions();
        DataBaseControllerRaffleProducts dBCRProd = new DataBaseControllerRaffleProducts();
        System.out.println(dBCSub.displayDataBaseSUBMISSIONS());
        System.out.println(dBCRProd.displayDataBaseRAFFLEPRODUCTS());
    }
}