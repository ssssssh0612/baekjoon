package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드_합체_놀이_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        long[] arr = new long[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < count; i ++){
            Arrays.sort(arr);
            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
        }
        long sum = 0;
        for(int i = 0; i < length; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
