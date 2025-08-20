package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회장_뽑기_2660 {
    static List<List<Integer>> list;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        // 그래프 구현
        list = new ArrayList<>();
        for (int i = 0; i < count+ 1; i++) {
            list.add(new ArrayList<>());
        }
        result = new int[count + 1];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == -1){
                break;
            }
            list.get(start).add(end);
            list.get(end).add(start);
        }

        for (int i = 1; i <=count; i++) {
            bfs(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.length; i++) {
            if(result[i] < min){
                min = result[i];
            }
        }
        List<Integer> memberList = new ArrayList<>();
        int length = 0;
        for (int i = 1; i < result.length; i++) {
            if(result[i] == min){
                length++;
                memberList.add(i);
            }
        }
        System.out.println(min + " " + length);
        for (int i = 0; i < memberList.size(); i++) {
            System.out.print(memberList.get(i) + " ");
        }

    }
    public static void bfs(int start){
        boolean[] visited = new boolean[result.length];
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        int resultNum = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(resultNum < now[1]){
                resultNum = now[1];
            }
            for (int i = 0; i < list.get(now[0]).size(); i++) {
                int num = list.get(now[0]).get(i);
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(new int[]{num, now[1] + 1});
                }
            }
        }
        result[start] = resultNum;
    }
}
