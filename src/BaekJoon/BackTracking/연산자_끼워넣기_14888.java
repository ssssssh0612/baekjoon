package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 연산자_끼워넣기_14888 {
    static int MAX = 0;
    static int MIN = 0;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> calList = new ArrayList<>();
    static int[] arr;
    static int n;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n - 1];
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < 4; i++) {
            // +, -, *, / 0,1,2,3
            calList.add(sc.nextInt());
        }

        backTracking(0);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void backTracking(int depth) {
        if (depth == n - 1) {
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                if (i == 0 && arr[i] == 0) {
                    result = list.get(i) + list.get(i + 1);
                } else if (i == 0 && arr[i] == 1) {
                    result = list.get(i) - list.get(i + 1);
                } else if (i == 0 && arr[i] == 2) {
                    result = list.get(i) * list.get(i + 1);
                } else if (i == 0 && arr[i] == 3) {
                    result = list.get(i) / list.get(i + 1);
                } else {
                    switch (arr[i]) { // +, -, *, /
                        case 0:
                            result = result + list.get(i + 1);
                            break;
                        case 1:
                            result = result - list.get(i + 1);
                            break;
                        case 2:
                            result = result * list.get(i + 1);
                            break;
                        case 3:
                            result = result / list.get(i + 1);
                            break;
                    }
                }
            }
            if (count == 0) {
                MAX = result;
                MIN = result;
                count++;
            } else {
                MAX = Math.max(result, MAX);
                MIN = Math.min(result, MIN);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (calList.get(i) > 0) {
                arr[depth] = i;
                calList.set(i, calList.get(i) - 1);  // 값을 수정할 때는 set() 메서드 사용
                backTracking(depth + 1);
                calList.set(i, calList.get(i) + 1);  // 값을 수정할 때는 set() 메서드 사용
            }
        }
    }
}
