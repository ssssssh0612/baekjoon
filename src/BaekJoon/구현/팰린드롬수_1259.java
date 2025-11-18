package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals("0")){
                return;
            }
            if(check(str)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
    public static boolean check(String str){

        int index = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(index)) {
                return false;
            }
            index--;
        }
        return true;
        // 3

        // 1
        // 4 0 1
        // 4 3 2

    }
}
