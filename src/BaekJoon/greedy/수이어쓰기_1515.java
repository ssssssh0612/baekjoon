package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int pointer = 0;
        int base = 1;
        while(pointer < str.length()){
            String baseString = String.valueOf(base);
            for(int i = 0 ; i < baseString.length(); i++){
                int number = baseString.charAt(i) - '0';
                if(str.charAt(pointer) - '0' == number){
                    pointer++;
                }
                if(pointer == str.length()){
                    break;
                }
            }
            base++;
        }
        System.out.println(base - 1);
    }
}
