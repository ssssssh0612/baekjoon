package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String A = "AAAA", B = "BB";

        str = str.replaceAll("XXXX", A);
        String result = str.replaceAll("XX", B);

        if (result.contains("X")) {
            result = "-1";
        }

        System.out.println(result);
    }
}
