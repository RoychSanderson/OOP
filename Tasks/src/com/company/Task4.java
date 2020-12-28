package com.company;

import java.util.*;
class Task4{
	public static String repairBessie(int n, int k,String str){
	String newStr = "";
	String[] words = new String[n+1];
	int i = 0;
	for(String word: str.split(" ")){
		words[i] = word;
		i++;
	}
	int countStrLength = 0;
	for(int j = 0; j<n;j++){
		if(words[j].length()+countStrLength <=k){
		newStr+=words[j]+" ";
		countStrLength += words[j].length();
		}else{
		newStr+="\n";
		newStr+=words[j]+" ";
		countStrLength = words[j].length();
		}
	}
	return newStr;	
	}
	public static String split(String str){
	int itr = 0;
	String newStr = "";
	for(int i=0;i<str.length();i++){
		if(str.charAt(i) == '('){
			itr++;
		}
		else{
			itr--;
		}
		newStr+=str.charAt(i);
		if(itr<=0)newStr+="\n";
		}
	     	return newStr;
	}
	public static String toCamelCase(String str){
		String newStr = "";
		boolean flag = false;
		for(String word: str.split("_")){
			if(!flag) {
				newStr+=word.toLowerCase();
				flag = true;
			}
			else {
			String s ="" + word.substring(0,1).toUpperCase() + word.substring(1);
			newStr+=s;
			}
		}
		return newStr;
	}
	public static String toSnakeCase(String str){
	ArrayList<String> words = new ArrayList();
	String byf = "";
	for(int i =0; i<str.length();i++){
		String s = str.substring(i,i+1).toUpperCase(); 
		if(str.charAt(i) != s.charAt(0)){
		byf+=str.charAt(i);
		}else{
		words.add(byf);
		byf=s.toLowerCase();
		}
	}
	words.add(byf);
	String newStr = "";
	for(String word:words){
	newStr+=word + "_";
	}
	return newStr.substring(0,newStr.length()-1);
	}
	public static String overTime(double[] mas){
		double sum = 0;
		if(mas[0] - 17 <= 0 && mas[1] -17 <= 0){
		sum = Math.abs(mas[1] - mas[0]) * mas[2];}
		else if (mas[0] - 17 > 0 && mas[1] -17 > 0){
		sum = Math.abs(mas[1] - mas[0]) * mas[2] * mas[3];}
		else if (mas[0] - 17 <= 0 && mas[1] - 17 > 0){
		sum = (17 - mas[0])*mas[2] + (mas[1] -17) * mas[2] * mas[3];}
		String s = String.format("$%.2f",sum);
	return s;
	}
	public static String BMI(String strMas, String strGrowth){
	String strResult;
	double mas,growth;
	if(strMas.contains("pounds")){
	mas = Double.parseDouble(strMas.split(" ")[0]) * 0.45;
	}else{
	mas = Double.parseDouble(strMas.split(" ")[0]);}
	if(strGrowth.contains("inches")){
	growth = Double.parseDouble(strGrowth.split(" ")[0]) / 39.5;}
	else{
	growth = Double.parseDouble(strGrowth.split(" ")[0]);}
	double result = mas/(growth*growth);
	result = Math.round(result*100) /10;
	result /= 10;
	if(result < 18.5){
	strResult = ""+result + " UnderWeigth";
	}else
	if(result < 24.9){
	strResult ="" + result + " NormalWeigth";
	}else{
	strResult = "" + result+ " OverWeigth";}
	
	return strResult;
	}
	public static int bugger(int num){
	int count = 0, buf, c = 1;
	while(num / 10 > 0){
		buf = num;
		 while (buf > 0){
		 	c *= buf % 10;
		 	buf = buf / 10; 
		 }
		 count ++;
		 num = c;
		 c = 1;
	}
	return count;
	}
	public static String toStarShorthand(String str){
	String Result = "";
	int itr;
	for(int i = 0; i<str.length(); i++){
		itr = 1;
		int current = i;
		boolean flag = false;
		for(int j=i+1; j < str.length(); j++){
			if(str.charAt(i) != str.charAt(j)){
				i = j-1;
				flag = false;
				break;
			}
			else{
				itr++;
			}
			flag = true;
		}
		if(itr > 1){
			Result += str.charAt(current)+ "*" +itr;
		}
		else{
			Result += str.charAt(current);
		}
		if(flag){
			break;
		}
	}
	return Result;
	}
	public static String lastWordGet(String str){
	str = str.toLowerCase();
	String word = "";
		for(int i = str.length()-1; i>=0; i--){
			if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
				word+=str.charAt(i);
			}
			else if(str.charAt(i) == ' '){
				break;
			}
		}
	return word;
	}
	public static boolean doesRhyme(String str1, String str2){
	String[] vowels = {"a","e","o","q","i","u","j","y"};
	ArrayList<String> w1 = new ArrayList();
	ArrayList<String> w2 = new ArrayList();
	String wordEnd1 = lastWordGet(str1);
	String wordEnd2 = lastWordGet(str2);
		for(String g:vowels){
			if(wordEnd1.contains(g)){
			w1.add(g);}
			}
		for(String g:vowels){
			if(wordEnd2.contains(g)){
			w2.add(g);}
			}
	Collections.sort(w1);
	Collections.sort(w2);
	return w1.equals(w2);
	}
	public static long numberSearch(int quantity, long number){
	long num = 0;
	int count = 1;
		while(number > 0){
			if(num == number % 10){
				count++;
				if(count == quantity){
				return num;
				}
			}
			else{
				num = number % 10;
				count = 1;
			}
			number /= 10;
		}
	return -1;	
	}
	public static boolean trouble(long num1, long num2){
	 return (numberSearch(3,num1) == numberSearch(2,num2) && numberSearch(3,num1) != -1);
	}
	public static int countUniqueBooks(String str, char ch){
	boolean flag = false;
	ArrayList List = new ArrayList();
	str = str.toUpperCase();
		for(int i = 0;  i < str.length(); i++){
			if(str.charAt(i) == ch){
				flag =! flag;
				continue;}
			if (flag && str.charAt(i) != str.charAt(i-1)){
				List.add(""+str.charAt(i));
			}
		}
	return List.size();
	}
}
