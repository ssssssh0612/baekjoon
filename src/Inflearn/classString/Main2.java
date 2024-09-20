package Inflearn.classString;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String result = "";
//        for (int i = 0; i < a.length(); i++) {
//            if (Character.isUpperCase(a.charAt(i))) {
//                char charResult = Character.toLowerCase(a.charAt(i));
//                result = result + charResult;
//            }else{
//                char charResult = Character.toUpperCase(a.charAt(i));
//                result = result + charResult;
//            }
//        }
        for (char x: a.toCharArray()) {
            if(x>=65 && x<=96){
                System.out.println();
            }else{
                System.out.println("대문자x = " + x);
            }
        }

        System.out.println(result);
    }
}
