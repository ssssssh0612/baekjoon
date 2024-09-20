package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 특정문자뒤집기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int lt = 0;
        int rt = a.length() - 1;
        char[] chars = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            if( lt > rt ){
                break;
            }
            char ltc = chars[lt];
            char rtc = chars[rt];

            if(!checking(ltc)){
                lt++;
            }else if(!checking(rtc)){
                rt--;
            }else{
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
//        String bb = solution(a);
    }

    public static boolean checking( char chr){
        int number = (int)chr;
        return (number >= 97 && number <= 122) || (number >= 65 && number <= 90);
    }

    public static String solution(String str){
        String answer = "";
        char[] s = str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt < rt){
            if(!Character.isAlphabetic(s[lt])){
                System.out.println("lt");
                lt++;
            }
		else if(!Character.isAlphabetic(s[rt])){
                System.out.println("rt");
            rt--;
            }
		else{
                char tmp = s[lt];
                s[lt] = s[rt];
                lt++;
                rt--;
            }
        }
        return answer;
    }
}
