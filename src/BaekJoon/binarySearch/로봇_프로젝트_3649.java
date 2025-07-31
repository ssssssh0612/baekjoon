package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇_프로젝트_3649 {
    static int C;
    static int resultFinal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            C = Integer.parseInt(input) * 10_000_000;
            int length = Integer.parseInt(br.readLine());

            int[] arr = new int[length];

            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (bs(arr, arr[i], C, i + 1, arr.length - 1)) {
                    System.out.println("yes " + arr[i] + " " + arr[resultFinal]);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            System.out.println("danger");
        }


    }

    public static boolean bs(int[] arr, int a, int c, int start, int end) {
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = (left + right) / 2;
            int b = arr[mid];
            if (c - b == a) {
                resultFinal = mid;
                return true;
            } else if (c - b > a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
