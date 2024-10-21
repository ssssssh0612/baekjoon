package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쉽게푸는문제_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[ m * (m + 1) / 2 ];
        int index = 1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count == index) {
                index++;
                count = 0;
                count++;
                arr[i] = index;
            }else{
                arr[i] = index;
                count++;
            }
        }
        int result = 0;
        for (int i = n - 1; i <= m - 1; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
