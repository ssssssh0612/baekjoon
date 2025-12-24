package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_14225 {
    static int count;
    static int[] arr;
    static int[] nums;
    static boolean[] visited;
    static boolean[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        result = new boolean[2_000_001];

        // n에 따른 combination 계산

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n];
            arr = new int[i];
            combination(i,0,-1);
        }
        for (int i = 1; i < result.length; i++) {
            if(!result[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(count);

    }
    public static void combination(int maxDepth, int depth, int index){
        if(depth == maxDepth){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += nums[arr[i]];
            }

            result[sum] = true;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited[i] && i > index){
                visited[i] = true;
                arr[depth] = i;
                combination(maxDepth, depth + 1, i);
                visited[i] = false;
            }
        }
        
    }
}

