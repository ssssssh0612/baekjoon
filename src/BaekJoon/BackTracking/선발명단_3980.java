package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 선발명단_3980 {
    static List<int[]> list;
    static int[] arr;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            check(br);
        }
    }
    
    public static void check(BufferedReader br) throws IOException {
        list = new ArrayList<>();
        arr = new int[11];
        visited = new boolean[11];
        result = 0;
        for (int i = 0; i < 11; i++) {
            int[] addArr = new int[11];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 11; j++) {
                addArr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(addArr);
        }
        backTracking(0);
        System.out.println(result);
    }
    public static void backTracking(int depth){
        // 0번 자리에 0 - 10 모두 올 수 있음
        if(depth == 11){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += list.get(arr[i])[i];
            }
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if(!visited[i] && list.get(i)[depth] > 0){
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
