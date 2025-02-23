package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기_2146 {
    static int[][] graph ;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static int resultCount = Integer.MAX_VALUE;
    static List<List<int[]>> numberList = new ArrayList<>();
    static int[] arr;
    static int number;
    static boolean[] arrVisited;
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[graph.length][graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < graph.length; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        number = 1;
        numberList.add(new ArrayList<>());
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i,j,number);
                    number++;
                }
            }
        }

        for(int i = 0 ; i < graph.length ; i ++ ){
            for(int j = 0 ; j < graph.length ; j ++){
                if(graph[i][j] > 0){
                    resultBFS(i,j);
                }
            }
        }
        System.out.println(resultCount - 1);
    }
    public static void resultBFS(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        int number = graph[y][x];
        boolean[][] newVisited = new boolean[graph.length][graph.length];
        newVisited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int newNumber = graph[now[0]][now[1]];
            if(newNumber != 0 && number != newNumber){
                resultCount = Math.min(resultCount, now[2]);
            }
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !newVisited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                    newVisited[nextY][nextX] = true;
                }
            }
        }
    }


    public static void bfs(int y, int x, int number){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        graph[y][x] = number;
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1){
                    queue.add(new int[]{nextY, nextX});
                    graph[nextY][nextX] = number;
                    visited[nextY][nextX] = true;
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
}
