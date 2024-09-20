package Inflearn.classString;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        String aUpper = a.toUpperCase();
        String bUpper = b.toUpperCase();
        int count =0;

//        for (int i = 0; i < aUpper.length(); i++) {
//            if(aUpper.charAt(i) == bUpper.charAt(0)){
//                count++;
//            }
        for (char item : aUpper.toCharArray()) {
            if(item == bUpper.charAt(0)){
                count++;
        }
        }
        System.out.println(count);
    }
}
