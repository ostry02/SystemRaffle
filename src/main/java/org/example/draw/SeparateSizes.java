package org.example.draw;

import org.example.sql.DataBaseControllerSubmissions;
import org.example.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class SeparateSizes {
    DataBaseControllerSubmissions dBCSub;

    public SeparateSizes(DataBaseControllerSubmissions dBCSub) {
        this.dBCSub = dBCSub;
    }

    public List<Integer> idsOfSize(Integer raffleID, Double size) {
        List<UserInfo> userInfoList = dBCSub.displayAllUsersFromRaffleSpecSize(raffleID, size);
        List<Integer> idsOfSub = new ArrayList<>();
        for (int i = 0; i < userInfoList.size(); i++) {
            idsOfSub.add(userInfoList.get(i).getId());
        }
        return idsOfSub;
    }
}