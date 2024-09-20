package BaekJoon.DFS;

import java.util.*;

public class 양_3184 {
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    // dfs 를 돌면서 늑대,양의 수를 센 후 늑대를 없앨지 양을 없앨지 선택한다
    static List<int[]> wolfList = new ArrayList<>();
    static List<int[]> sheepList = new ArrayList<>();
    static int[][] graph;
    static boolean[][] visited;
    static int sheepCount;
    static int wolfCount;

    public static void main(String[] args) {
        // 늑대, 울타리, 양, 빈칸
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        visited = new boolean[y][x];
        graph = new int[y][x];
        sc.nextLine();
        for (int i = 0; i < y; i++) {
            String a = sc.next();
            for (int j = 0; j < x; j++) {
                if (a.charAt(j) == '.') { // 영역
                    graph[i][j] = 0;
                } else if (a.charAt(j) == 'v') { // 늑대
                    graph[i][j] = 1;
                } else if (a.charAt(j) == 'o') { // 양
                    graph[i][j] = 2;
                } else {
                    graph[i][j] = -1; // # 울타리
                }
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] != -1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 1){
                    wolfCount++;
                }else if(graph[i][j] == 2){
                    sheepCount++;
                }
            }
        }
        System.out.println(sheepCount+" "+wolfCount);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        if(graph[y][x] == 1){
            wolfList.add(new int[]{y, x});
        } else if(graph[y][x] == 2){
            sheepList.add(new int[]{y, x});
        }
        visited[y][x] = true;
        queue.offer(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if( ny >= 0 && nx >= 0 && ny < graph.length &&
                        nx < graph[0].length && !visited[ny][nx] && graph[ny][nx] != -1 ){
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    if(graph[ny][nx] == 1){ // 늑대
                        wolfList.add(new int[]{ny, nx});
                    } else if (graph[ny][nx] == 2) {
                        sheepList.add(new int[]{ny, nx});
                    }
                }
            }
        }
        if(!sheepList.isEmpty() && !wolfList.isEmpty()){
            if( sheepList.size() > wolfList.size()){
                for (int i = 0; i < wolfList.size(); i++) {
                    graph[wolfList.get(i)[0]][wolfList.get(i)[1]] = 0;
                }
            }else {
                for (int i = 0; i < sheepList.size(); i++) {
                    graph[sheepList.get(i)[0]][sheepList.get(i)[1]] = 0;
                }
            }
        }
        wolfList.clear();
        sheepList.clear();
    }
}
