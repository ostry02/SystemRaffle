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

    public void separateSizes(Integer raffleID){
        System.out.println(dBCSub.displayALLSizes(raffleID));
        Map<Integer, Double> allSizesSub = dBCSub.displayALLSizes(raffleID);
        Map<Integer, Double> mapSize65 = new HashMap<>();
        Map<Integer, Double> mapSize4 = new HashMap<>();

//        for (int i=0;i<allSizesSub.size();i++){
//            if (allSizesSub.get(i).equals(4.0)){
//                System.out.println("siema ziomek");
//            }
//            System.out.println(allSizesSub.get(i));
//        }
        for (var entry : allSizesSub.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            if (entry.getValue().equals(6.5)){
                mapSize65.put(entry.getKey(),entry.getValue());
            } else if (entry.getValue().equals(4.0)) {
                mapSize4.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(mapSize65);
        System.out.println(mapSize4);
    }
}
