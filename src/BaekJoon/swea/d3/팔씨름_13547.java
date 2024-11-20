package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔씨름_13547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String a = br.readLine();
            char[] chArr = new char[15];
            for (int j = 0; j < 15; j++) {
                if(j >= a.length()){
                    chArr[j] = 'o';
                }else{
                    chArr[j] = a.charAt(j);
                }
            }
            int count = 0;
            for (int j = 0; j < 15; j++) {
                if(chArr[j] == 'o'){
                    count++;
                }
            }

            if(count >= 8){
                System.out.println("#"+ (i+1) +" YES");
            }else{
                System.out.println("#"+ (i+1) +" NO");
            }
        }
    }
}
