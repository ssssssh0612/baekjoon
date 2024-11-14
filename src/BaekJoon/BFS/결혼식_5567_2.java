package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식_5567_2 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int result = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        bfs(1);
        System.out.println(result);
    }
    // bfs 시에 단계가 0 인경우, 1인경우, 2인경우
    public static void input(BufferedReader br) throws IOException {
        int nodeCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[nodeCount + 1];

    }

    public static void bfs(int startNode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNode,0});
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nodeNumber = now[0];
            int checking = now[1];
            int length = list.get(nodeNumber).size();
            for(int i = 0 ; i < length; i++){
                int inNodeNumber = list.get(nodeNumber).get(i);
                if(!visited[inNodeNumber] && checking < 2){
//                    System.out.print(inNodeNumber + " ");
                    result++;
                    visited[inNodeNumber] = true;
                    queue.add(new int[]{inNodeNumber, checking+1});
                }
            }
        }
    }
}
