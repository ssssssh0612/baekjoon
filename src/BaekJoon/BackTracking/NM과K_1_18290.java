package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM과K_1_18290 {
    static int y;
    static int x;
    static int k;
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int RESULT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[y][x];
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


//        backTracking(0,0,visited);
        backTracking(0,0);
        System.out.println(RESULT);

    }
    public static void backTracking(int depth, int result){
        if( depth == k ){
            RESULT = Math.max(RESULT, result);
            return;
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    for (int l = 0; l < 4; l++) {
                        int nowY = i + dy[l];
                        int nowX = j + dx[l];
                        if( checking( nowY , nowX )){
                            visited[nowY][nowX] = true;
                        }
                    }
                    int newResult = result + graph[i][j];
                    checking();
                    backTracking(depth+1, newResult);
                    visited[i][j] = false;
                    for (int l = 0; l < 4; l++) {
                        int nowY = i + dy[l];
                        int nowX = j + dx[l];
                        if( checking( nowY , nowX )){
                            visited[nowY][nowX] = false;
                        }
                    }
                }
            }
        }
    }
    public static void checking(){
        System.out.println();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(visited[i][j]){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void backTracking(int depth, int result, boolean[][] newVisited){
        if( depth == k ){
            RESULT = Math.max(RESULT, result);
            return;
        }
        // 왜 같은값이 들어가는지 이해가 안됨
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if( !newVisited[i][j] ){
                    boolean[][] newOne = copyVisited(newVisited);
                    newOne[i][j] = true;
                    for (int l = 0; l < 4; l++) {
                        int nowY = i + dy[l];
                        int nowX = j + dx[l];
                        if(checking(nowY,nowX)){
                            newOne[nowY][nowX] = true;
                        }
                    }

                    int newResult = result + graph[i][j];
                    backTracking(depth+1, newResult, newOne);
                    newOne[i][j] = false;
                    for (int l = 0; l < 4; l++) {
                        int nowY = i + dy[l];
                        int nowX = j + dx[l];
                        if(checking(nowY,nowX)){
                            newOne[nowY][nowX] = false;
                        }
                    }
                }
            }
        }
    }
    public static boolean checking(int nowY , int nowX){
        return nowY >= 0 && nowX >= 0 && nowY < y && nowX < x;
    }
    public static boolean[][] copyVisited(boolean[][] oldVisited){
        boolean[][] newVisited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                newVisited[i][j] = oldVisited[i][j];
            }
        }
        return newVisited;
    }
}
