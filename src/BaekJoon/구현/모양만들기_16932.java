package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 모양만들기_16932 {
    static int[][] graph;
    static int count;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 2;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] == 1) {
                    dfs(i, j, index);
                    map.put(index, count);
                    count = 0;
                    index++;
                }
            }
        }


        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if(checking(nextY, nextX) && graph[nextY][nextX] != 0 && !set.contains(graph[nextY][nextX])){
                            set.add(graph[nextY][nextX]);
                            sum += map.get(graph[nextY][nextX]);
                        }
                    }
                    result = Math.max(result, sum + 1);
                }
            }
        }

        System.out.println(result);

    }

    public static void dfs(int y, int x, int index) {
        graph[y][x] = index;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextY = dy[i] + y;
            int nextX = dx[i] + x;
            if (checking(nextY, nextX) && graph[nextY][nextX] == 1) {
                dfs(nextY, nextX, index);
            }
        }
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
