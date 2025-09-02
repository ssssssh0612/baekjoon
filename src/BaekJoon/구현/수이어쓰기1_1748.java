package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기1_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if(i == str.length() - 1){
                // 현재 숫자 빼기
                int num = (Math.abs(Integer.parseInt(str) - num(i)) + 1) * (i + 1);
                count += num;
            }else{
                int x = (num(i) * 9) * (i + 1);
                count += x;
            }
        }
        System.out.println(count);
    }
    public static int num(int num){
        if(num == 0){
            return 1;
        }else{
            return 10 * num(num - 1);
        }
    }
}