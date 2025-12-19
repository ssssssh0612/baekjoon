package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Small_World_Network_18243 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            // 1부터 n까지 6번 bfs돌리고 모두 방문했는지 검사하기
            visited[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int count = 0;
            while(count < 6){
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int now = queue.poll();
                    for (int k = 0; k < list.get(now).size(); k++) {
                        if(!visited[list.get(now).get(k)]){
                            queue.add(list.get(now).get(k));
                            visited[list.get(now).get(k)] = true;
                        }
                    }
                }
                count++;
            }
            if(!visitedChecking(visited)){
                System.out.println("Big World!");
                return;
            }
        }
        System.out.println("Small World!");
    }
    public static boolean visitedChecking(boolean[] visited){
        for (int i = 1; i < visited.length; i++) {
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
