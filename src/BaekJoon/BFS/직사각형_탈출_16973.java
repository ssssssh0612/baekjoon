package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형_탈출_16973 {
    static int n;
    static int m;
    static int startN;
    static int startM;
    static int endN;
    static int endM;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<int[]> list = new ArrayList<>();
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new int[y][x];
        visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    list.add(new int[]{i,j});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startN = Integer.parseInt(st.nextToken()) - 1;
        startM = Integer.parseInt(st.nextToken()) - 1;
        endN = Integer.parseInt(st.nextToken()) - 1;
        endM = Integer.parseInt(st.nextToken()) - 1;

        bfs();

        if(flag){
            System.out.println(-1);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startN, startM, 0});
        visited[startN][startM] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == endN && now[1] == endM){
                System.out.println(now[2]);
                flag = false;
                return;
            }

            for (int i = 0; i < 4; i++) {
                // 이동 가능하면 이동
                if (rangeChecking(now[0] + dy[i], now[1] + dx[i])
                        && checking(now[0] + dy[i], now[1] + dx[i])
                        && !visited[now[0] + dy[i]][now[1] + dx[i]]) {
                    queue.add(new int[]{now[0] + dy[i], now[1] + dx[i], now[2] + 1});
                    visited[now[0]+dy[i]][now[1]+dx[i]] = true;
                }
            }
        }
    }

    public static boolean rangeChecking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length - (n - 1) && x < graph[0].length - (m - 1);
    }

    public static boolean checking(int y, int x) {
        for (int i = 0; i < list.size(); i++) {
            int wallY = list.get(i)[0];
            int wallX = list.get(i)[1];
            if(wallY >= y && wallX >= x && wallY <= y + n - 1 && wallX <= x + m - 1){
                return false;
            }
        }
        return true;
    }
}
// 0,0 0,1 0,2 0,3 0,4
// 1,0 1,1 1,2 1,3 1,4 // 3 x 4 1,1
// 2,0 2,1 2,2 2,3 2,4
// 3,0 3,1 3,2 3,3 3,4