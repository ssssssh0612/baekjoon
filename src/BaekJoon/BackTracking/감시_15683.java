package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 감시_15683 {
    static int[][] graph;
    static List<int[]> list = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    static int resultCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        graph = new int[y][x];
        // 0은 빈칸 6 은 벽 7은 감시 가능
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] > 0 && graph[i][j] < 6) {
                    list.add(new int[]{i, j, graph[i][j]});
                }
            }
        }

        backTracking(0, graph);
        System.out.println(result);
    }

    // 그래프를 복사해서 건네줘야함
    public static void backTracking(int depth, int[][] copyGraph) {
//        System.out.println(depth);
        if (depth == list.size()) {
            int count = 0;
            for (int i = 0; i < copyGraph.length; i++) {
                for (int j = 0; j < copyGraph[0].length; j++) {
                    if (copyGraph[i][j] == 0) {
                        count++;
                    }
                }
            }
            if (resultCount == 0) {
                result = count;
            } else {
                result = Math.min(count, result);
            }
            resultCount++;
            return;
        }
        switch (list.get(depth)[2]) {
            case 1:
                for (int j = 0; j < 4; j++) {
                    int[][] newCopyGraph = new int[copyGraph.length][copyGraph[0].length];
                    // 그래프를 복사하고
                    newCopyGraph = copyGraph(copyGraph, newCopyGraph);
                    caseOne(list.get(depth)[0], list.get(depth)[1], newCopyGraph, j);
                    int newDepth = depth + 1;
                    // 현재 0일경우 상황을 적용한 그래프를 만들고, 복사해서 값을 넘겨주기
                    backTracking(newDepth, newCopyGraph);
                }
                break;
            case 2:
                for (int j = 0; j < 2; j++) {
                    int[][] newCopyGraph = new int[copyGraph.length][copyGraph[0].length];
                    newCopyGraph = copyGraph(copyGraph, newCopyGraph);
                    caseTwo(list.get(depth)[0], list.get(depth)[1], newCopyGraph, j);
                    int newDepth = depth + 1;
                    backTracking(newDepth, newCopyGraph);
                }
                break;
            case 3:
                for (int j = 0; j < 4; j++) {
                    int[][] newCopyGraph = new int[copyGraph.length][copyGraph[0].length];
                    newCopyGraph = copyGraph(copyGraph, newCopyGraph);
                    caseThree(list.get(depth)[0], list.get(depth)[1], newCopyGraph, j);
                    int newDepth = depth + 1;
                    backTracking(newDepth, newCopyGraph);
                }
                break;
            case 4:
                for (int j = 0; j < 4; j++) {
                    int[][] newCopyGraph = new int[copyGraph.length][copyGraph[0].length];
                    newCopyGraph = copyGraph(copyGraph, newCopyGraph);
                    caseFour(list.get(depth)[0], list.get(depth)[1], newCopyGraph, j);
                    int newDepth = depth + 1;
                    backTracking(newDepth, newCopyGraph);
                }
                break;
            case 5:
                int[][] newCopyGraph = new int[copyGraph.length][copyGraph[0].length];
                newCopyGraph = copyGraph(copyGraph, newCopyGraph);
                caseFive(list.get(depth)[0], list.get(depth)[1], newCopyGraph);
                int newDepth = depth + 1;
                backTracking(newDepth, newCopyGraph);
                break;
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

    public static void checking_상하좌우(int y, int x, int[][] returnGraph, int number) {
        boolean flag = true;
        while (flag) {
//            System.out.println(y + " y ");
//            System.out.println(x + " x ");
//            checkingGraph(returnGraph);
            int nowY = y + dy[number];
            int nowX = x + dx[number];
            if (checking(nowY, nowX) && returnGraph[nowY][nowX] == 0) {
                y = nowY;
                x = nowX;
                returnGraph[nowY][nowX] = 7;
            } else if (checking(nowY, nowX) && returnGraph[nowY][nowX] == 6) {
                flag = false;
                break;
            } else if (checking(nowY, nowX) &&
                    (returnGraph[nowY][nowX] == 1 || returnGraph[nowY][nowX] == 2 ||
                            returnGraph[nowY][nowX] == 3 || returnGraph[nowY][nowX] == 4 || returnGraph[nowY][nowX] == 5 || returnGraph[nowY][nowX] == 7)) {
                y = nowY;
                x = nowX;
            } else if (!checking(nowY, nowX)) {
                flag = false;
                break;
            }
        }
    }

    public static int[][] caseOne(int y, int x, int[][] returnGraph, int caseNumber) {
        switch (caseNumber) {
            case 0: // 상
                checking_상하좌우(y, x, returnGraph, 0);
                break;
            case 1: // 하
                checking_상하좌우(y, x, returnGraph, 1);
                break;
            case 2: // 좌
                checking_상하좌우(y, x, returnGraph, 2);
                break;
            case 3: // 우
                checking_상하좌우(y, x, returnGraph, 3);
                break;
        }
        return returnGraph;
    }

    public static int[][] caseTwo(int y, int x, int[][] returnGraph, int caseNumber) {
        switch (caseNumber) { // 상 하 좌 우
            case 0:
                // 좌
                checking_상하좌우(y, x, returnGraph, 2);
                // 우
                checking_상하좌우(y, x, returnGraph, 3);
                break;
            case 1:
                // 상
                checking_상하좌우(y, x, returnGraph, 0);
                // 하
                checking_상하좌우(y, x, returnGraph, 1);
                break;
        }
        return returnGraph;
    }

    public static int[][] caseThree(int y, int x, int[][] returnGraph, int caseNumber) {
        switch (caseNumber) {
            case 0:
                checking_상하좌우(y, x, returnGraph, 0);
                checking_상하좌우(y, x, returnGraph, 3);
                break;
            case 1:
                checking_상하좌우(y, x, returnGraph, 0);
                checking_상하좌우(y, x, returnGraph, 2);
                break;
            case 2:
                checking_상하좌우(y, x, returnGraph, 1);
                checking_상하좌우(y, x, returnGraph, 3);
                break;
            case 3:
                checking_상하좌우(y, x, returnGraph, 1);
                checking_상하좌우(y, x, returnGraph, 2);
                break;
        }
        return returnGraph;
    }

    public static int[][] caseFour(int y, int x, int[][] returnGraph, int caseNumber) {
        switch (caseNumber) {
            case 0:
                checking_상하좌우(y, x, returnGraph, 0);
                checking_상하좌우(y, x, returnGraph, 1);
                checking_상하좌우(y, x, returnGraph, 2);
                break;
            case 1:
                checking_상하좌우(y, x, returnGraph, 1);
                checking_상하좌우(y, x, returnGraph, 2);
                checking_상하좌우(y, x, returnGraph, 3);
                break;
            case 2:
                checking_상하좌우(y, x, returnGraph, 0);
                checking_상하좌우(y, x, returnGraph, 3);
                checking_상하좌우(y, x, returnGraph, 1);
                break;
            case 3:
                checking_상하좌우(y, x, returnGraph, 0);
                checking_상하좌우(y, x, returnGraph, 2);
                checking_상하좌우(y, x, returnGraph, 3);
                break;
        }
        return returnGraph;

    }

    public static int[][] caseFive(int y, int x, int[][] returnGraph) {
        checking_상하좌우(y, x, returnGraph, 0);
        checking_상하좌우(y, x, returnGraph, 1);
        checking_상하좌우(y, x, returnGraph, 2);
        checking_상하좌우(y, x, returnGraph, 3);
        return returnGraph;
    }

    public static int[][] copyGraph(int[][] oldGraph, int[][] newGraph) {
        for (int i = 0; i < oldGraph.length; i++) {
            for (int j = 0; j < oldGraph[0].length; j++) {
                newGraph[i][j] = oldGraph[i][j];
            }
        }
        return newGraph;
    }

    public static void checkingGraph(int[][] checkingGraph) {
        System.out.println();
        for (int i = 0; i < checkingGraph.length; i++) {
            for (int j = 0; j < checkingGraph[0].length; j++) {
                System.out.print(checkingGraph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
