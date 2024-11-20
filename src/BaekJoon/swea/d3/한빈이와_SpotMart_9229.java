package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class 한빈이와_SpotMart_9229 {
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int minWeight = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                int number = Integer.parseInt(st.nextToken());
                arr[j] = number;
            }
            boolean[] visited = new boolean[length];
            int[] count = new int[2];
            Arrays.sort(arr);
            backTracking(0,minWeight,visited,arr,count);
            System.out.println("#"+(i+1)+" "+result);
            result = -1;
        }
    }
    public static void backTracking(int depth, int minWeight,boolean[] visited, int[] arr, int[] count){
        if(depth == 2){
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += count[i];
//                System.out.print(count[i]+" ");
            }
//            System.out.println();
            if(sum <= minWeight){
                result = Math.max(result, sum);
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                count[depth] = arr[i];
                backTracking(depth+1, minWeight, visited, arr, count);
                visited[i] = false;
            }
        }
    }
}
