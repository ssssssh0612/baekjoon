package BaekJoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1967 {
    static int max = 0;
    static List<List<int[]>> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i < n + 1; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,cost});
            list.get(b).add(new int[]{a,cost});
        }
        for(int i = 1 ; i <= n; i++){
            boolean[] visited = new boolean[n + 1];
            dfs(i,0, visited);
        }
        System.out.println(max);
    }
    public static void dfs(int startNode, int sum, boolean[] visited){
        max = Math.max(sum, max);
        visited[startNode] = true;
        for(int i = 0 ; i < list.get(startNode).size(); i++){
            int node = list.get(startNode).get(i)[0];
            int cost = list.get(startNode).get(i)[1];
            if(!visited[node]){
                dfs(node,sum+cost,visited);
            }
        }
    }
}

