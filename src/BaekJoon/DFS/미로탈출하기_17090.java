package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탈출하기_17090 {

    static int[] dy = {-1, 1, 0, 0};   // U, D, L, R
    static int[] dx = {0, 0, -1, 1};
    static int[][] graph;
    static int[][] checking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new int[y + 2][x + 2];
        checking = new int[y + 2][x + 2];

        // 그래프 방향 입력
        for (int i = 1; i <= y; i++) {
            String str = br.readLine();
            for (int j = 1; j <= x; j++) {
                char ch = str.charAt(j - 1);
                if (ch == 'U') {
                    graph[i][j] = 0;
                } else if (ch == 'D') {
                    graph[i][j] = 1;
                } else if (ch == 'L') {
                    graph[i][j] = 2;
                } else {
                    graph[i][j] = 3;
                }
            }
        }

        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (checking[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (checking[i][j] == 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    // 이 칸에서 시작했을 때:
    // 1 = 탈출 가능, 2 = 탈출 불가능(사이클/막힘)
    public static int dfs(int y, int x) {
        // 범위 밖으로 나가면 그 직전 칸은 탈출 성공
        if (!inRange(y, x)) {
            return 1;
        }

        // 이미 결과가 결정된 칸이면 그대로 반환
        if (checking[y][x] == 1 || checking[y][x] == 2) {
            return checking[y][x];
        }

        // 현재 DFS 경로에서 이미 방문 중인 칸 → 사이클
        if (checking[y][x] == -1) {
            return checking[y][x] = 2;
        }

        // 이제 방문 시작
        checking[y][x] = -1;  // 방문 중 표시

        int dir = graph[y][x];
        int ny = y + dy[dir];
        int nx = x + dx[dir];

        int res = dfs(ny, nx);    // 다음 칸 결과
        // 내가 가는 쪽의 결과를 그대로 이어받음
        return checking[y][x] = res;
    }

    public static boolean inRange(int y, int x) {
        return y >= 1 && x >= 1 && y < graph.length - 1 && x < graph[0].length - 1;
    }
}
