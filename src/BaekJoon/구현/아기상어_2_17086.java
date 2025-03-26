package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_2_17086 {
    static int result = Integer.MIN_VALUE;
    static int[][] graph;
    //(y-1,x-1) y-1,x y-1, x+1
    //(y,x-1) (y,x) (y, x+1)
    //y+1,x-1 y+1,x y+1, x+1
    static int[] dy = {-1,-1,-1,0,1,1,1,0};
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for(int i = 0 ; i < y ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < y ; i ++){
            for(int j = 0 ; j < x; j ++){
                int num = graph[i][j];
                if(num == 0){
                    bfs(i,j);
                }
            }
        }
        System.out.println(result);
    }
    public static void bfs(int y, int x){
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,0});
        while(!queue.isEmpty()){
            // 가장 빨리 만나는 숫자 1 찾기 그중에 가장 큰거
            int[] now = queue.poll();
            if(graph[now[0]][now[1]] == 1){
                result = Math.max(result, now[2]);
                return;
            }
            for(int i = 0; i < 8 ; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
