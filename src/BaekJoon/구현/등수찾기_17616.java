package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등수찾기_17616 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            win.get(a).add(b);
            lose.get(b).add(a);
        }
        int winCount = bfs(num, win);
        int loseCount = bfs(num, lose);
        System.out.println(loseCount + " " + (n - winCount + 1));
    }
    public static int bfs(int num, List<List<Integer>> list){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[num] = true;
        queue.add(num);
        int count = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            count++;
            for (int i = 0; i < list.get(now).size(); i++) {
                if(!visited[list.get(now).get(i)]){
                    queue.add(list.get(now).get(i));
                    visited[list.get(now).get(i)] = true;
                }
            }
        }
        return count;
    }
}
