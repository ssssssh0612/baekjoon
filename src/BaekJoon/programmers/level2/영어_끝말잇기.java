package BaekJoon.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        int count = 1;
        int index = 0;
        while (index < words.length) {
            int length = index + n;
            for (int i = index; i < length; i++) {
                if (i == 0) {
                    set.add(words[i]);
                }
                if (i != 0 && words[i].length() > 1) {
                    // i가 0이 아닌 경우에는 확인하기
                    if (!set.contains(words[i]) &&
                            checking(words[i], words[i - 1])) {
                        set.add(words[i]);
                        continue;
                    } else {
                        return new int[]{(i % n) + 1, count};
                    }
                }
            }
            index = length;
            if (index > words.length) {
                length = words.length;
            }
            count++;
        }

        return new int[]{0, 0};
    }

    public static boolean checking(String now, String before) {
        if (now.charAt(0) == before.charAt(before.length() - 1)) {
            return true;
        }
        return false;
    }
}
