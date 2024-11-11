package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M시리즈풀기 {
    static int length;
    static int number;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        arr = new int[length];
        visited = new boolean[number + 1];
        int[] list = new int[number];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        backTracking(0, list[0],list);
        System.out.println(sb);
    }

    public static void backTracking(int depth, int checkNum, int[] list) {
        if (depth == length) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < list.length; i++) {
//            if (!visited[i] && before != list[i] && list[i] >= checkNum) {
            if (before != list[i] && list[i] >= checkNum) {
                arr[depth] = list[i];
                visited[i] = true;
                before = list[i];
                backTracking(depth + 1, list[i],list);
                visited[i] = false;
            }
        }
    }
}
