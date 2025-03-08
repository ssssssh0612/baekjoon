package BaekJoon.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {
    static boolean[] visited;
    static List<List<Integer>> list;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    list.get(i + 1).add(j + 1);
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }


        return result;
    }

    public static void dfs(int startNum) {
        for (int i = 0; i < list.get(startNum).size(); i++) {
            if (!visited[list.get(startNum).get(i)]) {
                visited[list.get(startNum).get(i)] = true;
                dfs(list.get(startNum).get(i));
            }
        }
    }
}