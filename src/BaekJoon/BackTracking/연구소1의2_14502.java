package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소1의2_14502 {
    static int[][] graph;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited;
    static int[] arr = new int[6];
    static List<int[]> birusList = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        backTracking(0,0);
        System.out.println(max);
    }
    public static void backTracking(int depth, int number){
        if(depth == 6){
            for(int i = 0 ; i < 6; i += 2){
                int y = arr[i];
                int x = arr[i+1];
//                System.out.println("Y = " + y + " X = " + x+" ");
                graph[y][x] = 1;
            }
            bfs();
            for(int i = 0 ; i < 6; i += 2){
                int y = arr[i];
                int x = arr[i+1];
                graph[y][x] = 0;
            }
            return;
        }
        for(int i = 0 ; i < list.size(); i ++){
            if(!visited[i] && i >= number ){
                arr[depth] = list.get(i)[0];
                arr[depth + 1] = list.get(i)[1];
                visited[i] = true;
                backTracking(depth + 2, i);
                visited[i] = false;
            }
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int number = Integer.parseInt(st.nextToken());
                graph[i][j] = number;
                if (number == 0) {
                    list.add(new int[]{i, j});
                }else if(number == 2){
                    birusList.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[list.size()];
    }
    public static void bfs(){
        boolean[][] newVisited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < birusList.size(); i++){
            int y = birusList.get(i)[0];
            int x = birusList.get(i)[1];
            newVisited[y][x] = true;
            queue.add(new int[]{y,x});
        }
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY,nextX) && !newVisited[nextY][nextX] && graph[nextY][nextX] == 0){
                    newVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY,nextX});
                }
            }
        }
        int count = 0 ;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                int number = graph[i][j];
                if( number == 0 && !newVisited[i][j] ){
                    count++;
                }
            }
        }
        max = Math.max(count, max);
    }
    public static boolean checking(int y , int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }


    public static int[][] copyGraph(int[][] graph) {
        int[][] newGraph = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }
}
