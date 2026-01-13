package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한국이_9996 {
    static String regex;
    static StringBuilder front;
    static StringBuilder back;
    static int length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        regex = br.readLine();

        front = new StringBuilder();
        back = new StringBuilder();
        for (int i = 0; i < regex.length(); i++) {
            if(regex.charAt(i) == '*'){
                break;
            }else{
                front.append(regex.charAt(i));
            }
        }

        for (int i = regex.length() - 1; i >= 0; i--) {
            if(regex.charAt(i) == '*'){
                break;
            }else{
                back.append(regex.charAt(i));
            }
        }
        length = front.length() + back.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(check(str)){
                sb.append("DA").append("\n");
            }else{
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean check(String str){
        if(str.length() < length){
            return false;
        }

        for (int i = 0; i < front.length(); i++) {
            if(str.charAt(i) != front.charAt(i)){
                return false;
            }
        }

        int index = 0;
        for (int i = str.length() - 1; i >= str.length() - back.length(); i--) {
            if(str.charAt(i) != back.charAt(index)){
                return false;
            }
            index++;
        }

        return true;
    }
}
