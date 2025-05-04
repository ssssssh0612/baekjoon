package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 항체_인식_22352 {
    static int newGraphCount = 0;
    static int graphCount = 0;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] graph;
    static int[][] newGraph;
    static boolean[][] visited;
    static boolean[][] newVisited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        newGraph = new int[y][x];
        visited = new boolean[y][x];
        newVisited = new boolean[y][x];
        for(int i = 0 ; i < y ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < y ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < x; j++){
                newGraph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // newGraph
        for(int i = 0 ; i < y ; i ++){
            for(int j = 0 ; j < x; j++){
                if(!newVisited[i][j]){
                    newGraphCount++;
                    newBfs(i,j);
                }
            }
        }


        for(int i = 0 ; i < y ; i++){
            for(int j = 0 ; j < x; j++){
                if(!visited[i][j]){
                    graphCount++;
                    bfs(i, j);
                }
            }
        }

        if(graphCount < newGraphCount){
            System.out.println("NO");
            return;
        }


        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }
    public static void newBfs(int y, int x){
        int num = newGraph[y][x];
        Queue<int[]> queue = new LinkedList<>();
        newVisited[y][x] = true;
        queue.add(new int[]{y, x});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !newVisited[nextY][nextX]
                        && num == newGraph[nextY][nextX]){
                    newVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }
    public static void bfs(int y , int x){
        boolean[][] checkVisited = new boolean[graph.length][graph[0].length];
        checkVisited[y][x] = true;
        int num = graph[y][x];
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4; i ++){
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !visited[nextY][nextX]
                        && num == graph[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                    checkVisited[nextY][nextX] = true;
                }
            }
        }

//        System.out.println();
//        for(int i = 0 ; i < graph.length ; i++){
//            for(int j = 0 ; j < graph[0].length; j++){
//                if(checkVisited[i][j]){
//                    System.out.print(0 + " ");
//                }else{
//                    System.out.print(1 + " ");
//                }
//            }
//            System.out.println();
//        }

        for(int i = 0 ; i < graph.length ; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                if(!checkVisited[i][j] && graph[i][j] != newGraph[i][j]){
                    return;
                }
            }
        }
        int newNum = newGraph[y][x];
        for(int i = 0 ; i < graph.length ; i++){
            for(int j = 0 ; j < graph[0].length; j++){
                if(checkVisited[i][j] && newNum != newGraph[i][j]){
                    return;
                }
            }
        }



        flag = true;
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}

//1 4
//1 1 1 1
//2 2 3 3