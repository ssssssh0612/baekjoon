package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_18352 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < nodeCount + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        // 최단거리가 distance와 같은
        int[] distanceArr = new int[nodeCount + 1];

        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[start] = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int number = now[0];
            int nowDistance = now[1];

            for (int i = 0; i < list.get(number).size(); i++) {
                int next = list.get(number).get(i);
                int nextDistance = nowDistance + 1;
                if(distanceArr[next] > nextDistance){
                    queue.add(new int[]{next, nextDistance});
                    distanceArr[next] = nextDistance;
                }
            }

        }


        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < distanceArr.length; i++) {
            if(distanceArr[i] == distance){
                list.add(i);
            }
        }

        if(list.isEmpty()){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);

    }
}
