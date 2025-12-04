package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 샘터_18513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        Set<Integer> start = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start.add(arr[i]);
        }

        Set<Integer> visited = new HashSet<>();

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(new int[]{arr[i], 0});
        }

        // 범위는 -100_000_000 ~ 100_000_000
        long result = 0;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(visited.size() == count) break;

            if (!start.contains(now[0] + 1) && !visited.contains(now[0] + 1) ) {
                visited.add(now[0] + 1);
                queue.add(new int[]{now[0] + 1, now[1] + 1});
                result += now[1] + 1;
            }
            if(visited.size() == count) break;

            if (!start.contains(now[0] - 1) && !visited.contains(now[0] - 1) ) {
                visited.add(now[0] - 1);
                queue.add(new int[]{now[0] - 1, now[1] + 1});
                result += now[1] + 1;
            }
            if(visited.size() == count) break;

        }
        System.out.println(result);
    }
    public static boolean checking(int num){
        return num >= -100_000_000 && num <= 100_000_000;
    }
}
