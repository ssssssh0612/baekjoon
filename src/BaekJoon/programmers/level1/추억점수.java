package BaekJoon.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int num = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    num += map.get(photo[i][j]);
                }
            }
            list.add(num);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
