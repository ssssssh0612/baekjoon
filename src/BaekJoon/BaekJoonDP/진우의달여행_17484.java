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

        for(int i = 0; i < y; i++){
            for(int j = 0 ; j < x; j++){

            }
        }
    }
    public static boolean checking(int y, int x, int[][] graph) {
        return x >= 0 && y >= 0 && y < graph.length && x < graph[0].length;
    }
}
