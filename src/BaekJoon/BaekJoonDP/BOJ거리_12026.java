package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ거리_12026 {
    static String str;
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        str = br.readLine();
        arr = new int[length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        char next;
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(arr[i] == Integer.MAX_VALUE){
                continue;
            }
            if(cur == 'B'){
                next = 'O';
            }else if(cur =='O'){
                next = 'J';
            }else{
                next = 'B';
            }
            for(int j = i + 1; j < str.length(); j++){
                if(str.charAt(j) == next){
                    int nextValue = arr[i] + (j - i) * (j - i);
                    arr[j] = Math.min(arr[j],nextValue);
                }
            }
        }

        if(arr[length - 1] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(arr[length - 1]);
    }

}
