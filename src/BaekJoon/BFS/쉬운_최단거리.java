package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리 {
    static long[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int startY = 0;
    static int startX = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new long[y][x];
        visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 2){
                    startY = i;
                    startX = j;
                    graph[i][j] = 0;
                }else{
                    graph[i][j] = n;
                }
            }
        }
        bfs();
        result();



    }
    public static void bfs(){
        visited[startY][startX] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            long number = graph[poll[0]][poll[1]];
            for (int i = 0; i < 4; i++) {
                int nowY = poll[0] + dy[i];
                int nowX = poll[1] + dx[i];
                if(checking(nowY,nowX) && !visited[nowY][nowX] && graph[nowY][nowX] == 1){
                    queue.add(new int[]{nowY, nowX});
                    visited[nowY][nowX] = true;
                    graph[nowY][nowX] = number + 1;
                }
            }
        }
    }
    public static void result(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 1 && !visited[i][j]){
                    System.out.print(-1 + " ");
                }else{
                    System.out.print(graph[i][j] + " ");

                }
            }
            System.out.println();
        }
    }

    public static boolean checking(int y, int x){
        return y >= 0 && y < graph.length && x >= 0 && x < graph[0].length;
    }
}
