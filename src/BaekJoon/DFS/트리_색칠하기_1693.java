package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리_색칠하기_1693 {

    private static int N;

    private static int[] colors;
    private static int[] prevColors;
    private static int[] targets;

    private static boolean[] visited;
    private static List<Integer>[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        colors = new int[N + 1];
        prevColors = new int[N + 1];
        targets = new int[N + 1];

        visited = new boolean[N + 1];

        tree = new LinkedList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
            tree[i] = new LinkedList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            String[] temp = br.readLine().split(" ");

            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            tree[u].add(v);
            tree[v].add(u);
        }

        int count = BFS(1);

        System.out.print(count);
    }

    private static int BFS(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int parent = queue.poll();

            if(colors[parent] != targets[parent]) {
                colors[parent] = targets[parent]; //원하는 색을 칠한다.
                prevColors[parent] = colors[parent]; //부모 노드의 색을 저장한다. => 자식 노드에도 색칠
                count++;
            }

            for(int child : tree[parent]) {
                if(visited[child]) { continue; }
                visited[child] = true;

                colors[child] = prevColors[parent]; //부모 노드의 색과 같은 것으로 칠한다.
                prevColors[child] = colors[child];
                queue.add(child);
            }
        }

        return count;
    }
}
