package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 반지_5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < num; i++) {
            if(check(br.readLine(), str)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean check(String str, String compare){
        for (int i = 0; i < str.length(); i++) {
            int check = 0;
            for (int j = 0; j < compare.length(); j++) {
                int index = i + j;
                if(index >= str.length()){
                    index = index - str.length();
                }
                char ch1 = str.charAt(index);
                char ch2 = compare.charAt(j);
                if(ch1 != ch2){
                    break;
                }else{
                    check++;
                }
            }
            if(check == compare.length()){
                return true;
            }
        }
        return false;
    }
}
