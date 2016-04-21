/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import pojo.Farm;
import pojo.Line;
import pojo.Ship;

/**
 *
 * @author emman
 */
public class HidroAPITest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HidroConfig conf = new HidroConfig("localhost", 8080, "HidroGuys/webresources");
        System.out.println("URL: " + conf.getURL());

        HidroAPI api = new HidroAPI(conf);

        List<Farm> farmsList = api.getFarms().getAll();
        for (Farm farm : farmsList) {
            System.out.println("Farm ID: " + farm.getFarmName());
        }
        List<Ship> shipsList = api.getShips().getAll();
        for (Ship ship : shipsList) {
            System.out.println("Ship ID: " + ship.getShipName());
        }
        
        List<Line> lineList = api.getLines().getAll();
        for (Line line : lineList) {
            System.out.println("Line Name: " + line.getLineName());
        }
        
        Farm farm = api.getFarms().get(1);
        System.out.println("ONE FARM: " + farm.getFarmName());
        
        Ship ship = api.getShips().get(5);
        System.out.println("ONE SHIP: " + ship.getShipName());
        
        Line line = api.getLines().get(3);
        System.out.println("ONE LINE: " + line.getLineName());
    }
}
