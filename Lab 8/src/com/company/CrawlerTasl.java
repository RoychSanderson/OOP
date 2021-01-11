package com.company;

import java.util.LinkedList;

public class CrawlerTasl implements Runnable{

    public URLDepth myPair;
    public URLPool myPool;

    public CrawlerTasl(URLPool pool) {
        myPool = pool;
    }
    @Override
    public void run() {
        if (myPool.pendingURLs.size() == 0){
            System.out.println("No such elements");
        }
        myPair = myPool.get();
        int myDepth = myPair.getDepth();
        if (myDepth < Crawler.depth) {
            LinkedList<String> list;
            LinkedList<URLDepth> newPairs = new LinkedList<>();
            list = Crawler.getAllSites(myPair);
            for (int i = 0; i < list.size(); i++) {
                URLDepth tmp = new URLDepth(list.get(i), myDepth+1);
                if (!myPool.processedURLs.contains(tmp))
                {
                    myPool.processedURLs.add(tmp);
                    newPairs.add(tmp);
                }
            }
            myPool.put(newPairs);
        }
    }
}
