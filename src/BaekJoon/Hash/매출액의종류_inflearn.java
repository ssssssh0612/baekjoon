package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class 매출액의종류_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        for (int i = 0; i < b; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size()+" ");
        int start = 0;
        int end = b - 1;
        while (start < arr.length && end < arr.length) {
            map.put(arr[start], map.getOrDefault(arr[start], null) - 1);
            if (map.get(arr[start]) == 0) {
                map.remove(arr[start]);
            }
            start++;
            end++;
            if(checking(end,arr)) {
                int number = arr[end];
                map.put(number, map.getOrDefault(number, 0) + 1);
                System.out.print(map.size()+" ");
            }
        }
    }

    public static boolean checking(int number, int[] arr) {
        return number >= 0 && number < arr.length;
    }


//        int indexN = a - b + 1;
//        int[] arr = new int[a];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < a; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        int start = 0;
//        int end = b - 1;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < b; i++) {
//            int number = arr[i];
//            map.put(number, map.getOrDefault(number,0) + 1);
//        }
//        System.out.print(map.size()+" ");
//        while (end < a) {
//            map.put(arr[start], map.getOrDefault(arr[start], null) - 1);
//            if(map.get(arr[start]) == 0){
//                map.remove(arr[start]);
//            }
//            start++;
//            end++;
//            if(!checking(end,arr)){
//                break;
//            }
//            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
//            System.out.print(map.size()+" ");
//        }
//    }
//    public static boolean checking(int number, int[] arr){
//        return arr.length > number && number >= 0;
//    }
}
