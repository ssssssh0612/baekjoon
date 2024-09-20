package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OX퀴즈_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            int number = 0;
            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(j)=='O'){
                    number++;
                    result += number;
                }else{
                    number = 0;
                }
            }
            System.out.println(result);
            result = 0;
        }

    }
}
