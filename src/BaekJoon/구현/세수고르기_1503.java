package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세수고르기_1503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[] arr = new int[1002];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 1000 ; i++) {
            for (int j = i; j <= 1000 ; j++) {
                for (int k = j; k <= 1001; k++) {
                    if(arr[i] == 1 || arr[j] == 1 || arr[k] == 1){
                        continue;
                    }
                    result = Math.min(result, Math.abs(n - i * j * k));
                }
            }
        }
        System.out.println(result);
    }
}
