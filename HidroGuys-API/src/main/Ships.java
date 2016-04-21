/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Farm;
import pojo.Ship;

/**
 *
 * @author emman
 */
public class Ships {

    private final HidroConfig conf;
    private final String path = "ships";

    public Ships(HidroConfig conf) {
        this.conf = conf;
    }

    public List<Ship> getAll() {
        String urlString = conf.getURL() + path;
        URL url;
        InputStream is;
        List<Ship> farms = null;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();
            is = conn.getInputStream();
            farms = jsonToObject(HidroAPI.inputStreamToString(is));
        } catch (MalformedURLException ex) {
            Logger.getLogger(HidroAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HidroAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return farms;
    }

    public void add(Ship newFarm) {
        try {

            URL url = new URL(conf.getURL() + path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input;
            Gson gson = new Gson();
            input = gson.toJson(newFarm);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }

    private List<Ship> jsonToObject(String json) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Farm>>() {
        }.getType();
        List<Ship> list = gson.fromJson(json, collectionType);
        return list;
    }
}
