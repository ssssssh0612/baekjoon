package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹_1325 {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            int count = dfs(i,visited,0);
            int[] arr = new int[]{i,count};
            result.add(arr);
        }
        // 1번째 인덱스를 기준으로 내림차순 정렬
        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 1번째 인덱스(o1[1], o2[1])를 기준으로 내림차순 정렬
                return Integer.compare(o2[1], o1[1]);
            }
        });
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)[0]+" "+ result.get(i)[1]);
        }
    }
    public static int dfs(int number, boolean[]visited, int count){
        for (int i = 1; i <= list.get(number).size(); i++) {
            if(!visited[list.get(number).get(i)]){
                int newCount = count+1;
                visited[list.get(number).get(i)] = true;
                dfs(list.get(number).get(i),visited,newCount);
            }
        }
        return count;
    }
}
