package BaekJoon.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static int[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int solution(String[] maps) {
        graph = new int[maps.length][maps[0].length()];
        int[] startPos = new int[2];
        int[] midPos = new int[2];
        for (int i = 0; i < maps.length; i++) {
            String str = maps[i];
            for (int j = 0; j < maps[0].length(); j++) {
                char ch = str.charAt(j);
                if (ch == 'S') {
                    startPos[0] = i;
                    startPos[1] = j;
                } else if (ch == 'X') {
                    graph[i][j] = -1;
                } else if (ch == 'L') {
                    midPos[0] = i;
                    midPos[1] = j;
                    graph[i][j] = 1;
                } else if (ch == 'E') {
                    graph[i][j] = 2;
                }
            }
        }
        
        int midNum = bfs(startPos, 1);
        if (midNum > 0) {
            int endNum = bfs(midPos, 2);
            if (endNum > 0) {
                return midNum + endNum;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static int bfs(int[] startPos, int endValue) {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPos[0], startPos[1], 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (endValue == graph[now[0]][now[1]]) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (checking(nextY, nextX) && !visited[nextY][nextX]
                        && graph[nextY][nextX] >= 0) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                }
            }
        }
        return -1;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
