package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B_12904 {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        checking(a,b);
        if(flag){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
    //문자열의 뒤에 A를 추가한다.
    //문자열을 뒤집고 뒤에 B를 추가한다.
    // b -> a
    // b 문자열 맨 뒤에 B 가 있다면
    // b 문자열 맨 뒤에 A 가 있다면
    public static void checking(String a, String b){
        if(a.length() == b.length()){
            if(a.equals(b)){
                flag = true;
                return;
            }else{
                return;
            }
        }
        if(b.charAt(b.length() - 1) == 'A'){
            String newB1 = new StringBuilder(b).deleteCharAt(b.length() - 1).toString();
            checking(a,newB1);
        }else{
            String newB2 = new StringBuilder(b).deleteCharAt(b.length() - 1).reverse().toString();
            checking(a,newB2);
        }
    }
}
