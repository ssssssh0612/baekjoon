package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무박멸 {
    static class Node {
        int tree;
        int medicine;
        boolean wall;

        public Node() {
            this.tree = 0;
            this.medicine = 0;
            this.wall = true;
        }
    }

    static Node[][] graph;
    static int m;
    static int k;
    static int c;
    static int[] dy = {-1, -1, 1, 1};
    static int[] dx = {-1, 1, -1, 1};

    static int[] dy1 = {-1, 1, 0, 0};
    static int[] dx1 = {0, 0, -1, 1};

    static int resultCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
//        System.out.println(m);
        for (int i = 0; i < m; i++) {
            // 제초제 1씩 지우기

            upgradeTree();
            System.out.println("나무 1칸 증가");
            checkingTree();

            reproductionTree();
            System.out.println("나무 번식");
            checkingTree();

            killMedicine();
            System.out.println("나무 죽이기");
            checkingTree();

            spreadMedicine();
            System.out.println("나무 검사");
            checkingTree();
            System.out.println("허브 검사");
            checkingHub();
            System.out.println(resultCount);
        }
        System.out.println(resultCount);
    }

    public static void killMedicine() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j].medicine > 0) {
                    graph[i][j].medicine--;
                }
            }
        }
    }

    public static void spreadMedicine() {
        int[] pos = new int[2];
        int num = Integer.MIN_VALUE;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                Node node = graph[i][j];
                // 벽이 아니고, tree가 0보다 큰 곳에 제초제를 뿌림
                if (!node.wall && node.tree > 0) {
                    int checkNum = checkMedicine(i, j);

                    if (num < checkNum) {
                        pos[0] = i;
                        pos[1] = j;
                        num = checkNum;
                    }
                }
            }
        }
        if (num == Integer.MIN_VALUE) {
            num = 0;
        }
        System.out.println("제초제 뿌릴 위치 !");
        System.out.println(" y = " + pos[0] + " " + " x = " + pos[1]);
        resultCount += num;
        spread(pos[0], pos[1]);
    }

    public static void spread(int y, int x) {
        graph[y][x].medicine = c;
        graph[y][x].tree = 0;
        for (int i = 0; i < 4; i++) {
            // 대각선으로 뿌리기
            int nextY = y;
            int nextX = x;
            for (int j = 1; j <= k; j++) {
                nextY = nextY + dy[i];
                nextX = nextX + dx[i];
                // 일단 범위 안에 들어와야함
                if (checking(nextY, nextX)) {
                    if ((graph[nextY][nextX].wall)) break;
                    if(graph[nextY][nextX].tree == 0) {
                        graph[nextY][nextX].medicine = c;
                        break;
                    }
                    graph[nextY][nextX].medicine = c;
                    graph[nextY][nextX].tree = 0;
                }
            }
        }
    }

    public static int checkMedicine(int y, int x) {
        int treeCount = graph[y][x].tree;

        for (int i = 0; i < 4; i++) {
            // 대각선으로 뿌리기
            for (int j = 1; j <= k; j++) {
                int nextY = y + (dy[i] * j);
                int nextX = x + (dx[i] * j);
                // 일단 범위 안에 들어와야함
                if (checking(nextY, nextX)) {
                    if ((graph[nextY][nextX].wall) || (graph[nextY][nextX].tree == 0)) break;
                    treeCount += graph[nextY][nextX].tree;
                }
            }
        }
        return treeCount;
    }


    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }

    public static void reproductionTree() {
        int[][] newTree = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                Node node = graph[i][j];
                int count = 0;
                if (!node.wall && node.tree > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy1[k];
                        int nextX = j + dx1[k];
                        if (checking(nextY, nextX) && !graph[nextY][nextX].wall &&
                                graph[nextY][nextX].medicine == 0 && graph[nextY][nextX].tree == 0) {
                            count++;
                        }
                    }
                }
                if (count != 0) {
                    int addTree = node.tree / count;
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy1[k];
                        int nextX = j + dx1[k];
                        if (checking(nextY, nextX) && !graph[nextY][nextX].wall
                                && graph[nextY][nextX].medicine == 0 && graph[nextY][nextX].tree == 0) {
                            newTree[nextY][nextX] += addTree;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                Node node = graph[i][j];
                int addTree = newTree[i][j];
                node.tree += addTree;
            }
        }
    }

    public static void upgradeTree() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                Node node = graph[i][j];
                if (!node.wall && node.tree > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy1[k];
                        int nextX = j + dx1[k];
                        if (checking(nextY, nextX) && graph[nextY][nextX].tree > 0) {
                            node.tree++;
                        }
                    }
                }
            }
        }
    }

    public static void checkingTree() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j].wall) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(graph[i][j].tree + " ");
                }
            }
            System.out.println();
        }
    }

    public static void checkingHub() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j].medicine + " ");
            }
            System.out.println();
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        graph = new Node[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new Node();
            }
        }
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                Node node = graph[i][j];
                if (number != -1) {
                    node.tree = number;
                    node.wall = false;
                }
            }
        }
    }
}
