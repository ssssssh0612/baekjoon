package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 에리_카드_15728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Arrays.fill(result,Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num1 = arr1[i];
                int num2 = arr2[j];
                int num3 = num1 * num2;
                result[j] = Math.max(result[j], num3);
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add(new int[]{i, result[i]});
        }
        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                return o2[1]-o1[1];
            }
        };
        list.sort(comparator);
        System.out.println(list.get(m)[1]);
    }
}

