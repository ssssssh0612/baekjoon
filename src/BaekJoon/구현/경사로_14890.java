package BaekJoon.구현;

import java.util.Scanner;

public class 경사로_14890 {
    static int n;
    static int[][] graph;
    static int l;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visited1;
    static boolean[] visited2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        visited1 = new boolean[n];
        visited2 = new boolean[n];
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        checking1();
        for (int i = 0; i < visited1.length; i++) {
            System.out.println(visited1[i] ? "YES" : "NO");
        }
    }

    public static void checking1() {
    }

    public static void checking2() {

    }
}
