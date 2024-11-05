package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 소문난칠공주_2_1941 {
    static int[][] graph = new int[5][5];
    static int[] arr = new int[14];
    static List<int[]> list = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        boolean[] visited = new boolean[25];
        backTracking(0,0,visited);
        System.out.println(result);
    }

    public static void input(BufferedReader br) throws IOException {
        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            for (int j = 0; j < 5; j++) {
                char ch = a.charAt(j);
                list.add(new int[]{i, j});
                if (ch == 'S') { // 솜이 1
                    graph[i][j] = 1;
                } else { // 연이 1
                    graph[i][j] = 0;
                }
            }
        }
    }

    //이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
    //강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
    //화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
    //그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
    public static boolean checking(int y, int x) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }

    // 25개중에서 7개를 뽑고나서 bfs를 돌려보고 count가 7이 되면
    public static void backTracking(int depth, int number, boolean[] visited) {
        if (depth == 14) {
            if (checkSom()) {
                bfs();
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i] && i >= number) {
                visited[i] = true;
                arr[depth] = list.get(i)[0];
                arr[depth + 1] = list.get(i)[1];
                backTracking(depth + 2, i, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean checkSom() {
        int count = 0;
        for (int i = 0; i < 14; i += 2) {
            int y = arr[i];
            int x = arr[i + 1];
            if (graph[y][x] == 1) {
                count++;
            }
        }
        if (count >= 4) {
            return true;
        }
        return false;
    }

    public static void bfs() {
        boolean[][] visited = new boolean[5][5];
        int[][] bfsGraph = new int[5][5];
        int count = 1;
        for (int i = 0; i < 14; i += 2) {
            int y = arr[i];
            int x = arr[i + 1];
            bfsGraph[y][x] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{arr[0], arr[1]});
        visited[arr[0]][arr[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (checking(nextY, nextX) && !visited[nextY][nextX] && bfsGraph[nextY][nextX] == 1) {
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    count++;
                }
            }
        }
        if(count == 7){
            result++;
        }
    }
}
