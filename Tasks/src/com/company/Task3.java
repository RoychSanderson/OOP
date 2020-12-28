package com.company;

public class Task3 {
    public static int Diskr(int a, int b, int c){
        double sqD = b*b - 4*a*c;
        if (sqD < 0) {
            return 0;
        }
        double x1 = (-b + Math.sqrt(sqD))/(2*a);
        double x2 = (-b - Math.sqrt(sqD))/(2*a);
        if (x1 == x2){
            return 1;
        }
        return 2;
    }
    public static int findZip(String str){
        int fpos = str.indexOf("zip");
        int pos = str.indexOf("zip",fpos+1);
        return pos;
    }
    public static boolean chPerfect(int x){
        int sum = 0;
        for (int i = 1; i<x; i++){
            if (x % i == 0){
                sum += i;
            }
        }
        if (sum == x){
            return true;
        }
        return false;
    }
    public static String flipEndChr(String str){
        if (str.length() < 2){return "Несовместимо";}
        if (str.charAt(0) == str.charAt(str.length()-1)){return "Два - это пара";}
        String str1 = "";
        str1 += str.charAt(str.length()-1);
        for (int i = 1; i<str.length()-1; i++){
            str1 += str.charAt(i);
        }
        str1 += str.charAt(0);
        return str1;
    }
    public static boolean isValHexCode(String str){
        if (str.length() != 7) {return false;}
        if (str.charAt(0) != '#'){return false;}
        String chk = "1234567890abcdefABCDEF";
        for (int i = 1; i<6; i++){
            int flag = 0;
            for (int j = 0; j<chk.length(); j++){
                if (str.charAt(i) == chk.charAt(j)) {
                    flag = 1;
                }
            }
            if (flag == 0) {return false;}
        }
        return true;
    }
    public static boolean sameArr(int[] x, int[] y){
        int sumx = 1;
        int sumy = 1;
        for (int i = 1; i<x.length; i++){
            if (x[i-1] != x[i]){
                sumx += 1;
            }
        }
        for (int i = 1; i<y.length; i++){
            if (y[i-1] != y[i]){
                sumy += 1;
            }
        }
        if (sumx == sumy){
            return true;
        }
        return false;
    }
    public static boolean isKaprekar(int x){
        int sum = 0;
        int n = x*x;
        String ch = Integer.toString(n);
        if (ch.length() == 1){
            sum = Integer.parseInt(ch);
        }
        if (ch.length() == 2){
            int p1 = Character.getNumericValue(ch.charAt(0));
            int p2 = Character.getNumericValue(ch.charAt(1));
            sum = p1+p2;
        }
        if (ch.length() == 3){
            int p1 = Character.getNumericValue(ch.charAt(0));
            int p2 = Character.getNumericValue(ch.charAt(1)) + Character.getNumericValue(ch.charAt(2));
            sum = p1+p2;
        }
        if (ch.length() > 3){
            int leng = ch.length();
            int flag = 0;
            if (leng % 2 != 0){
                leng -= 1;
                flag = 1;
            }
            String pol1 = "";
            String pol2 = "";
            for (int i = 0; i<leng; i++){
                if (i<(leng/2)){
                    pol1 += ch.charAt(i);
                } else {
                    pol2 += ch.charAt(i);
                }
            }
            if (flag == 1){
                pol2 += ch.charAt(leng);
            }
            sum = Integer.parseInt(pol1)+Integer.parseInt(pol2);
        }
        if (sum == x){return true;}
        else {return false;}
    }
    public static String longestZero(String x){
        int col = 0;
        int tmp = 0;
        String otv = "";
        for (int i = 0; i<x.length(); i++){
            if (x.charAt(i) == '0'){
                tmp += 1;
            } else {
                if (tmp>col){
                    col = tmp;
                }
                tmp = 0;
            }
        }
        for (int i = 0; i<col; i++){
            otv += '0';
        }
        return otv;
    }
    public static int nextPrime(int x){
        int flag = 0;
        while (flag == 0){
            for (int i = 2; i<x; i++){
                flag = 1;
                if (x % i == 0){
                    flag = 0;
                    break;
                }
            }
            x += 1;
        }
        return x-1;
    }
    public static boolean rightTriangle(int x, int y, int z){

        if (x == Math.sqrt(y*y + z*z)){
            return true;
        }
        if (y == Math.sqrt(x*x + z*z)){
            return true;
        }
        if (z == Math.sqrt(x*x + y*y)){
            return true;
        }
        return false;
    }
}
