package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소트인사이드_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] num = new int[str.length()];
        for(int i = 0 ; i < num.length; i++){
            num[i] = str.charAt(i) - '0';
        }
        Arrays.sort(num);
        for(int i = num.length - 1; i >= 0; i--){
            System.out.print(num[i]);
        }
    }
}
