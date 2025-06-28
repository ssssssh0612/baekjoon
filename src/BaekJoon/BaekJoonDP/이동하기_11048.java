package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기_11048 {
    static int y;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int[][] arr = new int[y][x];
        int[][] dp = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(checking(i + 1, j)){
                    dp[i + 1][j] = Math.max(dp[i + 1][j] , dp[i][j] + arr[i + 1][j]);
                }

                if(checking(i,j+1)){
                    dp[i][j + 1] = Math.max(dp[i][j + 1] , dp[i][j] + arr[i][j + 1]);
                }

                if(checking(i + 1, j + 1)){
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1] , dp[i][j] + arr[i + 1][j + 1]);
                }
            }
        }

        System.out.println(dp[y - 1][x - 1]);


    }

    public static boolean checking(int nowY, int nowX){
        return y >= 0 && x >= 0 && nowY < y && nowX < x;
    }
}
