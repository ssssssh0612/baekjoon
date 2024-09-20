package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부분합_1806 {
    static int RESULT = Integer.MAX_VALUE;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
sdf
        result(list, m);
        if (check) {
            System.out.println(RESULT);
        }else{
            System.out.println(0);
        }
    }
    public static void result(List<Integer> list, int m) {
        int start = 0;
        int end = 0;
        int total = 0;
        while (start < list.size() && end < list.size()) {
            for (int i = start; i <= end; i++) {
                total += list.get(i);
            }
//            System.out.println("Start = "+ start + ", end = " + end + ", total = " + total);
            if( total == m ){
                RESULT = Math.min(RESULT, Math.abs(end - start + 1));
                check = true;
                break;
            }
            if( total < m ){
                end++;
            }else{
                RESULT = Math.min(RESULT, Math.abs(end - start + 1));
                check = true;
                start++;
            }
            total = 0;
        }
    }
}
