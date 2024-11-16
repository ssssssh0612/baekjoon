package Inflearn.classString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < number;  i++){
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            list.add(sb.toString());
        }
        for(int i = 0; i < number; i++){
            System.out.println(list.get(i));
        }
        // 아스키코드 65 ~ 91 대문자
        // 97 ~ 122 소문자


    }
}
