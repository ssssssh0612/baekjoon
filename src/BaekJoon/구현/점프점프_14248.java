package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프점프_14248 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();

            int number1 = now + arr[now];
            int number2 = now - arr[now];

            if(checking(number1) && !visited[number1] ){
                visited[number1] = true;
                queue.add(number1);
            }

            if(checking(number2) && !visited[number2] ){
                visited[number2] = true;
                queue.add(number2);
            }
        }
        int result = 0;
        for (int i = 1; i < visited.length; i++) {
            if(visited[i]){
                result++;
            }
        }
        System.out.println(result);
    }
    public static boolean checking(int number){
        return number > 0 && number < n + 1;
    }
}
