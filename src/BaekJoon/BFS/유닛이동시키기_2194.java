package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유닛이동시키기_2194 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] nowPos = new int[2];
    static int[] endPos = new int[2];
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int a;
    static int b;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        visited = new boolean[(n - a) + 1][(m - b) + 1];
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x] = 1;
        }
        st = new StringTokenizer(br.readLine());
        nowPos[0] = Integer.parseInt(st.nextToken()) - 1;
        nowPos[1] = Integer.parseInt(st.nextToken()) - 1;

        visited[nowPos[0]][nowPos[1]] = true;

        st = new StringTokenizer(br.readLine());
        endPos[0] = Integer.parseInt(st.nextToken()) - 1;
        endPos[1] = Integer.parseInt(st.nextToken()) - 1;

        bfs();

        System.out.println(result);

    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowPos[0], nowPos[1], 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == endPos[0] && now[1] == endPos[1]){
                result = now[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && !visited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX, now[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static boolean checking(int nextY, int nextX){
        if(!checkingRange(nextY,nextX)){
            return false;
        }
        for (int i = nextY; i < nextY + a; i++) {
            for (int j = nextX; j < nextX + b; j++) {
                if(graph[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkingRange(int y , int x){
        return y >= 0 && x >= 0 && y < visited.length && x < visited[0].length;
    }
}
