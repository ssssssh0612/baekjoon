package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라_17836 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] graph;
    static int[] gramPos = new int[2];
    static int zeroCount = 0;
    static int gramCount = 0;
    static int resultGram = 0;
    static boolean checkingGram = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int number = Integer.parseInt(st.nextToken());
                graph[i][j] = number;
                if (number == 2) {
                    gramPos[0] = i;
                    gramPos[1] = j;
                }
            }
        }

        bfs();
        // 0으로만 n,m을 감
        gram();
        startGram();
        // gram을 줍고나서의 최단거리
//        System.out.println("zeroCount = "+zeroCount +"resultGram="+resultGram);
        // zeroCount, gramCount
        // 만약 gram 을 먹는다면 무조건 도달할 수 있으므로 gram 이 0인지 아닌지만 검사
        if (zeroCount > 0 && resultGram > 0 &&
                zeroCount <= time && resultGram <= time) {
            if (zeroCount < resultGram) {
                System.out.println(zeroCount);
            } else {
                System.out.println(resultGram);
            }
        } else if (zeroCount > 0 && resultGram > 0 &&
                zeroCount <= time && resultGram > time) {
            System.out.println(zeroCount);

        } else if(zeroCount > 0 && resultGram > 0 &&
                zeroCount > time && resultGram <= time){
            System.out.println(resultGram);
        }else if (zeroCount == 0 && resultGram == 0) {
            System.out.println("Fail");
        } else if (zeroCount == 0 && resultGram > 0) {
            if (resultGram <= time) {
                System.out.println(resultGram);
            } else {
                System.out.println("Fail");
            }
        } else if (zeroCount > 0 && resultGram == 0) {
            if (zeroCount <= time) {
                System.out.println(zeroCount);
            } else {
                System.out.println("Fail");
            }
        } else {
            System.out.println("Fail");
        }
    }

    public static void gram() {
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // 그람과 같은걸 찾으면 끝내기
            if (now[0] == gramPos[0] && now[1] == gramPos[1]) {
                gramCount = now[2];
                checkingGram = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                int nowCount = now[2] + 1;
                if (checking(nowY, nowX) && (graph[nowY][nowX] == 0 || graph[nowY][nowX] == 2) && !visited[nowY][nowX]) {
                    queue.add(new int[]{nowY, nowX, nowCount});
                    visited[nowY][nowX] = true;
                }
            }
        }
    }

    // 그람을 구한경우
    public static void startGram() {
        if (gramCount == 0) {
            return;
        }
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{gramPos[0], gramPos[1], gramCount});
        visited[gramPos[0]][gramPos[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == graph.length - 1 && now[1] == graph[0].length - 1) {
                resultGram = now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                int nowC = now[2] + 1;
                if (checking(nowY, nowX) && !visited[nowY][nowX] && (graph[nowY][nowX] == 0 || graph[nowY][nowX] == 1)) { // 0인 경우만 생각하기
                    queue.add(new int[]{nowY, nowX, nowC});
                    visited[nowY][nowX] = true;
                }
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    // 그람을 먹고 가는경우 그람을 먹지 않고 가는경우
    // 예를들어 그람을 먹지않고 가는경우에 그람을 꼭 먹어야하는 경우가 생기는 케이스 생각하기
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == graph.length - 1 && now[1] == graph[0].length - 1) {
                zeroCount = now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                int nowC = now[2] + 1;
                if (checking(nowY, nowX) && !visited[nowY][nowX] && graph[nowY][nowX] == 0) { // 0인 경우만 생각하기
                    queue.add(new int[]{nowY, nowX, nowC});
                    visited[nowY][nowX] = true;
                }
            }
        }
    }
}
