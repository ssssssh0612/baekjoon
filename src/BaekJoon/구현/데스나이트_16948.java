package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트_16948 {
        // (r, c)라면, (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
    static int[] dy = {-2,-2,0,0,2,2};
    static int[] dx = {-1,1,-2,2,-1,1};
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());

        int endY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == endY && now[1] == endX){
                System.out.println(now[2]);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                }
            }
        }
        System.out.println(-1);
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
