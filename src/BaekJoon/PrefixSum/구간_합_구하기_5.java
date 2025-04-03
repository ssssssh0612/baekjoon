package BaekJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_5 {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += graph[i][j];
                graph[i][j] = sum;
            }
        }
        // 구간 합 구하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            sb.append(check(startY,startX,endY,endX)).append("\n");
        }
        System.out.println(sb);
    }

    public static int check(int startY, int startX, int endY, int endX) {
        if (startX == 0) {
            int sum = 0;
            for (int i = startY; i <= endY; i++) {
                sum += graph[i][endX];
            }
            return sum;
        } else {
            int sum = 0;
            for (int i = startY; i <= endY; i++) {
                sum += graph[i][endX];
                sum -= graph[i][startX - 1];
            }
            return sum;
        }
    }
}
