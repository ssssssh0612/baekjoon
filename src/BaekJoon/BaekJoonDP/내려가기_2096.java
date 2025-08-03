package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기_2096 {
    static int[] dy = {1,1,1};
    static int[] dx = {-1,0,1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        int[][] dp1 = new int[n][3];
        int[][] dp2 = new int[n][3];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp1[0][0] = arr[0][0];
        dp1[0][1] = arr[0][1];
        dp1[0][2] = arr[0][2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp2[i][j] = Integer.MAX_VALUE;
            }
        }

        dp2[0][0] = arr[0][0];
        dp2[0][1] = arr[0][1];
        dp2[0][2] = arr[0][2];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                // 현재 위치가 범위에 들면 들어가서 조사하기
                for (int k = 0; k < 3; k++) {
                    int nextY = dy[k] + i;
                    int nextX = dx[k] + j;
                    if(checking(nextY, nextX)){
                        // 범위 안에 들면 dp 테이블 최신화
                        dp1[nextY][nextX] = Math.max(dp1[nextY][nextX], dp1[i][j] + arr[nextY][nextX]);
                    }
                }
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                // 현재 위치가 범위에 들면 들어가서 조사하기
                for (int k = 0; k < 3; k++) {
                    int nextY = dy[k] + i;
                    int nextX = dx[k] + j;
                    if(checking(nextY, nextX)){
                        // 범위 안에 들면 dp 테이블 최신화
                        dp2[nextY][nextX] = Math.min(dp2[nextY][nextX], dp2[i][j] + arr[nextY][nextX]);
                    }
                }
            }
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max1 = Math.max(dp1[arr.length - 1][i], max1);
        }

        for (int i = 0; i < 3; i++) {
            max2 = Math.min(dp2[arr.length - 1][i], max2);
        }

        System.out.println(max1 + " " + max2);



    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < arr.length && x < arr[0].length;
    }
}
