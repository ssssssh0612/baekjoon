package BaekJoon.programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 미로탈출명령어 {
    static int[][] graph;
    static String[] strArr = new String[]{"d", "l", "r", "u"};
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, -1, 1, 0};
    static int K;
    static String answer = "impossible";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        graph = new int[n][m];
        K = k;
        int minDis = Math.abs(r - x) + Math.abs(c - y);

        if ((k < minDis) || ((k - minDis) % 2 != 0)) {
            return "impossible";
        }


        dfs(x - 1, y - 1, r - 1, c - 1, 0, "");
        return answer;
    }

    public static void dfs(int startY, int startX, int endY, int endX, int count, String str) {

        if (!answer.equals("impossible")) return;

        int minDis = Math.abs(endY - startY) + Math.abs(endX - startX);

        if (count == K) {

            if (startY == endY && startX == endX) {
                answer = str;
            }
            return;
        }

        int maxDis = K - count;
        if (minDis > maxDis) {
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];
            if (checking(nextY, nextX)) {
                dfs(nextY, nextX, endY, endX, count + 1, str + strArr[i]);
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}


