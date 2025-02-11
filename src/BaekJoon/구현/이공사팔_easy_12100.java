package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이공사팔_easy_12100 {
    // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;
    static int[] arr = new int[5];
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
//        left(graph,2);
//        mergeLeft(graph,3);
//        left(graph,2);

        backTracking(0);
        System.out.println(result);
    }

    public static void backTracking(int depth) {
        if (depth == 5) {
            int[][] newGraph = copy();
            for (int i = 0; i < arr.length; i++) {
                int dir = arr[i];
                if (dir == 0) {
                    //상
                    up(newGraph, dir);
                    mergeUp(newGraph, 1);
                    up(newGraph, dir);
                } else if (dir == 1) {
                    //하
                    down(newGraph, dir);
                    mergeDown(newGraph,0);
                    down(newGraph, dir);
                } else if (dir == 2) {
                    //좌
                    left(newGraph, dir);
                    mergeLeft(newGraph, 3);
                    left(newGraph, dir);
                } else if (dir == 3) {
                    //우
                    right(newGraph, dir);
                    mergeRight(newGraph, 2);
                    right(newGraph, dir);
                }
            }
            int check = checkNum(newGraph);

            result = Math.max(result, check);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            backTracking(depth + 1);
        }
    }

    public static int checkNum(int[][] newGraph) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                int number = newGraph[i][j];
                if (number > maxNum) {
                    maxNum = number;
                }
            }
        }
        return maxNum;
    }

    public static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int[][] copy() {
        int[][] newGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }

    public static void up(int[][] newGraph, int dir) {
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                int number = newGraph[j][i];
                // 현재 받아온 숫자를 위에까지 모두 올리기
                if (number > 0) {
                    int nextY = j;
                    int nextX = i;
                    while (true) {
                        nextY += dy[dir];
                        nextX += dx[dir];
                        if (checking(nextY, nextX) && newGraph[nextY][nextX] == 0) {
                            continue;
                        } else {
                            nextY -= dy[dir];
                            nextX -= dx[dir];
                            break;
                        }
                    }
                    newGraph[j][i] = 0;
                    newGraph[nextY][nextX] = number;
                }
            }
        }
    }

    public static void mergeUp(int[][] newGraph, int dir) {
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                int number = newGraph[j][i];
                int nextY = j + dy[dir];
                int nextX = i + dx[dir];
                if (checking(nextY, nextX) && number > 0) {
                    int number1 = newGraph[nextY][nextX];
                    // 합칠 수 있는지 체크
                    if (number == number1) {
                        newGraph[nextY][nextX] = 0;
                        newGraph[j][i] = number * 2;
                    }
                }
            }
        }
    }

    public static void down(int[][] newGraph, int dir) {
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = newGraph.length - 1; j >= 0; j--) {
                int number = newGraph[j][i];
                if (number > 0) {
                    int nextY = j;
                    int nextX = i;
                    while (true) {
                        nextY += dy[dir];
                        nextX += dx[dir];
                        if (checking(nextY, nextX) && newGraph[nextY][nextX] == 0) {
                            continue;
                        } else {
                            nextY -= dy[dir];
                            nextX -= dx[dir];
                            break;
                        }
                    }
                    newGraph[j][i] = 0;
                    newGraph[nextY][nextX] = number;
                }
            }
        }
    }
    public static void mergeDown(int[][] newGraph, int dir){
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = newGraph.length - 1; j >= 0; j--) {
                int number = newGraph[j][i];
                int nextY = j + dy[dir];
                int nextX = i + dx[dir];
                if (checking(nextY,nextX) && number > 0) {
                    int number1 = newGraph[nextY][nextX];
                    // 합칠 수 있는지 체크
                    if (number == number1) {
                        newGraph[nextY][nextX] = 0;
                        newGraph[j][i] = number * 2;
                    }
                }
            }
        }
    }

    public static void left(int[][] newGraph, int dir) {
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                int number = newGraph[i][j];
                if (number > 0) {
                    int nextY = i;
                    int nextX = j;
                    while (true) {
                        nextY += dy[dir];
                        nextX += dx[dir];
                        if (checking(nextY, nextX) && newGraph[nextY][nextX] == 0) {
                            continue;
                        } else {
                            nextY -= dy[dir];
                            nextX -= dx[dir];
                            break;
                        }
                    }
                    newGraph[i][j] = 0;
                    newGraph[nextY][nextX] = number;
                }
            }
        }
//        checking(newGraph);
    }
    public static void mergeLeft(int[][] newGraph, int dir){
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                int number = newGraph[i][j];
                int nextY = i + dy[dir];
                int nextX = j + dx[dir];
                if (checking(nextY,nextX) && number > 0) {
                    int number1 = newGraph[nextY][nextX];
                    // 합칠 수 있는지 체크
                    if (number == number1) {
                        newGraph[nextY][nextX] = 0;
                        newGraph[i][j] = number * 2;
                    }
                }
            }
        }
//        checking(graph);
    }

    public static void right(int[][] newGraph, int dir) {
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = newGraph.length - 1; j >= 0; j--) {
                int number = newGraph[i][j];
                if (number > 0) {
                    int nextY = i;
                    int nextX = j;
                    while (true) {
                        nextY += dy[dir];
                        nextX += dx[dir];
                        if (checking(nextY, nextX) && newGraph[nextY][nextX] == 0) {
                            continue;
                        } else {
                            nextY -= dy[dir];
                            nextX -= dx[dir];
                            break;
                        }
                    }
                    newGraph[i][j] = 0;
                    newGraph[nextY][nextX] = number;
                }
            }
        }
    }
    public static void mergeRight(int[][] newGraph, int dir){
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = newGraph.length - 1; j >= 0; j--) {
                int number = newGraph[i][j];
                int nextY = i + dy[dir];
                int nextX = j + dx[dir];
                if (checking(nextY, nextX) && number > 0) {
                    int number1 = newGraph[nextY][nextX];
                    // 합칠 수 있는지 체크
                    if (number == number1) {
                        newGraph[nextY][nextX] = 0;
                        newGraph[i][j] = number * 2;
                    }
                }
            }
        }
    }

    public static void checking(int[][] newGraph) {
        System.out.println();
        for (int i = 0; i < newGraph.length; i++) {
            for (int j = 0; j < newGraph.length; j++) {
                System.out.print(newGraph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//4
//2 4 16 8
//8 4 0 0
//16 8 2 0
//2 8 2 0