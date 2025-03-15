package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프렌즈4블록 {
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 0, 1};
    static int[][] graph;

    public int solution(int m, int n, String[] board) {
        graph = new int[board.length][board[0].length()];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int num = (int) (board[i].charAt(j)) - 64;
                graph[i][j] = num;
            }
        }
        int answer = 0;
        // int index = 3;
        while (true) {
            // 지울 블록 찾기
            List<int[]> list = find();
            // 블록 내리기
            if (list.isEmpty()) {
                break;
            }
            for (int[] arr : list) {
                int num = graph[arr[0]][arr[1]];
                if (num != 0) {
                    graph[arr[0]][arr[1]] = 0;
                    answer++;
                }
            }
            gravity();
        }


        return answer;
    }

    public static void checkingGraph() {
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void gravity() {
        int[][] newGraph = new int[graph.length][graph[0].length];

        for (int i = graph[0].length - 1; i >= 0; i--) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = graph.length - 1; j >= 0; j--) {
                // 한곳에 추가하기
                if (graph[j][i] != 0) {
                    queue.add(graph[j][i]);
                }
            }
            for (int j = graph.length - 1; j >= 0; j--) {
                if (!queue.isEmpty()) {
                    newGraph[j][i] = queue.poll();
                }
            }
        }
        graph = newGraph;
    }

    public static List<int[]> find() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int num = graph[i][j];
                if (num == 0) {
                    continue;
                }
                int count = 0;
                for (int k = 0; k < 3; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    // 범위 안에 들어가고, 숫자가 같으면
                    if (checking(nextY, nextX) &&
                            graph[nextY][nextX] == num) {
                        count++;
                    }
                }
                if (count == 3) {
                    list.add(new int[]{i, j});
                    for (int k = 0; k < 3; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        list.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
        return list;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}

