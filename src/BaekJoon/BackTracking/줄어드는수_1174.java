package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄어드는수_1174 {
    static int[] arr;
    static boolean[] visited = new boolean[10];
    static int index = 1;
    static long[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new long[1_000_001];
        for (int i = 1; i <= 10; i++) {
            arr = new int[i];
            backTracking(i,0,10);
        }
        if(n == 1){
            System.out.println(0);
            return;
        }
        if(result[n] == 0){
            System.out.println(-1);
        }else{
            System.out.println(result[n]);
        }
    }
    public static void backTracking(int maxDepth, int depth, int beforeNumber){
        if(maxDepth == depth){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
//            System.out.println(sb);
            result[index] = Long.parseLong(sb.toString());
            index++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(!visited[i] && beforeNumber > i){
                arr[depth]= i;
                visited[i] = true;
                backTracking(maxDepth, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
