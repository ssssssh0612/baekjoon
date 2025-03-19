package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 거리두기_확인하기 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        // 현재 위치에서 bfs 돌기
        for (int i = 0; i < places.length; i++) {
            if (checking(places[i])) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    public static boolean checking(String[] str) {
        int[][] graph = new int[5][5];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String str1 = str[i];
            for (int j = 0; j < 5; j++) {
                char ch = str1.charAt(j);
                if (ch == 'P') {
                    graph[i][j] = 1;
                    list.add(new int[]{i, j});
                } else if (ch == 'X') {
                    graph[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (!bfs(graph, list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean bfs(int[][] graph, int[] pos) {
        int startY = pos[0];
        int startX = pos[1];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        visited[startY][startX] = true;
        queue.add(new int[]{startY, startX, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if ((now[2] == 1) || (now[2] == 2)) {
                if (graph[now[0]][now[1]] == 1) {
                    return false;
                }
            }

            if (now[2] == 2) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (checking(nextY, nextX) && !visited[nextY][nextX]
                        && (graph[nextY][nextX] == 0 || graph[nextY][nextX] == 1)) {
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return true;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && x < 5 && y < 5;
    }
}
