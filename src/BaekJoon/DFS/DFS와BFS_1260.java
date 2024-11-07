package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DFS와BFS_1260 {
    static ArrayList<Integer>[] adjList; // 번호가 작은 것을 먼저 방문한다 했으니, 인접 리스트를 오름차순이 적용된 TreeSet으로 하거나, ArrayList 정렬
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M, V 입력
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = a[0]; // 노드 개수
        int M = a[1]; // 간선 개수
        int V = a[2]; // 시작 노드

        adjList = new ArrayList[N + 1];
        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        // 간선이 연결하는 두 정점들 입력 (양방향)
        // 인접리스트 생성
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int[] node = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList[node[0]].add(node[1]);
            adjList[node[1]].add(node[0]); // 양방향
        }
        br.close();
        // ArrayList로 했을 때 오름차순 정렬
        for (int i = 0; i < N; i++) {
            Collections.sort(adjList[i]);
        }

        // DFS 결과 출력
        dfs(V);
        // BFS 결과 출력
        bfs(V);

        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }

    private static void dfs(int now) {
        dfsVisited[now] = true;
        dfsResult.append(now).append(" ");

        for (int next : adjList[now]) {
            if (!dfsVisited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        bfsVisited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            bfsResult.append(now).append(" ");

            for (int next : adjList[now]) {
                if (!bfsVisited[next]) {
                    queue.addLast(next);
                    bfsVisited[next] = true;
                }
            }
        }
    }
}

