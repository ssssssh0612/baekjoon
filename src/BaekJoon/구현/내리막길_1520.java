package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 내리막길_1520 {
    static class Node {
        int y;
        int x;
        int value;

        public Node(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

    static int[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(map[graph.length - 1][graph[0].length - 1]);
    }

    public static void bfs() {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        };
        map[0][0] = 1;
        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);
        queue.add(new Node(0, 0, graph[0][0]));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
//            checkingGraph();
            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + now.y;
                int nextX = dx[i] + now.x;
                if (checking(nextY, nextX) && now.value > graph[nextY][nextX]) {
                    if (map[nextY][nextX] == 0) {
                        queue.add(new Node(nextY, nextX, graph[nextY][nextX]));
                    }
                    map[nextY][nextX] += map[now.y][now.x];
                }
            }
        }
    }
    public static void checkingGraph(){
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0 ; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }


}
