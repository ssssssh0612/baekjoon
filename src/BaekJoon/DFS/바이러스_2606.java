package BaekJoon.DFS;

//public class 바이러스_2606 {
//    static int node = 0;
//    static int edge = 0;
//    static int count = 0;
//    static boolean[] visited;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        node = sc.nextInt();
//        edge = sc.nextInt();
//        visited = new boolean[node];
//
//        List<ArrayList<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i < node; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < edge; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            graph.get(a - 1).add(b - 1);
//            graph.get(b - 1).add(a - 1);
//        }
//
//        dfs(0, graph); // 0번 노드부터 DFS 시작
//        System.out.println(count-1);
//    }
//
//    static void dfs(int nodeIndex, List<ArrayList<Integer>> graph) {
//        // 방문 처리
//        visited[nodeIndex] = true;
//        count++;
//
//        for (int adjacentNode : graph.get(nodeIndex)) {
//            if (!visited[adjacentNode]) {
//                dfs(adjacentNode, graph);
//            }
//        }
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 바이러스_2606 {
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static int[][] graph;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        visited = new boolean[node+1];
        for (int i = 0; i < 101; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < edge + 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 주요 로직
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1);
        dfsWithStack(1);
        System.out.println(count);
    }

    public static void dfs(int number) {
        visited[number] = true;
        for (int i = 0; i < list.get(number).size(); i++) {
            if (!visited[list.get(number).get(i)]) {
                visited[list.get(number).get(i)] = true;
                count++;
                dfs(list.get(number).get(i));
            }
        }
    }
    public static void dfsWithStack(int number) {
        Stack<Integer> stack = new Stack<>();
        stack.push(number);
        visited[number] = true;
        while (!stack.isEmpty()) {
//            int now = stack.pop();
//            for (int i = 0; i < ; i++) {
//
//            }
        }
    }
    public static void bfs(int number) {
    }
}
