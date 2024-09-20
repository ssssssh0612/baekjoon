package BaekJoon.DFS;

import java.util.*;

public class 연결_요소의_개수_11724 {
    static List<List<Integer>> list = new ArrayList<List<Integer>>();
    static boolean[] visited;
    static int count;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int node = scan.nextInt();
        int edge = scan.nextInt();
        visited = new boolean[node + 1];
        for (int i = 0; i < node+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            int y = scan.nextInt();
            int x = scan.nextInt();
            list.get(y).add(x);
            list.get(x).add(y);
        }
        for (int i = 1; i < node + 1; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
//        for (int i = 1; i < node + 1; i++) {
//            if(!visited[i]) {
//                dfs(i);
//                count++;
//            }
//        }
        System.out.println(count);
    }
    public static void dfs(int number){
        visited[number] = true;
        for (int i = 0; i < list.get(number).size(); i++) {
            if(!visited[list.get(number).get(i)]) {
                dfs(list.get(number).get(i));
            }
        }
    }
    public static void bfs(int number){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        visited[number] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < list.get(node).size(); i++) {
                if(!visited[list.get(node).get(i)]) {
                    queue.add(list.get(node).get(i));
                    visited[list.get(node).get(i)] = true;
                }
            }
        }
    }
}
