package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어_2_17086 {
    static int[][] graph;
    static int[] dx = {0,0,-1,1,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,-1,-1,1,1};
    static List<int[]> list = new ArrayList<int[]>();
    static int count =0;
    static int result=0;
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
                if(graph[i][j]==1){
                    list.add(new int[]{i,j});
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            bfs(list.get(i)[0], list.get(i)[1]);
        }

        System.out.println(result);

    }
    public static void bfs(int y, int x){
        int[][] newGraph = new int[graph.length][graph[0].length];
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y,x});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int number = newGraph[poll[0]][poll[1]];
            for (int i = 0; i < 8; i++) {
                int nowY = poll[0] + dy[i];
                int nowX = poll[1] + dx[i];
                if(checking(nowY,nowX) && !visited[nowY][nowX]){
                    queue.add(new int[]{nowY,nowX});
                    visited[nowY][nowX] = true;
                    newGraph[nowY][nowX] = number + 1;
                }
            }
        }
//        System.out.println();
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[0].length; j++) {
//                System.out.print(newGraph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            if( y != list.get(i)[0] || x != list.get(i)[1]){
                if(count == 0){
                    result = newGraph[list.get(i)[0]][list.get(i)[1]];
                    count++;
                }else{
                    result = Math.min(result,newGraph[list.get(i)[0]][list.get(i)[1]]);
                }
            }
        }
    }

    public static boolean checking(int y, int x){
        return y >= 0 && y < graph.length && x >= 0 && x < graph[0].length;

    }
}
