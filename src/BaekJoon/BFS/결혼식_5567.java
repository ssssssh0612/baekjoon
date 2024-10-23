package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식_5567 {
    static int result = 0;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        visited = new boolean[node+ 1];
        list = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited[1] = true;
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.get(1).size(); i++) {
            result++;
            list2.add(list.get(1).get(i));
            visited[list.get(1).get(i)] = true;
        }
        for (int i = 0; i < list2.size(); i++) {
            int Node = list2.get(i);
            for (int j = 0; j < list.get(Node).size(); j++) {
                if(!visited[list.get(Node).get(j)]){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static void dfs(int number, int count){
        if (count == 2) {
            return;
        }
        for (int i = 0; i < list.get(number).size(); i++) {
            if(!visited[list.get(number).get(i)]){
                System.out.println(list.get(number).get(i));
                result++;
                visited[list.get(number).get(i)] = true;
                dfs(list.get(number).get(i),count + 1);
            }
        }
    }
    public static void bfs(int number, int count){
        Queue<Integer> queue = new LinkedList<>();
    }
}
