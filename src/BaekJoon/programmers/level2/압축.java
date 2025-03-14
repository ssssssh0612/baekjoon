package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public int[] solution(String msg) {
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            map.put(ch + "", i + 1);
        }

        int number = 27;
        List<Integer> list = new ArrayList<>();
        while (index < msg.length()) {
            int nowIndex = index;
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(index) + "");
            int addNumber = 0;
            while (true) {
                // 처음 Index에 존재하는지 체크

                if (map.containsKey(sb.toString())) {
                    nowIndex++;
                    if (nowIndex == msg.length()) {
                        addNumber = map.get(sb.toString());
                        list.add(addNumber);
                        index = nowIndex;
                        break;
                    }
                    addNumber = map.get(sb.toString());
                    sb.append(msg.charAt(nowIndex) + "");
                } else {
                    map.put(sb.toString(), number);
                    number++;
                    index = nowIndex;
                    list.add(addNumber);
                    break;
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}