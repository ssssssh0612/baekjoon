package BaekJoon.DFS;

//public class 적록색약_10026 {
//    static char[][] arr;
//    static char[][] arr2;
//    // 상,하,좌,우
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//    static int count;
//    static int height;
//
//    public static void main(String[] args) {
//        // 0 으로 바꿔서 그냥 구역자체를 없애버리자
//        // R,G,B 구역을 dfs 실시
//        Scanner sc = new Scanner(System.in);
//        height = sc.nextInt();
//        sc.nextLine();
//        arr = new char[height][height];
//        arr2 = new char[height][height];
//        for (int i = 0; i < height; i++) {
//            String a = sc.nextLine();
//            for (int j = 0; j < height; j++) {
//                arr[i][j] = a.charAt(j);
//                arr2[i][j] = a.charAt(j);
//            }
//        }
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < height; j++) {
//                if (arr[i][j] != '0') {
//                    dfs(i, j, arr[i][j]);
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//        count = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < height; j++) {
//                if (arr2[i][j] != '0') {
//                    dfs2(i, j, arr2[i][j]);
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }
//
//    public static void dfs(int i, int j, char a) {
//        arr[i][j] = '0';
//        for (int k = 0; k < 4; k++) {
//            if (j + dy[k] >= 0 && i + dx[k] >= 0 && height > j + dy[k] &&
//                    height > i + dx[k] && arr[i + dx[k]][j + dy[k]] == a) {
//                dfs(i + dx[k], j + dy[k], a);
//            }
//        }
//    }
//
//    public static void dfs2(int i, int j, char a) {
//        arr2[i][j] = '0';
//        if (a == 'R') {
//            for (int k = 0; k < 4; k++) {
//                if (j + dy[k] >= 0 && i + dx[k] >= 0 && height > j + dy[k] &&
//                        height > i + dx[k] && arr2[i + dx[k]][j + dy[k]] == 'R') {
//                    dfs2(i + dx[k], j + dy[k], a);
//                } else if (j + dy[k] >= 0 && i + dx[k] >= 0 && height > j + dy[k] &&
//                        height > i + dx[k] && arr2[i + dx[k]][j + dy[k]] == 'G') {
//                    dfs2(i + dx[k], j + dy[k], a);
//                }
//            }
//        } else if (a == 'G') {
//            for (int k = 0; k < 4; k++) {
//                if (j + dy[k] >= 0 && i + dx[k] >= 0 && height > j + dy[k] &&
//                        height > i + dx[k] && arr2[i + dx[k]][j + dy[k]] == 'R') {
//                    dfs2(i + dx[k], j + dy[k], a);
//                } else if (j + dy[k] >= 0 && i + dx[k] >= 0 && height > j + dy[k] &&
//                        height > i + dx[k] && arr2[i + dx[k]][j + dy[k]] == 'G') {
//                    dfs2(i + dx[k], j + dy[k], a);
//                }
//            }
//        } else {
//            for (int k = 0; k < 4; k++) {
//                if (j + dy[k] >= 0 && i + dx[k] >= 0 && height > j + dy[k] &&
//                        height > i + dx[k] && arr2[i + dx[k]][j + dy[k]] == a) {
//                    dfs2(i + dx[k], j + dy[k], a);
//                }
//            }
//        }
//    }
//}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약_10026 {
    static int[][] arr;
    static int[][] greenArr;
    static Queue<int[]> queue = new LinkedList<>();
    static int count;
    static int greenCount;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+2][n+2];
        greenArr = new int[n+2][n+2];
        sc.nextLine();
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                arr[i][j] = -1;
                greenArr[i][j] = -1;
            }
        }
        // R == 0
        // G == 1
        // B == 2
        for (int i = 1; i < n + 1; i++) {
            String a = sc.nextLine();
            for (int j = 1; j < n + 1; j++) {
                if(a.charAt(j - 1) == 'R'){
                    arr[i][j] = 0;
                    greenArr[i][j] = 0;
                }else if(a.charAt(j - 1) == 'G'){
                    arr[i][j] = 1;
                    greenArr[i][j] = 0;
                }else{
                    arr[i][j] = 2;
                    greenArr[i][j] = 1;
                }
            }
        }
        // 한번에 진행할 순 없을까 ?
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(arr[i][j] != -1){
//                    dfs(i,j,arr[i][j],arr);
                    bfs(i,j,arr[i][j],arr);
                    count++;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(greenArr[i][j] != -1){
//                    dfs(i,j,greenArr[i][j],greenArr);
                    bfs(i,j,greenArr[i][j],greenArr);
                    greenCount++;
                }
            }
        }
        System.out.println(count+" "+greenCount);


    }
    public static void dfs(int y, int x, int number, int[][] arr1) {
        arr1[y][x] = -1;
        for (int i = 0; i < 4; i++) {
            if( arr1[y + dy[i]][x + dx[i]] == number ){
                dfs(y + dy[i], x + dx[i], number, arr1);
            }
        }
    }
    public static void bfs(int y, int x, int number, int[][]arr1){
        arr1[y][x] = -1;
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if( arr1[now[0] + dy[i]][now[1] + dx[i]] == number ){
                    queue.add(new int[]{now[0] + dy[i], now[1] + dx[i]});
                    arr1[now[0] + dy[i]][now[1] + dx[i]] = -1;
                }
            }
        }
    }
}


