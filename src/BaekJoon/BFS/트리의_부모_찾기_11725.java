package BaekJoon.BFS;

import java.util.*;

public class 트리의_부모_찾기_11725 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        BFS(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
    public static void BFS(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int i = 0; i < graph.get(now).size(); i++) {
                if (!visited[graph.get(now).get(i)]) {
                    queue.add(graph.get(now).get(i));
                    parent[graph.get(now).get(i)] = now;
                }
            }
        }
    }
}
