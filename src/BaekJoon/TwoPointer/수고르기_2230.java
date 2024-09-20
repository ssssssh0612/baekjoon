package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 수고르기_2230 {
    static int RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        twoPointer(list, m);
        System.out.println(RESULT);


    }

    public static void twoPointer(List<Integer> list, int m) {
        int start = 0;
        int end = 0;
        // check가 0이면 end증가
        // check가 1이면 start 증가
        while (start < list.size() && end < list.size()) {
            int result = list.get(end) - list.get(start);
            if( result == m){
                RESULT = result;
                break;
            }
            if(result < m){
                end++;
            }else {
                RESULT = Math.min(RESULT,result);
                start++;
            }
        }
    }
}
