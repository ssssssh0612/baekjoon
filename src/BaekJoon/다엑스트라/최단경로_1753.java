package BaekJoon.다엑스트라;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class 최단경로_1753 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000_000;
    static int v, e, k;
    static List<Node>[] list;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        // 리스트에 그래프 정보를 초기화
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight)); // 반대 방향도 추가!
        }

        for (int i = 1; i < list.length; i++) {
            System.out.print(" i = " + i );
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(" end = " + list[i].get(j).weight + " weight = " + list[i].get(j).weight);
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        // 다익스트라 알고리즘
        dijkstra(k);
        // 출력 부분
        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;
            System.out.println("Now Number = " + cur);
            if (check[cur]) {
                continue;
            }
            check[cur] = true;

            for (Node node : list[cur]) {
                System.out.println(node.end + " " + node.weight);
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
//7 9
//1
//1 2 4
//1 3 5
//1 5 1
//1 6 1
//6 7 1
//7 3 1
//2 3 4
//2 4 5
//4 3 6

