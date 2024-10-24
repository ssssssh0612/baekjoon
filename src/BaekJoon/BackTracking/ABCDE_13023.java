package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static boolean checking = false;
    static boolean[] visited;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited = new boolean[node];
        for (int i = 0; i < node; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < node; i++) {
            visited[i] = true;
            backTracking(0,i);
            visited[i] = false;
            if(checking){
                break;
            }
        }
        if(checking){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    public static void backTracking(int depth, int number){
        if(depth == 4){
            checking = true;
            return;
        }
        for (int i = 0; i < list.get(number).size(); i++) {
            int nodeNumber = list.get(number).get(i);
            if(!visited[nodeNumber]){
                visited[nodeNumber] = true;
                backTracking(depth+1,nodeNumber);
                visited[nodeNumber] = false;
            }
        }
    }
}
