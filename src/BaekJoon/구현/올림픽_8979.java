package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 올림픽_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b,c,d});
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o2[1] - o1[1];
                if(result != 0){
                    return result;
                }
                result = o2[2] - o1[2];
                if(result != 0){
                    return result;
                }
                return o2[3] - o1[3];
            }
        };
        Collections.sort(list,comparator);
        // 메달수가 같은경우일경우 어떻게 해야하지
        int[] result = new int[list.size()];
        int index = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if(!areArraysEqual(list.get(i),list.get(i+1))){
                result[i] = index;
                index++;
            }else{
                result[i] = index;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
    public static boolean areArraysEqual(int[] a, int[] b) {
        // 각 요소를 비교하여 다르면 false 반환
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false; // 요소가 다르면 false
            }
        }
        return true; // 모든 요소가 같으면 true
    }
}
