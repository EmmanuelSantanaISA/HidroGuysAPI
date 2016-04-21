/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emman
 */
public class HidroAPI {

    HidroConfig conf = null;

    public HidroAPI(HidroConfig conf) {
        this.conf = conf;
    }

    public Farms getFarms() {
        if (conf != null) {
            return new Farms(conf);
        } else {
            System.out.println("HidroAPI not configured!");
            return null;
        }

    }

    public Ships getShips() {
         if (conf != null) {
            return new Ships(conf);
        } else {
            System.out.println("HidroAPI not configured!");
            return null;
        }
    }

    public static String inputStreamToString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        String read;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((read = br.readLine()) != null) {
                //System.out.println(read);
                sb.append(read);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(HidroAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

}
