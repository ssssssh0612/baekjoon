package BaekJoon.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 컴백홈_1189 {
    static int[][] graph;
    static boolean[][] visited;
    static int result;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int x;
    static int y;
    static int output;
    static int[] memo = new int[2];
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        result = sc.nextInt();
        visited = new boolean[y + 2][x + 2];
        graph = new int[y + 2][x + 2];
        sc.nextLine();
        for (int i = 1; i < y + 1; i++) {
            String a = sc.nextLine();
            for (int j = 1; j < x + 1; j++) {
                if (a.charAt(j - 1) == '.') {
                    graph[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        // 시작점은 항상 왼쪽 아래
        // y + 1 , 0 부터 시작
        // 구분을 어떻게 해줄 수 있을까 ?
//        bfs(y, 1, 1);
        dfs(y,1,1);
        System.out.println(output);

        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int y1, int x1, int count) {
        visited[y1][x1] = true;
        queue.add(new int[]{y1, x1, count});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == 0 && now[1] == x && now[2] == result -1 ) {
                output++;
            }
            System.out.println(now[0] + " " + now[1] + " " + now[2]);
            for (int i = 0; i < 4; i++) {
                if (graph[now[0] + dy[i]][now[1] + dx[i]] == 1
                        && !visited[now[0] + dy[i]][now[1] + dx[i]]) {
                    queue.add(new int[]{now[0] + dy[i], now[1] + dx[i], now[2] + 1});
                    visited[now[0] + dy[i]][now[1] + dx[i]] = true;
                }
            }
        }
    }
    public static void dfs(int y1, int x1, int count) {
        visited[y1][x1] = true;
        count++;
        if (y1 == 0 && x1 == x && count == result ) {
            output++;
        }
        for (int i = 0; i < 4; i++) {
            if(graph[y1 + dy[i]][x1 + dx[i]] == 1
                    && !visited[y1 + dy[i]][x1 + dx[i]]){
                dfs(y1 + dy[i], x1 + dx[i],count+1);
                visited[y1][x1] = false;
            }
        }
    }
}
