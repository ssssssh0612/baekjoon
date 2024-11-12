package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NM과K_1_18290 {
    static int[][] graph;
    static int m;
    static boolean[][] visited;
    static int[] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int MAX = Integer.MIN_VALUE;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x];
        arr = new int[m * 2];
        for (int i = 0; i < graph.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0, 0, 0);
        System.out.println(MAX);
    }

    public static void backTracking(int depth, int y, int x) {
        if(depth == m * 2){
            return;
        }
//        for(int i = 0; i < list.)
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}


