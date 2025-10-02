package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 밤양갱_31926 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 8;
        int nowNum = 1;

        while(nowNum < num + 1){
            int newNum = nowNum + nowNum;
            if(newNum < num + 1){
                nowNum = newNum;
                count++;
                continue;
            }else{
                count+=2;
                break;
            }
        }
        System.out.println(count);

    }
}

// 1
// daldi dal go daldidan
// 12345 6   78 9      10
// 2
// daldidalgo daldidalgo daldidan
// 123456  78 9          10     11
// daldidalgo daldidalgo daldidalgo daldidan
// 123456  78 9          10                11
// daldidalgo daldidalgo daldidalgo daldidalgo daldidan
// 123456  78 9          10                    11     12
// daldidalgo daldidalgo daldidalgo daldidalgo daldidalgo daldidan

