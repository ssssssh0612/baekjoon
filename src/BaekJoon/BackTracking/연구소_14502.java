package BaekJoon.BackTracking;

import java.util.*;

public class 연구소_14502 {
    static int[] arr = new int[6];
    static int y ;
    static int x ;
    static int[][] graph;
    static List<int[]> list = new ArrayList<int[]>();
    static boolean[] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int count = 0;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
                if( graph[i][j] == 0 ){
                    list.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[list.size()];
        backTracking(0,0);
        System.out.println(result);
    }
    public static void backTracking( int depth, int index ) {
        if(depth == 6){
            count++;
            int[][] copyGraph = new int[graph.length][];
            for (int i = 0; i < graph.length; i++) {
                copyGraph[i] = graph[i].clone();
            }
            for (int i = 0; i < 6; i+=2) {
                // 0은 빈 칸, 1은 벽, 2는 바이러스
                copyGraph[arr[i]][arr[i+1]] = 1;
            }
            if( count == 1 ){
                result = count0(virus(copyGraph));
            }else {
                result = Math.max(result, count0(virus(copyGraph)));
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i] && index <= i ){
                visited[i] = true;
                arr[depth] = list.get(i)[0];
                arr[depth+1] = list.get(i)[1];
                backTracking(depth+2, i);
                visited[i] = false;
            }
        }
    }

    public static int count0( int[][] graph ){
        int count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] virus( int[][] copyGraph ){
        boolean[][] visited = new boolean[y][x];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if( graph[i][j] == 2 ){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if(checking(nowY , nowX) && copyGraph[nowY][nowX] == 0 && !visited[nowY][nowX]){
                    queue.add(new int[]{nowY,nowX});
                    copyGraph[nowY][nowX] = 2;
                    visited[nowY][nowX] = true;
                }
            }
        }
        return copyGraph;
    }

    public static boolean checking( int nowY , int nowX){
        return nowY >= 0 && nowY < y && nowX >= 0 && nowX < x;
    }
}
