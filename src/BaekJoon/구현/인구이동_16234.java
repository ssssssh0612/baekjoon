package BaekJoon.구현;

import java.util.*;

public class 인구이동_16234 {
    static int n;
    static int l;
    static int r;
    static int[][] graph;
    static int flagCount = 0;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // L 이상 R 사이의 값이어야 인구이동 가능
        l = sc.nextInt();
        r = sc.nextInt();
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean flag = true;

        int resultCount = 0;
        while (flag) {
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j, visited);
                    }
                }
            }
            if (flagCount == 0) {
                flag = false;
            } else {
                flagCount = 0;
            }
            resultCount++;
        }
        System.out.println(resultCount - 1);
    }

    public static void bfs(int y, int x, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> groupChange = new ArrayList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        int count = 1;
        int result = graph[y][x];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if (nowY >= 0 && nowX >= 0 && nowY < n && nowX < n
                        && checking(graph[now[0]][now[1]], graph[nowY][nowX]) && !visited[nowY][nowX]) {
                    queue.add(new int[]{nowY, nowX});
                    visited[nowY][nowX] = true;
                    result += graph[nowY][nowX];
                    groupChange.add(new int[]{nowY, nowX});
                    count++;
                    flagCount++;
                }
            }
        }
        int number = result / count;
        graph[y][x] = number;
        for (int[] pos : groupChange) {
            graph[pos[0]][pos[1]] = number;
        }

//        graphChecking();
    }

    public static boolean checking(int a, int b) {
//        System.out.println("a-b 값 = "+Math.abs(a-b));
        return Math.abs(a - b) >= l && Math.abs(a - b) <= r;
    }

    public static void graphChecking() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void visitedChecking(boolean[][] visited){
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
