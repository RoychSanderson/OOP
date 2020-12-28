package com.company;

public class Point3D extends Point2D {
    private double zCoord;
    public Point3D(double x, double y, double z){
        setX(x);
        setY(y);
        zCoord = z;
    }
    public Point3D(){
        this (0,0,0);
    }
    public double getz(){
        return zCoord;
    }
    public void setZ (double val){
        zCoord = val;
    }
    public static boolean isEqual(Point3D P1, Point3D P2){
        if (P1.getx() == P2.getx() && P1.gety() == P2.gety() && P1.zCoord == P2.zCoord) {
            System.out.println("Обнаружены одинаковые точки");
            return true;
        } else {
            return false;
        }
    }
    public static double distanceTo(Point3D P1,Point3D P2){
        double dist = Math.sqrt(Math.pow((P2.getx()- P1.getx()),2)+Math.pow((P2.gety()- P1.gety()),2)+Math.pow((P2.getz()- P1.getz()),2));
        return dist;
    }
}
