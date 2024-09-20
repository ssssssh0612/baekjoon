package Inflearn.classString;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[]arr = new String[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < arr.length; i++) {
                char[] result = arr[i].toCharArray();
                char[] result1 = new char[result.length];
            for (int j = 0; j < result.length; j++) {
                result1[j] = result[result.length-1-j];
            }
            String arrResult = new String(result1);
            System.out.println(arrResult);
            arr[i] = arrResult;
        }
    }
}
