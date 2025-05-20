package BaekJoon.programmers.level2;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(s, ",{}");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Integer num : map.keySet()) {
            list.add(new int[]{num, map.get(num)});
        }

        list.sort((o1, o2) -> o2[1] - o1[1]);
        int index = 0;
        int[] answer = new int[0];
        for (int[] arr : list) {
            if (index == 0) {
                answer = new int[arr[1]];
                answer[index] = arr[0];
                index++;
            } else {
                answer[index] = arr[0];
                index++;
            }
        }

        return answer;
    }
}
