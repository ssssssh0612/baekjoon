package BaekJoon.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 공_바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a+1; i++) {
            list.add(i);
        }
        for (int i = 0; i < b; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            Collections.swap(list, c, d);
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
