package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행_17484 {
    static int[] dy = {1, 1, 1};
    static int[] dx = {-1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] graph = new int[y][x];

        int[][] memo = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int number = Integer.parseInt(st.nextToken());
                graph[i][j] = number;
                if (i == 0) {
                    memo[i][j] = graph[i][j];
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 3; j++) {
                dp(graph, memo, j, 0, i);
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean checking(int y, int x, int[][] graph) {
        return x >= 0 && y >= 0 && y < graph.length && x < graph[0].length;
    }

    public static void dp(int[][] graph, int[][] memo, int distance, int y, int x) {

        if (distance == 0) {
            // 1, 2 로만 이동가능
            int nextY = y + dy[1];
            int nextX = x + dx[1];
            if (checking(nextY, nextX, graph)) {
                if (memo[nextY][nextX] == 0) {
                    memo[nextY][nextX] = memo[y][x] + graph[nextY][nextX];
                } else {
                    // 둘중 더 작은거선택
                    int compare1 = memo[nextY][nextX];
                    int compare2 = memo[y][x] + graph[nextY][nextX];
                    if (compare1 > compare2) {
                        memo[nextY][nextX] = compare2;
                    }
                }
                dp(graph, memo, 1, nextY, nextX);
            }
            int nextY2 = y + dy[2];
            int nextX2 = x + dx[2];
            if (checking(nextY2, nextX2, graph)) {
                if (memo[nextY2][nextX2] == 0) {
                    memo[nextY2][nextX2] = memo[y][x] + graph[nextY2][nextX2];
                } else {
                    // 둘중 더 작은거선택
                    int compare1 = memo[nextY2][nextX2];
                    int compare2 = memo[y][x] + graph[nextY2][nextX2];
                    if (compare1 > compare2) {
                        memo[nextY2][nextX2] = compare2;
                    }
                }
                dp(graph, memo, 2, nextY2, nextX2);
            }
        } else if (distance == 1) {
            // 0, 2 로만 이동가능
            int nextY = y + dy[0];
            int nextX = x + dx[0];
            if (checking(nextY, nextX, graph)) {
                if (memo[nextY][nextX] == 0) {
                    memo[nextY][nextX] = memo[y][x] + graph[nextY][nextX];
                } else {
                    // 둘중 더 작은거선택
                    int compare1 = memo[nextY][nextX];
                    int compare2 = memo[y][x] + graph[nextY][nextX];
                    if (compare1 > compare2) {
                        memo[nextY][nextX] = compare2;
                    }
                }
                dp(graph, memo, 0, nextY, nextX);
            }
            int nextY2 = y + dy[2];
            int nextX2 = x + dx[2];
            if (checking(nextY2, nextX2, graph)) {
                if (memo[nextY2][nextX2] == 0) {
                    memo[nextY2][nextX2] = memo[y][x] + graph[nextY2][nextX2];
                } else {
                    // 둘중 더 작은거선택
                    int compare1 = memo[nextY2][nextX2];
                    int compare2 = memo[y][x] + graph[nextY2][nextX2];
                    if (compare1 > compare2) {
                        memo[nextY2][nextX2] = compare2;
                    }
                }
                dp(graph, memo, 2, nextY2, nextX2);
            }
        } else {
            // 1, 2 로만 이동가능
            int nextY = y + dy[1];
            int nextX = x + dx[1];
            if (checking(nextY, nextX, graph)) {
                if (memo[nextY][nextX] == 0) {
                    memo[nextY][nextX] = memo[y][x] + graph[nextY][nextX];
                } else {
                    // 둘중 더 작은거선택
                    int compare1 = memo[nextY][nextX];
                    int compare2 = memo[y][x] + graph[nextY][nextX];
                    if (compare1 > compare2) {
                        memo[nextY][nextX] = compare2;
                    }
                }
                dp(graph, memo, 1, nextY, nextX);
            }
            int nextY2 = y + dy[0];
            int nextX2 = x + dx[0];
            if (checking(nextY2, nextX2, graph)) {
                if (memo[nextY2][nextX2] == 0) {
                    memo[nextY2][nextX2] = memo[y][x] + graph[nextY2][nextX2];
                } else {
                    // 둘중 더 작은거선택
                    int compare1 = memo[nextY2][nextX2];
                    int compare2 = memo[y][x] + graph[nextY2][nextX2];
                    if (compare1 > compare2) {
                        memo[nextY2][nextX2] = compare2;
                    }
                }
                dp(graph, memo, 0, nextY2, nextX2);
            }
        }
    }
}
