package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부등호_2529 {
    static boolean[] check ;
    static boolean[] visited = new boolean[10];
    static int[] arr;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        check = new boolean[n];
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if(st.nextToken().equals("<")){
                check[i] = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            arr[0] = i;
            visited[i] = true;
            backTracking(1);
            visited[i] = false;
        }
        int count = 0;
        long max1 = max;
        long min1 = min;
        int max1Count = 0;
        int min1Count = 0;
        while(max1 != 0){
            max1 = max1 / 10;
            max1Count++;
        }
        while(min1 != 0){
            min1 = min1 / 10;
            min1Count++;
        }
        for (int i = 0; i < n + 1 - max1Count; i++) {
            System.out.print("0");
        }
        System.out.println(max);
        for (int i = 0; i < n + 1 - min1Count; i++) {
            System.out.print("0");
        }
        System.out.println(min);

    }
    public static void backTracking(int depth){
        if(depth == arr.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            long sum = Long.parseLong(sb.toString());
            max = Math.max(sum, max);


            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(!visited[i] && depth > 0)   {
                if((check[depth -1] && arr[depth -1] < i) ||
                        (!check[depth - 1] && arr[depth - 1] > i)){
                    visited[i] = true;
                    arr[depth] = i;
                    backTracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
