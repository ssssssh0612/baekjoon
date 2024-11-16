package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산_2_2633 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        if(!flag){
            System.out.println(-1);
        }
    }
    public static void input(BufferedReader br) throws IOException{
        int nodeCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        int edgeCount = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < nodeCount + 1; i ++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[nodeCount + 1];
        for(int i = 0 ; i < edgeCount ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        bfs(startNode, endNode);

    }
    public static void bfs(int startNode, int endNode){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNode, 0});
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int node = now[0];
            if(node == endNode){
                System.out.println(now[1]);
                flag = true;
                return;
            }

            int length = list.get(node).size();
            for(int i = 0 ; i < length; i++){
                int newNode = list.get(node).get(i);
                if(!visited[newNode]){
                    queue.add(new int[]{newNode, now[1] + 1});
                    visited[newNode] = true;
                }
            }
        }
    }
}
