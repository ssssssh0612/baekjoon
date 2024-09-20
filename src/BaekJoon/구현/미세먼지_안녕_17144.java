package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 미세먼지_안녕_17144 {
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 동, 남, 서, 북
    static int[] dxBack = {1, 0, -1, 0};
    static int[] dyBack = {0, 1, 0, -1};

    // 동, 북, 서, 남
    static int[] dxFront = {1, 0, -1, 0};
    static int[] dyFront = {0, -1, 0, 1};

    static int[][] graph;
    static int[][] copyGraph;

    static boolean[][] visited;

    static boolean startFront = false;
    static int[] startFrontPos;
    static int[] startBackPos;
    static boolean startBack = false;
    static int result = 0;

    static List<int[]> list = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int time = sc.nextInt();
        startBackPos = new int[2];
        startFrontPos = new int[2];
        graph = new int[y][x];
        visited = new boolean[y][x];
        copyGraph = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
                copyGraph[i][j] = graph[i][j];
                if (!startFront && graph[i][j] == -1) {
                    startFront = true;
                    startFrontPos = new int[]{i, j + 1};
                } else if (startFront && graph[i][j] == -1) {
                    startBack = true;
                    startBackPos = new int[]{i, j + 1};
                }
            }
        }

        for (int k = 0; k < time; k++) {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (copyGraph[i][j] > 0 && !visited[i][j]) {
                        munjiSex(i, j);
                    }
                }
            }
            munjiSex2();
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    copyGraph[i][j] = graph[i][j];
                }
            }
            rotateMunjiFront();
            rotateMunjiBack();
            if (k != time - 1) {
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        copyGraph[i][j] = graph[i][j];
                        visited[i][j] = false;
                    }
                }
            }
            list.clear();
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] > 0) {
                    result = graph[i][j] + result;
                }
            }
        }
        System.out.println(result);
    }

    public static void munjiSex(int y, int x) {
        visited[y][x] = true;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nowY = y + dy[i];
            int nowX = x + dx[i];
            if (nowY >= 0 && nowY < graph.length &&
                    nowX >= 0 && nowX < graph[0].length
                    && copyGraph[nowY][nowX] != -1) {
                list.add(new int[]{nowY, nowX, copyGraph[y][x] / 5});
                count++;
            }
        }
        graph[y][x] = copyGraph[y][x] - (copyGraph[y][x] / 5 * count);
    }

    public static void munjiSex2() {
        for (int i = 0; i < list.size(); i++) {
            graph[list.get(i)[0]][list.get(i)[1]] = graph[list.get(i)[0]][list.get(i)[1]] + list.get(i)[2];
        }
    }


    public static void rotateMunjiFront() {
        boolean flag = true;
        int dir = 0;
        while (flag) {
            int nowY = startFrontPos[0] + dyFront[dir];
            int nowX = startFrontPos[1] + dxFront[dir];

            if (nowX >= 0 && nowY >= 0 && nowX < graph[0].length && nowY < graph.length) {
                if (graph[nowY][nowX] == -1) {
                    startFrontPos[0] = startFrontPos[0] + dyFront[dir];
                    startFrontPos[1] = startFrontPos[1] + dxFront[dir];
                    flag = false;
                } else {
                    graph[nowY][nowX] = copyGraph[startFrontPos[0]][startFrontPos[1]];
                    startFrontPos[0] = startFrontPos[0] + dyFront[dir];
                    startFrontPos[1] = startFrontPos[1] + dxFront[dir];
                }
            } else {
                nowY = startFrontPos[0] - dyFront[dir];
                nowX = startFrontPos[1] - dxFront[dir];
                dir++;
                nowY = startFrontPos[0] + dyFront[dir];
                nowX = startFrontPos[1] + dxFront[dir];
                graph[nowY][nowX] = copyGraph[startFrontPos[0]][startFrontPos[1]];
                startFrontPos[0] = startFrontPos[0] + dyFront[dir];
                startFrontPos[1] = startFrontPos[1] + dxFront[dir];
            }
        }
        graph[startFrontPos[0]][startFrontPos[1] + 1] = 0;
    }

    public static void rotateMunjiBack() {
        boolean flag = true;
        int dir = 0;
        while (flag) {
            int nowY = startBackPos[0] + dyBack[dir];
            int nowX = startBackPos[1] + dxBack[dir];
            if (nowX >= 0 && nowY >= 0 && nowX < graph[0].length && nowY < graph.length) {
                if (graph[nowY][nowX] == -1) {
                    startBackPos[0] = startBackPos[0] + dyBack[dir];
                    startBackPos[1] = startBackPos[1] + dxBack[dir];
                    flag = false;
                } else {
                    graph[nowY][nowX] = copyGraph[startBackPos[0]][startBackPos[1]];
                    startBackPos[0] = startBackPos[0] + dyBack[dir];
                    startBackPos[1] = startBackPos[1] + dxBack[dir];
                }
            } else {
                nowY = startBackPos[0] - dyBack[dir];
                nowX = startBackPos[1] - dxBack[dir];
                dir++;
                nowY = startBackPos[0] + dyBack[dir];
                nowX = startBackPos[1] + dxBack[dir];
                graph[nowY][nowX] = copyGraph[startBackPos[0]][startBackPos[1]];
                startBackPos[0] = startBackPos[0] + dyBack[dir];
                startBackPos[1] = startBackPos[1] + dxBack[dir];
            }
        }
        graph[startBackPos[0]][startBackPos[1] + 1] = 0;
    }
}

