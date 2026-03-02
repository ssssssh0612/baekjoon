package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현명한나이트_18404 {
    // (X-2,Y-1), (X-2,Y+1), (X-1,Y-2), (X-1,Y+2), (X+1,Y-2), (X+1,Y+2), (X+2,Y-1), (X+2,Y+1)
    static int[] dy = {-2,-2,-1,-1,1,1,2,2};
    static int[] dx = {-1,1,-2,2,-2,2,-1,1};
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;



        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(graph[now[0]][now[1]] == 0){
                graph[now[0]][now[1]] = now[2];
            }

            for (int i = 0; i < 8; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                // 범위안에 들어가고 방문해보지 않았다면
                if(checking(nextY, nextX) && !visited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int nowY = Integer.parseInt(st.nextToken()) - 1;
            int nowX = Integer.parseInt(st.nextToken()) - 1;
            sb.append(graph[nowY][nowX]).append(" ");
        }
        System.out.println(sb);
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
