package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 마법사_상어와_파이어스톰_20058 {
    static int[][] graph;
    static int[] arr;
    static int[][] newGraph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int ice = 0;
    static int iceCount = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        step();
        countIce();
        countIce2();
        System.out.println(ice);
        System.out.println(iceCount);
    }

    public static void countIce2() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int newIceCount = 1;
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (checking(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] > 0) {
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    newIceCount++;
                }
            }
        }
        iceCount = Math.max(iceCount, newIceCount);
    }

    public static void countIce() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0) {
                    ice += graph[i][j];
                }
            }
        }
    }

    public static void step() {
        for (int i = 0; i < arr.length; i++) {
            int number = number(arr[i]);
            if (number != 1) {
                rotate(number);
            }
            meltIce();
        }
        newGraph = copyGraph();
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }

    // 얼음 녹이기
    public static void meltIce() {
        newGraph = copyGraph();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                int count = 0;
                if (newGraph[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if (checking(nextY, nextX) && newGraph[nextY][nextX] > 0) {
                            // 이 둘에 대해서 범위안에 들어가는지, 그리고 0보다 큰지
                            count++;
                        }
                    }
                }
                if (count < 3) {
                    graph[i][j]--;
                }
            }
        }
    }

    // 한변의 회전
    public static void rotate(int number) {
        // number 가 돌려야할 한변의 길이
        // 면적
        newGraph = copyGraph();
        int shape = number * number;
        for (int i = 0; i < graph.length; i += number) {
            for (int j = 0; j < graph.length; j += number) {
                    rotate(i, j, number);
            }
        }
    }

    public static void rotate(int startY, int startX, int number) {
        int lengthY = startY + number;
        int lengthX = startX + number;

        int index = startX + number - 1;
        for (int i = startY; i < lengthY; i++) {
            int yIndex = startY;
            for (int j = startX; j < lengthX; j++) {
                int value = newGraph[i][j];
                graph[yIndex][index] = value;
                yIndex++;
            }
            index--;
        }
    }

    public static void checkingGraph(int[][] checkGraph) {
        for (int i = 0; i < checkGraph.length; i++) {
            for (int j = 0; j < checkGraph.length; j++) {
                System.out.print(checkGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] copyGraph() {
        int[][] newGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = number(Integer.parseInt(st.nextToken()));
        int rotateCount = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr = new int[rotateCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rotateCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[graph.length][graph.length];
    }

    public static int number(int n) {
        if (n == 0) {
            return 1;
        }
        return 2 * number(n - 1);
    }
}