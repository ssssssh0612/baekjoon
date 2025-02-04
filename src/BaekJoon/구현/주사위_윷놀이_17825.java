package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 주사위_윷놀이_17825 {
    public static class Horse {
        int y;
        int x;
        boolean finished;

        public Horse(int y, int x) {
            this.y = y;
            this.x = x;
            this.finished = false;
        }
    }

    static boolean[][] visited;
    static int[][] graph;
    static List<Horse> horseList = new ArrayList<>();
    static int[] arr;
    static int[] result = new int[10];
    static int count = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        graph = new int[4][];
        visited = new boolean[4][];
        int[] arr1 = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        int[] arr2 = new int[]{10, 13, 16, 19, 25, 30, 35, 40};
        int[] arr3 = new int[]{20, 22, 24, 25, 30, 35, 40};
        int[] arr4 = new int[]{30, 28, 27, 26, 25, 30, 35, 40};
        graph[0] = arr1;
        visited[0] = new boolean[arr1.length];
        graph[1] = arr2;
        visited[1] = new boolean[arr2.length];
        graph[2] = arr3;
        visited[2] = new boolean[arr3.length];
        graph[3] = arr4;
        visited[3] = new boolean[arr4.length];
        for (int i = 0; i < 4; i++) {
            horseList.add(new Horse(0, 0));
        }

        backTracking(0);

        System.out.println(count);
        // 말의 위치를 되돌려야함
    }

    public static void backTracking(int depth) {
        if (depth == 10) {
            int compare = 0;
            for (int i = 0; i < 10; i++) {
//                System.out.print(result[i] + " ");
                compare += result[i];
            }
//            System.out.println();
            count = Math.max(count, compare);
            return;
        }

        // 1번말, 2번말, 3번말, 4번말
        for (int i = 0; i < 4; i++) {
            // 현재 말 갖고와서 nextStep더해주기
            Horse newHorse = horseList.get(i);
            int nowY = newHorse.y;
            int nowX = newHorse.x;

            if (newHorse.finished) {
                continue;
            }
            int nextStep = arr[depth];
            int nextY = newHorse.y;
            int nextX = newHorse.x + nextStep;
            // 같은게 있는지 체크 -> visited

            boolean flag = true;
            // 도착지점을 넘었을경우 에러처리, 도착지점보다 큰경우
            if (graph[nextY].length <= nextX) {
                flag = false;
                visited[nowY][nowX] = false;
                result[depth] = 0;
                newHorse.finished = true;
            } else {
                if (graph[nextY][nextX] == 10 && !visited[1][0]) {
                    visited[1][0] = true;
                    visited[nowY][nowX] = false;
                    newHorse.y = 1;
                    newHorse.x = 0;
                    result[depth] = 10;
                } else if (graph[nextY][nextX] == 20 && !visited[2][0]) {
                    visited[2][0] = true;
                    visited[nowY][nowX] = false;
                    newHorse.y = 2;
                    newHorse.x = 0;
                    result[depth] = 20;
                } else if (graph[nextY][nextX] == 30 && !visited[3][0]) {
                    visited[3][0] = true;
                    visited[nowY][nowX] = false;
                    newHorse.y = 3;
                    newHorse.x = 0;
                    result[depth] = 30;
                } else if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    visited[nowY][nowX] = false;
                    newHorse.y = nextY;
                    newHorse.x = nextX;
                    result[depth] = graph[nextY][nextX];
                } else {
                    continue;
                }
            }
            backTracking(depth + 1);
            if (!flag) {
                visited[nowY][nowX] = true;
                newHorse.finished = false;
            } else {
                visited[nextY][nextX] = false;
                newHorse.y = nowY;
                newHorse.x = nowX;
                visited[nowY][nowX] = true;
            }
        }
    }
}
