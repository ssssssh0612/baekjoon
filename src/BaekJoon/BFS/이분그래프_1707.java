package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프_1707 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            input(br);
        }
        System.out.println(sb);
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < nodeCount + 1; i++){
            graph.add(new ArrayList<>());
        }
        int edgeCount = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < edgeCount; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] checking = new int[nodeCount + 1];
        boolean[] visited = new boolean[nodeCount + 1];
        boolean flag = true;
        for(int i = 1 ; i <= nodeCount; i++){
                // 하나라도 false 가 뜨면 NO
            if((!visited[i])){
                if(!bfs(i,checking,visited,graph,nodeCount)){
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            sb.append("YES").append("\n");
        }else{
            sb.append("NO").append("\n");
        }

    }

    public static boolean bfs(int startNum , int[] checking, boolean[] visited, List<List<Integer>> graph, int nodeCount){
        Queue<int[]> queue = new LinkedList<>();
        visited[startNum] = true;
        checking[startNum] = 1;
        queue.add(new int[]{startNum,1});
        boolean flag = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int number = now[0];
            int color = now[1];
            int nextColor = 0;
            if(color == 1){
                nextColor = 2;
            }else{
                nextColor = 1;
            }
            for(int i = 0; i < graph.get(number).size(); i++){
                int nextNumber = graph.get(number).get(i);
                if(!visited[nextNumber] && checking[nextNumber] != color){
                    visited[nextNumber] = true;
                    queue.add(new int[]{nextNumber, nextColor});
                    checking[nextNumber] = nextColor;
                }else if(checking[nextNumber] == color){
                    return false;
                }
            }
        }
        return true;
    }
}
