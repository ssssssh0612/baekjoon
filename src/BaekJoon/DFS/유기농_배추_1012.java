package BaekJoon.DFS;
//public class 유기농_배추_1012 {
//    // 상,하,좌,우
//    static int[] dx = {0, 0, -1, 1};
//
//    static int[] dy = {-1, 1, 0, 0};
//    static int count = 0;
//    static boolean[][] visited;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int testCase = sc.nextInt();
//        for (int i = 0; i < testCase; i++) {
//            int width = sc.nextInt();
//            int height = sc.nextInt();
//            visited = new boolean[width][height];
//            int tc = sc.nextInt();
//            for (int j = 0; j < tc; j++) {
//                int a = sc.nextInt();
//                int b = sc.nextInt();
//                visited[a][b] = true;
//            }
//            for (int z = 0; z < width; z++) {
//                for (int k = 0; k < height; k++) {
//                    if (visited[z][k] == true) {
//                        dfs(z, k, width, height);
//                        count++;
//                    }
//                }
//            }
//        System.out.println(count);
//        count = 0;
//        }
//    }
//
//
//    static void dfs(int a, int b, int width, int height) {
//        visited[a][b] = false;
//        for (int i = 0; i < 4; i++) {
//            if (a + dx[i] >= 0 && b + dy[i] >= 0 && a + dx[i] < width && b + dy[i] < height
//                    && visited[a + dx[i]][b + dy[i]] == true) {
//                dfs(a + dx[i], b + dy[i], width, height);
//            }
//        }
//    }
//}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 유기농_배추_1012 {
    static int count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Stack<Integer> stack = new Stack<Integer>();
    static Queue<int[]> queue = new LinkedList<int[]>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int x = sc.nextInt(); // 10
            int y = sc.nextInt(); // 8
            int lungCount = sc.nextInt();
            int[][] visited = new int[y][x];
            for (int j = 0; j < lungCount; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                visited[b][a] = 1;
            }
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if ( visited[j][k] == 1 ) {
//                        dfs(k, j, visited);
                        bfs(k, j, visited);
                        count++;
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
    public static void dfs(int x, int y, int[][] visited){
        visited[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            if(y + dy[i] >= 0 && x + dx[i] >= 0 &&
                y + dy[i] < visited.length && x + dx[i] < visited[0].length &&
                    visited[y + dy[i]][x + dx[i]] == 1){
                dfs(x + dx[i], y + dy[i], visited);
            }
        }
    }
    // 스택으로 구현해보기
    public static void dfsStack(int x, int y, int[][] visited){

    }
    // dfs 문제 bfs로 구현해보기
    public static void bfs(int x, int y, int[][] visited){
        queue.add(new int[]{y, x});
        visited[y][x] = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if( now[1] + dx[i] >= 0 && now[0] + dy[i] >= 0 &&
                        now[0] + dy[i] < visited.length && now[1] + dx[i] < visited[0].length &&
                        visited[ now[0] + dy[i] ][ now[1] + dx[i] ] == 1 ){
                    queue.add(new int[]{now[0] + dy[i], now[1] + dx[i]});
                    visited[now[0] + dy[i]][now[1] + dx[i]] = 0;
                }
            }
        }
    }
}
