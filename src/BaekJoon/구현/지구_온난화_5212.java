package BaekJoon.구현;

import java.util.Scanner;

public class 지구_온난화_5212 {
    static int[][] graph;
    static int[][] copyGraph;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int minX = 0;
    static int minY = 0;
    static int maxX = 0;
    static int maxY = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        graph = new int[y + 2][x + 2];
        copyGraph = new int[y + 2][x + 2];
        // 바다 = 0
        // 섬 = 1
        sc.nextLine();
        for (int i = 1; i < y + 1; i++) {
            String a = sc.nextLine();
            for (int j = 1; j < a.length() + 1; j++) {
                if (a.charAt(j - 1) == 'X') {
                    graph[i][j] = 1;
                    copyGraph[i][j] = 1;
                } else {
                    graph[i][j] = 0;
                    copyGraph[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if (graph[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        if (graph[i + dy[k]][j + dx[k]] == 0) {
                            count++;
                        }
                    }
                    if (count >= 3) {
                        copyGraph[i][j] = 0;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                if (copyGraph[i][j] == 1 && count == 0) {
                    minY = i;
                    minX = j;
                    maxY = i;
                    maxX = j;
                    count++;
                } else if (copyGraph[i][j] == 1) {
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                if (copyGraph[i][j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}

