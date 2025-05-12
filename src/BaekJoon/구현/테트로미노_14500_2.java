package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500_2 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] graph;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                dfs(i, j, i, j, 0, graph[i][j]);
                check(i,j);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int nowY, int nowX, int beforeY, int beforeX, int count, int sum) {
        if(count == 3){
            result = Math.max(sum, result);
            return;
        }
        // 이전 장소랑 같으면 안됨
        for (int i = 0; i < 4; i++) {
            int nextY = nowY + dy[i];
            int nextX = nowX + dx[i];
            if (checking(nextY, nextX) && (nextY != beforeY || nextX != beforeX)) {
                dfs(nextY,nextX,nowY,nowX,count + 1, sum + graph[nextY][nextX]);
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    public static void check(int y, int x){
        int count = 0;
        int sum = graph[y][x];
        for(int i = 0 ; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(!checking(nextY,nextX)){
                count++;
            }else{
                sum += graph[nextY][nextX];
            }
        }
        if(count > 1){
            return;
        }

        if(count == 1){
            result = Math.max(sum, result);
            return;
        }

        for(int i = 0 ; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            int num = graph[nextY][nextX];
            result = Math.max(sum - num, result);
        }
    }
}
