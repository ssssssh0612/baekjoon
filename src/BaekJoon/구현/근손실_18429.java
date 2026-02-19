package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실_18429 {
    static int[] arr;
    static int[] kit;
    static int n;
    static int m;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        kit = new int[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        System.out.println(result);
    }
    public static void backTracking(int depth){
        if(depth == n){
            int weight = 500;
            boolean flag = true;
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i];
                weight += kit[index];
                weight -= m;
                if(weight < 500){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result++;
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
