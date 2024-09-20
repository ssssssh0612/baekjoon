package BaekJoon.BFS;

import java.util.*;

public class 알고리즘_수업_너비우선탐색_24444 {
    static List<List<Integer>> list = new ArrayList<>();
    static int node;
    static int edge;
    static int startNode;
    static boolean[] visited;
    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node = sc.nextInt();
        edge = sc.nextInt();
        count = new int[node + 1];
        visited = new boolean[node + 1];
        startNode = sc.nextInt();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < node; i++) {
            Collections.sort(list.get(i));
        }
        bfs(startNode);
        for (int i = 1; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }


    public static void bfs( int number ){
        Queue<Integer> queue = new LinkedList<>();
        visited[number] = true;
        queue.add(number);
        int numberCount = 1;
        count[number] = numberCount;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int i = 0; i < list.get(node).size(); i++) {
                if( !visited[list.get(node).get(i)] ){
                    queue.add(list.get(node).get(i));
                    visited[list.get(node).get(i)] = true;
                    numberCount++;
                    count[list.get(node).get(i)] = numberCount;
                }
            }
        }
    }
}
