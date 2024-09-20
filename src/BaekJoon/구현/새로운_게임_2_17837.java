package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 새로운_게임_2_17837 {
    static int n;
    static int k;
    static int[][] graph;
    static List<int[]> kCase = new ArrayList<int[]>();
    // 우, 좌, 상, 하
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean flag = true;

    // 단독으로 있을땐 상관 없음 그러므로 같은게 생긴다면 해당 위치에 두개이상의 말이 겹치면 추가해주기
    static ArrayList<Integer>[][] graphHorse;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        graph = new int[n][n];
        graphHorse = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 0은 흰색, 1은 빨간색, 2는 파란색이다.
                graph[i][j] = sc.nextInt();
                graphHorse[i][j] = new ArrayList<Integer>();
//                graphHorse[i][j].add(0);
            }
        }

        for (int i = 0; i < k; i++) {
            // y, x, 이동방향
            kCase.add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1});
            graphHorse[kCase.get(i)[0]][kCase.get(i)[1]].add(i + 1);
        }
        checkingHorseHouse();
        int count = 0;
        while (count <= 1000) {
            boolean checking = false;
            for (int i = 0; i < kCase.size(); i++) {
                moving(i);
                resultChecking();
                if(!flag){
                    checking = true;
                    break;
                }
            }
            if(checking){
                break;
            }else{
                count++;
            }
        }
        if(count == 1001){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }


    }

    public static void moving(int number) {
        // 일단 말의 이동위치에대해 판단하기
        int dir = kCase.get(number)[2];
        // 우리가 옮길 위치
        int nowY = kCase.get(number)[0] + dy[dir];
        int nowX = kCase.get(number)[1] + dx[dir];
        // 이동위치가 범위에 벗어나지않고 해당 graph 의 위치가 0 이면 흰색
        if (checking(nowY, nowX) && graph[nowY][nowX] == 0) {
            // 옮길놈들을 정해주기
            List<int[]> moveList = moveList(kCase.get(number)[0], kCase.get(number)[1], number);
            // 흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
            // A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
            // 예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
            if (moveList.size() > 1) {
                // 옮겨야될게 2개 이상인경우
                for (int i = 0; i < moveList.size(); i++) {
                    int y = moveList.get(i)[0];
                    int x = moveList.get(i)[1];
                    int value = moveList.get(i)[2];
                    graphHorse[y][x].remove((Integer) value);
                    kCase.get(value)[0] = nowY;
                    kCase.get(value)[1] = nowX;
                    graphHorse[kCase.get(value)[0]][kCase.get(value)[1]].add(0, value);
                }
            } else {
                // 옮겨야될게 1개인경우
                graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].remove((Integer) number);
                kCase.get(number)[0] = nowY;
                kCase.get(number)[1] = nowX;
                graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].add(0, number);
            }
        } else if (checking(nowY, nowX) && graph[nowY][nowX] == 1) {
            List<int[]> moveList = moveList(kCase.get(number)[0], kCase.get(number)[1], number);
            // 빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
            // A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
            // A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
            if (moveList.size() > 1) {
                for (int i = moveList.size() - 1; i >= 0; i--) {
                    int y = moveList.get(i)[0];
                    int x = moveList.get(i)[1];
                    int value = moveList.get(i)[2];
                    graphHorse[y][x].remove((Integer) value);
                    kCase.get(value)[0] = nowY;
                    kCase.get(value)[1] = nowX;
                    kCase.get(value)[2] = changeDir(kCase.get(value)[2]);
                    graphHorse[kCase.get(value)[0]][kCase.get(value)[1]].add(0, value);
                }
            } else {
                // 옮겨야될게 1개인경우 그냥 이동
                graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].remove((Integer) number);
                kCase.get(number)[0] = nowY;
                kCase.get(number)[1] = nowX;
                graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].add(0, number);
                kCase.get(number)[2] = changeDir(kCase.get(number)[2]);
            }
            // 말의 이동 위치가 범위에 벗어나면 파란색
            // 이동위치가 범위에 벗어나지않고 해당 graph 의 위치가 2 이면 파란색
        } else if ((checking(nowY, nowX) && graph[nowY][nowX] == 2) || (!checking(nowY, nowX))) {
            kCase.get(number)[2] = changeDir(kCase.get(number)[2]);
            int newDir = kCase.get(number)[2];
            int newY = kCase.get(number)[0] + dy[newDir];
            int newX = kCase.get(number)[1] + dx[newDir];
            // 흰색
            if (graph[newY][newX] == 0) {
                // 옮길놈들을 정해주기
                List<int[]> moveList = moveList(kCase.get(number)[0], kCase.get(number)[1], number);
                // 흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
                // A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
                // 예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
                if (moveList.size() > 1) {
                    // 옮겨야될게 2개 이상인경우
                    for (int i = 0; i < moveList.size(); i++) {
                        int y = moveList.get(i)[0];
                        int x = moveList.get(i)[1];
                        int value = moveList.get(i)[2];
                        graphHorse[y][x].remove((Integer) value);
                        kCase.get(value)[0] = newY;
                        kCase.get(value)[1] = newX;
                        graphHorse[kCase.get(value)[0]][kCase.get(value)[1]].add(0, value);
                    }
                } else {
                    // 옮겨야될게 1개인경우
                    graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].remove((Integer) number);
                    kCase.get(number)[0] = newY;
                    kCase.get(number)[1] = newX;
                    graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].add(0, number);
                }
            } else if (graph[newY][newX] == 1) {
                // 빨간색
                List<int[]> moveList = moveList(kCase.get(number)[0], kCase.get(number)[1], number);
                // 빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
                // A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
                // A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
                if (moveList.size() > 1) {
                    for (int i = moveList.size() - 1; i >= 0; i--) {
                        int y = moveList.get(i)[0];
                        int x = moveList.get(i)[1];
                        int value = moveList.get(i)[2];
                        graphHorse[y][x].remove((Integer) value);
                        kCase.get(value)[0] = newY;
                        kCase.get(value)[1] = newX;
                        kCase.get(value)[2] = changeDir(kCase.get(value)[2]);
                        graphHorse[kCase.get(value)[0]][kCase.get(value)[1]].add(0, value);
                    }
                } else {
                    // 옮겨야될게 1개인경우 그냥 이동
                    graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].remove((Integer) number);
                    kCase.get(number)[0] = newY;
                    kCase.get(number)[1] = newX;
                    graphHorse[kCase.get(number)[0]][kCase.get(number)[1]].add(0, number);
                    kCase.get(number)[2] = changeDir(kCase.get(number)[2]);
                }
            }
        }
    }

    // 범위에 벗어나는지 안벗어나는지 체크하기
    public static boolean checking(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    public static List<int[]> moveList(int y, int x, int value) {
        List<int[]> moveList = new ArrayList<>();
        // 현재 위치를 나타내는 y,x
        int index = graphHorse[y][x].indexOf(value + 1);
            System.out.println(index+"=============");
        // 옮겨야될게 자신 포함 2개 이상인경우
        if (graphHorse[y][x].size() > 1 && index > 0) {
            for (int i = graphHorse[y][x].get(index); i >= 0; i--) {
                moveList.add(new int[]{y, x, graphHorse[y][x].get(index)});
            }
        } else { // 1이라면 옮길게 하나이거나 맨 위에있을경우
            moveList.add(new int[]{y, x, graphHorse[y][x].get(index)});
        }
        return moveList;
    }

    public static int changeDir(int dir) {
        switch (dir) {
            case 0:
                dir = 1;
                break;
            case 1:
                dir = 0;
                break;
            case 2:
                dir = 3;
                break;
            case 3:
                dir = 2;
                break;
        }
        return dir;
    }

    public static void resultChecking() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(graphHorse[i][j].size()+"말길이");
                if (graphHorse[i][j].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
    }

    public static void checkingHorseHouse(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < graphHorse[i][j].size(); l++) {
                    System.out.print(graphHorse[i][j].get(l));
                }
            }
            System.out.println();
        }
    }
}
