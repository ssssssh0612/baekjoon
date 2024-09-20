package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복문자제거_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        String str = br.readLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char ch = chars[i];
            int number = str.indexOf(ch);
            if (number == i) {
                result += ch;
            }
        }
        System.out.println(result);
    }
}
