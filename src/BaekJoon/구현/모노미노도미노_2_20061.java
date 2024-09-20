package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 모노미노도미노_2_20061 {
    static boolean[][] blockGraph = new boolean[10][10];

    // blue , green 순서
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    //첫째 줄에 블록을 모두 놓았을 때 얻은 점수를 출력한다.
    //둘째 줄에는 파란색 보드와 초록색 보드에서 타일이 들어있는 칸의 개수를 출력한다.
    static List<int[]> testCaseList = new ArrayList<>();
    static int resultCount = 0;
    static int resultCount2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            // testCase, y, x
            testCaseList.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        for (int i = 0; i < testCaseList.size(); i++) {
            dropBlock(testCaseList.get(i));
            countBlock();
            blockChecking();
//            blockGraphChecking();
        }
//        System.out.println(resultCount);
        resultChecking();
        System.out.println(resultCount);
        System.out.println(resultCount2);


        // 블록 놓기 o
        // 블록 떨구기 o

        // 블록 체크하기 행, 열 한줄로 가득 차있는지 o

        // 중간에 이어저있는 타일에 블록이 있는지 없는지 체크하기

        // 위 행위 반복


    }

    public static void resultChecking() {
        for (int i = 6; i <= 9; i++) {
            for (int j = 0; j < 4; j++) {
                if (blockGraph[i][j]) {
                    resultCount2++;
                }
                if (blockGraph[j][i]) {
                    resultCount2++;
                }
            }
        }
    }

    public static void blockChecking() {
        boolean[][] copyBlockGraph = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copyBlockGraph[i][j] = blockGraph[i][j];
            }
        }
//        System.out.println("blockChecking1");
//        blockGraphChecking();
        // blue
        int i4_countblue = 0;
        int i5_countblue = 0;

        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 4 && blockGraph[j][i]) {
                    i4_countblue++;
                } else if (i == 5 && blockGraph[j][i]) {
                    i5_countblue++;
                }
            }
        }
        int sumIcount = 0;
        if (i4_countblue > 0) {
            sumIcount++;
        }
        if (i5_countblue > 0) {
            sumIcount++;
        }
//        System.out.println("sumICount" + sumIcount);
//        resultCount = resultCount + sumIcount;
        for (int i = 0; i < sumIcount; i++) {
//            blockGraphChecking();
            for (int j = 8; j >= 4; j--) {
                for (int k = 0; k < 4; k++) {
                    blockGraph[k + dy[0]][j + dx[0]] = blockGraph[k][j];
                }
//                System.out.println("blockChecking2"+j);
//                blockGraphChecking();
            }
            for (int j = 0; j < 4; j++) {
                blockGraph[j][4] = false;
            }
//            blockGraphChecking();
        }
//        System.out.println("blockChecking2");
//        blockGraphChecking();
        // green
        int i4_countgreen = 0;
        int i5_countgreen = 0;
        for (int i = 4; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 4 && blockGraph[i][j]) {
                    i4_countgreen++;
                } else if (i == 5 && blockGraph[i][j]) {
                    i5_countgreen++;
                }
            }
        }

        int sumIcount2 = 0;
        if (i4_countgreen > 0) {
            sumIcount2++;
        }

        if (i5_countgreen > 0) {
            sumIcount2++;
        }
//        System.out.println("sumICount2Green"+sumIcount2);
//        resultCount = resultCount + sumIcount2;

        for (int i = 0; i < sumIcount2; i++) {
            for (int j = 8; j >= 4; j--) {
                for (int k = 0; k < 4; k++) {
                    blockGraph[j + dy[1]][k + dx[1]] = blockGraph[j][k];
                }
            }
            for (int j = 0; j < 4; j++) {
                blockGraph[4][j] = false;
            }
        }
    }

    public static void countBlock() {
        boolean[][] copyBlockGraph = new boolean[10][10];

//        System.out.println("1");
//        blockGraphChecking();
        // blue
        for (int i = 9; i >= 6; i--) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (blockGraph[j][i]) {
                    count++;
                }
            }
            if (count == 4) {
                resultCount++;
                for (int j = i - 1; j >= 4; j--) {
                int checkPoint = 0;
                    for (int k = 0; k < 4; k++) {
                        blockGraph[k + dy[0]][j + dx[0]] = blockGraph[k][j];
                        if(blockGraph[k][j]){
                            checkPoint++;
                        }
                    }
                    if(checkPoint == 4){
//                        for (int w = 0; w < 4; w++) {
//                            blockGraph[w][4] = false;
//                        }
                        i = i + 1;
                    }
                }
                for (int j = 0; j < 4; j++) {
                    blockGraph[j][4] = false;
                }
            }
        }
//        System.out.println("2");
//        blockGraphChecking();
        // green
        for (int i = 9; i >= 6; i--) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (blockGraph[i][j]) {
                    count++;
                }
            }
            if (count == 4) {
                resultCount++;
                for (int j = i - 1; j >= 4; j--) {
                    int checkPoint = 0;
                    for (int k = 0; k < 4; k++) {
                        blockGraph[j + dy[1]][k + dx[1]] = blockGraph[j][k];
                        if(blockGraph[j][k]){
                            checkPoint++;
                        }
                    }
                    if(checkPoint == 4){
//                        for (int w = 0; w < 4; w++) {
//                            blockGraph[4][w] = false;
//                        }
                        i = i+1;
                    }
                }
                for (int j = 0; j < 4; j++) {
                    blockGraph[4][j] = false;
                }
            }
        }
    }


    public static void dropBlock(int[] block) {
        // blue , green 순서 0, 1
        if (block[0] == 1) {
            int blueY = block[1];
            int blueX = block[2];
            int greenY = block[1];
            int greenX = block[2];
            // blue
            for (int i = 0; i < 10; i++) {
                int nowY = blueY + dy[0];
                int nowX = blueX + dx[0];
                if (!blueChecking(nowY, nowX)) {
                    blockGraph[blueY][blueX] = true;
                    break;
                } else {
                    blueY = nowY;
                    blueX = nowX;
                }
            }
            // green
            for (int i = 0; i < 10; i++) {
                int nowY = greenY + dy[1];
                int nowX = greenX + dx[1];
                if (!greenChecking(nowY, nowX)) {
                    blockGraph[greenY][greenX] = true;
                    break;
                } else {
                    greenY = nowY;
                    greenX = nowX;
                }
            }
        } else if (block[0] == 2) {
            int blueY = block[1];
            int blueX = block[2];
            int blueY1 = block[1];
            int blueX1 = block[2] + 1;

            int greenY = block[1];
            int greenX = block[2];
            int greenY1 = block[1];
            int greenX1 = block[2] + 1;

            // blue
            for (int i = 0; i < 10; i++) {
                int nowY = blueY + dy[0];
                int nowX = blueX + dx[0];
                int nowY1 = blueY1 + dy[0];
                int nowX1 = blueX1 + dx[0];
                if (!blueChecking(nowY1, nowX1)) {
                    blockGraph[blueY][blueX] = true;
                    blockGraph[blueY1][blueX1] = true;
                    break;
                } else {
                    blueY = nowY;
                    blueX = nowX;
                    blueY1 = nowY1;
                    blueX1 = nowX1;
                }
            }
            // green
            for (int i = 0; i < 10; i++) {
                int nowY = greenY + dy[1];
                int nowX = greenX + dx[1];
                int nowY1 = greenY1 + dy[1];
                int nowX1 = greenX1 + dx[1];
                if (!greenChecking(nowY, nowX) || !greenChecking(nowY1, nowX1)) {
                    blockGraph[greenY][greenX] = true;
                    blockGraph[greenY1][greenX1] = true;
                    break;
                } else {
                    greenY = nowY;
                    greenX = nowX;
                    greenY1 = nowY1;
                    greenX1 = nowX1;
                }
            }
        } else if (block[0] == 3) {
            int blueY = block[1];
            int blueX = block[2];
            int blueY1 = block[1] + 1;
            int blueX1 = block[2];

            int greenY = block[1];
            int greenX = block[2];
            int greenY1 = block[1] + 1;
            int greenX1 = block[2];
            // blue
            for (int i = 0; i < 10; i++) {
                int nowY = blueY + dy[0];
                int nowX = blueX + dx[0];
                int nowY1 = blueY1 + dy[0];
                int nowX1 = blueX1 + dx[0];
                if (!blueChecking(nowY, nowX) || !blueChecking(nowY1, nowX1)) {
                    blockGraph[blueY][blueX] = true;
                    blockGraph[blueY1][blueX1] = true;
                    break;
                } else {
                    blueY = nowY;
                    blueX = nowX;
                    blueY1 = nowY1;
                    blueX1 = nowX1;
                }
            }
            // green
            for (int i = 0; i < 10; i++) {
                int nowY = greenY + dy[1];
                int nowX = greenX + dx[1];
                int nowY1 = greenY1 + dy[1];
                int nowX1 = greenX1 + dx[1];
                if (!greenChecking(nowY1, nowX1)) {
                    blockGraph[greenY][greenX] = true;
                    blockGraph[greenY1][greenX1] = true;
                    break;
                } else {
                    greenY = nowY;
                    greenX = nowX;
                    greenY1 = nowY1;
                    greenX1 = nowX1;
                }
            }
        }
    }

    // 이동하려고 하는 위치에 블록이 존재하거나, 범위를 벗어난경우 false 반환
    public static boolean greenChecking(int y, int x) {
        // 블록이 없고, 해당 범위를 벗어나지 않으면 true
        // 범위를 벗어나거나 블록을 만나면 false
        return x >= 0 && y >= 0 && x < 4 && y < 10 && !blockGraph[y][x];
    }

    public static boolean blueChecking(int y, int x) {
        // 블록이 없고, 해당 범위를 벗어나지 않으면 true
        return x >= 0 && y >= 0 && y < 4 && x < 10 && !blockGraph[y][x];
    }

    public static void blockGraphChecking() {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (blockGraph[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
