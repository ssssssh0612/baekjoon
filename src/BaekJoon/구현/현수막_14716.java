package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 현수막_14716 {
    //
    static int[] dy = {-1,1,0,0,-1,-1,1,1};
    static int[] dx = {0,0,-1,1,-1,1,1,-1};

    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        boolean[][] visited = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && graph[i][j] == 1){
                    result++;
                    dfs(visited, graph, i, j);
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs(boolean[][] visited , int[][] graph, int y , int x){
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(checking(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                dfs(visited, graph, nextY, nextX);
            }
        }
    }
    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < n && x < m ;
    }
}
