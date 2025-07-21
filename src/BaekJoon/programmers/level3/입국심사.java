package BaekJoon.programmers.level3;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {

        Arrays.sort(times);
        long left = 1;
        long right = times[times.length - 1] * (long) n;
        long result = 0;

        while (left < right) {
            long mid = (left + right) / 2;
            long sum = sum(times, mid);
            if (sum >= n) {
                result = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static long sum(int[] arr, long mid) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (mid / arr[i]);
        }

        return sum;
    }
}
