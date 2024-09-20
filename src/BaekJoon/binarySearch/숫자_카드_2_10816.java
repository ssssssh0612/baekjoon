package BaekJoon.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 숫자_카드_2_10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        int b = sc.nextInt();
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            resultList.add(new int[]{sc.nextInt(), 0});
        }

        for (int i = 0; i < b; i++) {

        }
    }
    public static void binarySearch(int number, int[] arr){
        // 이분탐색 구현해보기




    }
}
