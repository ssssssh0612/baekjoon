package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 농장_관리_1245 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0,-1,-1,1,1};
    static int[] dx = {0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(!visited[i][j] && graph[i][j] > 0){
                    result += bfs(i,j);
//                    System.out.println(result);
//                    checking();
                }
            }
        }
        System.out.println(result);

    }
    public static void checking(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(visited[i][j]){
                    System.out.print(1 + " ");
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        int num = graph[y][x];
        queue.add(new int[]{y, x});
        int count = 1;
        boolean flag = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if(checking(nextY, nextX) && graph[nextY][nextX] == num && !visited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }else if(checking(nextY, nextX) && graph[nextY][nextX] > num){
                    flag = false;
                }
            }
        }
        if (!flag) {
            count--;
        }
        return count;
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
