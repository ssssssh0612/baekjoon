package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_6118 {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        // 더 이상 방문할 수 없을 때

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size() + 1];
        queue.add(new int[]{1, 0});
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                arr[i] = now[0];
                count = now[1];

                for (int j = 0; j < list.get(now[0]).size(); j++) {
                    int num = list.get(now[0]).get(j);
                    if (!visited[num]) {
                        queue.add(new int[]{num, now[1] + 1});
                        visited[num] = true;
                    }
                }
            }
            // 여기서 큐가 추가되지 않으면 ? 거기가 마지막
            if (queue.isEmpty()) {
                Arrays.sort(arr);
                System.out.println(arr[0] + " " + count + " " + size);
            }
        }
    }
}
