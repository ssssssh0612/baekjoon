package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N과M8_15657 {
    static List<Integer> list = new ArrayList<>();
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        arr = new int[M];
        Collections.sort(list);

        backTracking(0,list.get(0));

    }
    public static void backTracking(int depth, int number){
        if( depth == M ){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if( number <= list.get(i) ){
                arr[depth] = list.get(i);
                backTracking(depth + 1, list.get(i) );
            }
        }

    }
}
