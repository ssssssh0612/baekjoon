package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o1) {
            return this.weight - o1.weight;
        }
    }

    static int[] dist;
    static List<Node>[] list;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int weight = road[i][2];
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }
        daik(1);
        int answer = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    public static void daik(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        // 1번부터 시작해서 k보다 작은애를 찾기
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Node node : list[now.end]) {
                if (dist[node.end] > dist[now.end] + node.weight) {
                    dist[node.end] = dist[now.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
