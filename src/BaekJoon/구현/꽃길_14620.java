package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꽃길_14620 {
    static int[] arr = new int[6];
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // n 은 1,1 ~ n - 1 , n - 1

        backTracking(0);
        System.out.println(result);

    }
    public static void backTracking(int depth){
        if(depth == 6){
            // 현재 arr의 위치를 보기
            // 하지만 꽃이 겹치면 안됨
            boolean[][] check = new boolean[graph.length][graph.length];
            int num = 0;

            for (int i = 0; i < arr.length; i+=2) {
                // i, j 동서남북으로 돌기
                int y = arr[i];
                int x = arr[i + 1];
                check[y][x] = true;
                num += graph[y][x];
                for (int j = 0; j < 4; j++) {
                    int nextY = y + dy[j];
                    int nextX = x + dx[j];
                    if(!check[nextY][nextX]){
                        check[nextY][nextX] = true;
                        num += graph[nextY][nextX];
                    }else{
                        return;
                    }
                }
            }
            result = Math.min(result, num);
            return;
        }

        for (int i = 1; i < graph.length - 1; i++) {
            for (int j = 1; j < graph.length - 1; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    arr[depth] = i;
                    arr[depth + 1] = j;
                    backTracking(depth + 2);
                    visited[i][j] = false;
                }
            }
        }


    }
    public static boolean checking(int y , int x){
        return y>= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
}
