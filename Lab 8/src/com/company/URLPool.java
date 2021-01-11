package com.company;

import java.util.LinkedList;

public class URLPool {
    public LinkedList<URLDepth> pendingURLs;
    public LinkedList<URLDepth> processedURLs;
    public int waitingThreads;
    public URLPool(){
        waitingThreads = 0;
        pendingURLs = new LinkedList<>();
        processedURLs = new LinkedList<>();
    }
    public synchronized int getWaitingThreads(){
        return waitingThreads;
    }
    public synchronized void put(LinkedList<URLDepth> pairs){
        pendingURLs.addAll(pairs);
        if(waitingThreads > 0){
            waitingThreads--;
            this.notify();
        }
    }
    public synchronized URLDepth get(){
        URLDepth newcomer = null;
        if (pendingURLs.size() == 0) {
            try {
                waitingThreads++;
                this.wait();
            }
            catch (InterruptedException e) {
                System.err.println("MalformedURLException: " + e.getMessage());
                return null;
            }
        }
        newcomer = pendingURLs.removeFirst();
        processedURLs.add(newcomer);
        return newcomer;
    }
    public synchronized LinkedList<URLDepth> getProcessedURLs(){
        return processedURLs;
    }
}
