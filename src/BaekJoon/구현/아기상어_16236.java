package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static int[] sharkPos = new int[2];
    static int sharkSize = 2;
    static int sharkCount = 0;
    static int time = 0;
    static int fish = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==9){
                    sharkPos[0] = i;
                    sharkPos[1] = j;
                }else if(graph[i][j] > 0){
                    fish++;
                }
            }
        }
        bfs();
        System.out.println(time);
    }


    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int distance = 0;
        while(fish > 0){
            int eatY = -1;
            int eatX = -1;
            boolean[][] visited = new boolean[graph.length][graph[0].length];
            visited[sharkPos[0]][sharkPos[1]] = true;
            queue.offer(new int[]{sharkPos[0],sharkPos[1]});
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean flag = false;
                while (size > 0) {
                    size--;
                    for (int i = 0; i < 4; i++) {
                        int nowY = sharkPos[0] + dy[i];
                        int nowX = sharkPos[1] + dx[i];
                        if (checking(nowY, nowX) && !visited[nowY][nowX]) {
                            if (graph[nowY][nowX] > 0 && graph[nowY][nowX] < sharkSize) {
                                flag = true;
                                if (eatY == -1 && eatX == -1) {
                                    eatY = nowY;
                                    eatX = nowX;
                                    // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                                } else {
                                    if (eatY > nowY) {
                                        eatY = nowY;
                                        eatX = nowX;
                                    } else if (eatY == nowY && eatX > nowX) {
                                        eatY = nowY;
                                        eatX = nowX;
                                    }
                                }
                            } else {
                                queue.add(new int[]{nowY, nowX});
                                visited[nowY][nowX] = true;
                            }
                        }
                    }
                }
                distance++;
                if (flag) {
                    sharkPos[0] = eatY;
                    sharkPos[1] = eatX;
                    graph[eatY][eatX] = 0;
                    sharkCount++;
                    if (sharkCount == sharkSize) {
                        sharkSize++;
                        sharkCount = 0;
                    }
                    time += distance;
                    fish--;
                    break;
                }
            }
            if (eatY == -1 && eatX == -1) {
                break;
            }
        }
        // 거리가 가장 가까운 물고기를 먹는다.
        // 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다. -> bfs

    }
    // 지나갈 수 있는
    public static boolean checking(int y, int x){
       return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length && graph[y][x] <= sharkSize;
    }
}
