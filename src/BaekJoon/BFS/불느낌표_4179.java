package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불느낌표_4179 {
    static int[][] graph;
    static int[] startPos = new int[2];
    static List<int[]> fireList = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input(br);
            bfs();
            if (!flag) {
                System.out.println("IMPOSSIBLE");
            }
            flag = false;
            fireList.clear();
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = str.charAt(j);
                // 0이면 지나갈 수 있음
                // -1 이면 벽
                // -2 이면 불
                // J는 시작지점
                if (ch == '@') {
                    startPos[0] = i;
                    startPos[1] = j;
                    graph[i][j] = 1;
                } else if (ch == '#') {
                    graph[i][j] = -1;
                } else if (ch == '*') {
                    graph[i][j] = -2;
                    fireList.add(new int[]{i, j});
                } else{
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        // 지훈이가 탈출할 수 있는 경우는 범위를 벗어나게되면 탈출하게됨
        Queue<int[]> queue = new LinkedList<>();
        // y, x, 불인지 지훈인지, 이동지점,
        queue.add(new int[]{startPos[0], startPos[1], 0, 1});
        visited[startPos[0]][startPos[1]] = true;
        for (int i = 0; i < fireList.size(); i++) {
            int y = fireList.get(i)[0];
            int x = fireList.get(i)[1];
            queue.add(new int[]{y, x, 1});
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // 불인지 지훈인지 판단하기
            // 0 이면 지훈이
            checkingGraph();

            if (flag) {
                break;
            }

            if (now[2] == 0) {
                // 현재 내 위치가 먹혔는지 안먹혔는지 확인하기
                if (graph[now[0]][now[1]] == -2) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nextY = now[0] + dy[i];
                    int nextX = now[1] + dx[i];
                    if (checking(nextY, nextX)) {
                        // 아직 지훈이가 돌아다니는 경우
                        if (!visited[nextY][nextX] && graph[nextY][nextX] == 0) {
                            queue.add(new int[]{nextY, nextX, 0, now[3] + 1});
                            visited[nextY][nextX] = true;
                            graph[nextY][nextX] = now[3] + 1;
                        }
                    } else {
                        // 지훈이가 탈출 한 경우
                        flag = true;
                        System.out.println(now[3]);
                        break;
                    }
                }
            } else {
                // 0이 아니라면 불
                for (int i = 0; i < 4; i++) {
                    int nextY = now[0] + dy[i];
                    int nextX = now[1] + dx[i];
                    if (checking(nextY, nextX) && graph[nextY][nextX] >= 0) { // 불은 0 인 경우만 퍼질 수 있음
                        queue.add(new int[]{nextY, nextX, 1});
                        graph[nextY][nextX] = -2;
                    }
                }
                // 방문되어있는 상태인데 불로 덮여있다면 끝내기 ?
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
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
}
