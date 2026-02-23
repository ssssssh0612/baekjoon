package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 텔레포트정거장_18232 {
    static int nodeCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[nodeCount + 1];

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == end){
                System.out.println(now[1]);
                return;
            }
            int newPos1 = now[0] - 1;
            int newPos2 = now[0] + 1;
            if(!list.get(now[0]).isEmpty()){
                for (int i = 0; i < list.get(now[0]).size(); i++) {
                    int newPos = list.get(now[0]).get(i);
                    if(checking(newPos) && !visited[newPos]){
                        queue.add(new int[]{newPos, now[1] + 1});
                        visited[newPos] = true;
                    }
                }
            }

            if(checking(newPos1) && !visited[newPos1]){
                visited[newPos1] = true;
                queue.add(new int[]{newPos1, now[1] + 1});
            }

            if(checking(newPos2) && !visited[newPos2]){
                visited[newPos2] = true;
                queue.add(new int[]{newPos2, now[1] + 1});
            }
        }


    }
    public static boolean checking(int number){
        return number > 0 && number <= nodeCount;
    }
}
