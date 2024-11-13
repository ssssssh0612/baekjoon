package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이_1600 {

    static int[] hDx = {-2, -1, 1, 2, -2, -1, 2, 1};
    static int[] hDy = {-1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int movingCount;
    static int[][] graph;
    static boolean[][][] visited;
    static boolean checking = false;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        movingCount = Integer.parseInt(br.readLine());
        input(br);
        bfs();
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        visited = new boolean[y][x][movingCount + 1];
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if(!checking){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }


    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // y, x, 움직임 횟수, K
        int count = movingCount;
        queue.add(new int[]{0, 0, 0, count});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            if( y == graph.length - 1 && x == graph[0].length - 1){
                result = Math.min(now[2],result);
                checking = true;
            }
//            System.out.println("y = " + y + " x = " + x + " count = " + now[3]);
            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (checking(nextY, nextX) && !visited[nextY][nextX][now[3]] && graph[nextY][nextX] == 0) {
                    queue.add(new int[]{nextY, nextX, now[2] + 1, now[3]});
                    visited[nextY][nextX][now[3]] = true;
                }
            }
            if (now[3] != 0) {
                for (int i = 0; i < 8; i++) {
                    int nextY = y + hDy[i];
                    int nextX = x + hDx[i];
                    if (checking(nextY, nextX) && !visited[nextY][nextX][now[3]] && graph[nextY][nextX] == 0) {
                        queue.add(new int[]{nextY, nextX, now[2] + 1, now[3] - 1});
                        visited[nextY][nextX][now[3] - 1] = true;
                    }
                }
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}

//2
//8 12
//0 0 0 0 0 0 0 0
//0 1 1 1 1 1 1 0
//0 1 1 1 1 1 1 0
//0 1 1 0 0 0 0 0
//0 1 1 0 1 1 1 1
//0 1 1 0 1 1 1 1
//0 1 1 0 0 0 0 0
//0 1 1 0 1 1 1 0
//0 1 1 1 1 1 1 0
//1 1 0 0 0 0 1 1
//1 1 1 1 1 1 1 1
//1 1 1 0 1 1 0 0

//1
//7 8
//0 0 0 0 0 0 0
//1 1 1 1 1 1 0
//1 1 1 1 1 1 0
//0 0 0 1 1 1 0
//0 1 1 1 0 0 0
//0 1 1 1 1 1 1
//0 1 1 1 1 1 1
//0 0 0 0 0 0 0

//30
//7 10
//0 1 1 1 0 1 1
//1 1 0 1 1 1 0
//1 1 1 1 1 1 1
//1 1 1 1 1 0 1
//1 1 1 0 1 1 1
//1 0 1 1 1 1 1
//1 1 1 1 1 1 1
//1 1 0 1 1 1 1
//1 1 1 1 0 1 1
//1 1 1 1 1 1 0