package com.company;

import java.util.*;
public class Task6{
    //6.1
    static int bell(int num) {
        int[][] bell = new int[num+1][num+1];
        bell[0][0] = 1;
        for (int i = 1; i <= num; i++) {
        bell[i][0] = bell[i-1][i-1];
        for (int j=1; j<=i; j++) {
        bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
        }
    }
    return bell[num][0];
}
    //6.2
    public static String translateWord(String word){
        String glas = "aeiouyAEIOUY";
        if(word.length() <= 0){return "";}
            if( glas.indexOf(word.charAt(0))  != -1){
                return (word +="yay");
            }else{
                for(int i=0; i<word.length();i++){
                    if(glas.indexOf(word.charAt(0)) == -1){
                        word = word.substring(1) + word.substring(0,1);
                    }else{
                        return (word += "ay");
                    }
                }
        }
        return " ";
    }
    public static String translateSentence(String str){
        String result = "";
        for(String word:str.split(" ")){
            result+=translateWord(word)+" ";
        }
        return result;
    }
    //6.3
    public static boolean isNumericArray(String str) {
    if (str == null || str =="")
        return false;
    for (char c : str.toCharArray())
        if (c < '0' || c > '9')
            return false;
    return true;}
    public static boolean validColor(String str){
        if(str.indexOf("rgb") != 0){return false;}
        else{
            str = str.substring(str.indexOf('('));
            String[] num =  str.split(",");
            if(num.length == 0){return false;}
            for(int i=0; i<num.length;i++){if(num[i].isEmpty()){return false;}}
            if(num[0].indexOf("(") != 0){return false;}
            num[0] = num[0].substring(1);
            if(num[num.length-1].indexOf(")") != num[num.length-1].length()-1){return false;}
            num[num.length-1] = num[num.length-1].substring(0,num[num.length-1].length()-1);
            for(int i=0;i<num.length;i++){
               if(isNumericArray(num[i])){
                   int c = Integer.parseInt(num[i]);
                   if(!(c>=0 && c<=255)){return false;}
               }
            }
        }
        return true;
    }
    //6.4
    public static String stripUrlParams(String url, String... parametor){

        int startParam = url.indexOf("?"); //index input in start parametors
        if(startParam == -1){return url;}

        String param = url.substring(startParam+1, url.length());
        String result = url.substring(0,startParam+1);

       String[] par = param.split("&");
      HashSet<String> re = new HashSet<String>();

       for(int i=0; i<par.length;i++){
           for(int j=i+1; j<par.length;j++ ){
               if(par[i].charAt(0) == par[j].charAt(0)){
                   if(par[i].charAt(par[i].length()-1) < par[j].charAt(par[j].length()-1)){
                       par[i] = par[j];
                   }
               }
           }
           re.add(par[i]);
       }
       List<String> list = new ArrayList<String>(re);
       Collections.sort(list);
       
        for(String i:list){
            
            boolean flag = true;
            for(int j=0; j<parametor.length;j++){

                if(i.indexOf(parametor[j]) != -1){flag = false; break;}
            }

            if(flag){
          
            result+=i+"&";}

        }

        return result.substring(0,result.length()-1);
    }
    //6.5
    public static String getHashTags(String str){
        String result ="";
        String[] list = str.split(" ");

        Arrays.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2.length() - o1.length());
            }
        });

        for(int i =0; i<3;i++){
            result+="#"+list[i]+" ";
        }

        return result;
    }
    //6.6
    public static int ulam(int num){
        if (num<3){return -1;}
        ArrayList<Integer> ul = new ArrayList<Integer>();
        ul.add(1);
        ul.add(2);


        for(int i=3; i<=10000;i++){

            int count = 0;

            for(int j = 0; j<ul.size();j++){
                for(int k = j+1; k<ul.size();k++){

                    if(ul.get(j)+ul.get(k) == i){
                        count++;
                    }
                    if (count > 1)
                    break;
                }
                    if (count > 1)
                    break;
            }

            if(count == 1){
                ul.add(i);
                if(ul.size() >= num){
                    return (int)ul.get(ul.size()-1);
            }
            }
        }
        
        return -1;


    }
    //6.7
    public static String longestNonrepeatingSubstring(String str){
        String result = ""+str.charAt(0);
        str = str.substring(1, str.length());
        String buf = str;

        for(int i=0; i<buf.length();i++){
           
                if(str.indexOf(result) == 0){
                    break;
                }else{
                result+=""+str.charAt(0);
                if(str.length() > 2){
                str = str.substring(1, str.length());}else{
                    break;
                }
                }
               
            
        }
        return result;
    }
    //6.8
    public static String convertToRoman(int n){
        String result = "";
        int ten = n/10;
        for(int i=0; i<ten;i++){
            result+="X";
        }

        int ostatok = n%10;
   
            switch (ostatok){
                case (9):result+="IX"; break;
                case (8):result+="IIX"; break;
                case (7):result+="VII"; break;
                case (6):result+="VI"; break;
                case (5):result+="V"; break;
                case (4):result+="IV"; break;
                case (3):result+="III"; break;
                case (2):result+="II"; break;
                case (1):result+="I"; break;
                default: break;
            }
       
        

        return result;
    }
    //6.9
     public static boolean formula(String str){

         if(str.length() <=0){return false;}
         int[] mas = new int[str.length()];
         int[] res = new int[5];
         int indRes = 0;
         int index = 0;
         String num = "";
         String operand = "";
         str+=" =";
         for(int i=0; i<str.length();i++){

            if(str.charAt(i) >= '0' && str.charAt(i)<='9'){
                num+=""+str.charAt(i);
             }else{
                 if(""+str.charAt(i) == "" || ""+str.charAt(i) == " "){ continue; }
                 switch(""+str.charAt(i)){
                    case ("*"): operand = "*"; break;
                    case ("/"): operand = "/"; break;
                    case ("-"): operand = "-"; break;
                    case ("+"): operand = "+"; break;
                    default: break;
                }

                if(str.charAt(i) == ' ' && num != ""){
                    
                    mas[index] = Integer.parseInt(num);
                  //  System.out.println("num = "+mas[index]);
                   // System.out.println("index = "+index);
                    index++;
                    num ="";
                    continue;
                 }

                 if(str.charAt(i) == '='){
                    if(index==0){System.out.println("--2");return false;}

                       if(indRes >2){
                            if(res[0] != res[1]){System.out.println("--1"); return false;}else{
                                indRes--;
                             }
                         }

                         if(index<2){operand = "=";}

                    switch(operand){
                    case ("*"): res[indRes] = mas[0]*mas[1] ; break;
                    case ("/"): res[indRes] = mas[0]/mas[1] ; break;
                    case ("-"): res[indRes] = mas[0]-mas[1] ; break;
                    case ("+"): res[indRes] = mas[0]+mas[1] ; break;
                    case ("="): res[indRes] = mas[0]; break;
                    default: indRes--; break;
                    }
                  //  System.out.println(res[indRes]);
                    operand = "";
                    indRes++;
                    index = 0;
            }
         }
        }


        return (res[0] == res[1]);
     }
    //6.10
    public static String reverseString(String str){

        String s = "";

        for (int i=str.length()-1; i>=0;i--){
            s+=str.charAt(i);
        }
        return s;
    }
    public static boolean isPalindrome(String str){

        if (str.equals(reverseString(str))){
            return true;
        }else{
            return false;
        }
    }
    public static boolean palindromedescendant(String str){

    for(int j=0;j<1000;j++){
    String newstr ="";
    if(!(str.length() % 2 ==0)){return isPalindrome(str);}
    for(int i=0;i<str.length();i+=2){
        newstr+=""+(Integer.parseInt(""+str.charAt(i)) + Integer.parseInt(""+str.charAt(i+1)));
        //System.out.println(newstr);
    }
   if(isPalindrome(newstr)){return true;}else{
       if(newstr.length()>=2){
           str=newstr;
           newstr ="";
       }else{
           return false;
       }
   }
   }
   return false;
}
}
