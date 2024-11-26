package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양한마리_두마리_11123 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int count = 0 ;
            int[][] graph = input(br);
            boolean[][] visited = new boolean[graph.length][graph[0].length];
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[0].length; k++) {
                    if(!visited[j][k] && graph[j][k] == 1){
                        visited[j][k] = true;
                        count++;
                        dfs(graph,visited,j,k);
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static int[][] input(BufferedReader br )throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                if(str.charAt(j) == '#'){
                    graph[i][j] = 1;
                }else{
                    graph[i][j] = 0;
                }
            }
        }
        return graph;
    }
    public static void dfs(int[][] graph, boolean[][] visited, int y, int x){
        for (int i = 0; i < 4; i++) {
            int nextY = dy[i] + y ;
            int nextX = dx[i] + x ;
            if(checking(nextY,nextX, graph.length, graph[0].length) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                visited[nextY][nextX] = true;
                dfs(graph,visited,nextY,nextX);
            }
        }
    }

    public static boolean checking(int y, int x, int yLength, int xLength){
        return y >= 0 && x >= 0 && y < yLength && x < xLength;
    }
}