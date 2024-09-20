package BaekJoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 단지번호붙이기_2667 {
    static int[][] graph;
    static int count;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new int[n+2][n+2];
        visited = new boolean[n+2][n+2];
        for (int i = 1; i < n+1; i++) {
            String a = sc.next();
            for (int j = 1; j < n+1; j++) {
                graph[i][j] = a.charAt(j - 1) - '0';
                if(graph[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(graph[i][j]==1){
                    dfs(i,j);
                    list.add(count+1);
                    count= 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public static void dfs(int i, int j) {
        visited[i][j] = false;
        graph[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            if(graph[i+ dy[k]][j + dx[k]]==1 && visited[i+dy[k]][j+dx[k]]){
                visited[i+dy[k]][j+dx[k]] = false;
                graph[i+ dy[k]][j + dx[k]] = 0;
                count++;
                dfs(i+dy[k],j+dx[k]);
            }
        }
    }
}

//7
//0110100
//0110101
//1110101
//0000111
//0100000
//0111110
//0111000


