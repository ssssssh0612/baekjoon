package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를_최대로_10819 {
    static int[] result;
    static boolean[] visited;
    static int[] arr;
    static int resultNum = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        result = new int[length];
        visited = new boolean[length];
        arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);
        System.out.println(resultNum);
    }
    public static void backTracking(int depth){
        if(depth == result.length){
            int addNum = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                addNum += Math.abs(result[arr[i]] - result[arr[i + 1]]);
            }
            resultNum = Math.max(addNum, resultNum);
            return;
        }

        for (int i = 0; i < result.length; i++) {
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
