package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0 ; i < number; i ++){
            String str = br.readLine();
            result += step(str);
        }
        System.out.println(result);
    }
    public static int step(String str){
        int[] alphabet = new int[26];
        str =str.toUpperCase();
        int backNumber = 0;
        for(int i = 0; i < str.length(); i++){
            int number = str.charAt(i) - 'A';
            if(i == 0){
                alphabet[number]++;
                backNumber = number;
                continue;
            }
            if(backNumber != number){
                if(alphabet[number] > 0){
                    return 0;
                }else if(alphabet[number] == 0){
                    alphabet[number]++;
                    backNumber = number;
                }
            }
        }
        return 1;
    }
}
