package BaekJoon.programmers.level2;

public class 쿼드압축후개수세기 {
    static int zeroCount = 0;
    static int oneCount = 0;
    static int[][] graph;

    public int[] solution(int[][] arr) {
        graph = arr;
        step(arr.length, 0, 0);
        return new int[]{zeroCount, oneCount};
    }

    public static void step(int length, int y, int x) {
        if (length == 1) {
            if (graph[y][x] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }
        int num = length / 2;
        if (checking(length, y, x)) {
            if (graph[y][x] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        } else {
            step(num, y, x);
            step(num, y + num, x);
            step(num, y, x + num);
            step(num, y + num, x + num);
        }
    }

    public static boolean checking(int length, int y, int x) {
        int checkNum = graph[y][x];
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (checkNum != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
