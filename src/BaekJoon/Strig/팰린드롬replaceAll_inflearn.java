package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬replaceAll_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        a = a.toUpperCase();
        a = a.replaceAll("[^A-Z]","");
        char[] arr = a.toCharArray();
        boolean flag = false;
        a = new StringBuilder(a).reverse().toString();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c != arr[i]) {
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}
