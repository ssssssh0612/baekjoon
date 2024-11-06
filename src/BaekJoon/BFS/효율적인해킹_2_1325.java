package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적인해킹_2_1325 {
    static List<List<Integer>> list = new ArrayList<>();
    static int node;
    static int edge;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        step();
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        result = new int[node+1];
        for(int i  = 0 ; i < node + 1; i ++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edge; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
//        System.out.println(list);
    }

    public static void step(){
        for(int i = 1 ; i < node + 1; i++){
            boolean[] visited = new boolean[node + 1];
            visited[i] = true;
            dfs(i,visited);
            result[i] = count;
            if(max < count){
                max = count;
            }
            count = 0;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < node+1; i++){
            if(max == result[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }
    public static void dfs(int node, boolean[] visited){
        int length = list.get(node).size();
        for(int i = 0 ; i < length; i++){
            int visitNode = list.get(node).get(i);
            if(!visited[visitNode]){
                visited[visitNode] = true;
                dfs(visitNode, visited);
                count++;
            }
        }
    }
}


//12 11
//2 1
//3 2
//4 2
//5 1
//2 5
//6 7
//7 8
//8 9
//9 10
//10 11
//11 12


