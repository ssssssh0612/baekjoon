package BaekJoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 알고리즘수업_24479 {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] listCount;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[100001];
        int node = sc.nextInt();
        int edge = sc.nextInt();
        listCount = new int[node + 1];
        int startNode = sc.nextInt();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < edge + 1; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            list.get(n).add(m);
            list.get(m).add(n);
        }
        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        dfs(startNode);
        for (int i = 1; i < listCount.length; i++) {
            System.out.println(listCount[i]);
        }


    }

    public static void dfs(int number) {
        count++;
        visited[number] = true;
        listCount[number] = count;
        for (int i = 0; i < list.get(number).size(); i++) {
            if (!visited[list.get(number).get(i)]) {
                dfs(list.get(number).get(i));
            }
        }
    }
}
