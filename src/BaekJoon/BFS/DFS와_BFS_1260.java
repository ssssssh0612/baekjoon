package BaekJoon.BFS;

import java.util.*;

public class DFS와_BFS_1260 {
    // DFS 인 경우
    // BFS 인 경우
    static List<List<Integer>> graph = new ArrayList<List<Integer>>();
    static Queue<Integer> queue = new LinkedList<Integer>();
    static int node;
    static int edge;
    static int startNum;
    static boolean[] bfsVisited;
    static boolean[] dfsVisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node = sc.nextInt();
        edge = sc.nextInt();
        startNum = sc.nextInt();
        bfsVisited = new boolean[node+1];
        dfsVisited = new boolean[node+1];
        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            Collections.sort(graph.get(a));
            Collections.sort(graph.get(b));
        }
        DFS(startNum);
        System.out.println();
        BFS(startNum);
    }
    public static void BFS(int node) {
        bfsVisited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now+" ");
            for (Integer neighbor : graph.get(now)) {
                if(!bfsVisited[neighbor]) {
                    bfsVisited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void DFS(int node) {
        dfsVisited[node] = true;
        System.out.print(node+" ");
        for (Integer neighbor : graph.get(node)) {
            if(!dfsVisited[neighbor]) {
                DFS(neighbor);
            }
        }
    }
}
