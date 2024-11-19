package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze_16985 {
    // 10 : 44
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int count = 0;
    static int[] arr = new int[5];

    static int[] sort = new int[5];
    static int[][][] graph;
    static boolean[] visited = new boolean[5];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        backTracking(0);
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    public static void input(BufferedReader br) throws IOException {
        graph = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }



    // 순서도 백트래킹 해야함
    public static void backTracking1(int depth, int[][][] oldGraph){
        if(depth == 5){
            int[][][] newGraph = new int[5][5][5];
            for(int i = 0 ; i < 5; i++ ){
                int number = sort[i];
                for(int j = 0 ; j < 5; j ++){
                    for(int k = 0 ; k < 5; k ++){
                        newGraph[i][j][k] = oldGraph[number][j][k];
                    }
                }
            }
            int number = bfs(newGraph);
            if(number != 0){
                result = Math.min(number, result);
            }
            return;
        }
        for(int i = 0 ; i < 5; i++){
            if(!visited[i]){
                sort[depth] = i;
                visited[i] = true;
                backTracking1(depth + 1, oldGraph);
                visited[i] = false;
            }
        }
    }



    public static void backTracking(int depth) {
        if (depth == 5) {
            int[][][] copyGraph = copyGraph(graph);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    rotate(i, arr[i], copyGraph);
                }
            }
            // 회전을 먼저하고
            backTracking1(0,copyGraph);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            backTracking(depth + 1);
        }
    }

    public static int bfs(int[][][] newGraph) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[5][5][5];
        if(newGraph[0][0][0] != 1){
            return 0;
        }
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == 4 && now[1] == 4 && now[2] == 4) {
                count = now[3];
                break;
            }
            for (int i = 0; i < 6; i++) {
                int nextZ = now[0] + dz[i];
                int nextY = now[1] + dy[i];
                int nextX = now[2] + dx[i];
                if (checking(nextZ, nextY, nextX) && newGraph[nextZ][nextY][nextX] == 1
                        && !visited[nextZ][nextY][nextX]) {
                    queue.add(new int[]{nextZ, nextY, nextX, now[3] + 1});
                    visited[nextZ][nextY][nextX] = true;
                }
            }
        }
        return count;
    }

    public static boolean checking(int z, int y, int x) {
        return z >= 0 && y >= 0 && x >= 0 && z < 5 && y < 5 && x < 5;
    }

    public static void rotate(int number, int rotateCount, int[][][] newGraph) {
        for (int i = 0; i < rotateCount; i++) {
            int[][] checkGraph = copyGraph(number, newGraph);
            int index = 4;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    newGraph[number][k][index] = checkGraph[j][k];
                }
                index--;
            }
//            System.out.println("돌린 결과 !!!!! ");
//            for(int j = 0 ; j < 5; j ++){
//                for(int k = 0 ; k < 5; k ++){
//                    System.out.print(newGraph[number][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }


    public static int[][] copyGraph(int number, int[][][] oldGraph) {
        int[][] newGraph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newGraph[i][j] = oldGraph[number][i][j];
            }
        }
        return newGraph;
    }

    public static int[][][] copyGraph(int[][][] oldGraph) {
        int[][][] newGraph = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    newGraph[i][j][k] = oldGraph[i][j][k];
                }
            }
        }
        return newGraph;
    }

    public static void checking() {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(graph[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
