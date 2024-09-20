package Inflearn.classString;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[]arr = a.split(" ");
        String result="";
        for (int i = 0; i <arr.length; i++) {
            if(arr[i].length() > result.length()){
                result = arr[i];
            }
        }
        System.out.println(result);
    }
}
