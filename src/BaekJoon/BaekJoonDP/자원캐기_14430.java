package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자원캐기_14430 {
    static int[][] graph;
    static int[] dy = {-1,0};
    static int[] dx = {0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];

        int[][] dp = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = graph[0][0];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int num1 = 0;
                int num2 = 0;

                if(checking(i + dy[0], j + dx[0])){
                    num1 = dp[i + dy[0]][j + dx[0]];
                }

                if(checking(i + dy[1], j + dx[1])){
                    num2 = dp[i + dy[1]][j + dx[1]];
                }

                if(num1 > num2){
                    dp[i][j] = num1 + graph[i][j];
                }else{
                    dp[i][j] = num2 + graph[i][j];
                }

            }
        }

        System.out.println(dp[graph.length - 1][graph[0].length - 1]);
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
