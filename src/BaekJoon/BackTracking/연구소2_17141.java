package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소2_17141 {
    static int[][] graph;
    static List<int[]> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int finalResult = 0;
    static int resultCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        arr = new int[m * 2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
//                graph[i][j] = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                if (number == 2) {
                    list.add(new int[]{i, j});
                } else {
                    graph[i][j] = number;
                }
            }
        }
        visited = new boolean[list.size()];

        backTracking(0, 0);

        if (finalResult == -2) {
            System.out.println(-1);
        } else {
            System.out.println(finalResult);
        }

    }

    public static void backTracking(int depth, int number) {
        if (depth == arr.length) {
            int check = bfs(arr);
            if (resultCount == 0) {
                finalResult = check;
            } else {
                // -1 인데 0보다 큰게 온경우
                // 0보다 큰데 -1 이 온경우
                if( check > 0 && finalResult == -1){
                    finalResult = check;
                }else if(check > 0 && finalResult > 0){
                    finalResult = Math.min(finalResult,check);
                }
            }
            resultCount++;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i] && number <= i) {
                visited[i] = true;
                arr[depth] = list.get(i)[0];
                arr[depth + 1] = list.get(i)[1];
                backTracking(depth + 2, i);
                visited[i] = false;
            }
        }
    }

    public static int bfs(int[] newArr) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] newGraph = copyGraph();
        boolean[][] visited = new boolean[graph.length][graph[0].length];

        for (int i = 0; i < newArr.length; i += 2) {
            queue.add(new int[]{newArr[i], newArr[i + 1]});
            newGraph[newArr[i]][newArr[i + 1]] = 1;
            visited[newArr[i]][newArr[i + 1]] = true;
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int number = newGraph[now[0]][now[1]];
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if (checking(nowY, nowX) && !visited[nowY][nowX] && newGraph[nowY][nowX] == 0) {
                    visited[nowY][nowX] = true;
                    queue.add(new int[]{nowY, nowX});
                    newGraph[nowY][nowX] = number + 1;
                }
            }
        }
//        checking(newGraph);
        int maxNum = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (newGraph[i][j] == 0) {
                    return -1;
                } else {
                    maxNum = Math.max(newGraph[i][j], maxNum);
                }
            }
        }
//        System.out.println("maxNum =" + maxNum);
        return maxNum - 1;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }

    public static int[][] copyGraph() {
        int[][] newGraph = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

    public static void checking(int[][] printGraph) {
        System.out.println();
        for (int i = 0; i < printGraph.length; i++) {
            for (int j = 0; j < printGraph[0].length; j++) {
                System.out.print(printGraph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
