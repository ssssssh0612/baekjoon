package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물섬_2589 {
    // L 육지
    // W 바다
    // 육지로만 이동 가능
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int x;
    static int y;
    static int staticResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        int[][] graph = new int[y + 2][x + 2];
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                graph[i][j] = -1;
            }
        }
        for (int i = 1; i < y + 1; i++) {
            String a = sc.next();
            for (int j = 1; j < x + 1; j++) {
                if (a.charAt(j - 1) == 'L') {
                    graph[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if (graph[i][j] == 0) {
                    bfs(x, y, j, i, graph);
                }
            }
        }
        System.out.println(staticResult);
    }

    public static void bfs(int x1, int y1, int x, int y, int[][] graph) {
        // 초기화 하는
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[y1 + 2][x1 + 2];
        int[][] newGraph = new int[y1 + 2][x1 + 2];
        for (int i = 0; i < y1 + 2; i++) {
            for (int j = 0; j < x1 + 2; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < y1 + 2; i++) {
            for (int j = 0; j < x1 + 2; j++) {
                if (newGraph[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        queue.add(new int[]{x, y, 0});
        visited[y][x] = false;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (newGraph[now[1] + dy[i]][now[0] + dx[i]] == 0 &&
                        visited[now[1] + dy[i]][now[0] + dx[i]]) {
                    queue.add(new int[]{now[0] + dx[i], now[1] + dy[i], now[2] + 1});
                    visited[now[1] + dy[i]][now[0] + dx[i]] = false;
                    newGraph[now[1] + dy[i]][now[0] + dx[i]] = now[2] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 1; i < y1 + 1; i++) {
            for (int j = 1; j < x1 + 1; j++) {
                result = Math.max(newGraph[i][j], result);
            }
        }
        staticResult = Math.max(result, staticResult);
    }
}

