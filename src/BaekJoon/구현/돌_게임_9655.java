package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌_게임_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int result = number / 3;
        int namuji = number % 3;

        if(result % 2 == 0){
            if( namuji == 1){
                System.out.println("SK");
            }else{
                System.out.println("CY");
            }
        }else if(result % 2 == 1){
            if( namuji == 1){
                System.out.println("CY");
            }else{
                System.out.println("SK");
            }
        }
    }
}
