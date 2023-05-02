package org.example.user;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UserIP {
    public static String collectIP(){
        String urlString = "https://myexternalip.com/raw";
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return urlString;
    }
    //TODO collect MAC address from IP address
}
