package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_7569 {
    // 토마토가 모두 익은상태 0
    // 토마토가 모두 익지 못하는 상태 -1
    // 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
    // 토마토는 익은 상태의 토마토
    static boolean[][][] visited;
    static int[][][] graph;
    // 상, 하, 좌, 우, 위, 아래
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int result = 0;
    static boolean result1 = true;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        graph = new int[k + 2][m + 2][n + 2];
        visited = new boolean[k + 2][m + 2][n + 2];
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                for (int l = 0; l < n + 2; l++) {
                    graph[i][j][l] = -1;
                }
            }
        }
//      3차원 배열로 입력받기 1,1,1 로 시작
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int l = 1; l < n + 1; l++) {
                    graph[i][j][l] = sc.nextInt();
                }
            }
        }
        // queue 에 i,j 를 추가해서 해당 위치를 기억하자 bfs를 돌릴 위치를 기억하자
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int l = 1; l < n + 1; l++) {
                    if (graph[i][j][l] == 1) {
                        queue.add(new int[]{i, j, l, 1});
                        visited[i][j][l] = true;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                if (graph[now[0] + dx[i]][now[1] + dy[i]][now[2] + dz[i]] == 0
                        && !visited[now[0] + dx[i]][now[1] + dy[i]][now[2] + dz[i]]) {
                    queue.add(new int[]{now[0] + dx[i], now[1] + dy[i], now[2] + dz[i], now[3] + 1});
                    graph[now[0] + dx[i]][now[1] + dy[i]][now[2] + dz[i]] = now[3] + 1;
                    visited[now[0] + dx[i]][now[1] + dy[i]][now[2] + dz[i]] = true;
                }
            }
        }
//        System.out.println("");
//        for (int i = 1; i < m + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                System.out.print(graph[j][i] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int l = 0; l < n + 1; l++) {
                    if (graph[i][j][l] == 0) {
                        result1 = false;
                        break;
                    } else {
                        result = Math.max(graph[i][j][l], result);
                    }
                }
            }
        }
        if (!result1) {
            System.out.println(-1);
        } else if (result == 1) {
            System.out.println(0);
        } else {
            System.out.println(result - 1);
        }
        // 내가 어려운 부분 -> 현재 bfs 를 도는데 한 단계에서 bfs 를 돌려야하는데 어떻게 bfs 를 구현시킬지 어려움
        // 횟수는 어떻게 관리해야할까?
        // bfs 를 다 돈 후에

    }
}

