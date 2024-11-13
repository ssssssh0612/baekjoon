package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_practice {
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < testCase; i ++){
            input(br);
            checkingGraph();
        }
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x];
        for(int i = 0 ; i < count ; i ++){
            st = new StringTokenizer(br.readLine());
            int nowY = Integer.parseInt(st.nextToken());
            int nowX = Integer.parseInt(st.nextToken());
            graph[nowY][nowX] = 1;
        }
    }
    public static void checkingGraph(){
        int count = 0;
        for(int i = 0 ; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j++){
                if( graph[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(int y , int x){
        for(int i = 0 ; i < 4; i ++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(checking(nextY,nextX) && graph[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                dfs(nextY,nextX);
            }
        }
    }
    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
