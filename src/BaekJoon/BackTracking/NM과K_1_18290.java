package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NM과K_1_18290 {
    static int[][] graph;
    static int m;
    static boolean[][] visited;
    static int[] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x];
        arr = new int[m * 2];
        for(int i = 0; i < graph.length; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[0].length; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0,0,-1);
        System.out.println(MAX);
    }
    public static void backTracking(int depth , int y, int x){
        if(depth == m*2){
            int total = 0;
            for(int i = 0 ; i < arr.length; i += 2){
                int nextY = arr[i];
                int nextX = arr[i+1];
                total += graph[nextY][nextX];
                System.out.println("y = "+nextY+" x = " +nextX);
            }
            System.out.println("total = "+ total);
            MAX = Math.max( total, MAX);
            return;
        }
        for(int i = 0; i < graph.length; i ++){
            for(int j = 0 ; j < graph[0].length; j ++){
                if(!visited[i][j] && (y < i && x < j)){
                    arr[depth] = i;
                    arr[depth + 1] = j;
                    visited[i][j] = true;
                    for(int k = 0 ; k < 4; k ++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if(checking(nextY,nextX)){
                            visited[nextY][nextX] = true;
                        }
                    }
                    backTracking(depth + 2, i, j);
                    visited[i][j] = false;
                    for(int k = 0 ; k < 4; k ++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if(checking(nextY,nextX)){
                            visited[nextY][nextX] = false;
                        }
                    }
                }
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}

