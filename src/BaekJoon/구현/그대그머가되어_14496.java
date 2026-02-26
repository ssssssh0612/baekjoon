package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그대그머가되어_14496 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int end;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

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

        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == end) {
                System.out.println(now[1]);
                flag = true;
                return;
            }
            for (int i = 0; i < list.get(now[0]).size(); i++) {
                int num = list.get(now[0]).get(i);
                if (!visited[num]) {
                    queue.add(new int[]{num, now[1] + 1});
                    visited[num] = true;
                }
            }
        }
        System.out.println(-1);

    }
}
