package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자상의경로_10164 {
    static int n;
    static int m;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        int k = Integer.parseInt(st.nextToken());

        if(k == 0){
            step0();
        }else{
            int check = 1;
            int[] pos = new int[2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(check == k){
                        pos[0] = i;
                        pos[1] = j;
                    }
                    check++;
                }
            }
            step1(pos);
        }

    }
    public static void step0(){
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dp[i][j] >= 1){
                    // 현재 범위안에 들면 들어가기
                    if(checking(i, j + 1)){
                        dp[i][j + 1] += dp[i][j];
                    }

                    if(checking(i + 1, j)){
                        dp[i + 1][j] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }

    public static void step1(int[] pos){
        dp[0][0] = 1;

        for (int i = 0; i <= pos[0]; i++) {
            for (int j = 0; j <= pos[1]; j++) {
                if(dp[i][j] >= 1){
                    // 현재 범위안에 들면 들어가기
                    if(checking(i, j + 1)){
                        dp[i][j + 1] += dp[i][j];
                    }

                    if(checking(i + 1, j)){
                        dp[i + 1][j] += dp[i][j];
                    }
                }
            }
        }


        int num = dp[pos[0]][pos[1]];

        dp = new int[n][m];
        dp[pos[0]][pos[1]] = num;

        for (int i = pos[0]; i < n; i++) {
            for (int j = pos[1]; j < m; j++) {
                if(dp[i][j] >= 1){
                    // 현재 범위안에 들면 들어가기
                    if(checking(i, j + 1)){
                        dp[i][j + 1] += dp[i][j];
                    }

                    if(checking(i + 1, j)){
                        dp[i + 1][j] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < dp.length && x < dp[0].length;
    }
}
