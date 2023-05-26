package org.example.draw;

import org.example.sql.DataBaseControllerSubmissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawSeparateSizes {
    DataBaseControllerSubmissions dBCSub;

    public DrawSeparateSizes(DataBaseControllerSubmissions dBCSub) {
        this.dBCSub = dBCSub;
    }

    public List<Double> separateSizes(Integer raffleID){
        System.out.println(dBCSub.displayALLSizes(raffleID));
        List<Double> allSizesSub = dBCSub.displayALLSizes(raffleID);
        List<Double> mapSize65 = new ArrayList<>();

        for (int i=0;i<allSizesSub.size();i++){
            if (allSizesSub.get(i).equals(6.5)){
                System.out.println("to jest rozmiar 6.5");
            }
            System.out.println(allSizesSub.get(i));
        }
        System.out.println(mapSize65);
        return mapSize65;
    }
}
