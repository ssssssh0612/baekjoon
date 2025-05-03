package BaekJoon.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        // 제일 많은거부터
        int[] arr = new int[map.size()];
        int index = 0;
        for (Integer num : map.keySet()) {
            int num1 = map.get(num);
            arr[index] = num1;
            index++;
        }
        Arrays.sort(arr);

        // 끝에서부터 하나씩 빼기
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            // 끝에서부터 현재 arr의 숫자만큼 k를 빼주기
            k = k - arr[i];
            if (k <= 0) {
                break;
            }
            count++;
        }
        return count + 1;
    }
}

