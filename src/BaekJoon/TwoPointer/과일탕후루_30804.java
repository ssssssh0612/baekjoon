package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 과일탕후루_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int end = 0;
        map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
        max = 1;
        end++;
        while (end < n) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            // map 크기가 2보다 크면 ?
            // start를 mapsize가 2와 같을때까지 늘리기
            while (map.size() > 2) {
                int removeNum = arr[start];
                map.put(removeNum, map.getOrDefault(removeNum, 0) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }
            max = Math.max(max , end - start + 1);
            end++;
        }
        System.out.println(max);

    }
}
