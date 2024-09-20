package BaekJoon.구현;

import java.util.Scanner;

public class 행렬_덧셈_2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int[][] graph = new int[y][x];
        int[][] graph1 = new int[y][x];
        int[][] result = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                result[i][j] = graph1[i][j] + graph[i][j];
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
