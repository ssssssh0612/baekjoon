package BaekJoon.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Queue {
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static int[][] graph = {{1},{0,2,3},{1,3,4},{1,2,4,5},{2,3},{3,6,7},{5,8},{5},{6}};
    public static void main(String[] args) {
        visited = new boolean[9];
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now+" -> ");
            for (int i = 0; i < graph[now].length; i++) {
                if(!visited[graph[now][i]]){
                    visited[graph[now][i]] = true;
                    queue.add(graph[now][i]);
                }
            }
        }
    }
}
