package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리_색칠하기_1693 {
    static boolean[] visited;
    static int[] nodeColorArr;
    static List<List<Integer>> list = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNumber = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < nodeNumber + 1; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[nodeNumber + 1];
        nodeColorArr = new int[nodeNumber + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < nodeNumber + 1; i++) {
            nodeColorArr[i] = Integer.parseInt(st.nextToken());
        }
        if(nodeColorArr[1] != 0){
            result++;
        }
        for(int i = 0 ; i < nodeNumber - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1);
        System.out.println(result);
    }
    public static void dfs(int startNode){
        // 현재 내가 방문한 노드와 색이 다르다면 카운트
        visited[startNode] = true;
        for(int i = 0 ; i < list.get(startNode).size(); i++){
            int nodeColor = nodeColorArr[startNode];
            int nextNode = list.get(startNode).get(i);
            int nextNodeColor = nodeColorArr[nextNode];
            if(!visited[nextNode] && nextNodeColor != nodeColor){
                result++;
                dfs(nextNode);
            }else if(!visited[nextNode] && nextNodeColor == nodeColor){
                dfs(nextNode);
            }
        }
    }
}
