package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите координаты первой точки");
        Point3D FP = Vvod();
        Point3D BP = new Point3D();
        System.out.println("Введите координаты второй точки");
        Point3D SP = Vvod();
        System.out.println("Введите координаты третьей точки");
        Point3D TP = Vvod();
        double square = computeArea(FP,SP,TP);
        System.out.print("Площадь треугольника = ");
        System.out.print(square);
        if (square == 0)
            System.out.print(", ибо треугольника не существует");
    }
   private static Point3D Vvod(){
       Scanner in = new Scanner(System.in);
       System.out.print("Введите X: ");
       double tmp1 = in.nextDouble ();
       System.out.print("Введите Y: ");
       double tmp2 = in.nextDouble();
       System.out.print("Введите Z: ");
       double tmp3 = in.nextDouble();
       Point3D tmp = new Point3D(tmp1,tmp2,tmp3);
       return tmp;
    }
   private static double computeArea(Point3D fir, Point3D sec, Point3D thr){
        double area = 0;
        double sstor;
        double fstor;
        double tstor;
        double p;
        if (Point3D.isEqual(sec,thr) || Point3D.isEqual(fir,sec) || Point3D.isEqual(fir,thr)){
            return area;
        }
        else{
        fstor = Point3D.distanceTo(fir,sec);
        sstor = Point3D.distanceTo(fir,thr);
        tstor = Point3D.distanceTo(sec,thr);
        p = (fstor+sstor+tstor)/2;
        area = Math.sqrt(p*(p-fstor)*(p-sstor)*(p-tstor));
        return area;
        }
    }

}
