package BaekJoon.DFS;

import java.util.Scanner;

public class 전쟁_전투_1303 {
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int whiteMax = 0;
    static int blackMax = 0;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 가로
        int x = sc.nextInt();
        // 세로
        int y = sc.nextInt();
        graph = new int[y+2][x+2];
        visited = new boolean[y+2][x+2];
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                graph[i][j] = -1;
            }
        }
        sc.nextLine();
        for (int i = 1; i < y + 1; i++) {
            String line = sc.nextLine();
            for (int j = 1; j < x + 1; j++) {
                if(line.charAt(j - 1) == 'W') {
                    // 우리팀 W
                    graph[i][j] = 0;
                }else{
                    // 적팀 B
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if(graph[i][j] == 0 && !visited[i][j]) {
                    dfs(i,j,0);
                    whiteMax = whiteMax + (count*count);
                    count = 0;
                }else if(graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j,1);
                    blackMax = blackMax + (count*count);
                    count = 0;
                }
            }
        }
        System.out.println(whiteMax+" "+blackMax);
    }
    public static void dfs(int y, int x, int number) {
        count++;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if(graph[y + dy[i]][x + dx[i]] == number && !visited[y + dy[i]][x + dx[i]]){
                dfs(y + dy[i], x + dx[i], number);
            }
        }
    }
}
