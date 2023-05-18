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
                System.out.println("siema ziomek");
            }
            System.out.println(allSizesSub.get(i));
        }
//        for (var entry : allSizesSub.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//            if (entry.getValue().equals(6.5)){
//                mapSize65.put(entry.getKey(),entry.getValue());
//            } else if (entry.getValue().equals(4.0)) {
//                mapSize4.put(entry.getKey(),entry.getValue());
//            }
//        }
        System.out.println(mapSize65);
        return mapSize65;
    }
}
