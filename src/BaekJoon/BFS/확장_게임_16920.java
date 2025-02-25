package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 확장_게임_16920 {
    static int[] playerArr;
    static List<Queue<int[]>> list = new ArrayList<>();
    static int[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        int player = Integer.parseInt(st.nextToken());
        playerArr = new int[player];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < player; i++) {
            playerArr[i] = Integer.parseInt(st.nextToken());
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = str.charAt(j);
                int number = 0;
                if (ch == '#') {
                    number = -1;
                } else if (ch == '.') {
                    number = 0;
                } else {
                    number = ch - '0';
                }
                graph[i][j] = number;
                if (number != 0 && number != -1) {
                    list.get(number - 1).add(new int[]{i, j});
                }
            }
        }
        while (true) {
            for (int i = 0; i < playerArr.length; i++) {
                bfs(i);
            }
            int check = 0;
            for(int i = 0 ; i < list.size(); i++){
                if(list.get(i).isEmpty()){
                    check++;
                }
            }
            if(check == list.size()){
                break;
            }
        }
        result();
    }

    public static void bfs(int playerNumber) {
        Queue<int[]> queue = list.get(playerNumber);
        // 큐를 갖고옴
        for (int i = 0; i < playerArr[playerNumber]; i++) {
            // 횟수만큼 반복을 함
            int size = queue.size();
            if(size == 0){
                return;
            }
            bfs2(queue, size, playerNumber);
        }
    }

    public static void bfs2(Queue<int[]> queue, int size, int playerNumber) {
        for (int i = 0; i < size; i++) {
            int[] now = queue.poll();
            for (int j = 0; j < 4; j++) {
                int nextY = now[0] + dy[j];
                int nextX = now[1] + dx[j];
                if (checking(nextY, nextX) && graph[nextY][nextX] == 0) {
                    queue.add(new int[]{nextY, nextX});
                    graph[nextY][nextX] = playerNumber + 1;
                }
            }
        }
    }

    public static void result() {
        int[] arr = new int[playerArr.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                int number = graph[i][j];
                if (number > 0) {
                    arr[number - 1]++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void checkingGraph() {
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
