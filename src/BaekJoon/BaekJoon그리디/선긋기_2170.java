package BaekJoon.BaekJoon그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 선긋기_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        };
        list.sort(comparator);
        int result = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            if( i == 0 ){
                max = arr[1];
                result += arr[1] - arr[0];
                continue;
            }

            if(arr[0] >= max){
                max = arr[1];
                result += arr[1] - arr[0];
                continue;
            }

            if(arr[1] > max){
               result += arr[1] - max;
               max = arr[1];
            }

        }
        System.out.println(result);
    }
}
