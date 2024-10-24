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
//            System.out.println(list.get(1).get(i));
            visited[list.get(1).get(i)] = true;
        }
        for (int i = 0; i < list2.size(); i++) {
            int Node = list2.get(i);
            for (int j = 0; j < list.get(Node).size(); j++) {
                if(!visited[list.get(Node).get(j)]){
//                    System.out.println(list.get(Node).get(j));
//                    visited[list.get(Node).get(j)] = true;
                    result++;
                }
            }
        }
        int fucking = 0;
        for (int i = 2; i < visited.length; i++) {
            if(visited[i]){
                fucking++;
            }
        }
        System.out.println(fucking);
        System.out.println(result);
    }
}
