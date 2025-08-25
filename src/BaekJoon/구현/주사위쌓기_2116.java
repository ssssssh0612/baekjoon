package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 주사위쌓기_2116 {
    static int count;
    static boolean[] visited;
    static int[] arr;
    static List<int[]> list = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 일단 순서 정하기
        count = Integer.parseInt(br.readLine());
        visited = new boolean[count];
        arr = new int[count];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[6];
            for (int j = 0; j < 6; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        // 순서 정하기

        for (int i = 1; i <= 6; i++) {
            // 밑에 숫자가 1 ~ 6 인경우
            int resultNum = checking(i);
            result = Math.max(resultNum, result);
        }

        System.out.println(result);
    }

    public static int checking(int startNum) {
        // 현재 arr 순서대로 쌓기

        int resultNum = 0;
        for (int i = 0; i < count; i++) {
            int[] dice = list.get(arr[i]);
            int pos = 0;
            for (int j = 0; j < 6; j++) {
                if (dice[j] == startNum) {
                    pos = j;
                }
            }
            resultNum += maxNumFind(dice, pos);
            if (i == 0) {
                continue;
            }
            startNum = dice[checkPos(pos)];
        }
        return resultNum;

    }
    public static int checkPos(int startNum){
        if(startNum == 0){
            return 5;
        }
        if(startNum == 1){
            return 3;
        }
        if(startNum == 2){
            return 4;
        }
        if(startNum == 3){
            return 1;
        }
        if(startNum == 4){
            return 2;
        }
        return 0;
    }

    public static int maxNumFind(int[] dice, int pos) {
        if (pos == 0 || pos == 5) {
            int max = 0;
            for (int i = 0; i < 6; i++) {
                if (i == 0 || i == 5) {
                    continue;
                }
                max = Math.max(dice[i], max);
            }
            return max;
        }

        if (pos == 1 || pos == 3) {
            int max = 0;
            for (int i = 0; i < 6; i++) {
                if (i == 1 || i == 3) {
                    continue;
                }
                max = Math.max(dice[i], max);
            }
            return max;
        }

        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 2 || i == 4) {
                continue;
            }
            max = Math.max(dice[i], max);
        }
        return max;

    }

}
