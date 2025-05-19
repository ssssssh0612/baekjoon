package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복유치원_13164 {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[n - 1];
        for(int i = 0 ; i < n  - 1; i++){
            result[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(result);
        int resultNum = 0;
        for(int i = 0 ; i < result.length - (k - 1); i++ ){
            resultNum += result[i];
        }

        System.out.println(resultNum);
    }
}
