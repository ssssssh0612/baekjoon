package BaekJoon.BFS;

import java.util.*;

public class 벽부수고이동하기_2206 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int y;
    static int x;
    static int[][] graph;
    static int result = 0;
    static int resultCount = 0;
    static List<int[]> wall = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        graph = new int[y][x];
        sc.nextLine();
        for (int i = 0; i < y; i++) {
            String a = sc.nextLine();
            for (int j = 0; j < x; j++) {
                graph[i][j] = a.charAt(j) - '0';
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nowY = dy[k] + i;
                        int nowX = dx[k] + j;
                        if (checking(nowY, nowX) && graph[nowY][nowX] == 0) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        wall.add(new int[]{i, j});
                    }
                }
            }
        }

        for (int i = 0; i < wall.size(); i++) {
            int[] arr = wall.get(i);
            graph[arr[0]][arr[1]] = 0;
            bfs();
            graph[arr[0]][arr[1]] = 1;
        }

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    public static boolean checking(int nowY, int nowX) {
        return nowY >= 0 && nowY < y && nowX >= 0 && nowX < x;
    }

    public static void bfs() {
        int[][] copyGraph = new int[y][x];
        copyGraph[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if (checking(nowY, nowX) && graph[nowY][nowX] == 0 && !visited[nowY][nowX]) {
                    queue.add(new int[]{nowY, nowX});
                    visited[nowY][nowX] = true;
                    copyGraph[nowY][nowX] = copyGraph[now[0]][now[1]] + 1;
                }
            }
        }

        if (resultCount == 0 && copyGraph[y - 1][x - 1] > 0) {
            result = copyGraph[y - 1][x - 1];
            resultCount++;
        } else if (resultCount != 0 && copyGraph[y - 1][x - 1] > 0) {
            result = Math.min(result, copyGraph[y - 1][x - 1]);
        }
    }

}
