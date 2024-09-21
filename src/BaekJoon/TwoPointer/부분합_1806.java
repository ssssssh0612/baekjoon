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
        int total = list.get(0); // 0 번째 더해주고
        while (start < list.size() && end < list.size()) {
            if( total < m ){
                // end 가 올라가면 현재 end 값의 list를 더해줌
                end++;
                if( end < list.size() ){
                    total += list.get(end);
                }
            }else{
                RESULT = Math.min(RESULT, end - start + 1);
                check = true;
                int number = list.get(start);
                total -= number;
                start++;
            }
        }
    }
}
