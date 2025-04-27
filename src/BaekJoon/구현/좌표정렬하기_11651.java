package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표정렬하기_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[1] - o2[1];
                if(result != 0){
                    return result;
                }
                return o1[0] - o2[0];
            }
        };
        int length = Integer.parseInt(br.readLine());
        for(int i = 0; i < length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }
        list.sort(comparator);
        for(int[] arr : list){
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
