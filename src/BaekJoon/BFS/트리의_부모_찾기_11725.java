package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_부모_찾기_11725 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        visited = new boolean[nodeCount + 1];
        result = new int[nodeCount + 1];
        for(int i = 0 ; i < nodeCount + 1; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < nodeCount - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        bfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < result.length ; i ++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int startNumber){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNumber);
        visited[startNumber] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            List<Integer> nowList = list.get(now);
            for(int i = 0 ; i < nowList.size(); i++){
                int number = nowList.get(i);
                if(!visited[number]){
                    queue.add(number);
                    visited[number] = true;
                    result[number] = now;
                }
            }
        }

    }
}
