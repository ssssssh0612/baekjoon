package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {
    static int[][] beforeGraph;
    static int[][] afterGraph;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] bfsVisited;
    static boolean[][] dfsVisited;
    static Queue<int[]> queue = new LinkedList<>();
    static int bingCount;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        beforeGraph = new int[y][x];
        afterGraph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                beforeGraph[i][j] = Integer.parseInt(st.nextToken());
                afterGraph[i][j] = beforeGraph[i][j];
            }
        }
        // 빙하가 존재하는 위치를 찾은 후 큐에 넣어주기
        // 큐에 있는 애들을 하나씩 빼면서 주변에 0 이 있으면 해당 위치에 그래프의 숫자 줄여주기
        // bfs 돌면서 빙하가 2개이상 갈라졌는지 체크하면서 count 숫자 늘리기
        // 위 과정 반복
        // 어떻게 구현해야할지 고민
        for (int i = 1; i < y - 1; i++) {
            for (int j = 1; j < x - 1; j++) {
                if (beforeGraph[i][j] > 0) {
                    bfs(x, y, i, j);
                    if (bingCount > 1) {
                        break;
                    }
                }
            }
        }
        System.out.println(result + 1);
    }

    public static void bfs(int x, int y, int nowY, int nowX) {
        queue.add(new int[]{nowY, nowX});
        bfsVisited = new boolean[y][x];
        dfsVisited = new boolean[y][x];
        bfsVisited[nowY][nowX] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (beforeGraph[now[0] + dy[i]][now[1] + dx[i]] <= 0) {
                    afterGraph[now[0]][now[1]] = afterGraph[now[0]][now[1]] - 1;
                } else if (beforeGraph[now[0] + dy[i]][now[1] + dx[i]] > 0 && !bfsVisited[now[0] + dy[i]][now[1] + dx[i]]) {
                    queue.add(new int[]{now[0] + dy[i], now[1] + dx[i]});
                    bfsVisited[now[0] + dy[i]][now[1] + dx[i]] = true;
                }
            }
        }
        // 현재 그래프가 빙하 2개로 나뉘어져 있는지 체크
        for (int i = 1; i < y - 1; i++) {
            for (int j = 1; j < x - 1; j++) {
                if (afterGraph[i][j] > 0 && !dfsVisited[i][j]) {
                    dfs(i, j, dfsVisited);
                    bingCount++;
                    if (bingCount > 1) {
                        break;
                    }
                }
            }
        }
        if (bingCount <= 1) {
            result++;
            bingCount = 0;
        }
    }

    public static void dfs(int nowY, int nowX, boolean[][] dfsVisited) {
        dfsVisited[nowY][nowX] = true;
        for (int i = 0; i < 4; i++) {
            if (afterGraph[nowY + dy[i]][nowX + dx[i]] > 0 && !dfsVisited[nowY + dy[i]][nowX + dx[i]]) {
                dfs(nowY + dy[i], nowX + dx[i], dfsVisited);
            }
        }
    }
}
