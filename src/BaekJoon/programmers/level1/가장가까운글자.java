package BaekJoon.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장가까운글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] charArr = new int[26];
        Arrays.fill(charArr, -1);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i) - 97;
            if (charArr[num] == -1) {
                answer[i] = -1;
                charArr[num] = i;
            } else {
                answer[i] = i - charArr[num];
                charArr[num] = i;
            }
        }
        return answer;
    }
}
