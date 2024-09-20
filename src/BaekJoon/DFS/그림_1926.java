package BaekJoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그림_1926 {
    static int[][] graph;
    static int[] dx  = {0,0,-1,1};
    static int[] dy  = {-1,1,0,0};
    static boolean[][] visited;
    static int caseCount;
    static int maxCount = 0;
    static int realMaxCount = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        graph = new int[y + 2][x + 2];
        visited = new boolean[y + 2][x + 2];
        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if(graph[i][j] == 1 && caseCount == 0){
                    dfs(i, j);
                    realMaxCount = Math.max(maxCount, realMaxCount);
                    caseCount++;
                    maxCount = 0;
                } else if(graph[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    list.add(maxCount);
                    realMaxCount = Math.max(maxCount, realMaxCount);
                    caseCount++;
                    maxCount = 0;
                }
            }
        }
        System.out.println(caseCount);
        System.out.println(realMaxCount);
    }
    public static void dfs(int y, int x) {
        maxCount++;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if(graph[y + dy[i]][x + dx[i]] == 1 && !visited[y + dy[i]][x + dx[i]]){
                dfs(y + dy[i], x + dx[i]);
            }
        }
    }
}
