package BaekJoon.구현;

import java.util.Scanner;

public class 스위치_켜고_끄기_1244 {
    static boolean[] arr;
    static int switchCase;
    static int printCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        switchCase = sc.nextInt();
        arr = new boolean[switchCase + 1];
        for (int i = 1; i <= switchCase; i++) {
            if (sc.nextInt() == 1) {
                arr[i] = true;
            } else {
                arr[i] = false;
            }
        }
        int studentCase = sc.nextInt();
        for (int i = 0; i < studentCase; i++) {
            if (sc.nextInt() == 1) {
                man(sc.nextInt());
            } else {
                girl(sc.nextInt());
            }
        }
        for (int i = 1; i <= switchCase; i++) {
            printCount++;
            if (arr[i]) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
            if(printCount == 20){
                System.out.println();
                printCount = 0;
            }
        }
    }


    public static void girl(int number) {
        boolean flag = true;
        int count = 0;
        int i = 1;
        while (flag) {
            if (number + i >= 1 && number + i <= switchCase
                    && number - i >= 1 && number - i <= switchCase) {
                if (arr[number + i] == arr[number - i]) {
                    count++;
                    i++;
                } else {
                    if (count == 0) {
                        arr[number] = !arr[number];
                        flag = false;
                    } else {
                        for (int j = number - i + 1; j <= number + i - 1; j++) {
                            arr[j] = !arr[j];
                        }
                        flag = false;
                    }
                }
            } else {
                if (count == 0) {
                    arr[number] = !arr[number];
                    flag = false;
                } else {
                    for (int j = number - i + 1; j <= number + i - 1; j++) {
                        arr[j] = !arr[j];
                    }
                    flag = false;
                }
            }
        }
    }

    public static void man(int number) {
        for (int i = 1; i <= switchCase; i++) {
            if (i % number == 0) {
                arr[i] = !arr[i];
            }
        }
    }
}
