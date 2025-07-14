package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좋다_1253 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long count = 0;

        // 첫 번째 수 i, 두 번째 수 j 고정
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int target = -(arr[i] + arr[j]);

                // target이 arr[j+1] ~ arr[N-1] 사이에 몇 개 있는지 찾기
                int lower = lowerBound(j + 1, N, target);
                int upper = upperBound(j + 1, N, target);
                count += (upper - lower);
            }
        }

        System.out.println(count);
    }

    // target 이상인 첫 인덱스
    private static int lowerBound(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // target 초과인 첫 인덱스
    private static int upperBound(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
