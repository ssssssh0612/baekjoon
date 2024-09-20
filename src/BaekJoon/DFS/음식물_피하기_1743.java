package BaekJoon.DFS;

import java.util.Scanner;

public class 음식물_피하기_1743 {
        static int y;
        static int x;
        static boolean[][] visited;
        static int[][] graph;
        // 상, 하, 좌, 우
        static int[] dx ={0,0,-1,1};
        static int[] dy ={-1,1,0,0};
        static int result =0;
        static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        int trashCase = sc.nextInt();
        visited = new boolean[y + 2][x + 2];
        graph = new int[y + 2][x + 2];
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                graph[i][j] = -1;
            }
        }
        for (int i = 0; i < trashCase; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            graph[y][x] = 1;
            visited[y][x] = true;
        }


        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if(graph[i][j]==1){
                    dfs(i,j);
                    result = Math.max(count, result);
                    count = 0;
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs(int y, int x){
        count++;
        visited[y][x] = false;
        graph[y][x] = -1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(visited[ny][nx] && graph[ny][nx] == 1 ){
                dfs(ny,nx);
            }
        }
    }
}
