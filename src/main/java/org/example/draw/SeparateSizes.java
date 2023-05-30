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
    List<Integer> idlistOfSize4 = new ArrayList<>();
    List<Integer> idlistOfSize45 = new ArrayList<>();
    List<Integer> idlistOfSize5 = new ArrayList<>();
    List<Integer> idlistOfSize55 = new ArrayList<>();
    List<Integer> idlistOfSize6 = new ArrayList<>();
    List<Integer> idlistOfSize65 = new ArrayList<>();
    List<Integer> idlistOfSize7 = new ArrayList<>();
    List<Integer> idlistOfSize75 = new ArrayList<>();
    List<Integer> idlistOfSize8 = new ArrayList<>();
    List<Integer> idlistOfSize85 = new ArrayList<>();
    List<Integer> idlistOfSize9 = new ArrayList<>();
    List<Integer> idlistOfSize95 = new ArrayList<>();
    List<Integer> idlistOfSize10 = new ArrayList<>();
    List<Integer> idlistOfSize105 = new ArrayList<>();
    List<Integer> idlistOfSize11 = new ArrayList<>();
    List<Integer> idlistOfSize115 = new ArrayList<>();
    List<Integer> idlistOfSize12 = new ArrayList<>();
    List<Integer> idlistOfSize125 = new ArrayList<>();
    List<Integer> idlistOfSize13 = new ArrayList<>();
    List<Integer> idlistOfSize135 = new ArrayList<>();
    List<Integer> idlistOfSize14 = new ArrayList<>();

    public List<Integer> idsOfSize(Integer raffleID,Double size){
        List<UserInfo> userInfoList =dBCSub.displayAllUsersFromRaffleSpecSize(raffleID,size);
        List<Integer>idsOfSub = new ArrayList<>();
        for (int i=0;i<userInfoList.size();i++){
            idsOfSub.add(userInfoList.get(i).getId());
        }
        return idsOfSub;
    }

    public void separateSizesInSubmissions(Integer raffleID){
//        System.out.println(dBCSub.displayALLSelectedSizes(raffleID));
        List<Double> allSizesSub = dBCSub.displayALLSelectedSizes(raffleID);
        List<UserInfo> allSubmissions = dBCSub.displayAllUsersFromRaffle(raffleID);
//        System.out.println(allSizesSub.size());
//        System.out.println(allSubmissions.size());

        for (int i=0;i<allSubmissions.size();i++){
            if (allSizesSub.get(i).equals(4.0)){
                this.idlistOfSize4.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            } else if (allSizesSub.get(i).equals(4.5)) {
                this.idlistOfSize45.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            } else if (allSizesSub.get(i).equals(5.0)) {
                this.idlistOfSize5.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            } else if (allSizesSub.get(i).equals(5.5)) {
                this.idlistOfSize55.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            } else if (allSizesSub.get(i).equals(6.0)) {
                this.idlistOfSize6.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(6.5)) {
                this.idlistOfSize65.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(7.5)) {
                this.idlistOfSize75.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(8.0)) {
                this.idlistOfSize8.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(8.5)) {
                this.idlistOfSize85.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(9.0)) {
                this.idlistOfSize9.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(9.5)) {
                this.idlistOfSize95.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(10.0)) {
                this.idlistOfSize10.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(10.5)) {
                this.idlistOfSize105.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(11.0)) {
                this.idlistOfSize11.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(11.5)) {
                this.idlistOfSize115.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(12.0)) {
                this.idlistOfSize12.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(12.5)) {
                this.idlistOfSize125.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(13.0)) {
                this.idlistOfSize13.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(13.5)) {
                this.idlistOfSize135.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }else if (allSizesSub.get(i).equals(14.0)) {
                this.idlistOfSize14.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
            }
        }

//        for (int i=0;i<allSizesSub.size();i++){
//            if (allSizesSub.get(i).equals(4.0)){
//                this.idlistOfSize4.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            } else if (allSizesSub.get(i).equals(4.5)) {
//                this.idlistOfSize45.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            } else if (allSizesSub.get(i).equals(5.0)) {
//                this.idlistOfSize5.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            } else if (allSizesSub.get(i).equals(5.5)) {
//                this.idlistOfSize55.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            } else if (allSizesSub.get(i).equals(6.0)) {
//                this.idlistOfSize6.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(6.5)) {
//                this.idlistOfSize65.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(7.5)) {
//                this.idlistOfSize75.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(8.0)) {
//                this.idlistOfSize8.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(8.5)) {
//                this.idlistOfSize85.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(9.0)) {
//                this.idlistOfSize9.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(9.5)) {
//                this.idlistOfSize95.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(10.0)) {
//                this.idlistOfSize10.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(10.5)) {
//                this.idlistOfSize105.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(11.0)) {
//                this.idlistOfSize11.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(11.5)) {
//                this.idlistOfSize115.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(12.0)) {
//                this.idlistOfSize12.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(12.5)) {
//                this.idlistOfSize125.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(13.0)) {
//                this.idlistOfSize13.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(13.5)) {
//                this.idlistOfSize135.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }else if (allSizesSub.get(i).equals(14.0)) {
//                this.idlistOfSize14.add(dBCSub.displayAllUsersFromRaffle(raffleID).get(i).getId());
//            }
//        }
    }

    public List<Integer> getIdlistOfSize4() {
        return idlistOfSize4;
    }

    public List<Integer> getIdlistOfSize45() {
        return idlistOfSize45;
    }

    public List<Integer> getIdlistOfSize5() {
        return idlistOfSize5;
    }

    public List<Integer> getIdlistOfSize55() {
        return idlistOfSize55;
    }

    public List<Integer> getIdlistOfSize6() {
        return idlistOfSize6;
    }

    public List<Integer> getIdlistOfSize65() {
        return idlistOfSize65;
    }

    public List<Integer> getIdlistOfSize7() {
        return idlistOfSize7;
    }

    public List<Integer> getIdlistOfSize75() {
        return idlistOfSize75;
    }

    public List<Integer> getIdlistOfSize8() {
        return idlistOfSize8;
    }

    public List<Integer> getIdlistOfSize85() {
        return idlistOfSize85;
    }

    public List<Integer> getIdlistOfSize9() {
        return idlistOfSize9;
    }

    public List<Integer> getIdlistOfSize95() {
        return idlistOfSize95;
    }

    public List<Integer> getIdlistOfSize10() {
        return idlistOfSize10;
    }

    public List<Integer> getIdlistOfSize105() {
        return idlistOfSize105;
    }

    public List<Integer> getIdlistOfSize11() {
        return idlistOfSize11;
    }

    public List<Integer> getIdlistOfSize115() {
        return idlistOfSize115;
    }

    public List<Integer> getIdlistOfSize12() {
        return idlistOfSize12;
    }

    public List<Integer> getIdlistOfSize125() {
        return idlistOfSize125;
    }

    public List<Integer> getIdlistOfSize13() {
        return idlistOfSize13;
    }

    public List<Integer> getIdlistOfSize135() {
        return idlistOfSize135;
    }

    public List<Integer> getIdlistOfSize14() {
        return idlistOfSize14;
    }
}
