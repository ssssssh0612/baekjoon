package BaekJoon.programmers.level1;

import java.util.*;

public class 개인정보수집유효기간 {
    static int[] todayArr = new int[3];
    static Map<String, Integer> map = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        todayArr = convert(today);
        for (int i = 0; i < terms.length; i++) {
            StringTokenizer st = new StringTokenizer(terms[i], " ");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            int[] arr = convert(st.nextToken());
            int number = map.get(st.nextToken());
            if (!checking(arr, number)) {
                list.add(i + 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static boolean checking(int[] arr, int number) {
        arr[1] += number;
        if (arr[1] > 12) {
            arr[0] = arr[0] + (arr[1] / 12);
            arr[1] = arr[1] % 12;
        }
        arr[2]--;
        if (arr[2] == 0) {
            arr[2] = 28;
            arr[1]--;
        }
        if (arr[1] == 0) {
            arr[1] = 12;
            arr[0]--;
        }

        if (arr[0] > todayArr[0]) {
            return true;
        }

        if (arr[0] < todayArr[0]) {
            return false;
        }

        if (arr[1] > todayArr[1]) {
            return true;
        }

        if (arr[1] < todayArr[1]) {
            return false;
        }

        if (arr[2] > todayArr[2]) {
            return true;
        }

        if (arr[2] < todayArr[2]) {
            return false;
        }

        return true;
    }

    public static int[] convert(String str) {
        StringTokenizer st = new StringTokenizer(str, ".");
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
