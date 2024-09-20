package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 등수구하기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= new int[101];
        int length = Integer.parseInt(br.readLine());
        int[] newArr = new int[length];
        // 5
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
            result.add(number);
            newArr[i] = number;
        }
        solution(newArr);
//        Collections.sort(list);
//        for (int i = list.size() - 1; i >= 0; i--) {
//            int indexNum = Math.abs(i - (list.size() - 1));
//            if(arr[list.get(i)] == 0){
//                arr[list.get(i)] = indexNum+1;
//            }
//        }
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for (int i = 1; i <= list.size(); i++) {
//            if( arr[list.get(i - 1)] == 0 ){
//                arr[list.get(i - 1)] = i;
//            }
//        }
//        for (int i = 0; i < result.size(); i++) {
//            System.out.print(arr[result.get(i)]+" ");
//        }
    }

    public static void solution(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            result[i]++;
            for (int j = 0; j < arr.length; j++) {
                if( i != j && number < arr[j]){
                    result[i]++;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
