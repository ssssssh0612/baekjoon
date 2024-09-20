package BaekJoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 욕심쟁이_판다_1937 {
    static int n;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                list.add(graph[i][j]);
            }
        }
        Collections.sort(list);

    }
    public static void dfs(int i, int j) {

    }
}
