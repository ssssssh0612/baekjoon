package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리_4803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        while (true) {
            index++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            if (nodeCount == 0 && edgeCount == 0) {
                break;
            }

            boolean[] visited = new boolean[nodeCount + 1];
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
            int result = 0;
            for (int i = 1; i < nodeCount + 1; i++) {
                // 여기서 BFS 하기
                if (!visited[i]) {
                    boolean flag = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{0,i});
                    visited[i] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int j = 0; j < list.get(now[1]).size(); j++) {
                            if(list.get(now[1]).get(j) == now[0]){
                                continue;
                            }
                            if(visited[list.get(now[1]).get(j)]){
                                flag = false;
                                break;
                            }else{
                                queue.add(new int[]{now[1], list.get(now[1]).get(j)});
                                visited[list.get(now[1]).get(j)] = true;
                            }
                        }
                    }
                    if (flag) {
                        result++;
                    }
//                    System.out.println("result = " + result);
                }
            }
            if (result == 0) {
                System.out.println("Case " + index + ": No trees.");
            } else if (result == 1) {
                System.out.println("Case " + index + ": There is one tree.");
            } else {
                System.out.println("Case " + index + ": A forest of " + result + " trees.");
            }
        }
    }
}
