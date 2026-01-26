package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 갤러리_2115 {
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m][4];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if(str.charAt(j) == 'X'){
                    graph[i][j] = 1;
                }else{
                    graph[i][j] = 0;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0) continue;
                // 상, 하, 좌, 우 살피기
                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if(checking(nextY, nextX) && graph[nextY][nextX] == 0 && !visited[i][j][k]){
                        if(k == 0 || k == 1){
                            if(checking(i + dy[3], j + dx[3]) && checking(i + dy[3] + dy[k],j + dx[3] + dx[k])
                                    && graph[i + dy[3]][j + dx[3]] == 1
                                    && !visited[i + dy[3]][j + dx[3]][k]
                                    && graph[i + dy[3] + dy[k]][j + dx[3] + dx[k]] == 0){
                              visited[i][j][k] = true;
                              visited[i + dy[3]][j + dx[3]][k] = true;
                              result++;
                            }
                        }else{
                            if(checking(i + dy[1], j + dx[1]) && checking(i + dy[1] + dy[k],j + dx[1] + dx[k])
                                    && graph[i + dy[1]][j + dx[1]] == 1
                                    && !visited[i + dy[1]][j + dx[1]][k]
                                    && graph[i + dy[1] + dy[k]][j + dx[1] + dx[k]] == 0){
                                visited[i][j][k] = true;
                                visited[i + dy[1]][j + dx[1]][k] = true;
                                result++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
