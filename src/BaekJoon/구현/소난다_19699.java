package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 소난다_19699 {
    static Set<Integer> set = new HashSet<>();
    static int[] arr ;
    static int[] cow;
    static int n;
    static int m;
    static boolean[] visited;
    static Set<Integer> result = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cow = new int[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] prime = new boolean[10_001];
        visited = new boolean[n];
        for (int i = 2; i <= 10_000; i++) {
            if(!prime[i]){
                set.add(i);
                for (int j = i; j <= 10_000; j = j + i) {
                    prime[j] = true;
                }
            }
        }

        combination(0, 0);

        if(result.isEmpty()){
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>(result);

        Collections.sort(list);


        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
    public static void combination(int depth, int index){
        if(depth == m){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += cow[arr[i]];
            }

            if(set.contains(sum)){
                result.add(sum);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i] && i >= index){
                arr[depth] = i;
                visited[i] = true;
                combination(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
