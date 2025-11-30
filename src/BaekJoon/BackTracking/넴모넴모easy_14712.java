package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 넴모넴모easy_14712 {
    static boolean[][] visited;
    static int n;
    static int m;
    // y-1, x-1| y-1, x
    // y, x-1  | y,x
    static int[] dy = {-1,0,-1};
    static int[] dx = {-1,-1,0};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        
        dfs(0,0, 0);
        System.out.println(result);
    }
    // 이차원 배열로도 구현이 가능한가 ?

    public static void dfs(int nowY, int nowX, int depth){
        if(nowX == m){
            nowY = nowY + 1;
            nowX = 0;
        }

        if(nowY == n){
            result++;
            return;
        }

        dfs(nowY, nowX + 1, depth + 1);

        visited[nowY][nowX] = true;
        if(!checking(nowY, nowX)){
            dfs(nowY, nowX + 1, depth + 1);
        }
        visited[nowY][nowX] = false;
    }

    public static boolean checking(int nowY, int nowX){
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if(checkingLength(nowY + dy[i], nowX + dx[i]) && visited[nowY + dy[i]][nowX + dx[i]]){
                count++;
            }
        }
        return count == 3;
    }

    public static boolean checkingLength(int nowY, int nowX){
        return nowY >= 0 && nowX >= 0 && nowY < n && nowX < m;
    }
}
