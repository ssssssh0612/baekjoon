package BaekJoon.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 주사위_굴리기_2_23288 {
    static int y;
    static int x;
    static int testCase;
    static int result;
    static int[][] graph;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int diceDir = 3;
    static int[][] dice = new int[4][3];
    static int[] dicePos = new int[2];

    public static void main(String[] args) {
        // 주사위 초기값
        dicePos[0] = 0;
        dicePos[1] = 0;

        dice[0][0] = 0;
        dice[0][1] = 2;
        dice[0][2] = 0;
        dice[1][0] = 4;
        dice[1][1] = 1;
        dice[1][2] = 3;
        dice[2][0] = 0;
        dice[2][1] = 5;
        dice[2][2] = 0;
        dice[3][0] = 0;
        dice[3][1] = 6;
        dice[3][2] = 0;
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        testCase = sc.nextInt();
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < testCase; i++) {
            //주사위가 이동 방향으로 한 칸 굴러간다. 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
            diceDir();
            //주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
            int count = bfs();
            result = result + (count * graph[dicePos[0]][dicePos[1]]);
            // 주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다.
            // 주사위 아랫면에 있는 정수 A
            int a = dice[3][1];
            // 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다.
            int b = graph[dicePos[0]][dicePos[1]];
            //A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.

            //A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
            rotate(a,b);
            //A = B인 경우 이동 방향에 변화는 없다.
        }
        System.out.println(result);


    }

    public static boolean checkingDicePos() {
        int nowY = dicePos[0] + dy[diceDir];
        int nowX = dicePos[1] + dx[diceDir];
        return nowY >= 0 && nowX >= 0 && nowY < y && nowX < x;
    }

    // 주사위의 방향이 바뀌면 이 메서드 호출을 통해 바꿈
    public static void diceDir() {
        // 주사위가 이동할 수 있는지 확인하기
        if (checkingDicePos()) {
            dicePos[0] = dicePos[0] + dy[diceDir];
            dicePos[1] = dicePos[1] + dx[diceDir];
        } else {
            // 방향 반대로 바꾸고
            switch (diceDir) {
                case 0:
                    diceDir = 1;
                    break;
                case 1:
                    diceDir = 0;
                    break;
                case 2:
                    diceDir = 3;
                    break;
                case 3:
                    diceDir = 2;
                    break;
            }
            // 반대로 바꾼 뒤, 주사위 위치 한칸 이동하기
            dicePos[0] = dicePos[0] + dy[diceDir];
            dicePos[1] = dicePos[1] + dx[diceDir];
        }


        int[][] copyDice = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                copyDice[i][j] = dice[i][j];
            }
        }

        switch (diceDir) {
            case 0:
                dice[2][1] = copyDice[3][1];
                dice[1][1] = copyDice[2][1];
                dice[0][1] = copyDice[1][1];
                dice[3][1] = copyDice[0][1];
                break;
            case 1:
                dice[1][1] = copyDice[0][1];
                dice[2][1] = copyDice[1][1];
                dice[3][1] = copyDice[2][1];
                dice[0][1] = copyDice[3][1];
                break;
            case 2:
                dice[1][1] = copyDice[1][2];
                dice[1][0] = copyDice[1][1];
                dice[3][1] = copyDice[1][0];
                dice[1][2] = copyDice[3][1];
                break;
            case 3:
                dice[1][1] = copyDice[1][0];
                dice[1][2] = copyDice[1][1];
                dice[3][1] = copyDice[1][2];
                dice[1][0] = copyDice[3][1];
                break;
        }

    }

    public static int bfs(){
        boolean[][] visited = new boolean[y][x];
        int count = 1;
        int number = graph[dicePos[0]][dicePos[1]];
        visited[dicePos[0]][dicePos[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{dicePos[0], dicePos[1]});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if( nowY >= 0 && nowX >= 0 && nowY < y && nowX < x
                    && !visited[nowY][nowX] && graph[nowY][nowX] == number){
                    count++;
                    queue.add(new int[]{nowY, nowX});
                    visited[nowY][nowX] = true;
                }
            }
        }
        return count;
    }

    public static void rotate(int a, int b){
        //A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
        if(a > b){
            switch (diceDir){
                case 0:
                    diceDir = 3;
                    break;
                case 1:
                    diceDir = 2;
                    break;
                case 2:
                    diceDir = 0;
                    break;
                case 3:
                    diceDir = 1;
                    break;
            }
        }else if( a < b ){
            switch (diceDir){
                case 0:
                    diceDir = 2;
                    break;
                case 1:
                    diceDir = 3;
                    break;
                case 2:
                    diceDir = 1;
                    break;
                case 3:
                    diceDir = 0;
                    break;
            }

        }


        //A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.

        //A = B인 경우 이동 방향에 변화는 없다.
    }

}
