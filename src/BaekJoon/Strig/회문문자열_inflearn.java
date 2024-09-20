package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문문자열_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder newStr = new StringBuilder(str).reverse();
        System.out.println(newStr);
        str = str.toUpperCase();
        boolean flag = false;
        int lt = 0;
        int rt = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(lt);
            char b = str.charAt(rt);
            if (a != b) {
                flag = true;
                break;
            }
            lt++;
            rt--;
        }
        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
