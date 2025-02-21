package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 왕실의기사대결 {
    static int[][] graph;
    static int[][] humanGraph;
    static int[][] humanCopyGraph;
    static int[] humanHealth;
    static int[] humanCopyHealth;
    static int resultCount = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        graph = new int[L][L];
        humanGraph = new int[L][L];
        humanCopyGraph = new int[L][L];
        int N = Integer.parseInt(st.nextToken());
        humanHealth = new int[N + 1];
        humanCopyHealth = new int[N + 1];
        int Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                // 0은 빈칸
                // 1은 함정
                // 2는 벽
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int newY = Integer.parseInt(st.nextToken());
            int newX = Integer.parseInt(st.nextToken());
            int health = Integer.parseInt(st.nextToken());
            for (int j = y; j < y + newY; j++) {
                for (int k = x; k < x + newX; k++) {
                    humanGraph[j][k] = i + 1;
                }
            }
            humanHealth[i + 1] = health;
            humanCopyHealth[i + 1] = health;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int humanNumber = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            copyGraph();
            if (findHuman(humanNumber, dir)) {
                // 밀기 가능한 상태
                pushHuman(humanNumber, dir);
                // 현재 밀쳐진 상태로 체력을 잃는지 안잃는지 확인하기
                healthChecking(humanNumber);
                set.clear();
//                humanGraph();
//                checkingHealth();
            }
        }

        for(int i = 1; i < humanHealth.length; i++){
            if(humanHealth[i] != 0){
                resultCount += humanCopyHealth[i] - humanHealth[i];
            }
        }

        System.out.println(resultCount);

    }
    public static void copyGraph(){
        for(int i = 0 ; i < humanGraph.length ; i ++){
            for(int j = 0 ; j < humanGraph.length; j ++){
                humanCopyGraph[i][j] = humanGraph[i][j];
            }
        }
    }
    public static void checkingHealth(){
        for(int i = 1 ; i < humanHealth.length ; i ++){
            System.out.print(humanHealth[i] + " ");
        }
    }

    public static void healthChecking(int humanNumber){

        for(int i = 0 ; i < humanGraph.length; i++){
            for(int j = 0 ; j < humanGraph.length; j++){
                int newHumanNumber = humanGraph[i][j];
                if(newHumanNumber == humanNumber){
                    continue;
                }
                int graphNumber = graph[i][j];
                if(set.contains(newHumanNumber) && graphNumber == 1){
                    humanHealth[newHumanNumber]--;
                    if(humanHealth[newHumanNumber] == 0){
                        humanDie(newHumanNumber);
                    }
                }

            }
        }
        // 무빙한 애들만 피해를 입어야함
    }
    public static void humanDie(int humanNumber){
        for(int i = 0 ; i < humanGraph.length; i++){
            for(int j = 0 ; j < humanGraph.length; j++){
                int newHumanNumber = humanGraph[i][j];
                if(newHumanNumber == humanNumber){
                    humanGraph[i][j] = 0;
                }
            }
        }
    }


    public static void humanGraph() {
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(humanGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 기사 밀기
    public static boolean findHuman(int humanNumber, int dir) {
        List<int[]> gisaPos = findHumanPos(humanNumber);
        if (gisaPos.isEmpty()) {
            return false;
        }
        Set<Integer> numberList = new HashSet<>();
        boolean flag = true;
        // 기사 밀치는 로직 구현하기
        for (int[] arr : gisaPos) {
            int nextY = arr[0] + dy[dir];
            int nextX = arr[1] + dx[dir];
            // 벽이 있으면 종료
            // 옮기려고 하는 곳에 벽이 있으면 종료
            if (checking(nextY, nextX) && graph[nextY][nextX] == 2) {
                return false;
            } else if (checking(nextY, nextX) && humanGraph[nextY][nextX] != humanNumber && humanGraph[nextY][nextX] > 0) {
                numberList.add(humanGraph[nextY][nextX]);
            } else if (!checking(nextY, nextX)) {
                return false;
            }
        }

        if (numberList.isEmpty()) {
            return true;
        } else {
            for (Integer newHumanNumber : numberList) {
                if (!findHuman(newHumanNumber, dir)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void pushHuman(int humanNumber, int dir) {
        List<int[]> gisaPos = findHumanPos(humanNumber);
        set.add(humanNumber);
        madeZero(gisaPos);
        Set<Integer> numberList = new HashSet<>();

        for (int[] arr : gisaPos) {
            int nextY = arr[0] + dy[dir];
            int nextX = arr[1] + dx[dir];
            if (checking(nextY, nextX) && humanGraph[nextY][nextX] != humanNumber && humanGraph[nextY][nextX] > 0) {
                numberList.add(humanGraph[nextY][nextX]);
            }
        }
        if (!numberList.isEmpty()) {
            for (Integer newHumanNumber : numberList) {
                pushHuman(newHumanNumber, dir);
            }
        }

        for (int[] arr : gisaPos) {
            int nextY = arr[0] + dy[dir];
            int nextX = arr[1] + dx[dir];
            if (checking(nextY, nextX) && humanGraph[nextY][nextX] != humanNumber && humanGraph[nextY][nextX] > 0) {
                numberList.add(humanGraph[nextY][nextX]);
            }
            humanGraph[nextY][nextX] = humanNumber;
        }
    }

    public static void madeZero(List<int[]> gisaPos) {
        for (int[] arr : gisaPos) {
            humanGraph[arr[0]][arr[1]] = 0;
        }
    }

    public static List<int[]> findHumanPos(int humanNumber) {
        // humanNumber를 찾아서 보내줌
        List<int[]> humanPos = new ArrayList<>();
        for (int i = 0; i < humanGraph.length; i++) {
            for (int j = 0; j < humanGraph.length; j++) {
                if (humanCopyGraph[i][j] == humanNumber) {
                    humanPos.add(new int[]{i, j});
                }
            }
        }
        return humanPos;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
}
