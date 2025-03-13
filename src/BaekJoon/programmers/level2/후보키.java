package BaekJoon.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 후보키 {
    static String[][] graph;
    static int[] arr;
    static Set<String> set;

    public int solution(String[][] relation) {
        graph = relation;
        set = new HashSet<>();
        for (int i = 1; i <= relation[0].length; i++) {
            arr = new int[i];
            boolean[] visited = new boolean[relation[0].length];
            backTracking(0, i, 0, visited);
        }
        int answer = set.size();
        return answer;
    }

    public static void checking() {
        Set<String> checkSet = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        if (!set.isEmpty()) {
            for (String str : set) {
                int count = 0;
                for (int i = 0; i < str.length(); i++) {
                    String checking = str.charAt(i) + "";
                    if (sb.toString().contains(checking)) {
                        count++;
                    }
                }
                if (count == str.length()) {
                    return;
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            StringBuilder sb1 = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb1.append(graph[i][arr[j]]);
            }
            // System.out.println(sb);
            // 중복된거 집어넣으면 종료
            if (checkSet.contains(sb1.toString())) {
                return;
            } else {
                checkSet.add(sb1.toString());
            }
        }
        set.add(sb.toString());
        // 현재 중복되는건 없지만, 유일성 체크
    }

    public static void backTracking(int depth, int maxDepth,
                                    int number, boolean[] visited) {
        if (depth == maxDepth) {
            // for(int i = 0 ; i < arr.length; i++){
            // System.out.print(arr[i] + " ");
            // }
            // System.out.println();
            checking();
            return;
        }

        for (int i = 0; i < graph[0].length; i++) {
            if (!visited[i] && i >= number) {
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1, maxDepth, i, visited);
                visited[i] = false;
            }
        }
    }
}
