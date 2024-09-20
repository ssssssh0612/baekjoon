package BaekJoon.구현;

import java.util.ArrayList;
import java.util.Scanner;

public class 청소년_상어_19236 {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int sharkY;
    static int sharkX;
    static int sharkDir = 0;
    static int RESULT = 0;
    static ArrayList<Integer>[][] graph = new ArrayList[4][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                graph[i][j] = new ArrayList<Integer>();
                graph[i][j].add(sc.nextInt());
                graph[i][j].add(sc.nextInt() - 1);
            }
        }
        sharkDir = graph[0][0].get(1);
        RESULT = graph[0][0].get(0);
        sharkY = 0;
        sharkX = 0;
        // index, value
        graph[0][0].set(0, 0);
        graph[0][0].set(1, 0);
//        System.out.println("DIR"+sharkDir);
        for (int i = 1; i <= 16; i++) {
            movingFish(i, graph);
//            checkingGraph(graph);
        }

        int rangeCount = 0;
        int zeroCount = 0;

        for (int j = 1; j <= 3; j++) {
            int newY = dy[sharkDir] * j;
            int newX = dx[sharkDir] * j;
            if(moveShark(newY,newX)){
                rangeCount++;
            }
        }

        for (int j = 1; j <= 3; j++) {
            int newY = dy[sharkDir] * j;
            int newX = dx[sharkDir] * j;
            if (moveShark(newY, newX) && graph[newY][newX].get(0) == 0) {
                zeroCount++;
            }
        }

//        System.out.println("DIR"+sharkDir);
//        checkingGraph(graph);
        backTracking(sharkY, sharkX, sharkDir, rangeCount,zeroCount,RESULT, graph);

        System.out.println(RESULT);
    }

    //
    public static void backTracking(int y, int x, int dir, int rangeCount, int zeroCount, int result, ArrayList<Integer>[][] copyGraph) {
        if(rangeCount == zeroCount){
            RESULT = Math.max(RESULT, result);
                    return;
        }

        for (int i = 1; i <= 3; i++) {
            ArrayList<Integer>[][] newCopyGraph = new ArrayList[4][4];

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (copyGraph[j][k] != null) {
                        newCopyGraph[j][k] = new ArrayList<>(copyGraph[j][k]);
                    }
                }
            }
            // 상어가 해당 위치로 움직이고,
            int nowY = y + dy[dir] * i;
            int nowX = x + dx[dir] * i;
            // 양수라면 이동가능
            if (moveShark(nowY, nowX) && newCopyGraph[nowY][nowX].get(0) > 0) {
                // 여기서 이동한 후, 움직일 수 없는지 움직일 수 있는지 확인 == newCount
                int newDir = newCopyGraph[nowY][nowX].get(1);
                // 물고기먹기
                int fish = newCopyGraph[nowY][nowX].get(0);
                result = result + fish;
                newCopyGraph[nowY][nowX].set(0, 0);
                newCopyGraph[nowY][nowX].set(1, 0);
                //
                sharkY = nowY;
                sharkX = nowX;
                sharkDir = newDir;
                //
                System.out.println(newDir+"상어의 새로운 움직임 찍음");
                System.out.println("물고기 식사");
                checkingGraph(newCopyGraph);
                for (int j = 1; j <= 16; j++) {
                    movingFish(j, newCopyGraph);
                    System.out.println(j+"번째물고기 움직임");
                    checkingGraph(newCopyGraph);
                }
                System.out.println(newDir+"상어의 새로운 움직임 찍음");

                ArrayList<Integer>[][] newCopyGraph1 = new ArrayList[4][4];

                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (newCopyGraph[j][k] != null) {
                            newCopyGraph1[j][k] = new ArrayList<>(newCopyGraph[j][k]);
                        }
                    }
                }
                int newZeroCount = 0;
                int newRangeCount = 0;

                for (int j = 1; j <= 3; j++) {
                    int newY = nowY + dy[newDir] * j;
                    int newX = nowX + dx[newDir] * j;
                    if(moveShark(newY,newX)){
                        newRangeCount++;
                    }
                }

                for (int j = 1; j <= 3; j++) {
                    int newY = nowY + dy[newDir] * j;
                    int newX = nowX + dx[newDir] * j;
                    if (moveShark(newY, newX) && newCopyGraph[newY][newX].get(0) == 0) {
                        newZeroCount++;
                    }
                }
//                if (zeroCount == rangeCount) {
//                }
                backTracking(nowY, nowX, newDir,newRangeCount,newZeroCount, result, newCopyGraph1);
            }
        }
    }

    public static void movingFish(int number, ArrayList<Integer>[][] copyGraph) {
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (copyGraph[j][k].get(0) == number) {
                    for (int l = 0; l < 8; l++) {
                        int nowY = 0;
                        int nowX = 0;
                        int dir = copyGraph[j][k].get(1) + l;
                        if (dir > 7) {
                            dir = dir - 8;
                            nowY = j + dy[dir];
                            nowX = k + dx[dir];
                        } else {
                            nowY = j + dy[dir];
                            nowX = k + dx[dir];
                        }
                        if (checking(nowY, nowX) && copyGraph[nowY][nowX].get(0) == 0) {
                            // 현재 위치
                            copyGraph[j][k].set(0, 0);
                            copyGraph[j][k].set(1, 0);
                            // 이동 할 위치
                            copyGraph[nowY][nowX].set(0, number);
                            copyGraph[nowY][nowX].set(1, dir);
                            return;
                        } else if (checking(nowY, nowX) && copyGraph[nowY][nowX].get(0) > 0) {
                            int temp = copyGraph[nowY][nowX].get(0);
                            int newDir = copyGraph[nowY][nowX].get(1);
                            copyGraph[nowY][nowX].set(0, number);
                            copyGraph[nowY][nowX].set(1, dir);
                            copyGraph[j][k].set(0, temp);
                            copyGraph[j][k].set(1, newDir);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && y < 4 && x >= 0 && x < 4 && (sharkY != y || sharkX != x);
    }

    public static boolean moveShark(int y, int x) {
        return y >= 0 && y < 4 && x >= 0 && x < 4;
    }

    public static void checkingGraph(ArrayList<Integer>[][] copyGraph) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(copyGraph[i][j].get(0) + "," + copyGraph[i][j].get(1) + " ");
            }
            System.out.println();
        }
    }

}
