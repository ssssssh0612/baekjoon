package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 부분수열의_합_1182 {
    static int result;
    static int length;
    static int[] list;
    static int resultCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for (int i = 1; i <= length; i++) {
            boolean[] visited = new boolean[length];
            int[] arr = new int[i];
            backTracking(0, i, arr, visited, -1);
        }
        System.out.println(resultCount);
    }

    public static void backTracking(int depth, int lastDepth, int[] arr, boolean[] visited, int number) {
        if (depth == lastDepth) {
            int resultCheck = 0;
            for (int i = 0; i < arr.length; i++) {
                resultCheck += arr[i];
            }
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
            if (resultCheck == result) {
                resultCount++;
            }
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (!visited[i] && i > number) {
                arr[depth] = list[i];
                visited[depth] = true;
                backTracking(depth + 1, lastDepth, arr, visited, i);
                visited[depth] = false;
            }
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        result = Integer.parseInt(st.nextToken());
        list = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }
}