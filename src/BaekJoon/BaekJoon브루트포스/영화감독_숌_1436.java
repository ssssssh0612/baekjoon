package BaekJoon.BaekJoon브루트포스;

import java.util.Scanner;

public class 영화감독_숌_1436 {
    static int result;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result = 1;
        count = 1000;
        boolean flag = true;
        while (flag) {
            if (checking(String.valueOf(count))) {
                result++;
                count++;
            } else {
                count++;
            }

            if (result == n) {
                flag= false;
                break;
            }
        }

        if (n == 1) {
            System.out.println("666");
        } else {
            System.out.println(count - 1);
        }
    }

    public static boolean checking(String str) {
        boolean flag = false;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == '6' && str.charAt(i + 1) == '6' && str.charAt(i + 2) == '6') {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
