package BaekJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합구하기_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] sum = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0){
                sum[i] = arr[i];
            }
            if(i > 0){
                sum[i] = sum[i-1] + arr[i];
            }
        }
        int length = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            int index1 = Integer.parseInt(st.nextToken()) - 2;
            int index2 = Integer.parseInt(st.nextToken()) - 1;
            if(index1 == -1){
                sb.append(sum[index2]).append("\n");
                continue;
            }
            sb.append(sum[index2] - sum[index1]).append("\n");
        }
        System.out.println(sb);
    }
}
