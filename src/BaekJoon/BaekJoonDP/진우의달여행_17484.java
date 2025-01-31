package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행_17484 {
    static int[] dy = {1, 1, 1};
    static int[] dx = {-1, 0, 1};
    static int[][] graph;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int number = Integer.parseInt(st.nextToken());
                graph[i][j] = number;
            }
        }

        for(int i = 0; i < x; i++) {
            dfs(-1,graph[0][i], 0 ,0 , i );
        }

        System.out.println(result);
    }
    public static void dfs(int distance, int value, int depth, int y, int x){
        if(depth == graph.length - 1){
            result = Math.min(value, result);
            return;
        }

        for(int i = 0 ; i < 3; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(distance != i && checking(nextY,nextX)){
                dfs(i, value + graph[nextY][nextX], depth + 1, nextY, nextX);
            }
        }
    }
    public static boolean checking(int y, int x) {
        return x >= 0 && y >= 0 && y < graph.length && x < graph[0].length;
    }
}
