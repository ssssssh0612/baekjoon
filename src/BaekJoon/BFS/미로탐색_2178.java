package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] resultGraph;
    static int result = 0;
    static int qqq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs();
        System.out.println(result);
        System.out.println(qqq);
    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j++){
                System.out.print(resultGraph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        resultGraph = new int[y][x];
        for(int i = 0 ; i < y ; i ++){
            String a = br.readLine();
            for(int j = 0 ; j < x ; j++){
                graph[i][j] = a.charAt(j) - '0';
            }
        }

    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        resultGraph[0][0] = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == graph.length - 1 && now[1] == graph[0].length - 1){
                result = now[2];
            }
            for(int i = 0; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY,nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                    queue.add(new int[]{nextY,nextX,now[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }


    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

}
