package BaekJoonString;

import java.util.Scanner;

public class BaekJoon1152 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        a = a.trim();
        int count =0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(c==' '){
                count++;
            }
        }
        if(count>=1){
            System.out.println(++count);
        }
        else {
            System.out.println(0);
        }
    }
}
