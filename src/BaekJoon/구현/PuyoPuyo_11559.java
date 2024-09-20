package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo_11559 {
    static int[][] graph;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    static int resultCount = 0;
    public static void main(String[] args) throws IOException {
        // R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[12][6];
        for (int i = 0; i < 12; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == '.') {
                    graph[i][j] = 0;
                } else if (a.charAt(j) == 'R') {
                    graph[i][j] = 1;
                } else if (a.charAt(j) == 'G') {
                    graph[i][j] = 2;
                } else if (a.charAt(j) == 'B') {
                    graph[i][j] = 3;
                } else if (a.charAt(j) == 'P') {
                    graph[i][j] = 4;
                } else if (a.charAt(j) == 'Y') {
                    graph[i][j] = 5;
                }
            }
        }
        boolean flag = true;
        while (true) {
            resultCount = 0;
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    puyo(i, j);
                }
            }
//            System.out.println("resultCount"+resultCount);
            gravity();
            if(resultCount == 0){
                flag = false;
                break;
            }else{
                result++;
            }
//            checking();
        }
        System.out.println(result);
    }

    public static void checking() {
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gravity() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = graph.length - 1; j >= 0; j--) {
                for (int k = 0; k < graph[0].length; k++) {
                    int nowY = j + dy[1];
                    int nowX = k + dx[1];
                    int number = graph[j][k];
                    if (checking(nowY, nowX) && number > 0 && graph[nowY][nowX] == 0) {
                        graph[nowY][nowX] = number;
                        graph[j][k] = 0;
                    }
                }
            }
        }
//        checking();
    }

    public static void puyo(int y, int x) {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        List<int[]> list = new LinkedList<>();
        if(graph[y][x] == 0){
            return;
        }
        int number = graph[y][x];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if (checking(nowY, nowX) && graph[nowY][nowX] == number && !visited[nowY][nowX] && number != 0) {
                    visited[nowY][nowX] = true;
                    queue.add(new int[]{nowY, nowX});
                    list.add(new int[]{nowY, nowX});
                    count++;
                }
            }
        }
        if (count >= 4) {
            for (int i = 0; i < list.size(); i++) {
                graph[list.get(i)[0]][list.get(i)[1]] = 0;
            }
            resultCount++;
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
