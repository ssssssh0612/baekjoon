package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    static List<int[]> list = new ArrayList<>();
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }
        for(int i = 0 ; i < n ; i ++){
            int[] pos = list.get(i);
            int day = pos[0];
            int value = pos[1];
            if(i + day < n){
                step(value, i + day);
            }else if( i + day == n){
                dp[n - 1] = Math.max(value, dp[n - 1]);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }

    public static void step(int num, int index){
        for (int i = index; i < n; i++) {
            int[] pos = list.get(i);
            int day = pos[0];
            int value = pos[1];
            if( i + day < n ){
                step(num + value, i + day);
            }else if(i == n - 1 && day == 1){
                dp[n - 1] = Math.max(num + value, dp[n - 1]);
            }else if( i + day == n){
                dp[n - 1] = Math.max(num + value , dp[n - 1]);
            } else{
                dp[index] = Math.max(num, dp[index]);
            }
        }
    }
}
