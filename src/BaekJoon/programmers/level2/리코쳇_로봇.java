package BaekJoon.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {
    static int[][] graph;
    static int[] startPos = new int[2];
    static int[] endPos = new int[2];

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int solution(String[] board) {
        graph = new int[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            String str = board[i];
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == 'D') {
                    graph[i][j] = -1;
                } else if (ch == 'R') {
                    startPos[0] = i;
                    startPos[1] = j;
                } else if (ch == 'G') {
                    endPos[0] = i;
                    endPos[1] = j;
                }
            }
        }
        return bfs();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        visited[startPos[0]][startPos[1]] = true;
        queue.add(new int[]{startPos[0], startPos[1], 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (endPos[0] == now[0] && endPos[1] == now[1]) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int[] next = moving(now[0], now[1], i, visited);
                if (next[0] == -1) {
                    continue;
                } else {
                    // System.out.println("y = " + next[0] + " x = " + next[1]);
                    queue.add(new int[]{next[0], next[1], now[2] + 1});
                }
            }
        }
        return -1;
    }

    public static int[] moving(int y, int x, int dir, boolean[][] visited) {
        boolean flag = false;
        // 해당 방향으로 쭉 갈 수 있는지 없는지
        // 일단 해당 방향으로 쭈욱 진행
        while (true) {
            y = y + dy[dir];
            x = x + dx[dir];
            if (checking(y, x) && graph[y][x] == 0) {
                flag = true;
            } else {
                y = y - dy[dir];
                x = x - dx[dir];
                break;
            }
        }

        if (flag && !visited[y][x]) {
            visited[y][x] = true;
            return new int[]{y, x};
        } else {
            return new int[]{-1};
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}