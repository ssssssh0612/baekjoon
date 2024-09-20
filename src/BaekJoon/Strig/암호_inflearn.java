package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호_inflearn {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String answer = "";
        for (int i = 0; i < a; i++) {
            if( i == 0 ){
                String result = str.substring(0,7);
                answer += number(result);
            }else{
                String result = str.substring(i*7,i*7+7);
                answer += number(result);
            }
        }
        System.out.println(answer);
    }


    public static char number(String result){
        StringBuilder str = new StringBuilder(result).reverse();
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#'){
                newStr += 1;
            }else{
                newStr += 0;
            }
        }
        int num = 0;
        for (int i = 0; i < newStr.length(); i++) {
            if(newStr.charAt(i) == '1'){
                num += numberChecking(i);
            }
        }
        return (char)num;
    }

    public static int numberChecking(int number){
        if(number == 0){
            return 1;
        }
        return 2*numberChecking(number -1);
    }
}
