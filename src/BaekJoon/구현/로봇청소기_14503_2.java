package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503_2 {
    // 북 동 남 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] robotPos = new int[3];
    static int[][] graph;
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        //현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        while (true) {
            step1();
            if (!step2()) {
                int dir = switchDir2(robotPos[2]);
                int nextY = robotPos[0] + dy[dir];
                int nextX = robotPos[1] + dx[dir];
                //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                if (checking(nextY, nextX) && graph[nextY][nextX] == 0) {
                    robotPos[0] = nextY;
                    robotPos[1] = nextX;
                } else {
                    //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    break;
                }
            }
            //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        }
        resultChecking();
        System.out.println(result);
    }

    public static void resultChecking() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (visited[i][j] && graph[i][j] == 0) {
                    result++;
                }
            }
        }
    }

    public static void step1() {
        //현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (!visited[robotPos[0]][robotPos[1]]) {
            visited[robotPos[0]][robotPos[1]] = true;
        }
    }

    public static void step3() {
        // 반시계 방향으로 90도 회전
        robotPos[2] = switchDir(robotPos[2]);
        // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        int nextY = robotPos[0] + dy[robotPos[2]];
        int nextX = robotPos[1] + dx[robotPos[2]];
        if (checking(nextY, nextX) && graph[nextY][nextX] == 0 && !visited[nextY][nextX]) {
            robotPos[0] = nextY;
            robotPos[1] = nextX;
        }
        //1번으로 돌아간다.
    }

    public static boolean step2() {
        //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        for (int i = 0; i < 4; i++) {
            int nextY = robotPos[0] + dy[i];
            int nextX = robotPos[1] + dx[i];
            if (checking(nextY, nextX) && !visited[nextY][nextX]
                    && graph[nextY][nextX] == 0) {
                // 청소할게 남아있음
                step3();
                return true;
            }
        }
        return false;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x];
        st = new StringTokenizer(br.readLine());
        // y
        robotPos[0] = Integer.parseInt(st.nextToken());
        // x
        robotPos[1] = Integer.parseInt(st.nextToken());
        // dir
        robotPos[2] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int switchDir2(int dir) {
        int newDir = 0;
        switch (dir) {
            case 0:
                newDir = 2;
                break;
            case 1:
                newDir = 3;
                break;
            case 2:
                newDir = 0;
                break;
            case 3:
                newDir = 1;
                break;
        }
        return newDir;
    }

    public static int switchDir(int dir) {
        int newDir = 0;
        switch (dir) {
            case 0:
                newDir = 3;
                break;
            case 1:
                newDir = 0;
                break;
            case 2:
                newDir = 1;
                break;
            case 3:
                newDir = 2;
                break;
        }
        return newDir;
    }
}
