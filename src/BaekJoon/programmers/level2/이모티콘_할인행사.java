package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 이모티콘_할인행사 {
    static int[] arr;
    static List<int[]> list = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        arr = new int[emoticons.length];
        backTracking(0, users, emoticons);
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o2[0] - o1[0];
                if (result != 0) {
                    return result;
                }
                return o2[1] - o1[1];
            }
        };
        Collections.sort(list, comparator);
        return list.get(0);
    }

    public static void backTracking(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            checking(users, emoticons);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[depth] = (i + 1) * 10;
            backTracking(depth + 1, users, emoticons);
        }
    }

    public static void checking(int[][] users, int[] emoticons) {
        int person = 0;
        int money = 0;

        for (int i = 0; i < users.length; i++) {
            int percent = users[i][0];
            int sumMoney = users[i][1];
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= percent) {
                    sum += (emoticons[j] - (arr[j] * emoticons[j] / 100));
                }
            }
            if (sum >= sumMoney) {
                person++;
            } else {
                money += sum;
            }
        }
        list.add(new int[]{person, money});
    }
}

