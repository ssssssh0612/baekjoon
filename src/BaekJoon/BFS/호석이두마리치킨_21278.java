package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 호석이두마리치킨_21278 {
    static int result = Integer.MAX_VALUE;
    static int[] resultArr = new int[2];
    static boolean[] visited;
    static int[] arr = new int[2];
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
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
        backTracking(0,1);
        System.out.println(resultArr[0] + " " + resultArr[1] + " " + result * 2);
    }
    public static void backTracking(int depth, int number){
        if(depth == 2){
            bfs();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if(!visited[i] && number <= i){
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void bfs(){
        // 현재 arr 에 적혀있는 위치에서 너비우선탐색 시작
        boolean[] queueVisited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        int[] tracking = new int[n + 1];
        tracking[arr[0]] = 0;
        tracking[arr[1]] = 0;
        queue.add(new int[]{arr[0], 0});
        queue.add(new int[]{arr[1], 0});
        queueVisited[arr[0]] = true;
        queueVisited[arr[1]] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            tracking[now[0]] = now[1];
            // 큐에서 뽑아서 방문하기
            for (int i = 0; i < list.get(now[0]).size(); i++) {
                int num = list.get(now[0]).get(i);
                if(!queueVisited[num]){
                    queueVisited[num] = true;
                    queue.add(new int[]{num, now[1] + 1});
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < tracking.length; i++) {
            sum += tracking[i];
        }
        if(sum < result){
            result = sum;
            resultArr[0] = arr[0];
            resultArr[1] = arr[1];
            return;
        }
        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                int result = o1[0] - o2[0];
                if(result!=0){
                    return result;
                }
                return o1[1] - o2[1];
            }
        };
        List<int[]> compareList = new ArrayList<>();
        compareList.add(arr);
        compareList.add(resultArr);
        compareList.sort(comparator);

        if(sum == result){
            resultArr = compareList.get(0);
        }
    }
}
