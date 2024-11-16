package Inflearn.classString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 아스키코드 65 ~ 91 대문자
        // 97 ~ 122 소문자
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int check = str.charAt(i);
            char ch = str.charAt(i);
            if( check >= 97){
                sb.append((char)(ch - 32));
            }else{
                sb.append((char)(ch + 32));
            }
        }
        System.out.println(sb);
    }
}
