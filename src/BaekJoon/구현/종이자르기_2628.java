package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 종이자르기_2628 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static boolean[][] graph;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());
        List<Integer> garo = new ArrayList<>();
        List<Integer> sero = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            // 가로인지, 세로인지
            int check = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if(check == 0){
                garo.add(number);
            }else{
                sero.add(number);
            }
        }

        graph = new boolean[y + garo.size()][x + sero.size()];
        Collections.sort(garo);
        Collections.sort(sero);
        for (int i = 0; i < garo.size(); i++) {
            int number = garo.get(i);
            for (int j = 0; j < graph[0].length; j++) {
                graph[number + i][j] = true;
            }
        }

        for (int i = 0; i < sero.size(); i++) {
            int number = sero.get(i);
            for (int j = 0; j < graph.length; j++) {
                graph[j][number + i] = true;
            }
        }
        visited = new boolean[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                // 얘가 false면 들어가기
                if(!visited[i][j] && !graph[i][j]){
                    visited[i][j] = true;
                    dfs(i,j, 1);
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs(int y, int x, int count){
        for (int i = 0; i < 4; i++) {
            int nextY = dy[i] + y;
            int nextX = dx[i] + x;
            if(checking(nextY,nextX) && !visited[nextY][nextX] && !graph[nextY][nextX]){
                visited[nextY][nextX] = true;
                dfs(nextY,nextX,count + 1);
            }
        }
        result = Math.max(result, count);
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < visited.length && x < visited[0].length;
    }
}
