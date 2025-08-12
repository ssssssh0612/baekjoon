package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Four_Squares_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr,100_000_000);
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            // 범위 벗어나면 종료
            int num = 1;
            while(true){
                // 1부터 범위가 종료될때까지 최신화
                int range = i + (num * num);
                if(range < arr.length){
                    arr[range] = Math.min(arr[i] + 1, arr[range]);
                    num++;
                }else{
                    break;
                }
            }
        }
        System.out.println(arr[n]);
    }
}
