package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무탈출_15900 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> nodeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        // 자식 찾기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        boolean[] visited = new boolean[nodeCount + 1];
        visited[1] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            // 큐에서 하나 뺌
            int size = list.get(now[0]).size();

            if(size == 1 && visited[list.get(now[0]).get(0)]){
                visited[now[0]] = true;
                nodeList.add(now[1]);
                continue;
            }

            for (int i = 0; i < size; i++) {
                int getNumber = list.get(now[0]).get(i);
                if(!visited[getNumber]){
                    queue.add(new int[]{getNumber, now[1] + 1});
                    visited[getNumber] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            result += nodeList.get(i);
        }
        if(result % 2 == 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

    }
}
