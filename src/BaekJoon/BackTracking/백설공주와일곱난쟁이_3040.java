package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백설공주와일곱난쟁이_3040 {
    static int[] arr;
    static int[] result = new int[7];
    static boolean[] visited = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        backTracking(0,0);
    }
    public static void backTracking(int depth , int index ){
        if( depth == 7 ){
            int sum = 0;
            for (int i = 0; i < result.length; i++) {
                sum += result[i];
            }
            if(sum == 100){
                for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if(!visited[i] && i >= index){
                result[depth] = arr[i];
                visited[i] = true;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
