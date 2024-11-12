package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 계란으로계란치기_16987 {
    static int result = Integer.MIN_VALUE;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        // 가장 왼쪽의 계란을 든다. -> 0부터 시작함
        // 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
        // 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
        // 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
        // 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
        // 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
        dfs(0);
        System.out.println(result);
    }

    // index 는 손에 쥔 계란
    public static void dfs(int index) {
        // 내 손에 쥔 계란이 깨진 계란인가 ?
        if (index == list.size()) {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                int[] egg = list.get(i);
                if (egg[0] <= 0) {
                    count++;
                }
            }
//            System.out.println("result = " + count);
            result = Math.max(count, result);
            return;
        }
        int[] egg = list.get(index);
        // 현재 계란이 깨진계란이냐 ?
        if (egg[0] > 0) {
            boolean next = false;
            for (int i = 0; i < list.size(); i++) {
                // 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
                int[] nowEgg = list.get(i);
                if (index != i && nowEgg[0] > 0) {
                    next = true;
                    boom(egg, nowEgg);
                    dfs(index + 1);
                    cancelBoom(egg, nowEgg);
//                    System.out.println(egg[0] + " " + nowEgg[0]);
                }
            }
            if (!next) {
                dfs(index + 1);
            }
        } else {
            dfs(index + 1);
        }
    }

    public static void boom(int[] egg1, int[] egg2) {
        egg2[0] -= egg1[1];
        egg1[0] -= egg2[1];
    }

    public static void cancelBoom(int[] egg1, int[] egg2) {
        egg2[0] += egg1[1];
        egg1[0] += egg2[1];
    }

    public static void input(BufferedReader br) throws IOException {
        int eggCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < eggCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 내구도
            int check = Integer.parseInt(st.nextToken());
            // 무게
            int weight = Integer.parseInt(st.nextToken());
            list.add(new int[]{check, weight, 1});
        }
    }
}
