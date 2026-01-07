package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일루미네이션_5547 {
    static int result;
    static int[][] graph;
    static int[] holY = {0,-1,-1,0,1,1};
    static int[] holX = {-1,0,1,1,1,0};
    static int[] jY = {0,1,1,0,-1,-1};
    static int[] jX = {1,0,-1,-1,-1,0};
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(graph[i][j] == 1){
                    if (i % 2 == 1) {
                        // 홀수인 경우
                        for (int k = 0; k < 6; k++) {
                            int nextY = i + holY[k];
                            int nextX = j + holX[k];
                            if(graph[nextY][nextX] == 0){
                                result++;
                            }
                        }

                    } else {
                        // 짝수인 경우
                        for (int k = 0; k < 6; k++) {
                            int nextY = i + jY[k];
                            int nextX = j + jX[k];
                            if(graph[nextY][nextX] == 0){
                                result++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
    public static void bfs(){
        // 현재 여기서 bfs했을때 visited가 false인 애들은 1로 색칠
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] % 2 == 1){
                for (int i = 0; i < 6; i++) {
                    int nextY = holY[i] + now[0];
                    int nextX = holX[i] + now[1];
                    if (checking(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 0) {
                        queue.add(new int[]{nextY,nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }else{
                for (int i = 0; i < 6; i++) {
                    int nextY = jY[i] + now[0];
                    int nextX = jX[i] + now[1];
                    if (checking(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 0) {
                        queue.add(new int[]{nextY,nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(!visited[i][j] &&  graph[i][j] == 0){
                    graph[i][j] = 1;
                }
            }
        }

    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }
}
