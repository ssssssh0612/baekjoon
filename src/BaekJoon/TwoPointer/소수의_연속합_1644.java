package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의_연속합_1644 {
    static int result = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        // 일단 입력받은 소수를 List에 넣어주기
        // 해당 리스트를 투포인터를 사용해서 누접합에대해 판별하기
        int[] arr = new int[a + 1];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                sosu(arr, i);
                list.add(i);
            }
        }
        if( a== 1 ){
            System.out.println(0);
            return;
        }else{
            nujuck(a);
        }
        System.out.println(result);


    }

    public static void sosu(int[] arr, int number) {
        // 배수에 해당하는 배열안에 것들 모두 +1 해줘서 거르기
        for (int i = number; i < arr.length; i = number + i) {
            if (checking(arr, i)) {
                arr[i]++;
            }
        }
    }

    public static boolean checking(int[] arr, int number) {
        return number >= 0 && arr.length > number;
    }

    // 20을 발견했을때 어떻게 처리해야할까 ?
    // start 를 올린다
    // end 를 올린다
    public static void nujuck(int number) {
        int end = 0;
        int start = 0;
        int total = list.get(0);
        while (end < list.size() && start < list.size()) {
            if (number == total) {
                result++;
            }
            if (total < number) {
                end++;
                if (end < list.size()) {
                    total += list.get(end);
                } else {
                    break;
                }
            } else {
                int minus = list.get(start);
                start++;
                total -= minus;
            }
        }
    }
}
