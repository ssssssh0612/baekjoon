package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 준규와_사과_5913 {
    static int result = 0 ;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] graph = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            visited[y][x] = true;
        }
        visited[0][0] = true;
        // 0,0 에서 백트래킹을 시작해 h 에 도달하는데, 모두 방문한 경우의 수 ?
        backTracking(0,0);
        System.out.println(result);
    }
    public static boolean resultChecking(){
        // 모두 true 라면
        for(int i = 0 ; i < 5; i++){
            for(int j = 0 ; j < 5;  j++){
                if(!visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    // 현재 내 위치가 4,4 이고 visited checking 으로 검사하기
    public static void backTracking(int nowY, int nowX){
//        checking();
        if(nowY == 4 && nowX == 4) {
            if(resultChecking()){
                result++;
            }
            return;
        }
        for(int i = 0 ; i < 4; i ++){
            int nextY = nowY + dy[i];
            int nextX = nowX + dx[i];
            if(checking(nextY, nextX) && !visited[nextY][nextX]){
//                System.out.println("nextY = " + nextY + " nextX = " + nextX);
                visited[nextY][nextX] = true;
                backTracking(nextY, nextX);
                visited[nextY][nextX] = false;
            }
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < 5 && x < 5;
    }

    public static void checking(){
        System.out.println("=========현재 그래프========");
        for(int i = 0 ; i < 5; i ++){
            for(int j = 0 ; j < 5; j ++){
                int num = 1;
                if(!visited[i][j]){
                    num = 0;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
