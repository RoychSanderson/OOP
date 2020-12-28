package com.company;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[] {"java","Palindrome","madam","racecar","apple","kayak","song","noon",};
        byte x;
        System.out.print("Simple numbers - ");
        for (x = 1; x<101; x = (byte) (x+1)) {
            if (Main.isPrime(x))
                System.out.print(" " + x);
        }
        System.out.println("");
        for (int i = 0; i < str.length; i++) {
           String s = str[i];
           if (isPal(s))
               System.out.println(s + " палиндром");
           else
               System.out.println(s + " не палиндром");
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i<(n-1); i++)
            if (n % i == 0)
                return false;
        return true;
    }
    public static String reverseString(String tmp) {
        String rever = "";
        for (int j = tmp.length()-1; j >= 0; j--)
            rever += tmp.charAt(j);
        return rever;
    }
    public static boolean isPal(String str){
        String nstr = reverseString(str);
        return str.equals(nstr);
    }
}
