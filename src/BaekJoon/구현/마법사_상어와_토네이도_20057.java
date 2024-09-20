package BaekJoon.구현;

import java.util.Scanner;

public class 마법사_상어와_토네이도_20057 {
    static int[][] graph;
    static int[] startPos = new int[2];
    // 서, 남, 동, 북
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir = 0;
    static int dis = 1;
    static int n;
    static int resultSand = 0 ;
    static int[][] copyGraph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        startPos[0] = n / 2;
        startPos[1] = n / 2;
        copyGraph = new int[n][n];
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                copyGraph[i][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            rotate(i);
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(copyGraph[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(resultSand);


    }

    // 회전하기
    // 현재 기준 방향으로
    public static void rotate(int number) {
        // dis 의 숫자에 따라 이동하는 횟수가 증가

        // 마지막은 길이 n-1 만큼 횟수 반복 3번
        if (number == n - 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < dis; j++) {
                    startPos[0] = startPos[0] + dy[dir];
                    startPos[1] = startPos[1] + dx[dir];
                    // 이동한 위치 기준으로 모래폭풍 일으키기
                    tornado( startPos[0] , startPos[1] );
                    copyGraph[startPos[0]][startPos[1]] = number;
                }
                // 횟수가 하나 증가할때마다 dir 증가
                if (dir != 3) {
                    dir++;
                } else {
                    // dir 이 3이면 0으로 다시 초기화
                    dir = 0;
                }
            }
        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < dis; j++) {
                    startPos[0] = startPos[0] + dy[dir];
                    startPos[1] = startPos[1] + dx[dir];
                    copyGraph[startPos[0]][startPos[1]] = number;
                    tornado( startPos[0] , startPos[1] );
                }
                // 횟수가 하나 증가할때마다 dir 증가
                if (dir != 3) {
                    dir++;
                } else {
                    // dir 이 3이면 0으로 다시 초기화
                    dir = 0;
                }
            }
        }
        // 방향은 한 사이클마다 증가
        dis++;


    }

    // 현재 들어온 값의 범위가 graph 안에 들어가는지 체크
    public static boolean checkingRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    public static void tornado(int y, int x) {
        // 모래양 저장
        int sand = graph[y][x];
        // 현재 모래양에서 얼마나 빠져야하는가
        int minusSandTotal = 0;
        switch (dir) {
            // 서쪽
            case 0:
                graph[y][x] = 0;
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x + 1, 1);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x + 1, 1);

                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y - 2, x, 2);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 2, x, 2);

                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x - 1, 10);
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x - 1, 10);

                minusSandTotal = minusSandTotal + minusSand( sand, y, x - 2, 5);
                if( checkingRange(y + dy[dir], x + dx[dir])){
                    graph[y + dy[dir]][x + dx[dir]] = graph[y + dy[dir]][x + dx[dir]] + (sand - minusSandTotal);
                }else{
                    resultSand = resultSand + (sand - minusSandTotal);
                }
                break;
            // 남쪽
            case 1:
                graph[y][x] = 0;
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x - 1, 1);
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x + 1, 1);

                minusSandTotal = minusSandTotal + minusSand( sand, y, x - 1, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y, x + 1, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y, x + 2, 2);
                minusSandTotal = minusSandTotal + minusSand( sand, y, x - 2, 2);

                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x - 1, 10);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x + 1, 10);

                minusSandTotal = minusSandTotal + minusSand( sand, y + 2, x, 5);
                if( checkingRange(y + dy[dir], x + dx[dir])){
                    graph[y + dy[dir]][x + dx[dir]] = graph[y + dy[dir]][x + dx[dir]] + (sand - minusSandTotal);
                }else{
                    resultSand = resultSand + (sand - minusSandTotal);
                }
                break;
            // 동쪽
            case 2:
                graph[y][x] = 0;
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x - 1, 1);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x - 1, 1);

                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y - 2, x, 2);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 2, x, 2);

                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x + 1, 10);
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x + 1, 10);

                minusSandTotal = minusSandTotal + minusSand( sand, y, x + 2, 5);
                if( checkingRange(y + dy[dir], x + dx[dir])){
                    graph[y + dy[dir]][x + dx[dir]] = graph[y + dy[dir]][x + dx[dir]] + (sand - minusSandTotal);
                }else{
                    resultSand = resultSand + (sand - minusSandTotal);
                }

                break;
            // 북쪽
            case 3:
                graph[y][x] = 0;
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x - 1, 10);
                minusSandTotal = minusSandTotal + minusSand( sand, y - 1, x + 1, 10);

                minusSandTotal = minusSandTotal + minusSand( sand, y, x - 1, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y, x + 1, 7);
                minusSandTotal = minusSandTotal + minusSand( sand, y, x + 2, 2);
                minusSandTotal = minusSandTotal + minusSand( sand, y, x - 2, 2);

                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x - 1, 1);
                minusSandTotal = minusSandTotal + minusSand( sand, y + 1, x + 1, 1);

                minusSandTotal = minusSandTotal + minusSand( sand, y - 2, x, 5);
                if( checkingRange(y + dy[dir], x + dx[dir])){
                    graph[y + dy[dir]][x + dx[dir]] = graph[y + dy[dir]][x + dx[dir]] + (sand - minusSandTotal);
                }else{
                    resultSand = resultSand + (sand - minusSandTotal);
                }
                break;
        }

    }
    // 비율에 따라 모래가 얼마나 사라지는지에대해
    public static int minusSand( int sand, int y , int x, int percent){ // 전체 모래양, 해당 위치, 몇퍼센트인지
        // 범위에 들어가는지 체크하고 범위에 들어간다면
        if(checkingRange(y,x)){
            graph[y][x] = graph[y][x] + (percent * sand / 100);
            return percent * sand / 100;
        }else{
            resultSand = resultSand + (percent * sand / 100);
            return percent * sand / 100;
        }
    }

}
