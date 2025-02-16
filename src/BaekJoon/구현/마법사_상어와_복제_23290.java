package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class 마법사_상어와_복제_23290 {
    static class Node {
        int[] arr;
        int[] newArr;
        int smell;

        public Node() {
            arr = new int[8];
            newArr = new int[8];
            smell = 0;
        }


    }

    // y, x-1 y, x y, x + 1
    static int[] sharkArr = new int[3];
    static int[] resultShark = new int[3];
    static int result = Integer.MIN_VALUE;
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] sharkPos = new int[2];
    static int practice;
    static Node[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
//        backTracking(0);
        for (int i = 0; i < practice; i++) {
            result = Integer.MIN_VALUE;
            Node[][] copyGraph = copyGraph();
            moving();
            backTracking(0);
            sharkFeeding();
            copy(copyGraph);
//            checking();
        }
        System.out.println(result());
    }

    public static int result() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 8; k++) {
                    count += graph[i][j].arr[k];
                }
            }
        }
        return count;
    }

    public static void copy(Node[][] copyGraph) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 8; k++) {
                    graph[i][j].arr[k] += copyGraph[i][j].arr[k];
                }
            }
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new Node[4][4];
        int m = Integer.parseInt(st.nextToken());
        practice = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                graph[i][j] = new Node();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            Node node = graph[y][x];
            node.arr[dir]++;
        }
        st = new StringTokenizer(br.readLine());
        sharkPos[0] = Integer.parseInt(st.nextToken()) - 1;
        sharkPos[1] = Integer.parseInt(st.nextToken()) - 1;
    }

    public static void backTracking(int depth) {
        if (depth == 3) {
            // 현재 상어 위치에서 가장 숫자가 크고
            int nowY = sharkPos[0];
            int nowX = sharkPos[1];
            // 상, 하, 좌, 우
            // 상은 0, 좌는 1, 하는 2, 우는 3
            // 이중에 숫자가 가장 큰 수
            int count = 0;
//            for(int i = 0 ; i < sharkArr.length; i++){
//                System.out.print(sharkArr[i]+ " ");
//            }
//            System.out.println();
            boolean[][] visited = new boolean[4][4];
            for (int i = 0; i < sharkArr.length; i++) {
                int dir = convertDir(sharkArr[i]);
                nowY = nowY + dy[dir];
                nowX = nowX + dx[dir];
//                System.out.println("nowY = " + nowY + " " + "nowX = "+ nowX);
                if (checkingShark(nowY, nowX)) {
                    Node node = graph[nowY][nowX];
                    if (!visited[nowY][nowX]) {
                        visited[nowY][nowX] = true;
                        for (int j = 0; j < 8; j++) {
                            count += node.arr[j];
//                            System.out.print(node.arr[j]+" ");
                        }
                    }
                } else {
                    return;
                }
            }
//            System.out.println("count = " + count);
            // 값이 최신화되면 arr채택
            if (result < count) {
//                System.out.println(count);
                for (int i = 0; i < 3; i++) {
                    // 상어 위치 최신화
                    int number = sharkArr[i];
//                    System.out.print(number + " ");
                    resultShark[i] = number;
                    result = count;
                }
//                System.out.println();
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            sharkArr[depth] = i;
            backTracking(depth + 1);
        }
    }

    public static void sharkFeeding() {
        for (int i = 0; i < sharkArr.length; i++) {
            int dir = convertDir(resultShark[i]);
            sharkPos[0] = sharkPos[0] + dy[dir];
            sharkPos[1] = sharkPos[1] + dx[dir];
            Node node = graph[sharkPos[0]][sharkPos[1]];
            boolean flag = false;
            for (int j = 0; j < 8; j++) {
                // 물고기 한번 먹으면 냄새 만들기
                if (node.arr[j] > 0) {
                    flag = true;
                    node.arr[j] = 0;
                }
            }
            if (flag) {
                node.smell = 3;
            }
        }

//        System.out.println(sharkPos[0] + " " + sharkPos[1]);
        // 냄새 지우기
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Node node = graph[i][j];
                if (node.smell > 0) {
                    node.smell--;
                }
            }
        }
    }

    // 모든 물고기가 한 칸 이동한다. 상어가 있는 칸, 물고기의 냄새가 있는 칸,
    // 격자의 범위를 벗어나는 칸으로는 이동할 수 없다.
    // 각 물고기는 자신이 가지고 있는 이동 방향이 이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킨다.
    // 만약, 이동할 수 있는 칸이 없으면 이동을 하지 않는다. 그 외의 경우에는 그 칸으로 이동을 한다. 물고기의 냄새는 아래 3에서 설명한다.
    public static void moving() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                movingFish(i, j);
            }
        }
//        System.out.println("움직이고나서;");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fishChecking(i, j);
            }
        }
//        checking();
    }

    public static void fishChecking(int y, int x) {
        Node node = graph[y][x];
        for (int i = 0; i < 8; i++) {
            int number = node.newArr[i];
            if (number > 0) {
                node.arr[i] += number;
                node.newArr[i] = 0;
            }
        }
    }

    public static void checking() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Node node = graph[i][j];
                System.out.println("y = " + (i + 1) + " x = " + (j + 1));
                for (int k = 0; k < 8; k++) {
                    System.out.print(node.arr[k] + " ");
                }
                System.out.println();
                for (int k = 0; k < 8; k++) {
                    System.out.print(node.newArr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void movingFish(int y, int x) {
        Node node = graph[y][x];
        int[] nodeArr = node.arr;
        for (int i = 0; i < 8; i++) {
            int number = nodeArr[i];
            if (number > 0) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                // 범위안에 들어가는지,
                if (movingChecking(nextY, nextX) && graph[nextY][nextX].smell == 0) {
                    // 이동가능하면 이동하기
                    node.arr[i] = 0;
                    graph[nextY][nextX].newArr[i] += number;
                } else {
                    // 이동 불가능
                    // 현재 방향에 대해서 확인
                    int dir = i;
                    for (int j = 0; j < 7; j++) {
                        // 현재 방향에서 회전
                        dir = rotateDir(dir);
                        nextY = y + dy[dir];
                        nextX = x + dx[dir];
                        if (movingChecking(nextY, nextX) && graph[nextY][nextX].smell == 0) {
                            node.arr[i] = 0;
                            graph[nextY][nextX].newArr[dir] += number;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean movingChecking(int y, int x) {
        return (y >= 0 && x >= 0 && y < 4 && x < 4) && !(y == sharkPos[0] && x == sharkPos[1]);
    }

    public static Node[][] copyGraph() {
        Node[][] copyGraph = new Node[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyGraph[i][j] = new Node();
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Node newNode = copyGraph[i][j];
                Node node = graph[i][j];
                for (int k = 0; k < 8; k++) {
                    newNode.arr[k] = node.arr[k];
                }
            }
        }
        return copyGraph;
    }

    public static int rotateDir(int dir) {
        int newDir = dir - 1;
        if (dir == 0) {
            return 7;
        } else {
            return newDir;
        }
    }

    public static int convertDir(int dir) {
        // 상 좌 하 우
        if (dir == 0) {
            return 2;
        } else if (dir == 1) {
            return 0;
        } else if (dir == 2) {
            return 6;
        } else {
            return 4;
        }
    }

    public static boolean checkingShark(int y, int x) {
        return y >= 0 && y < 4 && x >= 0 && x < 4;
    }
}

