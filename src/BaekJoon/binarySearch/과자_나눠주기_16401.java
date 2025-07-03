package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과자_나눠주기_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < m; i++) {
                count += arr[i] / mid;
            }

            if (count >= people) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
