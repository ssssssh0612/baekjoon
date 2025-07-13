package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 합이_0_3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Boolean> boolMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            boolMap.putIfAbsent(arr[i], false);
        }

        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                int sum = arr[i] + arr[j];
                if (arr[i] == 0 && map.get(sum) > 1) {
                    if (arr[j] == 0) {
                        if (map.get(sum) > 2 && (map.containsKey(sum) && !boolMap.get(sum))) {
                            boolMap.put(sum, true);
                            answer += map.get(sum);
                        }
                        continue;
                    }
//                    System.out.println(1);
                    if (map.containsKey(sum) && !boolMap.get(sum)) {
                        boolMap.put(sum, true);
                        answer += map.get(sum);
                    }
                    continue;
                }
                if (arr[j] == 0 && map.get(sum) > 1) {
//                    System.out.println(2);
                    if (map.containsKey(sum) && !boolMap.get(sum)) {
                        boolMap.put(sum, true);
                        answer += map.get(sum);
                    }
                    continue;
                }

                if (arr[i] == 0 || arr[j] == 0) {
                    continue;
                }

                if (map.containsKey(sum) && !boolMap.get(sum)) {
//                    System.out.println(3);
                    boolMap.put(sum, true);
                    answer += map.get(sum);
                }
            }
//            System.out.println(answer);
        }

        System.out.println(answer);
    }
}

// -5 0 5




