package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결요소의개수_11724_2 {
    static List<List<Integer>> list = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = input(br);
        boolean[] visited = new boolean[nodeCount + 1];
        for(int i = 1 ; i <= nodeCount ; i++){
            if(!visited[i]){
                result++;
                visited[i] = true;
                dfs(i, visited);
            }
        }
        System.out.println(result);
    }
    public static int input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < nodeCount + 1; i ++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edgeCount ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        return nodeCount;
    }
    public static void dfs(int startNode, boolean[] visited){
        int length = list.get(startNode).size();
        for(int i = 0 ; i < length; i++){
            int number = list.get(startNode).get(i);
            if(!visited[number]){
                visited[number] = true;
                dfs(number,visited);
            }
        }
    }
}
