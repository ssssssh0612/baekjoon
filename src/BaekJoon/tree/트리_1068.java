package BaekJoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리_1068 {
    static List<List<Integer>> list;
    static int result = 0;
    static int[] motherList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        motherList = new int[count];
        int rootNode = 0;
        // 0번째 노드도 노드임
        for(int i = 0 ; i < count; i ++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < count ; i ++){
            int motherNode = Integer.parseInt(st.nextToken());
            if(motherNode == - 1){
                rootNode = i;
                motherList[i] = -1;
                continue;
            }
            motherList[i] = motherNode;
            list.get(i).add(motherNode);
            list.get(motherNode).add(i);
        }
        boolean[] visited = new boolean[count];
        int removeNode = Integer.parseInt(br.readLine());
        if(removeNode == rootNode){
            System.out.println(result);
            return;
        }
        dfs(removeNode,visited, false);
        dfs(rootNode,visited, true);
        System.out.println(result);
    }

    public static void dfs(int startNode, boolean[] visited, boolean checking){
        visited[startNode] = true;
        int check = 0;
        for(int i = 0 ; i < list.get(startNode).size(); i++){
            int nodeNumber = list.get(startNode).get(i);
            if(!visited[nodeNumber] && motherList[startNode] != nodeNumber){
                dfs(nodeNumber,visited,checking);
                check++;
            }
        }
        if(check == 0 && checking){
            result++;
        }
    }
}
