package com.company;

public class Point2D {
    private double xCoord;
    private double yCoord;
    public Point2D(double x, double y){
        xCoord = x;
        yCoord = y;
    }
    public Point2D(){
        this (0,0);
    }
    public double getx(){
        return xCoord;
    }
    public double gety(){
        return yCoord;
    }
    public void setX (double val){
        xCoord = val;
    }
    public void setY (double val){
        yCoord = val;
    }
}
