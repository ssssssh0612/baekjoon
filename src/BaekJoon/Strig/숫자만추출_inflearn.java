package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if(!Character.isAlphabetic(a)){
                result += a;
            }
        }
        System.out.println(Long.valueOf(result));
    }
}
