package com.company;

import java.security.MessageDigest;
import java.util.*;
class Task5{

//5.1
public static String decrypt(int[] crypt){
    if(!(crypt.length >0)){return null;}
    String result = "";
    int num = 0;//пред символ
    for(int i = 0; i < crypt.length; i++){
        result += "" + (char)(crypt[i]+num);
        num = crypt[i] + num;
    }
    return result;
}
public static int[] encrypt(String str){
   if(!(str.length()>0)){return null;}
   int[] result = new int[str.length()];
   int num = 0; //Предыдущий символ
   for(int i = 0; i<str.length(); i++){
       result[i] = ((int)str.charAt(i)) - num;
       num = (int)str.charAt(i);
   }
return result;
}
//5.2
public static boolean rook(String start, String end){
    if(start.length() != 2 || end.length() != 2){return false;}
    if(start.charAt(0) != end.charAt(0)){
        if (start.charAt(1) != end.charAt(1)){return false;}
    }
    return true;
}//ладья
public static boolean bishop(String start, String end){
    if(start.length() != 2 || end.length() != 2){return false;}
    int a,b;
    a = (int)end.charAt(0) - (int)start.charAt(0) + (int)end.charAt(1);
    b = (int)start.charAt(1);
    return a==b;
}//слон
public static boolean queen(String start, String end){
    if(start.length() != 2 || end.length() != 2){return false;}
    int a = 0;
    a = (int)end.charAt(0) - (int)start.charAt(0) + (int)end.charAt(1) - (int)start.charAt(1);
    return a<=1;
}//королева
public static boolean horse(String start, String end){
     if(start.length() != 2 || end.length() != 2){return false;}
     int a = 0;
     int b = 0;   
    a = Math.abs((int)end.charAt(0) - (int)start.charAt(0));
    b = Math.abs((int)end.charAt(1) - (int)start.charAt(1));
    
    if ((a == 1 && b == 2) || (a==2 && b==1)) return true;
    return false;
}//конь
public static boolean pawn(String start, String end){
    if(start.charAt(0) != end.charAt(0)) return false;
    if(Math.abs((int)start.charAt(1) - (int)end.charAt(1)) != 1) return false;
    return true;
}//пешка
public static boolean canMove(String str,String start,String end){
    boolean flag = false;
    switch (str){
        case "Rook":{flag = rook(start,end); break;}
        case "Bishop":{flag = bishop(start,end); break;}
        case "Queen":{flag = queen(start,end); break;}
        case "Horse":{flag = horse(start,end); break;}
        case "Pawn":{flag = pawn(start,end); break;}
    }
    return flag;
}
//5.3
public static boolean canComplete(String str1, String str2){
    int j = 0;
    for (int i = 0; i<str2.length();i++){
        if(str2.charAt(i) == str1.charAt(j)){
            j++;
        }
    }
    if(str1.length() == j){return true;}
    return false;
}
//5.4
public static int sumDigProd(int... numbers){
    int sum = 0;
    for(int num:numbers){
        sum +=num;
    }
    int mult = 1;

    while(sum / 10 > 0){
        int c = sum;
        mult = 1;
        while (c % 10 > 0){
            mult*=c % 10;
            c = c / 10;
        }
        sum = mult;
    }
    return sum;
}
//5.5
public static String sameVowelGroup(String... words){
    if(words.length < 1){return " ";}
    String glas = "aeoqiujy";
    String resultS = "";
    HashSet<String> sim = new HashSet<String>();
    for(int i=0; i<words[0].length();i++){
        if(  glas.indexOf(words[0].charAt(i)) != -1  ){
            sim.add(""+words[0].charAt(i));
        }
    }
List<String> list = new ArrayList<String>(sim);
Collections.sort(list);

  

    for(String word:words){
         HashSet<String> sim2 = new HashSet<String>();
        for(int i =0; i<word.length();i++){
            if( glas.indexOf(word.charAt(i)) != -1  ){
            sim2.add(""+word.charAt(i));
        }
        }
       List<String> list2 = new ArrayList<String>(sim2);
       Collections.sort(list2);

       if(list.equals(list2)){
           resultS+=word+" ";
       }
        
    }


return resultS;
}
//5.6
public static boolean validateCard(String number){
    int len = number.length() - 1; //Step 1
    String numReverse = "";
    int flag = (int)number.charAt(len) - 48;


    for(int i = len-1; i>=0; i--){ //Step 2
        numReverse+=""+number.charAt(i);
    }

    int sum = 0;

    for(int i = 0; i<numReverse.length(); i++){ //Step 3
        int buf = (int)numReverse.charAt(i) - 48;

        if(buf % 2 != 0){
            buf*=2;
            if(buf / 10 > 0){
                buf = buf/10 + buf%10;
            }
        }
        sum+=buf; //Step 4
    }
    return (10 - (sum%10) == flag);
}
//5.8
public static String getSha256Hash(String base) {
 try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
//5.9
public static String correctTitle(String str){
    final String flag = "the of in a on ";
    str = str.toLowerCase();
    String[] word = str.split(" ");
    String result1 = "";

    for(String c:word){
        if(flag.indexOf(c) == -1){
            c = c.substring(0,1).toUpperCase() + c.substring(1,c.length());
        }
        result1+=""+c+" ";
    } 
    return result1;
}
//Task 5.10
public static boolean isGeksogonal(int n){

    int count = 1;
    for(int i=1; i<n;i++){
        if (count == n){return true;}
        if(count>n){return false;}
        count+=6*i;
        
    }
    return false;
}
public static int countColumns(int n){
    int count = 1;
    int index = 0;
    for(int i=1; i<n;i++){
        if(count == n){index = i; break;}
        count+=6*i;
    }

    return (3 + 2*(index - 2));
}
public static int[] countPoint(int n){
    
    int[] columns = new int[n];
    int h = (int) java.lang.Math.floor(n / 2);

    for (int i = 0; i < n; i++) {
        columns[i] = n - java.lang.Math.abs(i - h);
    }

    return columns;
}
public static String hexLattice(int n){
    if(n==1){return "o";}
    if(!isGeksogonal(n)){return "Invalid";}

    int[] columns = countPoint(countColumns(n));
    if(columns.length < 1){return "Invalid";}  

    int max = columns[0]; //находим максимальное число точек, для определения кол-во отступов
    for (int i = 1; i < columns.length; i++) max = Math.max(max, columns[i]);

    String result = "";
    for(int i =0; i < columns.length; i++){
        int space = max - columns[i]; //кол-во пробелов от начала строки
        for(int j=0; j<space;j++){result+=" ";}
        for(int t=0; t<columns[i];t++){result+="o ";} //раставляем точки в строке
        result+="\r\n";
    }

return result;
}

}