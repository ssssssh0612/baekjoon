package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내선물을받아줘2_15886 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        str = br.readLine();
        int count = 0 ;
        for (int i = 0; i < n - 1; i++) {
            if(str.charAt(i) == 'E' && str.charAt(i + 1) == 'W'){
                count++;
            }
        }
        System.out.println(count);
    }
}
