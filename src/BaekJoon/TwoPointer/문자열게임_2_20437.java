package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임_2_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            input(br);
        }
    }
    public static void input(BufferedReader br) throws IOException {
        String str = br.readLine();
        int count = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        for(int i = 0; i < str.length(); i++){
            alphabet[str.charAt(i) - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if(count == 1) { //k가 1일때
            System.out.println("1 1");
            return;
        }
        for(int i = 0; i < str.length(); i++){
            if(alphabet[str.charAt(i) - 'a'] < count ) continue;
            int checkNumber = 1;
            for(int j = i + 1; j < str.length(); j++){
                if( str.charAt(j) == str.charAt(i) ){
                   checkNumber++;
                }
                if(checkNumber == count){
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }
        if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min + " " + max);
        }
    }
}
