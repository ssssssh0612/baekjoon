package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B_12904 {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    public static void input(BufferedReader br) throws IOException {
        String a = br.readLine();
        StringBuilder sb1 = new StringBuilder(a);
        String b = br.readLine();
        StringBuilder sb2 = new StringBuilder(b);
        step(sb1,sb2);
    }

    public static void step(StringBuilder a, StringBuilder b){
        while(a.length() < b.length()){
            if(b.charAt(b.length() - 1) == 'A'){
                b.deleteCharAt(b.length() - 1);
            }else{
                b.deleteCharAt(b.length() - 1);
                b.reverse();
            }
        }
        if(a.toString().contentEquals(b)){
            flag = true;
        }
    }

    //문자열의 뒤에 A를 추가한다.
    //문자열을 뒤집고 뒤에 B를 추가한다.

    public static void addA(String str, String result){
        if(str.length() == result.length()){
            if(str.equals(result)){
                flag = true;
                return;
            }else{
                return;
            }
        }
        str = str + "A";
        addA(str,result);
        addB(str,result);
    }
    public static void addB(String str, String result){
        if(str.length() == result.length()){
            if(str.equals(result)){
                flag = true;
                return;
            }else{
                return;
            }
        }
        StringBuilder newString = new StringBuilder();
        // 문자열을 뒤집고 뒤에 B를 추가
        for(int i = str.length() - 1 ; i >= 0; i--){
            newString.append(str.charAt(i));
        }
        newString.append("B");
        addA(newString.toString(),result);
        addB(newString.toString(),result);
    }
}
