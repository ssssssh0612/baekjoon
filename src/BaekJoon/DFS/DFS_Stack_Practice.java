package BaekJoon.DFS;

import java.util.Stack;

//public class DFS_Stack_Practice {
//    static int [][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
//    static boolean visited[] = new boolean[9];
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(1);
//        visited[1] = true;
//        while(!stack.isEmpty()) {
//            int popItem = stack.pop();
//            System.out.println(popItem + "->");
//
//            for (int i = 0; i <graph[popItem].length; i++) {
//                if(!visited[graph[popItem][i]]){
//                    stack.push(graph[popItem][i]);
//                    visited[graph[popItem][i]] = true;
//                }
//            }
//        }
//    }
//}

public class DFS_Stack_Practice {
    static int[][] graph = {{1}, {2, 3}, {1, 3, 4}, {1, 2, 4, 5}, {2, 3}, {3, 6, 7}, {5, 8}, {5}, {6}};
    static Stack<Integer> stack = new Stack<Integer>();
    static boolean[] visited = new boolean[graph.length];

    public static void main(String[] args) {
        stack.push(0);
        dfs(0);
    }

    public static void dfs(int startStack) {
        visited[startStack] = true;
        while (!stack.isEmpty()) {
            int now = stack.pop();
            System.out.print(now + "->");
            for (int i = 0; i < graph[now].length; i++) {
                if (!visited[graph[now][i]]) {
                    stack.push(graph[now][i]);
                    visited[graph[now][i]] = true;
                }
            }
        }
    }
}