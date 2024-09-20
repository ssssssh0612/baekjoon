package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 원판_돌리기 {
    static int y;
    static int x;
    static int[][] graph;

    // 바깥쪽도 아니고 안쪾도 아닌
    static int[] dx = {};
    static int[] dy = {};

    // 가장 안쪽
    static int[] dxStart = {};
    static int[] dyStart = {};
    // 가장 바깥쪽
    static int[] dxLast = {};
    static int[] dyLast = {};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        graph = new int[y][x];
        List<int[]> testList = new ArrayList<int[]>();
        int testCase = sc.nextInt();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < testCase; i++) {
            testList.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        for (int i = 0; i < testCase; i++) {
            rotate(testList.get(i)[0], testList.get(i)[1], testList.get(i)[2]);
//            System.out.println("회전");
//            checkGraph();
            deleteNumber();
//            System.out.println("삭제후");
//            checkGraph();
        }
        System.out.println(resultGraph());

    }

    public static int resultGraph() {
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                result += graph[i][j];
            }
        }
        return result;
    }

    public static void checkGraph() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(graph[i][j] + "");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 원판 돌리기
    //첫째 줄에 N, M, T이 주어진다.
    //둘째 줄부터 N개의 줄에 원판에 적힌 수가 주어진다. i번째 줄의 j번째 수는 (i, j)에 적힌 수를 의미한다.
    //다음 T개의 줄에 xi, di, ki가 주어진다.

    // 번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다.
    // di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
    public static void rotate(int xi, int di, int ki) {
        // 번호가 xi 의 배수인 원판을 di 방향으로 ki 칸 회전
        for (int i = 1; i <= y; i++) {
            if (i % xi == 0) {
                // 배수의 원판이라면 돌리기
                for (int j = 0; j < ki; j++) {
                    int[][] copyGraph = new int[y][x];
                    for (int k = 0; k < y; k++) {
                        for (int l = 0; l < x; l++) {
                            copyGraph[k][l] = graph[k][l];
                        }
                    }
                    for (int k = 0; k < x; k++) {
//                        시계방향인지 반시계방향인지 체크
                        if (di == 0) { // 시계 방향
                            if (k == x - 1) {
                                graph[i - 1][0] = copyGraph[i - 1][k];
                            } else {
                                graph[i - 1][k + 1] = copyGraph[i - 1][k];
                            }
                        } else {
                            if (k == 0) {
                                graph[i - 1][x - 1] = copyGraph[i - 1][k];
                            } else {
                                graph[i - 1][k - 1] = copyGraph[i - 1][k];
                            }
                        }
                    }
                }
            }
        }
    }

    public static void deleteNumber() {
        int[][] copyGraph = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }

        boolean flagGraph = false;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0) {
                    if (j == 0) {
                        if (copyGraph[i][j] == copyGraph[i][j + 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j + 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][x - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][x - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i + 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i + 1][j] = 0;
                            flagGraph = true;
                        }
                    } else if (j == x - 1) {
                        if (copyGraph[i][j] == copyGraph[i][0] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][0] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][j - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i + 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i + 1][j] = 0;
                            flagGraph = true;
                        }

                    } else {
                        if (copyGraph[i][j] == copyGraph[i][j + 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j + 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][j - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i + 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i + 1][j] = 0;
                            flagGraph = true;
                        }
                    }
                } else if (i == y - 1) {
                    if (j == 0) {
                        if (copyGraph[i][j] == copyGraph[i][j + 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j + 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][x - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][x - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i - 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i - 1][j] = 0;
                            flagGraph = true;
                        }
                    } else if (j == x - 1) {
                        if (copyGraph[i][j] == copyGraph[i][0] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][0] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][j - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i - 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i - 1][j] = 0;
                            flagGraph = true;
                        }
                    } else {
                        if (copyGraph[i][j] == copyGraph[i][j - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][j + 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j + 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i - 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i - 1][j] = 0;
                            flagGraph = true;
                        }

                    }
                } else {
                    if (j == 0) {
                        if (copyGraph[i][j] == copyGraph[i][j + 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j + 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][x - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][x - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i - 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i - 1][j] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i + 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i + 1][j] = 0;
                            flagGraph = true;
                        }

                    } else if (j == x - 1) {
                        if (copyGraph[i][j] == copyGraph[i][0] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][0] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][j - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i - 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i - 1][j] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i + 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i + 1][j] = 0;
                            flagGraph = true;
                        }

                    } else {
                        if (copyGraph[i][j] == copyGraph[i][j + 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j + 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i][j - 1] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i][j - 1] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i - 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i - 1][j] = 0;
                            flagGraph = true;
                        }
                        if (copyGraph[i][j] == copyGraph[i + 1][j] && copyGraph[i][j] != 0) {
                            graph[i][j] = 0;
                            graph[i + 1][j] = 0;
                            flagGraph = true;
                        }
                    }
                }
            }
        }
//        System.out.println(flagGraph);
        if (!flagGraph) {
            // 없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
            int average = 0;
            int count = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if(graph[i][j] > 0){
                        average += graph[i][j];
                        count++;
                    }
                }
            }
            double result = (double) average / count;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if( result < graph[i][j] && copyGraph[i][j] != 0) {
                        graph[i][j] = graph[i][j] - 1;
                    }else if (result > graph[i][j] && copyGraph[i][j] != 0) {
                        graph[i][j] = graph[i][j] + 1;
                    }
                }
            }
        }
    }
}

