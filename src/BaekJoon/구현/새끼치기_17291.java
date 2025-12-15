package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 새끼치기_17291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[21];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        arr[4] = 7;

        for (int i = 5; i <= 20; i++) {
            arr[i] = arr[i-1]*2;
            if(i%2 == 0){
                arr[i] -= (arr[i-4] + arr[i-5]);
            }
        }
        System.out.println(arr[n]);
    }
}
