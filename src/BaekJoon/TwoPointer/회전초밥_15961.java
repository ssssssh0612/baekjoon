package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int numberRange = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + (size - 1)];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int index = 0;
        for (int i = n; i < n + (size - 1); i++) {
            arr[i] = arr[index];
            index++;
        }
        int nowSetSize = 0;
        int[] set = new int[numberRange + 1];

        for (int i = 0; i < size; i++) {
            if (set[arr[i]] == 0) {
                nowSetSize++;
            }
            set[arr[i]]++;
        }

        int result = nowSetSize;
        if (set[coupon] == 0) {
            result = result + 1;
        }

        int start = 1;
        int end = size;
        while (end < arr.length) {
//            for (int i = 0; i < set.length; i++) {
//                if(set[i] > 0){
//                    System.out.println(i + " " + set[i]);
//                }
//            }
//            System.out.println();
            // start 제외하기
            set[arr[start - 1]]--;
            if (set[arr[start - 1]] == 0) {
                nowSetSize--;
            }

            if (set[arr[end]] == 0) {
                nowSetSize++;
            }

            set[arr[end]]++;
            end++;
            start++;

            boolean flag = true;
            if (set[coupon] == 0) {
                nowSetSize += 1;
                flag = false;
            }

            result = Math.max(result, nowSetSize);

            if(!flag){
                nowSetSize--;
            }
        }

        System.out.println(result);
    }
}
