package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 순열_사이클_10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            for (int j = 0; j < count + 1; j++) {
                list.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < count + 1; j++) {
                list.get(j).add(Integer.parseInt(st.nextToken()));
            }
            boolean[] visited = new boolean[count + 1];
            int result = 0;
            for (int j = 1; j < count + 1; j++) {
                if(!visited[j]){
                    visited[j] = true;
                    dfs(j, list, visited);
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    public static void dfs(int number, List<List<Integer>> list, boolean[] visited){
        if(!visited[list.get(number).get(0)]){
            visited[list.get(number).get(0)] = true;
            dfs(list.get(number).get(0), list, visited);
        }
    }
}
