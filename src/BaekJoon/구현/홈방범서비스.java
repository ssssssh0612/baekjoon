package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스 {
    static int result = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static int m;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            input(br);
            step();
            System.out.println("#" + (i + 1) + " " + result);
            result = 0;
        }

    }

    public static void input(BufferedReader br) throws IOException {
        graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    graph[i][j] = true;
                } else {
                    graph[i][j] = false;
                }
            }
        }


    }

    public static void step() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = 1;
                while (bfs(i, j, k) != -1) {
                    k++;
                }
            }
        }
    }


    public static int bfs(int startY, int startX, int k) {

        int range = (k * k) + (k - 1) * (k - 1);
        int groundCount = 1;
        int homeCount = 0;
        // k만큼 돌아다니기
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
//            System.out.println("queueSize = " + size);
//            checking(visited);
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                // 집이 있으면 체크

                if (graph[now[0]][now[1]]) {
                    homeCount++;
                }

                if (now[2] == k - 1) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    int nextY = now[0] + dy[j];
                    int nextX = now[1] + dx[j];
                    if (checking(nextY, nextX) && !visited[nextY][nextX]) {
                        queue.add(new int[]{nextY, nextX, now[2] + 1});
                        groundCount++;
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }

        if (homeCount * m >= range) {
//            System.out.println("homeCount = " + homeCount);
            result = Math.max(result, homeCount);
            return 0;
        }

        //  range > 현재 채워지는 마름모 면적 * 집
        if (range > groundCount * m) {
            return -1;
        }


        return 0;
    }

    public static boolean checking(int posY, int posX) {
        return posY >= 0 && posX >= 0 && posY < n && posX < n;
    }

    public static void checking(boolean[][] num) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

}
