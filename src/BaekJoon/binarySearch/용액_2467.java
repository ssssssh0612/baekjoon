package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액_2467 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;

        for (int i = 0; i < n - 1; i++) {
            int fixed = arr[i];
            int target = -fixed;

            int idx = binarySearch(i + 1, n - 1, target);

            // 이분 탐색 결과 근처 두 개 값 확인
            for (int j = idx - 1; j <= idx; j++) {
                if (j <= i || j >= n) continue;
                int sum = fixed + arr[j];
                if (Math.abs(sum) < minDiff) {
                    minDiff = Math.abs(sum);
                    answer1 = fixed;
                    answer2 = arr[j];
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    // target과 가장 가까운 값의 인덱스를 리턴
    public static int binarySearch(int left, int right, int target) {
        int res = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
