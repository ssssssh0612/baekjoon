package BaekJoon.BackTracking;

import java.util.Scanner;

public class 부분수열의_합_1182 {
    static int arr[];
    static int result;
    static int length;
    static int count;

    public static void main(String[] args) {
        // 부분수열의 합이 result 를 만족하는 숫자의 갯수를 구하기
        Scanner sc = new Scanner(System.in);
        count = 0;
        length = sc.nextInt();
        result = sc.nextInt();
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < length; i++) {
            dfs(arr[i], i);
        }
            if (result == 0) {
            count--;  // 공집합 제외
        }
        System.out.println(count);
    }

    public static void dfs(int num, int index) {
        for (int i = index + 1; i < length; i++) {
            num = num + arr[i];
            if (num == result) {
                count++;
            } else {
                dfs(num, i);
            }
        }
    }
}
//import java.util.Scanner;
//
//public class 부분수열의_합_1182 {
//    static int[] arr;
//    static int result;
//    static int length;
//    static int count;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        length = sc.nextInt();
//        result = sc.nextInt();
//        arr = new int[length];
//        for (int i = 0; i < length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        count = 0;
//        dfs(0, 0);
//        if (result == 0) {
//            count--;  // 공집합 제외
//        }
//        System.out.println(count);
//    }
//
//    public static void dfs(int sum, int index) {
//        if (index == length) {
//            if (sum == result) {
//                count++;
//            }
//            return;
//        }
//        dfs(sum, index + 1);  // 현재 인덱스의 요소를 포함하지 않는 경우
//        dfs(sum + arr[index], index + 1);  // 현재 인덱스의 요소를 포함하는 경우
//    }
//}
