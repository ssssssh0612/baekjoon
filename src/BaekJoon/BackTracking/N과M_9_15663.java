package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_9_15663 {
    static int depth;
    static int[] Arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arr = new int[depth];
        boolean[] visited = new boolean[length];
        backTracking(0,arr, visited,0);
        System.out.println(sb);
    }
    public static void backTracking(int nowDepth, int[] arr, boolean[] visited, int number) {
        if(depth == nowDepth){
            for (int i = 0; i < Arr.length; i++) {
                sb.append(Arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int beforeNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != beforeNum && number <= arr[i]) {
                beforeNum = arr[i];
                Arr[nowDepth] = arr[i];
                visited[i] = true;
                backTracking(nowDepth + 1, arr, visited, arr[i]);
                visited[i] = false;
            }
        }
    }
}
