package BaekJoon.구현;

import java.util.Scanner;

public class 달팽이_1913 {
    // 하 우 상 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = sc.nextInt();
        int x = 0;
        int y = 0;
        arr = new int[n + 2][n + 2];
        arr[1][1] = n * n;
        boolean flag = true;
        dfs(1, 1, n);


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(arr[i][j] == result){
                    x = j;
                    y = i;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(y+" "+x);
    }

    public static void dfs(int y, int x, int n) {
        if(arr[y][x] == 1) {
            return;
        }
        else if (y + dy[dir % 4] > 0 && x + dx[dir % 4] > 0 &&
                y + dy[dir % 4] <= n && x + dx[dir % 4] <= n &&
                arr[y + dy[dir % 4]][x + dx[dir % 4]] == 0) {

            arr[y + dy[dir % 4]][x + dx[dir % 4]] = arr[y][x] - 1;
            dfs(y + dy[dir % 4], x + dx[dir % 4], n);

        } else if (y + dy[dir % 4] <= 0 || x + dx[dir % 4] <= 0 ||
                y + dy[dir % 4] > n || x + dx[dir % 4] > n ||
                arr[y + dy[dir % 4]][x + dx[dir % 4]] != 0) {

            dir++;
            arr[y + dy[dir % 4]][x + dx[dir % 4]] = arr[y][x] - 1;
            dfs(y + dy[dir % 4], x + dx[dir % 4], n);
        }
    }
}
