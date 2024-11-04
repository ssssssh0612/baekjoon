package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException {
        int q = 1;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[][] graph = new int[n][n];
            int[][] copyGraph = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    graph[i][j] = number;
                    copyGraph[i][j] = number;
                }
            }
            //Problem 1: 20
            System.out.println("Problem "+q+": "+bfs(copyGraph, graph));
            q++;
        }
    }
    public static int bfs(int[][] copyGraph, int[][] graph){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph.length];
        queue.add(new int[]{0,0,graph[0][0]});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                // 범위 안에 들어가고
                if(checking(nextY, nextX, graph) && !visited[nextY][nextX] ){
                    queue.add(new int[]{nextY,nextX,now[2] + copyGraph[nextY][nextX]});
                    graph[nextY][nextX] = now[2] + graph[nextY][nextX];
                    visited[nextY][nextX] = true;
                }else if(checking(nextY, nextX, graph) && visited[nextY][nextX]){
                    if(graph[nextY][nextX] > now[2] + copyGraph[nextY][nextX]){
                        graph[nextY][nextX] = now[2] + copyGraph[nextY][nextX];
                        queue.add(new int[]{nextY,nextX,now[2] + copyGraph[nextY][nextX]});
                    }
                }
            }
        }
        return graph[graph.length-1][graph.length-1];
    }
    public static void checking(int[][] graph){
        System.out.println();
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean checking(int y, int x,int[][] graph){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
}
