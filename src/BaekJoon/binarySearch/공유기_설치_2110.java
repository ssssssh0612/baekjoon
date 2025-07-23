package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(arr);


        if(m == 2){
            System.out.println(arr[n - 1] - arr[0]);
            return;
        }

        if (n == m) {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                result = Math.min(result, arr[i] - arr[i - 1]);
            }
            System.out.println(result);
            return;
        }

        int left = 1;
        int right = arr[arr.length - 1] - arr[0];

        // upper bound - 1 로 공유기 설치 가능한 갯수 m대
        while (left < right) {
            int mid = (left + right) / 2;
//            System.out.println(left + " " + mid + " " + right);
            if (num(mid, arr, m)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left - 1 이 우리가 찾고자 하는 값
        int dis = left - 1;
        //        System.out.println("dis = " +  dis);
        int beforeNum = arr[0];
        int result = Integer.MAX_VALUE;


        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            }
            int num = arr[i];
            if (num - beforeNum >= dis) {
//                System.out.println(num + " " + beforeNum);
                result = Math.min(result, num - beforeNum);
                beforeNum = num;
            }
        }
        System.out.println(result);

    }

    public static boolean num(int mid, int[] arr, int m) {
        int count = 0;
        // 0번째는 무조건 카운트
        int beforeNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                count++;
                continue;
            }

            int num = arr[i];
            if (num - beforeNum >= mid) {
                beforeNum = num;
                count++;
            }
        }

        return m <= count;
    }
}

