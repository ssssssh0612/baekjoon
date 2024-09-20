package BaekJoon.BFS;
//
//import java.util.*;
//
//public class 촌수계산_2644 {
//    // 최단경로 문제
//    // x 로 시작해서 y 까지 count 를 얼마나하는지
//    static int node;
//    static int startNode;
//    static int endNode;
//    static int edge;
//    static Queue<Integer> queue = new LinkedList<>();
//    static boolean[] visited1;
//    static boolean flag;
//    static List<List<Integer>> graph = new ArrayList<List<Integer>>();
//    static int count;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        node = sc.nextInt();
//        startNode = sc.nextInt();
//        endNode = sc.nextInt();
//        edge = sc.nextInt();
//        visited1 = new boolean[node+1];
//        for (int i = 0; i < node+1; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int i = 0; i < edge; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            graph.get(a).add(b);
//            graph.get(b).add(a);
//        }
//        BFS1(startNode, endNode);
//        System.out.println(count);
//    }
//
//    public static void BFS1(int startNode, int endNode) {
//        // 최단거리로 무조건 가야함 즉 자식노드인 애들은 방문하지않음 오직 부모노드만
//        queue.add(startNode);
//        visited1[startNode] = true;
//        while(!queue.isEmpty()) {
//            int now =  queue.poll();
//            if(now == endNode) {
//                flag = true;
//                return;
//            }
//            for (int i = 0; i < graph.get(now).size(); i++) {
//                if(!visited1[graph.get(now).get(i)]) {
//                    visited1[graph.get(now).get(i)] = true;
//                    queue.add(graph.get(now).get(i));
//                }
//            }
//        }
//    }
//}

import java.util.*;

public class 촌수계산_2644 {
    static int n;  // 전체 사람 수
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int startNode = sc.nextInt();
        int endNode = sc.nextInt();
        int edgeCount = sc.nextInt();

        distance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = BFS(startNode, endNode);
        System.out.println(result);
    }

    public static int BFS(int startNode, int endNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        distance[startNode] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now);
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    // 핵심코드
                    distance[next] = distance[now] + 1;
                    // 각각 배열로 거리를 관리하는
                    // 자식노드들은 모두 같은 거리를 갖게되는
                    queue.add(next);
                }
            }
        }

        return visited[endNode] ? distance[endNode] : -1;
    }
}

