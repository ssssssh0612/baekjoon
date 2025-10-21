package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 구슬찾기_2617 {
    static int[] arr1;
    static int[] arr2;
    static List<List<Integer>> list1 = new ArrayList<>();
    static List<List<Integer>> list2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr1 = new int[n + 1];
        arr2 = new int[n + 1];
        for (int i = 0; i < n + 1;  i++) {
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list1.get(a).add(b);
            list2.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i,arr1, list1);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i,arr2, list2);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < arr1.length; i++) {
//            System.out.print(arr1[i] + " ");
            if((n / 2) + 1 <= arr1[i]){
                set.add(i);
            }
        }
//        System.out.println();

        for (int i = 1; i < arr2.length; i++) {
//            System.out.print(arr2[i] + " ");
            if((n / 2) + 1 <= arr2[i]){
                set.add(i);
            }
        }
//        System.out.println();

        System.out.println(set.size());


    }
    public static void bfs(int startNum, int[] arr, List<List<Integer>> list){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        boolean[] visited = new boolean[arr.length];
        visited[startNum] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                if(!visited[list.get(now).get(i)]){
                    queue.add(list.get(now).get(i));
                    arr[list.get(now).get(i)]++;
                    visited[list.get(now).get(i)] = true;
                }
            }
        }

    }

}
