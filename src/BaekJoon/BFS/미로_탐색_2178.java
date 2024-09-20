package BaekJoon.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 미로_탐색_2178 {
    static int[][] graph;
    static int[][] distance;
    static boolean[][] visited;
    // 동,서,남,북 순으로 이동
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Integer[]> queue = new LinkedList<Integer[]>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        sc.nextLine();
//        // 어차피 겉은 기본값인 0으로 찍힘
//        visited = new boolean[a + 2][b + 2];
//        graph = new int[a + 2][b + 2];
//        distance = new int[a + 2][b + 2];
//        for (int i = 1; i <= a; i++) {
//            String line = sc.nextLine();
//            for (int j = 1; j <= b; j++) {
//                graph[i][j] = line.charAt(j - 1) - '0'; // 문자를 정수로 변환
//                if (graph[i][j] == 0) {
//                    visited[i][j] = false;
//                } else {
//                    visited[i][j] = true;
//                }
//            }
//        }
//        distance[1][1] = 0;
//        bfs(1, 1);
//        System.out.println(distance[a][b]+1);
//
//    }
//
//    public static void dfs(int x, int y) {
//        visited[x][y] = false;
//        for (int i = 0; i < 4; i++) {
//            if (visited[x + dx[i]][y + dy[i]]) {
//                distance[x + dx[i]][y + dy[i]] = distance[x][y] + 1;
//                dfs(x + dx[i], y + dy[i]);
//            }
//        }
//    }
//
//    public static void bfs(int x, int y) {
//        queue.add(new Integer[]{x, y});
//        visited[x][y] = false;
//        while (!queue.isEmpty()) {
//            Integer[] now  = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                if (visited[now[0] + dx[i]][now[1] + dy[i]]) {
//                    distance[now[0] + dx[i]][now[1] + dy[i]] = distance[now[0]][now[1]] + 1;
//                    visited[now[0] + dx[i]][now[1] + dy[i]] = false;
//                    queue.add(new Integer[]{now[0] + dx[i], now[1] + dy[i]});
//                }
//            }
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        boolean[][] maze = new boolean[n][];
        Queue<Cell> queue = new LinkedList<>();
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            char[] m = br.readLine().toCharArray();
            maze[i] = new boolean[m.length];

            for (int j = 0; j < m.length; j++)
                if (m[j] == '1')
                    maze[i][j] = true;
        }

        queue.offer(new Cell(0, 0, 1));
        maze[0][0] = false;

        while (!queue.isEmpty()) {
            Cell[] dir = {new Cell(-1, 0), new Cell(0, 1), new Cell(1, 0), new Cell(0, -1)};
            Cell cell = queue.poll();

            if (cell.x == n - 1 && cell.y == maze[0].length - 1) {
                bw.write(cell.cnt + "");
                break;
            }

            for (Cell d : dir) {
                int nx = cell.x + d.x;
                int ny = cell.y + d.y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < maze[0].length && maze[nx][ny]) {
                    queue.offer(new Cell(nx, ny, cell.cnt + 1));
                    maze[nx][ny] = false;
                }
            }
        }

        br.close();
        bw.close();
    }

    public static class Cell {
        int x, y, cnt;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Cell(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
