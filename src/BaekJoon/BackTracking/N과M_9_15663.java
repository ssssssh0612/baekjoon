package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_9_15663 {
    static int depth;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());
        visited = new boolean[length];
        arr = new int[depth];
        st = new StringTokenizer(br.readLine());
        int[] arrList = new int[length];
        for(int i = 0 ; i < arrList.length; i++){
            arrList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrList);
        backTracking(0,arrList);
    }
    public static void backTracking(int newDepth, int[] arrList){
        if(depth == newDepth){
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] +" ");
            }
            System.out.println();
            return;
        }
        int before = 0;
        for(int i = 0 ; i < arrList.length; i++ ){
            if(!visited[i] && (before != arrList[i])){
                arr[newDepth] = arrList[i];
                visited[i] = true;
                before = arrList[i];
                backTracking(newDepth + 1, arrList );
                visited[i] = false;
            }
        }
    }
}
