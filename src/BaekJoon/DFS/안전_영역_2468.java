package BaekJoon.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class 안전_영역_2468 {
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//    static boolean[][] visited;
//    static int[][] miro;
//    static int count = 0;
//    static int length;
//    static int MAX = 0;
//    static int MAXCOUNT = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        length = sc.nextInt();
//        visited = new boolean[length][length];
//        miro = new int[length][length];
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                int x = sc.nextInt();
//                miro[i][j] = x;
//                if (x > MAX) {
//                    MAX = x;
//                }
//            }
//        }
//        for (int k = 2; k <= MAX; k++) {
//            for (int i = 0; i < length; i++) {
//                for (int j = 0; j < length; j++) {
//                    // 수위 조절
//                    if (miro[i][j] > MAX) {
//                        visited[i][j] = true;
//                    }
//                    if (visited[i][j]) {
//                        dfs(i, j);
//                        count++;
//                    }
//                }
//                MAXCOUNT = Math.max(MAXCOUNT, count);
//                count = 0;
//                for (int j = 0; j < length; j++) {
//                    visited[i][j] = false;
//                }
//            }
//        }
//        System.out.println(MAXCOUNT);
//    }
//
//    public static void dfs(int i, int j) {
//        visited[i][j] = false;
//        for (int k = 0; k < 4; k++) {
//            if (i + dx[k] >= 0 && j + dy[k] >= 0 && i + dx[k] < length && j + dy[k] < length) {
//                if (visited[i + dx[k]][j + dy[k]]) {
//                    dfs(i + dx[k], j + dy[k]);
//                }
//            }
//        }
//    }
//}
public class 안전_영역_2468 {
    static int count;
    static int max = 0;
    static int[][] graph;
    static int maxCount = 1; // 최대 높이
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new int[n+2][n+2];
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                graph[i][j] = -1;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = sc.nextInt();
                maxCount = Math.max(maxCount,graph[i][j]);
            }
        }

        for (int i = 1; i < maxCount + 1; i++) {
            boolean[][] visited = new boolean[n+2][n+2];
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if( count == 0 && graph[j][k] >= i ) {
//                        dfs(j,k,visited,i);
                        bfs(j,k,visited,i);
                        count++;
                    }else if( count > 0 && graph[j][k] >= i && !visited[j][k] ) {
//                        dfs(j,k,visited,i);
                        bfs(j,k,visited,i);
                        count++;
                    }
                }
            }
            max = Math.max(max,count);
            count = 0;
        }
        System.out.println(max);
    }
    public static void dfs(int y, int x, boolean[][] visited, int safeCount) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if( graph[y + dy[i]][x + dx[i]] >= safeCount && !visited[y + dy[i]][x + dx[i]] ){
                dfs(y + dy[i], x + dx[i], visited, safeCount);
            }
        }
    }
    public static void bfs(int y, int x, boolean[][] visited, int safeCount){
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if(!visited[now[0] + dy[i]][now[1] + dx[i]] && graph[now[0] + dy[i]][now[1] + dx[i]] >= safeCount){
                    queue.add(new int[]{now[0] + dy[i],now[1] + dx[i]});
                    visited[now[0] + dy[i]][now[1] + dx[i]] = true;
                }
            }
        }
    }
}