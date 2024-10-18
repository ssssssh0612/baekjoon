package BaekJoon.BFS;

import BaekJoon.Strig.팰린드롬replaceAll_inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹_1325 {
    static List<List<Integer>> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, visited);
            result.add(count);
            count = 0;
        }
        int max = Integer.MIN_VALUE;
        for (Integer number : result) {
            if (max < number) {
                max = number;
            }
        }
        int index = 1;
        for (Integer number : result) {
            if (max == number) {
                System.out.print(index + " ");
            }
            index++;
        }
    }

    public static void dfs(int number, boolean[] visited) {
        for(Integer i : list.get(number)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited);
                count++;
            }
        }
    }
}
