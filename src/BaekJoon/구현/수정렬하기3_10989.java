package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수정렬하기3_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        for(int i = 0; i < testCase; i ++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i = 0; i < testCase; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
