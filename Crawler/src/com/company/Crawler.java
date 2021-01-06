package com.company;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;


public class Crawler {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int depth = 0;
        System.out.println("Enter depth level");
        try{
        depth = in.nextInt();
        }
        catch (InputMismatchException err){
            System.err.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        }
        System.out.println("Enter URL");
        String site = in.next();
        if (!site.contains("http://")){
            System.err.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        }
        LinkedList<URLDepth> reviewedURLs = new LinkedList<>();
        LinkedList<URLDepth> untrackedURLs = new LinkedList<>();
        URLDepth fir = new URLDepth(site, 0);
        untrackedURLs.add(fir);
        ArrayList<String> Track = new ArrayList<>();
        Track.add(fir.getURL());
        for (int j = 0; j <= depth; j++) {
            while (untrackedURLs.size() > 0) {
                URLDepth Pair = untrackedURLs.pop();
                int Depth = Pair.getDepth();
                reviewedURLs.add(Pair);
                LinkedList<String> sites;
                sites = Crawler.getAllSites(Pair);
                String newUrl;
                if (Depth < depth) {
                    for (int i = 0; i < sites.size(); i++) {
                        newUrl = sites.get(i);
                        if (Track.contains(newUrl)) {
                            continue;
                        } else {
                            untrackedURLs.add(new URLDepth(newUrl, Depth + 1));
                            Track.add(newUrl);
                        }
                    }
                }
            }
        }
        Iterator<URLDepth> iterator = reviewedURLs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().ToString());
        }
    }
    public static LinkedList<String> getAllSites(URLDepth myPair){
        LinkedList<String> URLs = new LinkedList<>();
        Socket socket;
        try{
            socket = new Socket(myPair.getHost(),80);
        }
        catch (UnknownHostException e){
            System.err.println("UnknownHostException: " + e.getMessage());
            return URLs;
        }
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
            return URLs;
        }
        try {
            socket.setSoTimeout(5000);
        }
        catch (SocketException e) {
            System.err.println("SocketException: " + e.getMessage());
            return URLs;
        }
        OutputStream out;
        try {
            out = socket.getOutputStream();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return URLs;
        }
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("GET " + myPair.getPath() + " HTTP/1.1");
        writer.println("Host: " + myPair.getHost());
        writer.println("Connection: close");
        writer.println();

        BufferedReader in;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(IOException e){
            System.err.println("IOException: " + e.getMessage());
            return URLs;
        }
        String Lines = "";
        while (true) {
            String line;
            try {
                line = in.readLine();
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
                return URLs;
            }
            if (line == null) {
                break;
            }
            Lines += line;
        }
        int begin, end, ind = 0;
        while (true){
            String URL_IND = "a href=\"";
            String END_URL ="\"";
            ind = Lines.indexOf(URL_IND, ind);
            if (ind == -1){
                break;
            }
            ind += URL_IND.length();
            begin = ind;
            end = Lines.indexOf(END_URL, ind);
            ind = end;
            String newLink = Lines.substring(begin, end);
            if (newLink.contains("http:")){
                URLs.add(newLink);
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return URLs;
        }
        return URLs;
    }
}
