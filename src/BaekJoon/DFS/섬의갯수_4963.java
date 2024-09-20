package BaekJoon.DFS;

import java.util.Scanner;

public class 섬의갯수_4963 {
    //
    static int[] dx = {0,0,-1,1,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,-1,1,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int count = 0;
            if(x == 0 && y == 0){
                flag = false;
                break;
            }
            int[][] graph = new int[y][x];
            boolean[][] visited = new boolean[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
//            System.out.println("graph입니다");
//            for (int i = 0; i < y; i++) {
//                for (int j = 0; j < x; j++) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if(!visited[i][j] && (graph[i][j] == 1)){
                        dfs(visited,graph,i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void dfs(boolean[][] visited,int[][] graph, int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nowY = y + dx[i];
            int nowX = x + dy[i];
            if(checking(graph.length , graph[0].length , nowY , nowX) && graph[nowY][nowX] == 1 && !visited[nowY][nowX]){
                dfs(visited, graph, nowY, nowX);
            }
        }
    }
    public static boolean checking(int y , int x , int nowY, int nowX){
        return nowY >=0 && nowX >=0 && nowY < y && nowX < x;
    }
}
