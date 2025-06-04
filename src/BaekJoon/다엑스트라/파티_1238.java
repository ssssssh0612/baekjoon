package BaekJoon.다엑스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_1238 {
    static int n;
    static int m;
    static int x;
    static List<Node>[] list;
    static int[] result;
    static class Node implements Comparable<Node> {
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o1){
            return this.weight - o1.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        result = new int[n + 1];
        for(int i = 1; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }
        // list 완성
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node newNode = new Node(end, weight);
            list[start].add(newNode);
        }

        for(int i = 1; i <= n; i++){
            다엑스트라(i);
        }
        // 그리고 x 부터 시작한 다엑스트라 구현
        Arrays.sort(result);
        System.out.println(result[result.length - 1]);
    }
    public static void 다엑스트라(int start){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[n + 1];
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int cur = now.end;
            if(visited[now.end]){
                continue;
            }

            visited[cur] = true;

            for(Node node : list[cur]){
                if( dist[node.end] > dist[cur] + node.weight ){
                    dist[node.end] = dist[cur] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
//        for(int num : dist){
//            System.out.print(num+ " ");
//        }
//        System.out.println();

        if(start == x){
            for(int i = 1; i < dist.length; i++){
                result[i] += dist[i];
            }
        }else{
            result[start] += dist[x];
        }
    }
}
