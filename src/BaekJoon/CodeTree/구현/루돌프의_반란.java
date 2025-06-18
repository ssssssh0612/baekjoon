package BaekJoon.CodeTree.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 루돌프의_반란 {
    static int n;
    static int m;
    static int p;
    static int c;
    static int d;

    static class Santa implements Comparable<Santa> {
        int number;
        int y;
        int x;
        int check;
        boolean isRemove;
        public Santa(int number, int y, int x) {
            this.number = number;
            this.y = y;
            this.x = x;
            this.check = 0;
            this.isRemove = false;
        }

        @Override
        public int compareTo(Santa o) {
            return this.number - o.number;
        }
    }

    static int[] santaScore;
    static List<Santa> list = new LinkedList<>();
    static int[] deerPos = new int[2];
    static int[] santaDy = {-1, 0, 1, 0};
    static int[] santaDx = {0, 1, 0, -1};
    static int[] deerDy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] deerDx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        santaScore = new int[p];
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        // 매 턴마다 루돌프 무빙 산타 무빙 가능
        st = new StringTokenizer(br.readLine());
        deerPos[0] = Integer.parseInt(st.nextToken()) - 1;
        deerPos[1] = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Santa santa = new Santa(number - 1, y - 1, x - 1);
            list.add(santa);
        }

        Collections.sort(list);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i).number + " ");
//        }
//        System.out.println();
        for (int i = 0; i < m; i++) {
//            System.out.println("=============" + (i + 1) + "턴 입니다. ===============");
//            System.out.println("사슴 움직이기 전");
//            checkingSantaGraph();

            movingDeer();
            if(isRemoveList()){
                break;
            }
//            System.out.println("사슴 움직인 후, 산타 움직이기 전");
//            checkingSantaGraph();
            movingSanta();
//            System.out.println("산타 움직이고 나서");
//            checkingSantaGraph();
            if(isRemoveList()){
                break;
            }

            score();
//            System.out.println("===점수===");
//            checkingScore();
        }
        for (int i = 0; i < santaScore.length; i++) {
            System.out.print(santaScore[i]+ " ");
        }

    }
    public static boolean isRemoveList(){
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).isRemove){
                return false;
            }
        }
        return true;
    }
    public static void checkingSantaGraph(){
        int[][] graph = new int[n][n];
        graph[deerPos[0]][deerPos[1]] = -1;
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).isRemove){
                graph[list.get(i).y][list.get(i).x] = list.get(i).number + 1;
            }
        }
        System.out.println("산타 위치");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void checkingScore(){
        for (int i = 0; i < santaScore.length; i++) {
            System.out.print(santaScore[i] + " ");
        }
        System.out.println();
    }
    public static void score(){
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).isRemove){
                santaScore[list.get(i).number]++;
            }
        }
    }

    public static void movingDeer() {
        // 현재 루돌프 위치에서 가장 가까운 산타 찾기
        // 굳이 queue가 아니어도 된다
        // 가장 작은거
        int result = Integer.MAX_VALUE;
        Santa nowSanta = null;
        for (Santa santa : list) {
            if(santa.isRemove){
                continue;
            }
            int num1 = (deerPos[0] - santa.y) * (deerPos[0] - santa.y);
            int num2 = (deerPos[1] - santa.x) * (deerPos[1] - santa.x);
            if (result > num1 + num2) {
                result = num1 + num2;
                nowSanta = santa;
            } else if (result == num1 + num2) {
                if (santa.y > nowSanta.y) {
                    nowSanta = santa;
                } else if (santa.y == nowSanta.y) {
                    // x가 더 큰놈
                    if (santa.x > nowSanta.x) {
                        nowSanta = santa;
                    }
                }
            }
        }

        // 가장 가까워지는 방향으로
        int nextY = 0;
        int nextX = 0;

        int distance = result;
        int deerDir = 0;
        // 거리가 가까워 져야함
        for (int i = 0; i < 8; i++) {
            int nowY = deerPos[0] + deerDy[i];
            int nowX = deerPos[1] + deerDx[i];
            if (checking(nowY, nowX) && distance >
                    (nowY - nowSanta.y) * (nowY - nowSanta.y) +
                            (nowX - nowSanta.x) * (nowX - nowSanta.x)) {
                nextY = nowY;
                nextX = nowX;
                deerDir = i;
                distance = (nowY - nowSanta.y) * (nowY - nowSanta.y) +
                        (nowX - nowSanta.x) * (nowX - nowSanta.x);
            }
        }


        deerPos[0] = nextY;
        deerPos[1] = nextX;

        // 현재 위치와 충돌이 있다면 충돌
        for (Santa santa : list) {
            if(santa.isRemove){
                continue;
            }
            if (santa.y == deerPos[0] && santa.x == deerPos[1]) {
                crushDeer(santa.number, deerDir);
                break;
            }
        }
    }

    public static void crushDeer(int santaNumber, int dir) {
        // 현재 루돌프가 산타랑 충돌한상태
        santaScore[santaNumber] += c;
        int index = 0;
        Santa santa = null;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).isRemove){
                continue;
            }
            if (list.get(i).number == santaNumber) {
                santa = list.get(i);
                index = i;
                break;
            }
        }

        // 해당 위치에서 산타 이동하기
        int nextY = santa.y + deerDy[dir] * c;
        int nextX = santa.x + deerDx[dir] * c;

        if (checking(nextY, nextX)) {
            santa.check = 2;
            // 다른 산타랑 겹치는지 확인하기
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).isRemove){
                    continue;
                }
                // 숫자가 다른데 겹친다면
                if ((list.get(i).number != santa.number) && (nextY == list.get(i).y && nextX == list.get(i).x)) {
                    checkingSanta(santa, list.get(i), dir, true);
                    return;
                }
            }
            // 안겹치면 그냥 이동
            santa.y = nextY;
            santa.x = nextX;

        } else {
            // 산타 삭제하기
            list.get(index).isRemove = true;
        }
    }

    public static void checkingSanta(Santa pushSanta, Santa backSanta, int dir, boolean check) {
        // 해당 위치에 산타가
        // 일단 밀은 산타는 backSanta 에 위치
        pushSanta.y = backSanta.y;
        pushSanta.x = backSanta.x;

        // back은 밀려야함
        int nextY = 0;
        int nextX = 0;

        if(check){
            nextY = backSanta.y + deerDy[dir];
            nextX = backSanta.x + deerDx[dir];
        }else{
            nextY = backSanta.y + santaDy[dir];
            nextX = backSanta.x + santaDx[dir];
        }

        if (checking(nextY, nextX)) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).isRemove){
                    continue;
                }

                // 숫자가 다른데 겹친다면
                if ((list.get(i).number != backSanta.number) && (nextY == list.get(i).y && nextX == list.get(i).x)) {
                    checkingSanta(backSanta, list.get(i), dir, check);
                    return;
                }
            }
            backSanta.y = nextY;
            backSanta.x = nextX;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).isRemove){
                    continue;
                }
                if (list.get(i).number == backSanta.number) {
                    list.get(i).isRemove = true;
                    break;
                }
            }
        }
    }

    public static void crushSanta(int santaNumber, int dir) {
        santaScore[santaNumber] += d;
        Santa santa = null;
        int index = 0;
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).isRemove){
                continue;
            }
            if(list.get(i).number == santaNumber){
                santa = list.get(i);
                index = i;
                break;
            }
        }

        // 해당 위치에서 산타 이동하기
        int nextY = santa.y + santaDy[dir] * d;
        int nextX = santa.x + santaDx[dir] * d;

        if(checking(nextY,nextX)){
            santa.check = 1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).isRemove){
                    continue;
                }
                // 숫자가 다른데 겹친다면
                if ((list.get(i).number != santa.number) && (nextY == list.get(i).y && nextX == list.get(i).x)) {
                    checkingSanta(santa, list.get(i), dir, false);
                    break;
                }
            }
            santa.y = nextY;
            santa.x = nextX;
        }else{
//            System.out.println("삭제");
            list.get(index).isRemove = true;
            // 삭제가 돼서 for 문이 완전종료가 되지않음

        }
    }

    public static void movingSanta() {
        for (Santa santa : list) {
            if(santa.isRemove){
                continue;
            }

            if (santa.check > 0) {
                santa.check--;
                continue;
            }

            // 루돌프와 가까워지는 방향으로 이동
            int distance = (santa.y - deerPos[0]) * (santa.y - deerPos[0]) +
                    (santa.x - deerPos[1]) * (santa.x - deerPos[1]);
            int santaDir = 0;
            for(int i = 0 ; i < 4; i ++){
                int nextY = santa.y + santaDy[i];
                int nextX = santa.x + santaDx[i];
                if(checkingSanta(santa.number, nextY, nextX) &&
                        distance > (nextY - deerPos[0]) * (nextY - deerPos[0]) +
                                (nextX - deerPos[1]) * (nextX - deerPos[1])){
                    // distance 얻기
                    santaDir = i;
                    distance = (nextY - deerPos[0]) * (nextY - deerPos[0]) +
                            (nextX - deerPos[1]) * (nextX - deerPos[1]);
                }
            }
            // 최소 거리를 구하고
            for(int i = 0 ; i < 4; i ++){
                int nextY = santa.y + santaDy[i];
                int nextX = santa.x + santaDx[i];
                if(checkingSanta(santa.number, nextY, nextX) &&
                        distance == (nextY - deerPos[0]) * (nextY - deerPos[0]) +
                                (nextX - deerPos[1]) * (nextX - deerPos[1])){
                    // distance 얻기
                    santaDir = i;
                    santa.y = nextY;
                    santa.x = nextX;
                }
            }


            // 현재 위치가 루돌프와 같다면
            if(santa.y == deerPos[0] && santa.x == deerPos[1]){
                // 충돌!

//                System.out.println(santa.number +"충돌");
                int dir = switchDir(santaDir);
                crushSanta(santa.number, dir);
            }

        }
    }
    public static int switchDir(int santaDir){
        if(santaDir == 0){
            return 2;
        }else if(santaDir == 1){
            return 3;
        }else if(santaDir == 2){
            return 0;
        }else{
            return 1;
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    public static boolean checkingSanta(int santaNumber, int y, int x) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).isRemove){
                continue;
            }

            if(santaNumber != list.get(i).number &&
                    (y == list.get(i).y && x == list.get(i).x)){
                return false;
            }

        }
        return y >= 0 && x >= 0 && y < n && x < n;
    }
}
