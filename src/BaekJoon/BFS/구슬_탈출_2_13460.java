package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬_탈출_2_13460 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] red = new int[2];
    static int[] blue = new int[2];
    static int[] goal = new int[2];
    static int[][] graph;
    static int[] arr = new int[10];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = str.charAt(j);
                if (ch == '#') {
                    graph[i][j] = -1;
                } else if (ch == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if (ch == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                } else if (ch == 'O') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            backTracking(0, i);
        }
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    public static void backTracking(int depth, int number) {
        if (depth == 10) {
            int[] newBlue = new int[]{blue[0], blue[1]};
            int[] newRed = new int[]{red[0], red[1]};
            int count = 0;
            for (int i = 0; i < 10; i++) {
                // 내가 가려고 한 방향이 벽이면 바로 종료
                int dir = arr[i];
                boolean[] goalFlag = move(newRed, newBlue, dir);
                if (goalFlag[0] && !goalFlag[1]) {
                    count = i + 1;
                    break;
                }else if(goalFlag[1]){
                    break;
                }
            }
            if (count > 0) {
                result = Math.min(count, result);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (i != number) {
                arr[depth] = i;
                backTracking(depth + 1, i);
            }
        }
    }

    public static boolean[] move(int[] red, int[] blue, int dir) {
        // 한 방향으로 기울이기
        boolean redFlag = false;
        boolean blueFlag = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{red[0], red[1], 0});
        queue.add(new int[]{blue[0], blue[1], 1});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nextY = now[0] + dy[dir];
            int nextX = now[1] + dx[dir];

            int checkNextY = now[0] + 2 * dy[dir];
            int checkNextX = now[1] + 2 * dx[dir];
            // 여기서 막힌건지, 아니면 안막힌건지 체크하기
            if((now[2] == 0) && (nextY == blue[0] && nextX == blue[1]) && checking(checkNextY, checkNextX) &&
            graph[checkNextY][checkNextX] != -1){
                queue.add(now);
                continue;
            }else if(now[2] == 1 && (nextY == red[0] && nextX == red[1]) && checking(checkNextY, checkNextX) &&
                    graph[checkNextY][checkNextX] != -1){
                queue.add(now);
                continue;
            }

//            System.out.println(" nextY = " + nextY + " nextX = " + nextX);
            if (nextY == goal[0] && nextX == goal[1] && now[2] == 0) {
                redFlag = true;
                red[0] = -1;
                red[1] = -1;
                continue;
            } else if (nextY == goal[0] && nextX == goal[1] && now[2] == 1) {
                blueFlag = true;
                blue[0] = -1;
                blue[1] = -1;
                continue;
            }
            // 현재 가고자 하는 방향과 같은데 앞에 어떠한 구술이 있으면 해당 방향으로 2칸더 가봐서 벽인지 아닌지 체크

            // 빨강인경우
            if (checking(nextY, nextX) && graph[nextY][nextX] != -1 && now[2] == 0
                    && !(nextY == blue[0] && nextX == blue[1])) {
                queue.add(new int[]{nextY, nextX, now[2]});
                red[0] = nextY;
                red[1] = nextX;
            } else if (checking(nextY, nextX) && graph[nextY][nextX] != -1 && now[2] == 1
                    && !(nextY == red[0] && nextX == red[1])) {
                queue.add(new int[]{nextY, nextX, now[2]});
                blue[0] = nextY;
                blue[1] = nextX;
            }
        }
        return new boolean[]{redFlag, blueFlag};
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}

//3 5
//#####
//#BOR#
//#####
// 1


//3 5
//#####
//#ROB#
//#####


//3 5
//#####
//#ORB#
//#####

//3 5
//#####
//#OBR#
//#####

//4 5
//#####
//#.BR#
//#.O##
//#####