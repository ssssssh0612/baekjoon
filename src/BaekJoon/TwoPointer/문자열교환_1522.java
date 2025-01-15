package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환_1522 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int aCount = 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                aCount++;
            }
        }
        for(int i = 0; i < str.length(); i++){
            int end = i + aCount;
            int bCount = 0;
            for(int j = i; j < end; j++){
                if(j >= str.length()){
                    char ch = str.charAt(j - str.length());
                    if(ch == 'b'){
                        bCount++;
                    }
                }else{
                    char ch = str.charAt(j);
                    if (ch == 'b') {
                        bCount++;
                    }
                }
            }
            result = Math.min(bCount, result);
        }
        System.out.println(result);
    }

}
