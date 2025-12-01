package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 돌다리_12761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100_001];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});
        visited[n] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == m){
                System.out.println(now[1]);
                return;
            }

            int case1 = now[0] + 1;
            int case2 = now[0] - 1;
            int case3 = now[0] + a;
            int case4 = now[0] + b;
            int case5 = now[0] - a;
            int case6 = now[0] - b;
            int case7 = now[0] * a;
            int case8 = now[0] * b;

            if(checking(case1) && !visited[case1]){
                queue.add(new int[]{case1, now[1] + 1});
                visited[case1] = true;
            }
            if(checking(case2) && !visited[case2]){
                queue.add(new int[]{case2, now[1] + 1});
                visited[case2] = true;
            }
            if(checking(case3) && !visited[case3]){
                queue.add(new int[]{case3, now[1] + 1});
                visited[case3] = true;
            }
            if(checking(case4) && !visited[case4]){
                queue.add(new int[]{case4, now[1] + 1});
                visited[case4] = true;
            }
            if(checking(case5) && !visited[case5]){
                queue.add(new int[]{case5, now[1] + 1});
                visited[case5] = true;
            }
            if(checking(case6) && !visited[case6]){
                queue.add(new int[]{case6, now[1] + 1});
                visited[case6] = true;
            }if(checking(case7) && !visited[case7]){
                queue.add(new int[]{case7, now[1] + 1});
                visited[case7] = true;
            }
            if(checking(case8) && !visited[case8]){
                queue.add(new int[]{case8, now[1] + 1});
                visited[case8] = true;
            }
        }
    }
    public static boolean checking(int number){
        return number >= 0 && number < 100_001;
    }
}
