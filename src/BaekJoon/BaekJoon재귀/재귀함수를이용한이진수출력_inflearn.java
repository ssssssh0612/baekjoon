package BaekJoon.BaekJoon재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수를이용한이진수출력_inflearn {
    static StringBuilder newSb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        returnString(number, new StringBuilder());
        System.out.println(newSb.reverse());
    }

    public static void returnString(int number, StringBuilder sb){
        // 2를 나눈 나머지
        int result = number / 2;
        int namuji = number % 2;
        if(number == 0){
            sb.append(0);
            newSb = sb;
            return;
        }else{
            sb.append(namuji);
            returnString(result, sb);
        }
    }
}
