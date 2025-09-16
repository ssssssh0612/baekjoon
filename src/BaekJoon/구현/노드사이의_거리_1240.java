package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노드사이의_거리_1240 {
    static List<List<int[]>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < length + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < length - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            list.get(startNum).add(new int[]{endNum, dis});
            list.get(endNum).add(new int[]{startNum, dis});
        }
        for (int i = 0; i < count; i++) {
            // 거리 구하기
            st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());
            bfs(startNum, endNum);
        }
    }
    public static void bfs(int startNum, int endNum){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        visited[startNum] = true;
        queue.add(new int[]{startNum, 0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == endNum){
                System.out.println(now[1]);
                return;
            }
            for (int i = 0; i < list.get(now[0]).size(); i++) {
                int[] arr = list.get(now[0]).get(i);
                if(!visited[arr[0]]){
                    queue.add(new int[]{arr[0],arr[1] + now[1]});
                    visited[arr[0]] = true;
                }
            }

        }
    }
}
