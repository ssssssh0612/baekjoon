package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 물건_팔기_1487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set.add(a);
            list.add(new int[]{a, b});
        }
        int[] result = new int[]{Integer.MAX_VALUE, 0};
        for (Integer nowNum : set) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int[] arr = list.get(i);
                if (nowNum <= arr[0]) {
                    if (nowNum - arr[1] > 0) {
                        sum += (nowNum - arr[1]);
                    }
                }
            }

            if (sum == 0) {
                continue;
            }
            if (result[1] < sum) {
                result[0] = nowNum;
                result[1] = sum;
            } else if (result[1] == sum) {
                if(nowNum < result[0]){
                    result[0] = nowNum;
                    result[1] = sum;
                }
            }
        }
        if (result[0] == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result[0]);
        }
    }
}
