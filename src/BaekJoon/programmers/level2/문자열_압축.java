package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 문자열_압축 {
    public int solution(String s) {
        int answer = 0;
        int result = Integer.MAX_VALUE;
        // String 의 길이만큼 짜르기
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            List<String> list = new ArrayList<>();
            // i 길이만큼 잘라서 list에 추가하기
            int index = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                int newIndex = index + i;
                if (newIndex > s.length()) {
                    for (int j = index; j < s.length(); j++) {
                        list.add(s.charAt(j) + "");
                    }
                    break;
                }

                for (int j = index; j < index + i; j++) {
                    sb.append(s.charAt(j) + "");
                }
                list.add(sb.toString());
                index = index + i;
            }

            result = Math.min(result, checking(list, i));
        }

        return result;
    }

    public static int checking(List<String> list, int size) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < list.size()) {
            // 현재 인덱스부터 list의 사이즈 까지
            String str = list.get(index);
            int count = 0;
            for (int i = index + 1; i < list.size(); i++) {
                if (str.length() == size && list.get(i).equals(str)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == 0) {
                sb.append(str);
                index++;
            } else {
                str = (count + 1) + str;
                sb.append(str);
                index = index + (count + 1);
            }
        }
        return sb.length();
    }
}
