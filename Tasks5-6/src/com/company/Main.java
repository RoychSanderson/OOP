package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	//5 task
        System.out.println("Task 5.1");
        System.out.println(Arrays.toString(Task5.encrypt("Hello")));
        System.out.println(Task5.decrypt(Task5.encrypt("Hello") ));
        System.out.println("Task 5.2");
        System.out.println(Task5.canMove("Rook", "A8", "H8"));
        System.out.println(Task5.canMove("Bishop", "A7", "G1"));
        System.out.println(Task5.canMove("Queen", "C4", "D6"));
        System.out.println("Task 5.3");
        System.out.println(Task5.canComplete("bbutl", "beautiful"));
        System.out.println("Task 5.4");
        System.out.println(Task5.sumDigProd(16,28));
        System.out.println("Task 5.5");
        System.out.println(Task5.sameVowelGroup("many", "carriage", "emit", "apricot", "animal" ));
        System.out.println("Task 5.6");
        System.out.println(Task5.validateCard("1234567890123456"));
        System.out.println(Task5.validateCard("1234567890123452"));
        Task57 con12 = new Task57();
        System.out.println("Task 5.7");
        System.out.println(con12.convert(123));
        System.out.println(con12.convert(1));
        System.out.println(con12.convert(9876));
        System.out.println("Task 5.8");
        System.out.println(Task5.getSha256Hash("password123"));
        System.out.println("Task 5.9");
        System.out.println(Task5.correctTitle("jOn SnoW, kINg IN thE noRth." ));
        System.out.println(Task5.correctTitle("TYRION LANNISTER, HAND OF THE QUEEN." ));
        System.out.println("Task 5.10");
        System.out.println(Task5.hexLattice(19));
        System.out.println(Task5.hexLattice(21));
        //6 task
        System.out.println("Task6.1");
        System.out.println(Task6.bell(1));
        System.out.println(Task6.bell(3));
        System.out.println("Task6.2");
        System.out.println(Task6.translateWord("button"));
        System.out.println(Task6.translateSentence("I like to eat honey waffles"));
        System.out.println("Task6.3");
        System.out.println(Task6.validColor("rgb(0,0,0)"));
        System.out.println(Task6.validColor("rgb(0,,0)"));
        System.out.println(Task6.validColor("rgba(0,0,0)"));
        System.out.println("Task6.4");
        System.out.println(Task6.stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(Task6.stripUrlParams("https://edabit.com?a=1&b=2&a=2","b"));
        System.out.println("Task6.5");
        System.out.println(Task6.getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println("Task6.6");
        System.out.println(Task6.ulam(206));
        System.out.println("Task6.7");
        System.out.println(Task6.longestNonrepeatingSubstring("abcabcbb"));
        System.out.println("Task5.8");
        System.out.println(Task6.convertToRoman(16));
        System.out.println("Task5.9");
        System.out.println(Task6.formula("6 * 4 = 24"));
        System.out.println("Task5.10");
        System.out.println(Task6.palindromedescendant("11211230"));



    }
}
