package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 새로운_게임_2_17837 {
    public static class Horse{
        int dir;
        int number;
        public Horse(int number, int dir){
            this.number = number;
            this.dir = dir;
        }
    }
    static int[][] graph;
    // 오른쪽 왼쪽 위쪽 아래쪽
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Horse>[][] nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int horseCount = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nodeList = new ArrayList[n][n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                nodeList[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0 ; i < horseCount; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            nodeList[y][x].add(new Horse(i+1,dir));
        }

    }
}
