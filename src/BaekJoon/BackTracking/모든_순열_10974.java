package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든_순열_10974 {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        arr = new int[a];
        visited = new boolean[a];
        backTracking(0);
    }
    public static void backTracking(int depth){
        if(depth == arr.length){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
