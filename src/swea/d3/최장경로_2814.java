package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최장경로_2814 {
    static int nodeCount;
    static int edgeCount;
    static int result = Integer.MIN_VALUE;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            input(br);
            if(edgeCount == 0){
                System.out.println("#" + (i + 1) + " " + 1);
                continue;
            }
            for(int j = 1; j <= nodeCount; j++){
                boolean[] visited = new boolean[nodeCount + 1];
                dfs(j,visited,0);
            }
            System.out.println("#" + (i + 1) + " " + result);
            result = Integer.MIN_VALUE;
            clear();
        }
    }
    public static void clear(){
        for(int i = 0 ; i < nodeCount + 1; i++){
            list.get(i).clear();
        }
    }
    public static void dfs(int startNode, boolean[] visited,int count){
        int length = list.get(startNode).size();
        if( count > result ){
            result = count;
        }
        for(int i = 0; i < length; i++){
            int nowNode = list.get(startNode).get(i);
            if(!visited[nowNode]){
                visited[nowNode] = true;
                dfs(nowNode, visited, count + 1);
                visited[nowNode] = false;
            }
        }
    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < nodeCount + 1; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edgeCount; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
    }
}