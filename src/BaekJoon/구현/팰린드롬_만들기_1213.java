package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬_만들기_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] number = new int[26];
        for(int i = 0 ; i < str.length(); i++){
            int ch = str.charAt(i) - 'A';
            number[ch]++;
        }
        char[] arr = new char[str.length()];
        int index1 = 0;
        int index2 = arr.length - 1;
        while(index1 < index2){
            if(str.length() % 2 == 0){
                // 짝수인경우
                for(int i = 0 ; i < 26; i++){
                    if(number[i] >= 2){
                        int num = i + 65;
                        number[i] -= 2;
                        arr[index1] = (char) num;
                        arr[index2] = (char) num;
                        index1++;
                        index2--;
                        break;
                    }else if(number[i] == 1){
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    }
                }
            }else{
                // 홀수인경우
                for(int i = 0 ; i < 26; i++){
                    if(number[i] >= 2){
                        int num = i + 65;
                        number[i] -= 2;
                        arr[index1] = (char) num;
                        arr[index2] = (char) num;
                        index1++;
                        index2--;
                        break;
                    }
                }

                int count = 0 ;
                for(int i = 0 ; i < 26; i++){
                    if(number[i] == 1){
                        count++;
                    }
                }
                if(count >= 2){
                    break;
                }

            }
        }
        if(str.length() % 2 == 0){
            for(int i = 0 ; i < arr.length; i++){
                System.out.print(arr[i]);
            }
        }else{
            int count = 0;
            for(int i = 0 ; i < 26; i++){
                if(number[i] == 1){
                    count++;
                    int num = i + 65;
                    arr[index1] = (char) num;
                }
            }
            if(count == 1){
                for(int i = 0 ; i < arr.length; i++){
                    System.out.print(arr[i]);
                }
            }else{
                System.out.println("I'm Sorry Hansoo");
            }
        }
    }
}
