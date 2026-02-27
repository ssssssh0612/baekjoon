package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영상처리_21938 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        int[][] number = new int[y][x * 3];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < number[0].length; j++) {
                int num = Integer.parseInt(st.nextToken());
                number[i][j] = num;
            }
        }

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < y; i++) {
            int sum = 0;
            int index = 0;
            int indexX = 0;
            for (int j = 0; j < number[0].length; j++) {
                sum += number[i][j];
                index++;
                if(index == 3){
                    int newNum = sum / 3;
                    if(newNum >= num){
                        graph[i][indexX] = 1;
                    }else{
                        graph[i][indexX] = 0;
                    }
                    index = 0;
                    sum = 0;
                    indexX++;
                }
            }
        }

        visited = new boolean[y][x];
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 1 && !visited[i][j]){
                    result++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);
    }
    public static void dfs(int startY, int startX){
        for (int i = 0; i < 4; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];
            if(checking(nextY, nextX) && graph[nextY][nextX] == 1&& !visited[nextY][nextX]){
                visited[nextY][nextX] = true;
                dfs(nextY,nextX);
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
