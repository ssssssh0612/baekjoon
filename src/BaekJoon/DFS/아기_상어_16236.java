package BaekJoon.DFS;

import java.util.*;

public class 아기_상어_16236 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] graph;
    static boolean flag = true;
    static int[] sharkPos;
    static int shark = 2;
    static int sharkCount = 0;
    static int n;

    static int sharkDistance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        // 현재 상어 위치
        sharkPos = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 9) {
                    sharkPos[0] = i; // y
                    sharkPos[1] = j; // x
                }
            }
        }

        while (flag) {
            // 먹이 찾기
            // 먹이 동선 그래프
            List<int[]> eatList = new ArrayList<int[]>();
            int[][] eatGraph = new int[n][n];
            boolean[][] visited = new boolean[n][n];

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > shark) {
                        eatGraph[i][j] = -1;
                    } else if (graph[i][j] == shark) {
                        eatGraph[i][j] = 0;
                    } else if (graph[i][j] < shark && graph[i][j] > 0) {
                        eatGraph[i][j] = 1;
//                        System.out.println("eatList = " + i + "," + j);
                        eatList.add(new int[]{i, j, 0});
                    }
                }
            }
//            System.out.println();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(eatGraph[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            bfs(sharkPos[0], sharkPos[1], eatGraph, visited, eatList); // 상어 위치 기준 먹이찾기
        }
        System.out.println(sharkDistance);
    }

    public static void bfs(int y, int x, int[][] eatGraph, boolean[][] visited, List<int[]> eatList) {
        Queue<int[]> queue = new LinkedList<>();
        eatGraph[y][x] = 1;
        visited[y][x] = true;
        queue.offer(new int[]{y, x, 1});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (now[0] + dy[i] >= 0 && now[1] + dx[i] >= 0 &&
                        now[0] + dy[i] < n && now[1] + dx[i] < n &&
                        !visited[now[0] + dy[i]][now[1] + dx[i]] &&
                        eatGraph[now[0] + dy[i]][now[1] + dx[i]] != -1) {
                    queue.offer(new int[]{now[0] + dy[i], now[1] + dx[i], now[2] + 1});
                    visited[now[0] + dy[i]][now[1] + dx[i]] = true;
                    eatGraph[now[0] + dy[i]][now[1] + dx[i]] = now[2] + 1;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(eatGraph[i][j] + " ");
//            }
//            System.out.println();
//        }


        // 먹을 수 잇는 먹이인지 아닌지 체크함
        for (int i = 0; i < eatList.size(); i++) {
            eatList.get(i)[2] = eatGraph[eatList.get(i)[0]][eatList.get(i)[1]];
//            System.out.println("eatList =" + eatList.get(i)[0] + "," + eatList.get(i)[1] + "," + eatList.get(i)[2]);
            // 1이면 도달할 수 없는 먹이
//            if(eatGraph[eatList.get(i)[0]][eatList.get(i)[1]] == 1) {
//                eatList.remove(i);
//            } else{
//            }
        }
        for (int i = eatList.size() - 1; i >= 0; i--) {
            if (eatList.get(i)[2] == 1) {
//                System.out.println("사라지는 eatList =" + eatList.get(i)[0] + "," + eatList.get(i)[1] + "," + eatList.get(i)[2]);
                eatList.remove(i);
            }
//            System.out.println();
        }


            if (eatList.isEmpty()) {
                flag = false;
                return;
            }
            eatList.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // 거리 기준으로 비교
                    int distanceComparison = Integer.compare(a[2], b[2]);
                    if (distanceComparison != 0) {
                        return distanceComparison;
                    }

                    // Y 좌표 기준으로 비교 (거리 같을 때)
                    int yComparison = Integer.compare(a[0], b[0]);
                    if (yComparison != 0) {
                        return yComparison;
                    }

                    // X 좌표 기준으로 비교(Y 좌표도같을때)
                    return Integer.compare(a[1], b[1]);
                }
            });
            sharkPos[0] = eatList.get(0)[0];
            sharkPos[1] = eatList.get(0)[1];
            graph[eatList.get(0)[0]][eatList.get(0)[1]] = 9;
            graph[y][x] = 0;
            sharkDistance = sharkDistance + eatList.get(0)[2] - 1;
            sharkCount++;

            if (shark == sharkCount) {
                shark++;
                sharkCount = 0;
            }
        }
    }
