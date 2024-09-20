package BaekJoon.구현;

import java.util.Scanner;

public class 주사위_굴리기_14499 {
    static int[][] graph;
    static int[][] dice = new int[4][3];
    // 상, 하, 좌, 우
    // 동 서 북 남
    // 우 좌 상 하
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int blockPosY;
    static int blockPosX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        blockPosY = sc.nextInt();
        blockPosX = sc.nextInt();
        int testCase = sc.nextInt();
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < testCase; i++) {
            if (dice(sc.nextInt() - 1)){
                if(graph[blockPosY][blockPosX] == 0){
                    //주사위 바닥면 수가 칸에 복사
                    graph[blockPosY][blockPosX] = dice[3][1];
                }else{
                    dice[3][1] = graph[blockPosY][blockPosX];
                    graph[blockPosY][blockPosX] = 0;
                }
            }else{
                continue;
            }
            System.out.println(dice[1][1]);
        }
    }

public static boolean dice(int number) {
    // 동쪽 = 1 서쪽 = 2 북쪽 = 3 남쪽 = 4
    switch (number) {
        case 0:
            if (validatePos(number)) return false;
            int tmp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = tmp;
            break;
        case 1:
            if (validatePos(number)) return false;
            tmp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = tmp;
            break;
        case 2:
            if (validatePos(number)) return false;
            tmp = dice[0][1];
            for (int i = 0; i < 3; i++) dice[i][1] = dice[i + 1][1];
            dice[3][1] = tmp;
            break;
        case 3:
            if (validatePos(number)) return false;
            tmp = dice[3][1];
            for (int i = 3; i >= 1; i--) dice[i][1] = dice[i - 1][1];
            dice[0][1] = tmp;
            break;
    }
    return true;
}

private static boolean validatePos(int number) {
    if (blockPosY + dy[number] >= 0 && blockPosY + dy[number] < graph.length &&
            blockPosX + dx[number] >= 0 && blockPosX + dx[number] < graph[0].length) {
        blockPosY = blockPosY + dy[number];
        blockPosX = blockPosX + dx[number];
    } else {
        return true;
    }
    return false;
}
}
