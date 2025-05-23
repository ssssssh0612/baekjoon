package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질1_2_1697 {
    static boolean[][] visited = new boolean[100001][3];
    static int startNum;
    static int endNum;
    static int result = 0;
    static boolean checking = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        endNum = Integer.parseInt(st.nextToken());
        if(endNum == startNum ){
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        if (startNum + 1 <= 100000 ) {
            queue.add(new int[]{startNum + 1, 1});
            visited[startNum + 1][0] = true;
        }

        if (startNum > 0) {
            queue.add(new int[]{startNum - 1, 1});
            visited[startNum - 1][1] = true;
        }

        if (2 * startNum <= 100000) {
            queue.add(new int[]{startNum * 2, 0});
            visited[2 * startNum][2] = true;
        }
        while (!queue.isEmpty()) {
            // 큐가 비어있지 않다면
            int[] now = queue.poll();
            if (now[0] == endNum && !checking) {
                checking = true;
                result = now[1];
            }else if(now[0] == endNum){
                result = Math.min(result,now[1]);
            }
            int nowNumber = now[0];
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int nextNumber = nowNumber + 1;
                    if (nextNumber < 100001 && !visited[nextNumber][0]) {
                        queue.add(new int[]{nextNumber, now[1] + 1});
                        visited[nextNumber][0] = true;
                    }
                } else if (i == 1) {
                    int nextNumber = nowNumber - 1;
                    if (nextNumber >= 0 && !visited[nextNumber][1] ) {
                        queue.add(new int[]{nextNumber, now[1] + 1});
                        visited[nextNumber][1] = true;
                    }
                } else {
                    int nextNumber = nowNumber * 2;
                    if (nextNumber < 100001 && !visited[nextNumber][2]) {
                        queue.add(new int[]{nextNumber, now[1]});
                        visited[nextNumber][2] = true;
                    }
                }
            }
        }
    }
}
