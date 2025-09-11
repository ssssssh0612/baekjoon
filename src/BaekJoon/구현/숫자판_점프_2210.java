package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판_점프_2210 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] graph = new int[5][5];
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = graph[i][j];
                for (int k = 0; k < 4; k++) {
                    StringBuilder sb = new StringBuilder().append(num);
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if(checking(nextY,nextX)){
                        sb.append(graph[nextY][nextX]);
                        dfs(nextY,nextX,1,sb);
                    }
                }
            }
        }
        System.out.println(set.size());
    }
    public static void dfs(int nowY, int nowX, int depth, StringBuilder sb){
        if(depth == 5){
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = nowY + dy[i];
            int nextX = nowX + dx[i];
            if(checking(nextY,nextX)){
                StringBuilder newSb = new StringBuilder();
                newSb.append(sb.toString()).append(graph[nextY][nextX]);
                dfs(nextY, nextX, depth + 1, newSb);
            }
        }


    }
    public static boolean checking(int y, int x){
        return y>=0 && x >=0 && y < 5 && x < 5;
    }
}
