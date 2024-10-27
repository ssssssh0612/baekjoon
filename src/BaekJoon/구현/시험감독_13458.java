package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int numberA = Integer.parseInt(st.nextToken());
        int numberB = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - numberA;
            result++;
            if(arr[i] % numberB == 0 && arr[i] > 0){
                result += arr[i] / numberB;
            }else if(arr[i] % numberB != 0 && arr[i] > 0){
                result += arr[i] / numberB;
                result++;
            }else if(arr[i] < 0){
                continue;
            }
        }
        System.out.println(result);
    }
}
