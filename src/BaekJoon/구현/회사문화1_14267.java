package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 회사문화1_14267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            arr[a] += b;
        }
        int addNum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                sb.append(0).append(" ");
                continue;
            }
            if(arr[i] > 0){
                addNum += arr[i];
            }
            sb.append(addNum).append(" ");
        }
        System.out.println(sb);
    }
}
