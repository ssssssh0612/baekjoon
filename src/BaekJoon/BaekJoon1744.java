package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marr = new ArrayList<Integer>();
        int a = sc.nextInt();
        int startPoint = 0;
        int sum = 0;
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (arr[i] <= 0) {
                    marr.add(arr[i]);
                }
            }
            if (arr[i] > 1) {
                startPoint = i;
                break;
            } else if (arr[i] == 1) {
                sum += arr[i];
            }
        }
        if (marr.contains(0)) {
            int index = marr.indexOf(0);
            int a1;
            if (index == 1) {
                a1 = marr.get(0) * marr.get(1);
                sum += a1;
            } else if (index > 1 && index % 2 == 0) {
                for (int i = 0; i < index; i += 2) {
                    a1 = marr.get(i) * marr.get(i + 1);
                    sum += a1;
                }
            } else if (index > 1 && index % 2 != 0) {
                for (int i = 0; i <= index; i += 2) {
                    a1 = marr.get(i) * marr.get(i + 1);
                    sum += a1;
                }
            }
        } else {
            int a2;
            if (marr.size() % 2 == 0) {
                for (int i = 0; i < marr.size(); i += 2) {
                    a2 = marr.get(i) * marr.get(i + 1);
                    sum += a2;
                }
            } else {
                for (int i = 0; i < marr.size() - 1; i += 2) {
                    a2 = marr.get(i) * marr.get(i + 1);
                    sum += a2;
                }
                sum += marr.get(marr.size() - 1);
            }


            if (arr[startPoint] > 1) {
                if ((arr.length - startPoint) / 2 == 0) {
                    for (int i = startPoint; i < a; i += 2) {
                        sum += arr[i] * arr[i + 1];
                    }
                } else if ((arr.length - startPoint) / 2 != 0) {
                    for (int i = startPoint + 1; i < a; i += 2) {
                        sum += arr[i] * arr[i + 1];
                    }
                }
            }
            System.out.println(sum);
        }
    }
}