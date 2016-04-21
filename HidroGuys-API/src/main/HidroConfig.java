/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author emman
 */
public class HidroConfig {

    private final String server;
    private final int port;
    private final String path;

    public HidroConfig(String server, int port, String path) {
        this.server = server;
        this.port = port;
        this.path = path;
    }

    public String getServer() {
        return server;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getURL() {
        return "http://" + server + ":" + port + "/" + path + "/";
    }
}
