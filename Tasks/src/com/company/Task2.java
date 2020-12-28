package com.company;

public class Task2 {
    public static void repeat(String m, int x){
        for (int i = 0; i<m.length(); i++){
            for (int j = 0; j<x; j++) System.out.print(m.charAt(i));
        }
        System.out.println();
    }
    public static void differenceMaxMin(int[] x){
        float min =Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        for (int i = 0; i<x.length; i++){
            if (x[i]<min){
                min = x[i];
            }
            if (x[i]>max){
                max = x[i];
            }
        }
        System.out.print("Разница между максимальным и минимальным числом равна ");
        System.out.println(max-min);
    }
    public static void isAvgWhole(int[] x){
        System.out.print("Среднее число - целое? - ");
        int summ = 0;
        for (int i = 0; i<x.length; i++){
            summ += x[i];
        }
        if ((summ % x.length) == 0){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public static void cumulativeSum(int[] x){
        System.out.print("[");
        int sum = x[0];
        System.out.print(sum);
        for (int i = 1; i<x.length; i++){
            System.out.print(",");
            sum += x[i];
            System.out.print(sum);
        }
        System.out.println("]");
    }
    public static void getDecimalPlaces(String x){
        int sum = -1;
        for (int i = x.indexOf("."); i<x.length(); i++){
            sum++;
        }
        System.out.print("Количество цифр после точки - ");
        System.out.println(sum);
    }
    public static void Fibonacci(int x){
        int sl1 = 0;
        int sl2 = 1;
        for (int i = 0; i<=x; i++){
            int tmp = sl1+sl2;
            sl1 = sl2;
            sl2 = tmp;
        }
        System.out.print("Запрошенное число из ряда Фибоначчи - ");
        System.out.println(sl2);
    }
    public static void isValidIndex(String x){
        boolean chk = true;
        if (x.length() != 5){chk = false;}
        if (x.contains(" ")) {chk = false;}
        try {double d = Double.parseDouble(x);}
        catch (NumberFormatException | NullPointerException nfe) {
                chk = false;
        }
        if (chk){
            System.out.println("Этот почтовый индекс подходит");
        } else {
            System.out.println("Этот почтовый индекс не подходит");
        }
    }
    public static void isStrangePair(String x, String y){
        boolean chk;
        if (x.length() < 1 && y.length() < 1){
            System.out.println("Эта пара - странная");
        }
        if (x.charAt(0) == y.charAt(y.length()-1) && x.charAt(x.length()-1) == y.charAt(0)){
            chk = true;
        } else {chk = false;}
        if (chk){
            System.out.println("Эта пара - странная");
        } else {
            System.out.println("Это пара - не странная");
        }
    }
    public static void isPrefix(String x, String y) {
        String pod = "";
        for (int i = 0; i < y.length()-1; i++) {
            pod += y.charAt(i);
        }
        if (x.lastIndexOf(pod) == -1) {
            System.out.println("Это не префикс");
        } else {
            System.out.println("Это префикс");
        }
    }
    public static void isSuffix(String x, String y){
        String po = "";
        for (int i = 1; i < y.length(); i++) {
            po += y.charAt(i);
        }
        if (x.lastIndexOf(po) == -1) {
            System.out.println("Это не суффикс");
        } else {
            System.out.println("Это суффикс");
        }
    }
    public static void boxSeq(int x){
        int seq = 0;
        int fl = 0;
        for (int i = 1; i<=x; i++) {
            if (fl == 0){
                seq += 3;
                fl = 1;
            } else {
                seq -= 1;
                fl = 0;
            }
        }
        System.out.print("Количество полей - ");
        System.out.println(seq);
    }
}
