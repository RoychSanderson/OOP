package com.company;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDepth {
    private int currentDepth;
    private String currentURL;

    public URLDepth(String URL, int depth){
        currentDepth = depth;
        currentURL = URL;
    }
    public String getURL(){
        return currentURL;
    }
    public int getDepth(){
        return currentDepth;
    }
    public String ToString(){
        String depS = Integer.toString(currentDepth);
        return currentURL + " Depth = " + depS;
    }
    public String getHost(){
        try {
            URL url = new URL(currentURL);
            return url.getHost();
        } catch (MalformedURLException e){
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }
    public String getPath(){
        try {
            URL url = new URL(currentURL);
            return url.getPath();
        } catch (MalformedURLException e){
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }
}
