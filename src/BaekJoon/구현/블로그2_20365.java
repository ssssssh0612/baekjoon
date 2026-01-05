package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 블로그2_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int a = step1(str);
        int b = step2(str, 'R');
        int c = step2(str, 'B');
        a = Math.min(a, b);
        a = Math.min(a, c);
        System.out.println(a);
    }
    public static int step1(String str) {
        char nowCh = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if(nowCh != str.charAt(i)){
                count++;
                nowCh = str.charAt(i);
            }
        }
        return count;
    }
    public static int step2(String str, char ch){
        char nowCh = ch;
        int count = 1;
        int index = 0;
        while(index < str.length()){
            if(str.charAt(index) == nowCh){
                index++;
            }else{
                count++;
                index++;
                while(str.length() > index && str.charAt(index) != nowCh){
                    index++;
                }
            }
        }

        return count;
    }
}
