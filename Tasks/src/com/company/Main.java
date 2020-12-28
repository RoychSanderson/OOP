package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = Task1.Mod();
        System.out.println("Остаток от деления равен = "+x);
        x = Task1.Square();
        System.out.println("Площадь треугольника = "+x);
        int y = Task1.Farm();
        System.out.println("Общее количество ног у фермера = "+y);
        boolean z = Task1.Prize();
        System.out.println("Получили ли профит? - "+z);
        String str = Task1.Check();
        System.out.println("Нужное действие для получения N - "+str);
        y = Task1.Code();
        System.out.println("Код символа - "+y);
        y = Task1.addUpTo();
        System.out.println("Сумма ряда чисел = "+y);
        x = Task1.Max();
        System.out.println("Максимально возможное значение третьей стороны = "+x);
        int[] nums = {8,9,4};
        x = 0;
        for (int i = 0; i<nums.length; i++){
            x += Task1.Cube(i);
        }
        System.out.println("Сумма кубов = "+x);
        Task1.AddAndCheck();

        Task2.repeat("mice", 5);
        int[] p = {1, 2, 3, 4, 7, 8};
        Task2.differenceMaxMin(p);
        Task2.isAvgWhole(p);
        Task2.cumulativeSum(p);
        String l = "40.240";
        Task2.getDecimalPlaces(l);
        Task2.Fibonacci(7);
        Task2.isValidIndex("55346");
        Task2.isStrangePair("radio","orator");
        Task2.isPrefix("automaton","auto-");
        Task2.isSuffix("automaton","-ton");
        Task2.boxSeq(2);

        int v = Task3.Diskr(1,0,0);
        if (v == 0){
            System.out.println("При данных условиях решений нет");
        }
        if (v == 1){
            System.out.println("При данных условиях существует одно решение");
        }
        if (v == 2){
            System.out.println("При данных условиях существует два решения");
        }

        x = Task3.findZip("all zip files are zipped");
        System.out.println("Индекс второго вхождения zip - " + x);

        if (Task3.chPerfect(6)){
            System.out.println("Число совершенно");
        } else {
            System.out.println("Число несовершенно");
        }
        System.out.println(Task3.flipEndChr("Task3"));

        if (Task3.isValHexCode("#CD5C5C")){
            System.out.println("Код соответствует требованиям");
        } else {
            System.out.println("Код не соответствует требованиям");
        }

        int[] u = {1, 2, 2, 4, 4, 8};
        int[] n = {0, 2, 3, 4, 7, 7};
        if (Task3.sameArr(u,n)){
            System.out.println("Количество уникальных элементов одинаково");
        } else {
            System.out.println("Количество уникальных элементов не одинаково");
        }

        if (Task3.isKaprekar(297)){
            System.out.println("Это число Капрекара");
        } else {
            System.out.println("Это не число Капрекара");
        }

        System.out.println(Task3.longestZero("01100001011000"));
        System.out.println(Task3.nextPrime(244));

        if (Task3.rightTriangle(3,4,5)){
            System.out.println("Это правильный треугольник");
        } else {
            System.out.println("Это не правильный треугольник");
        }

        System.out.println(Task4.repairBessie(10,7,"hello my name is Bessie and this is my essay"));
        System.out.println(Task4.split("(())(())((()))"));
        System.out.println(Task4.toCamelCase("hello_edabit"));
        System.out.println(Task4.toSnakeCase("helloEdabit"));
        double a[] = {9,17,30,1.5f};
        System.out.println(Task4.overTime(a));
        System.out.println(Task4.BMI("154 pounds", "2 meters"));
        System.out.println(Task4.bugger(999));
        System.out.println(Task4.toStarShorthand("77777geff"));
        System.out.println(Task4.doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(Task4.trouble(451999277, 417722899));
        System.out.println(Task4.countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
      /*  System.out.println("Task5");
        System.out.println(Task5.encrypt("Hello"));
        System.out.println(Task5.decrypt(Task5.encrypt("Hello")));
        System.out.println(Task5.canMove("Queen", "C4", "D6") );
*/
    }


}
