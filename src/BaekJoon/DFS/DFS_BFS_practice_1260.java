package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_practice_1260 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < nodeCount + 1; i ++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edge; i ++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i = 0 ; i <= nodeCount; i ++){
//            Collections.sort(list.get(i), new Comparator<>(){
//                @Override
//                public int compare(Integer o1, Integer o2){
//                    return o2 - o1;
//                }
//            });
            Collections.sort(list.get(i));
        }
        System.out.println(list);
        boolean[] visitedDFS = new boolean[nodeCount + 1];
        visitedDFS[startNode] = true;
        System.out.print(startNode + " ");
        dfs(startNode, visitedDFS);
        System.out.println();

        boolean[] visitedBFS = new boolean[nodeCount + 1];
        System.out.print(startNode + " ");
        visitedBFS[startNode] = true;
        bfs(startNode, visitedBFS);

    }
    public static void dfs(int startNode, boolean[] visited){
        for(int i = 0; i < list.get(startNode).size(); i++ ){
            int node = list.get(startNode).get(i);
            if(!visited[node]){
                visited[node] = true;
                System.out.print(node+" ");
                dfs(node,visited);
            }
        }
    }
    public static void bfs(int startNode, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < list.get(now).size(); i ++){
                int node = list.get(now).get(i);
                if(!visited[node]){
                    System.out.print(node + " ");
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
