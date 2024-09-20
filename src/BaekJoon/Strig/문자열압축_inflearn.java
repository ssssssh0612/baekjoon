package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuilder anwser = new StringBuilder();
        char ch = a.charAt(0);
        int count = 1;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == ch) {
                count++;
            } else if (a.charAt(i) != ch) {
                if (count == 1) {
                    anwser.append(ch);
                } else {
                    anwser.append(ch).append(count);
                }
                ch = a.charAt(i);
                count = 1;
            }

            if( i == a.length() - 1 ){
                if (a.charAt(i) == ch) {
                    if (count == 1) {
                        anwser.append(ch);
                    } else {
                        anwser.append(ch).append(count);
                    }
                } else if (a.charAt(i) != ch) {
                    ch = a.charAt(i);
                    count = 1;
                    anwser.append(ch);
                }
            }
        }
        System.out.println(anwser);
    }
}
