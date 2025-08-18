package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠_2580 {
    static boolean flag = false;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 값 집어넣기
                arr[i][j] = num;
            }
        }

        backTracking();

    }
    public static void backTracking(){
        if(flag){
            return;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 1부터 시작해서 9까지
                if(arr[i][j] == 0){
                    boolean[] visited = checking(i, j);
                    // 이미 나온 숫자들 거르기
                    for (int k = 1; k < 10; k++) {
                        if (!visited[k]) {
                            // 하나 골라서 넣어주기
                            arr[i][j] = k;
                            backTracking();
                            arr[i][j] = 0;
                        }
                    }
                    return;
                }

            }
        }
        flag = true;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean[] checking(int y, int x) {
        boolean[] visited = new boolean[10];

        // 현재 위치에서 십자가를 그려 포함된 숫자 생각하기
        check1(y, x, 0, visited);
        check1(y, x, 1, visited);
        check1(y, x, 2, visited);
        check1(y, x, 3, visited);

        // 현재 위치에 따른 사분면 나누기
        // 현재 위치를 3으로 나눴을때
        int[] startPos = check2(y, x);
        for(int i = startPos[0]; i < startPos[0] + 3; i ++){
            for(int j = startPos[1]; j < startPos[1] + 3; j ++){
                int num = arr[i][j];
                if(num > 0){
                    visited[num] = true;
                }
            }
        }

        return visited;
    }
    public static void check1(int y, int x, int dir, boolean[] visited){
        int nowY = y + dy[dir];
        int nowX = x + dx[dir];
        while(true){
            if(checkingRange(nowY, nowX)){
                int num = arr[nowY][nowX];
                if(num > 0){
                    visited[num] = true;
                }
                nowY = nowY + dy[dir];
                nowX = nowX + dx[dir];
            }else{
                break;
            }
        }
    }
    public static int[] check2(int y, int x){
        int newY = y / 3 * 3;
        int newX = x / 3 * 3;
        return new int[]{newY, newX};
    }

    public static boolean checkingRange(int y , int x){
        return y >= 0 && x >= 0 && y < 9 && x < 9 ;
    }
}
