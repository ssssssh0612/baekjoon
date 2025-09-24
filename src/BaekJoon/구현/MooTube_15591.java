package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MooTube_15591 {
    static List<List<int[]>> list = new ArrayList<>();
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // node의 개수 N
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,length});
            list.get(b).add(new int[]{a,length});
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            // 여기서 num 에 대해서 dfs 하기
            bfs(num, k);
        }
        System.out.println(sb);
    }
    public static void bfs(int startNum, int k){
        boolean[] visited = new boolean[n + 1];
        int[] check = new int[n + 1]; // k 구하는 방법
        Arrays.fill(check, Integer.MAX_VALUE);
        visited[startNum] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNum, Integer.MAX_VALUE});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            check[now[0]]= now[1];
            for (int i = 0; i < list.get(now[0]).size(); i++) {
                int[] arr = list.get(now[0]).get(i);
                // arr[1] 과 now[1] 비교하기
                if(!visited[arr[0]]){
                    // 방문하지 않았다면 방문하기
                    queue.add(new int[]{arr[0], Math.min(arr[1], now[1])});
                    visited[arr[0]] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < check.length; i++) {
            if(startNum != i && check[i] >= k){
                count++;
            }
        }
        sb.append(count).append("\n");
    }
}
