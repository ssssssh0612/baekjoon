package BaekJoon.CodeTree.구현.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 예술성 {
    static int[][] graph;
    static int n;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        group = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) {

        }

        panel();
        checkingGroup();


    }
    public static void bfs(int y, int x, int count){
        visited[y][x] = true;
        int number = graph[y][x];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        group[y][x] = count;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = poll[0] + dy[i];
                int nowX = poll[1] + dx[i];
                if(checking(nowY,nowX) && !visited[nowY][nowX] && graph[nowY][nowX] == number){
                    queue.add(new int[]{nowY,nowX});
                    visited[nowY][nowX] = true;
                    group[nowY][nowX] = count;
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n;
    }
    public static void checkingGroup(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(group[i][j]+" ");
            }
            System.out.println();

        }
    }
    public static void panel(){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    bfs(i,j,++count);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {

                }
            }
        }

    }


    public static int[][] copyGraph(int[][] graph) {
        int[][] copy = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                copy[i][j] = graph[i][j];
            }
        }
        return copy;
    }





    public static void checking(){
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}



