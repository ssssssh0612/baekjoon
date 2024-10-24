package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {
    static int[] dochiPos = new int[2];
    static int[] waterPos = new int[2];
    static int[] endPos = new int[2];
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =  new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String a = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = a.charAt(j);
                if(ch =='D'){
                    // 목적지
                    graph[i][j] = -1;
                    endPos[0] = i;
                    endPos[1] = j;
                }else if(ch == 'S'){
                    // 출발지
                    graph[i][j] = 0;
                    dochiPos[0] = i;
                    dochiPos[1] = j;
                }else if(ch == '*'){
                    // 물
                    graph[i][j] = -2;
                }else if(ch == 'X'){
                    // 돌
                    graph[i][j] = -3;
                }else{
                    graph[i][j] = 0;
                }
            }
        }
        checking();


    }
    public static void dochiMove(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x,0});

        while(!queue.isEmpty()){

        }
    }
    public static void bfsWater(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if(checking(nowY,nowX) && !visited[nowY][nowX] && graph[nowY][nowX] != -3 &&
                        graph[nowY][nowX] != -2){
                    
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && y < graph.length && x >=0 && x < graph[0].length;
    }
    public static void checking(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
