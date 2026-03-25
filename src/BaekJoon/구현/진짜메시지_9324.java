package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진짜메시지_9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean flag = step(str);
            if(flag){
                result.append("OK").append("\n");
            }else{
                result.append("FAKE").append("\n");
            }
        }
        System.out.println(result);
    }
    public static boolean step(String str){
        int[] arr = new int[26];

        int after = 0;
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            if(check){
                if(num == after){
                    check = false;
                    continue;
                }else{
                    return false;
                }
            }
            arr[num]++;
            if(arr[num] == 3){
                after = num;
                check = true;
                arr[num] = 0;
            }
        }
        return !check;
    }
}
