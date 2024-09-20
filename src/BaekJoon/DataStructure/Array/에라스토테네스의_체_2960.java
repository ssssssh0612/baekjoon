package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 에라스토테네스의_체_2960 {
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] arr = new int[a + 1];
        for (int i = 2; i <= a; i++) {
            if (arr[i] == 0) {
                checking(arr, i);
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        System.out.println(list.get(b - 1));
    }

    public static void checking(int[] arr, int number) {
        for (int i = number; i <= arr.length; i = i + number) {
            if (checkingLength(arr, i) && arr[i] == 0) {
                arr[i]++;
                list.add(i);
            }
        }
    }

    public static boolean checkingLength(int[] arr, int number) {
        return number >= 0 && number < arr.length;
    }
}
