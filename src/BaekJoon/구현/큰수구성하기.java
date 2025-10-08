package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰수구성하기 {
    static String num;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = st.nextToken();
        int length = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            dfs(arr, new StringBuilder().append(arr[i]));
        }
        System.out.println(result);
    }

    public static void dfs(int[] arr, StringBuilder sb) {

        if (Integer.parseInt(sb.toString()) <= Integer.parseInt(num)) {

            result = Math.max(result, Integer.parseInt(sb.toString()));
        }
        if (sb.length() == num.length()) {
            if (Integer.parseInt(sb.toString()) <= Integer.parseInt(num)) {
                result = Math.max(result, Integer.parseInt(sb.toString()));
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            dfs(arr, new StringBuilder().append(sb).append(arr[i]));
        }
    }



}

