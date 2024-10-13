package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 게리멘더링_17471 {
    static List<List<Integer>> list;
    static int[] Arr;
    static int n;
    static int RESULT = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < Arr.length; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        list  = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }


        if(n % 2 == 0){
            for (int i = n - 1; i >= n / 2; i--) {
                int[] backArr = new int[i];
                boolean[] visited = new boolean[n];
                backTracking(0,0,backArr,visited);
            }
        }else{
            for (int i = n - 1; i >= (n / 2) + 1; i--) {
                int[] backArr = new int[i];
                boolean[] visited = new boolean[n];
                backTracking(0,0,backArr,visited);
            }
        }

        if(RESULT == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(RESULT);
        }
    }
    public static void backTracking(int depth, int number, int[] arr, boolean[] visited){
        if(arr.length == depth){
            // 얘네로 dfs를 돌려서 구간이 몇개 나오는지 확인하기
            // 구간이 2개가 나오지 않으면 break
            // 구간이 3개 이상이 나오면 break
            boolean[] visitedDFS = new boolean[n + 1];
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            for (int i = 0; i < arr.length; i++) {
                visitedDFS[arr[i]+1] = true;
            }

            System.out.println();
            for (int i = 1; i < visitedDFS.length; i++) {
                System.out.print(visitedDFS[i]+" ");
            }
            System.out.println();
            dfs(visitedDFS, arr[0]+1);

            for (int i = 1; i < visitedDFS.length; i++) {
                System.out.print(visitedDFS[i]+" ");
            }
            System.out.println();
            for (int i = 0; i < arr.length; i++) {
                if(visitedDFS[arr[i]+1]){
                    return;
                }else{
                    visitedDFS[arr[i]+1] = true;
                }
            }
            for (int i = 1; i < visitedDFS.length; i++) {
                System.out.print(visitedDFS[i]+" ");
            }
            for (int i = 1; i < visitedDFS.length; i++) {
                if(!visitedDFS[i]){
                    dfs2(visitedDFS, i);
                    break;
                }
            }
            System.out.println();
            for (int i = 1; i < visitedDFS.length; i++) {
                System.out.print(visitedDFS[i]+" ");
            }
            System.out.println();

            for (int i = 1; i < visitedDFS.length; i++) {
                if(!visitedDFS[i]){
                    return;
                }
            }
            int result = 0;
            boolean[] lastVisted = new boolean[n + 1];
            for (int i = 0; i < arr.length; i++) {
                result += Arr[arr[i]+1];
                lastVisted[arr[i]+1] = true;
            }

            int result2 = 0;

            for (int i = 1; i < lastVisted.length; i++) {
                if(!lastVisted[i]){
                    result2 += Arr[i];
                }
            }

            System.out.println(Math.abs(result - result2));
            RESULT = Math.min(RESULT, Math.abs(result - result2));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i] && i >= number){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth+1, i, arr, visited);
                visited[i] = false;
            }
        }
    }

    public static void dfs(boolean[] visited, int number){
        visited[number] = false;
        for (int i = 0; i < list.get(number).size(); i++) {
            if(visited[list.get(number).get(i)]){
                visited[list.get(number).get(i)] = false;
                dfs(visited, list.get(number).get(i));
            }
        }
    }

    public static void dfs2(boolean[] visited, int number){
        visited[number] = true;
        for (int i = 0; i < list.get(number).size(); i++) {
            if(!visited[list.get(number).get(i)]){
                visited[list.get(number).get(i)] = true;
                dfs2(visited, list.get(number).get(i));
            }
        }
    }
}
