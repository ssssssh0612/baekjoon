package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636 {
    static int[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> removeQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int size = 0;
        while (true) {
            // 구멍이 아닌곳 찾기
            step1();
            // 구멍이 아닌곳에서
            step2();
//            checkingGraph();
            if (!removeQueue.isEmpty()) {
                size = removeQueue.size();
                while (!removeQueue.isEmpty()) {
                    int[] now = removeQueue.poll();
                    graph[now[0]][now[1]] = 0;
                }
                for (int i = 0; i < graph.length; i++) {
                    for (int j = 0; j < graph[0].length; j++) {
                        if (graph[i][j] == 2) {
                            graph[i][j] = 0;
                        }
                    }
                }
                time++;
            } else {
                break;
            }
        }
        System.out.println(time);
        System.out.println(size);
        // 0이면 해당 0에서 bfs돌기
        // 0이면 해당 0에서 bfs돌면서 상하좌우 확인하고 제거하기

    }

    public static void step1() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                // 0이면 bfs돌기
                if (graph[i][j] == 0 && !visited[i][j] && bfs(i, j, visited)) {
                    bfs2(i, j);
                }
            }
        }


    }
    public static void bfs2(int y, int x){
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        graph[y][x] = 2;
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checkingRange(nextY,nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 0){
                    queue.add(new int[]{nextY,nextX});
                    graph[nextY][nextX] = 2;
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static boolean bfs(int y, int x, boolean[][] visited) {
        boolean flag = true;
        // bfs돌면서 감싸져있으면
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (!(checking(now[0], now[1], 0) && checking(now[0], now[1], 1) &&
                    checking(now[0], now[1], 2) && checking(now[0], now[1], 3))) {
                flag = false;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checkingRange(nextY,nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 0){
                    queue.add(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return flag;
    }

public static void step2() {
    boolean[][] visited = new boolean[graph.length][graph[0].length];
    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[0].length; j++) {
            if (graph[i][j] == 1 && !visited[i][j]) {
                step3(i, j, visited);
            }
        }
    }
}

public static void step3(int y, int x, boolean[][] visited) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    visited[y][x] = true;
    while (!queue.isEmpty()) {
        int[] now = queue.poll();
        for (int i = 0; i < 4; i++) {
            int nextY = now[0] + dy[i];
            int nextX = now[1] + dx[i];
            if (checkingRange(nextY, nextX) && graph[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                queue.add(new int[]{nextY, nextX});
                visited[nextY][nextX] = true;
            }
        }
        for (int i = 0; i < 4; i++) {
            int nextY = now[0] + dy[i];
            int nextX = now[1] + dx[i];
            if (checkingRange(nextY, nextX) && graph[nextY][nextX] == 0) {
                removeQueue.add(new int[]{now[0], now[1]});
                break;
            }
        }
    }
}

public static boolean checking(int y, int x, int dir) {
    int startY = y;
    int startX = x;
    while (true) {
        // 하나라도 범위가 끝나거나 0이 나온다면
        startY = startY + dy[dir];
        startX = startX + dx[dir];
        if (checkingRange(startY, startX)) {
            if (graph[startY][startX] == 1) {
                return true;
            }
        } else {
            return false;
        }
        // 범위가 종료되거나 1이 나올때까지 진행
    }
}

public static boolean checkingRange(int y, int x) {
    return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
}

public static void checkingGraph() {
    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[0].length; j++) {
            System.out.print(graph[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
}
}
