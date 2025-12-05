package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업_21937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        int number = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{number, 0});
        boolean[] visited = new boolean[n + 1];
        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < list.get(now[0]).size(); i++) {
                if (!visited[list.get(now[0]).get(i)]) {
                    queue.add(new int[]{list.get(now[0]).get(i), now[1] + 1});
                    visited[list.get(now[0]).get(i)] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
