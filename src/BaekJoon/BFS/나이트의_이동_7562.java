package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의_이동_7562 {
    // 나이트의 8가지 경우의 수
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int resultX;
    static int resultY;
    static int[][] distance;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<Integer[]> queue = new LinkedList<Integer[]>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            distance = new int[n][n];
            graph = new int[n][n];
            visited = new boolean[n][n];
            int x = sc.nextInt();
            int y = sc.nextInt();
            resultX = sc.nextInt();
            resultY = sc.nextInt();
            bfs(x,y,n);
            System.out.println(distance[resultX][resultY]);
        }
    }
    public static void bfs(int startX, int startY, int n) {
        distance[startX][startY] = 0;
        visited[startX][startY] = true;
        queue.add(new Integer[]{startX, startY});
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                if(now[0]+dx[i] >= 0 && now[1]+dy[i] >= 0 &&
                 now[0]+dx[i] < n && now[1]+dy[i] < n && !visited[now[0] + dx[i]][now[1] + dy[i]]){
                    distance[now[0]+dx[i]][now[1]+dy[i]] = distance[now[0]][now[1]] + 1;
                    visited[now[0]+dx[i]][now[1]+dy[i]] = true;
                    queue.add(new Integer[]{now[0]+dx[i],now[1]+dy[i]});
                }
            }
        }
    }
}
