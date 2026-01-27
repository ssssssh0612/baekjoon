package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알바생강호_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long sum = 0;
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i] - index;
            if(num > 0){
                sum += num;
            }else{
                break;
            }
            index++;
        }
        System.out.println(sum);
    }
}
