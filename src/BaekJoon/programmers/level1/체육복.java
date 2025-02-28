package BaekJoon.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // lost에 존재하는 번호중 reserve에 있는지 확인
        Set<Integer> set = new HashSet<>();
        Arrays.sort(lost);
        for (int i = 0; i < reserve.length; i++) {
            set.add(reserve[i]);
        }
        for (int i = 0; i < lost.length; i++) {
            if (set.contains(lost[i])) {
                set.remove(lost[i]);
                lost[i] = 0;
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == 0) continue;
            if (set.contains(lost[i] - 1)) {
                set.remove(lost[i] - 1);
                lost[i] = 0;
            } else if (set.contains(lost[i] + 1)) {
                set.remove(lost[i] + 1);
                lost[i] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] > 0) {
                count++;
            }
        }

        return n - count;
    }
}
