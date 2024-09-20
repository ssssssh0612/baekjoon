package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 마법사_상어와_블리자드 {
    static int n;
    static int caseCount;
    static int[][] graph;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 첫번째 결과 삭제 구슬 개수
    static int result1 = 0;
    static int result2 = 0;
    static int result3 = 0;

    static int sharkPosY = 0;
    static int sharkPosX = 0;

    // 좌 하 우 상
    static int[] dx1 = {-1, 0, 1, 0};
    static int[] dy1 = {0, 1, 0, -1};

    static List<int[]> caseCountList = new ArrayList<int[]>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        caseCount = sc.nextInt();
        graph = new int[n][n];
        sharkPosY = n / 2;
        sharkPosX = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < caseCount; i++) {
            // 방향 di와 거리 si
            caseCountList.add(new int[]{sc.nextInt() - 1, sc.nextInt()});
        }

        destroy1();

        checkingGraph();

    }

    // 그래프 복사하기
    public static int[][] copyGraph() {
        int[][] copyGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
        return copyGraph;
    }

    public static void checkingGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void destroy1() {
        // 복사할 필요없이 나머지 0의 개수를 뒤로 보내면 됨
        // 방향 di와 거리 si
        // 방향
        int direction = caseCountList.get(0)[0];
        // 거리
        int distance = caseCountList.get(0)[1];

        List<int[]> zeroList = new ArrayList<>();
        for (int i = 1; i <= distance; i++) {
            graph[sharkPosY + i * dy[direction]][sharkPosX + i * dx[direction]] = 0;
        }
        // checking 하는 만큼 현재 방향에서 더해주기
        int checking = 1;
        int checkingCount = 0;
        int startY = sharkPosY;
        int startX = sharkPosX;
        int dir = 0;
        while (checking < n) {
            // 마지막으로 더해준다면?
            if (checking == n - 1) {
                for (int i = 1; i <= checking; i++) {
                    startY = startY + dy[dir];
                    startX = startX + dx[dir];
                    if (graph[startY][startX] == 0) {
                        pushBack(i, checking, dir, checkingCount, startY, startX);
                    }
                }
                if (checkingCount == 0) {
                    checkingCount++;
                    dir = checkingDir(dir);

                } else {
                    checkingCount = 0;
                    dir = checkingDir(dir);
                    checking++;
                }
            } else {
                // 마지막으로 더해주는게 아니라면 ?
                for (int i = 1; i <= checking; i++) {
                    startY = startY + dy[dir];
                    startX = startX + dx[dir];
                    if (graph[startY][startX] == 0) {
                        pushBack(i, checking, dir, checkingCount, startY, startX);
                    }
                }
                if (checkingCount == 0) {
                    checkingCount++;
                    dir = checkingDir(dir);

                } else {
                    checkingCount = 0;
                    dir = checkingDir(dir);
                    checking++;
                }
            }
            // 돌면서 내가 0 이고 다음숫자가 양수라면
        }


        caseCountList.remove(0);
    }

    public static void destroy2() {


    }

    public static void destroy3() {


    }

    public static int checkingDir(int dir) {
        if (dir == 3) {
            dir = 0;
        }
        return ++dir;
    }

    public static void pushBack(int iNumber, int checking, int dir, int checkingCount, int y, int x) {
        // y, x 는 현재 0 인 지점
        int[] temp = new int[2];
        int tempNumber = 0;
        for (int i = iNumber; i <= checking; i++) {
            temp[0] = y;
            temp[1] = x;
            y = y + dy[dir];
            x = x + dx[dir];
            tempNumber = graph[y][x];
            graph[temp[0]][temp[1]] = tempNumber;
            graph[y][x] = 0;
            if (checkingCount == 0) {
                checkingCount++;
                dir = checkingDir(dir);

            } else {
                checkingCount = 0;
                dir = checkingDir(dir);
                checking++;
            }
        }
        if(checkingCount == 3){
            return;
        }

        while (checking < n) {
            // 마지막으로 더해준다면?
            if (checking == n - 1) {
                for (int i = 1; i <= checking; i++) {
                    temp[0] = y;
                    temp[1] = x;
                    y = y + dy[dir];
                    x = x + dx[dir];
                    tempNumber = graph[y][x];
                    graph[temp[0]][temp[1]] = tempNumber;
                    graph[y][x] = 0;
                    if (checkingCount < 3) {
                        checkingCount++;
                        dir = checkingDir(dir);
                    }
                }
            } else {
                // 마지막으로 더해주는게 아니라면 ?
                for (int i = 1; i <= checking; i++) {
                    temp[0] = y;
                    temp[1] = x;
                    y = y + dy[dir];
                    x = x + dx[dir];
                    tempNumber = graph[y][x];
                    graph[temp[0]][temp[1]] = tempNumber;
                    graph[y][x] = 0;
                    if (checkingCount == 0) {
                        checkingCount++;
                        dir = checkingDir(dir);

                    } else {
                        checkingCount = 0;
                        dir = checkingDir(dir);
                        checking++;
                    }
                }

                if (checkingCount == 0) {
                    checkingCount++;
                    dir = checkingDir(dir);

                } else {
                    checkingCount = 0;
                    dir = checkingDir(dir);
                    checking++;
                }
            }

            if( checkingCount == 3){
                break;
            }
        }
    }
}

