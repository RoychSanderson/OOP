package com.company;

import java.util.Scanner;

public class Task1 {
    public static double Mod() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите делимое");
        double fir = in.nextDouble ();
        System.out.println("Введите делитель");
        double sec = in.nextDouble ();
        double num = fir % sec;
        return num;
    }
    public static double Square(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите основание");
        int fir = in.nextInt();
        System.out.println("Введите высоту");
        int sec = in.nextInt();
        double num = (fir*sec)/2;
        return num;
    }
    public static int Farm(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество куриц");
        int chickens = in.nextInt();
        System.out.println("Введите количество коров");
        int cows = in.nextInt();
        System.out.println("Введите количество свиней");
        int pig = in.nextInt();
        int num = chickens*2+cows*4+pig*4;
        return num;
    }
    public static boolean Prize(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите prob");
        double prob = in.nextDouble();
        System.out.println("Введите приз");
        double prize = in.nextDouble();
        System.out.println("Введите уплоченное");
        double pay = in.nextDouble();
        if  (prob*prize>pay){
            return true;
        }
        return false;
    }
    public static String Check(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N");
        int N = in.nextInt();
        System.out.println("Введите первое число");
        int a = in.nextInt();
        System.out.println("Введите второе число");
        int b = in.nextInt();
        String num;
        if (a*b == N)
            return num = "умножение";
        if (a/b == N)
            return num = "деление";
        if (a+b == N)
            return num = "сложение";
        if (a-b == N)
            return num = "вычитание";
        return num = "ничего";
    }
    public static int Code(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите символ");
        String sym = in.next();
        char c = sym.charAt(0);
        int num = c;
        return num;
    }
    public static int addUpTo(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите конечное число ряда");
        int fir = in.nextInt();
        int summ = 0;
        for (int i = 1; i<=fir; i++)
            summ = summ + i;
        return summ;
    }
    public static int Max(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую сторону");
        int A = in.nextInt();
        System.out.println("Введите вторую сторону");
        int B = in.nextInt();
        int C = A+B-1;
        return C;
    }
    public static double Cube(int ar){
        double cub = ar*ar*ar;
        return cub;
    }
    public static void AddAndCheck(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите A");
        int A = in.nextInt();
        System.out.println("Введите B");
        int B = in.nextInt();
        System.out.println("Введите C");
        int C = in.nextInt();
        for (int i = 0; i<B; i++)
            A += A;
        System.out.println("Значение А = "+A);
        if ((A%C)==0)
            System.out.println(A+" делится нацело на "+C);
        else System.out.println(A+" не делится нацело на "+C);
    }

}
