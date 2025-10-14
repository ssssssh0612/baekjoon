package BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 영재의시험_19949 {
    static int check;
    static int[] arr = new int[10];
    static int[] result = new int[10];
    static int[] count = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(count, 3);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            result[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        dfs(0);
        System.out.println(check);
    }
    public static void dfs(int depth){
        if(depth == 10){
            int score =0 ;
            for (int i = 0; i < 10; i++) {
                // 이 둘이 같으면 + 1
                if(result[i] == arr[i]){
                    score++;
                }
            }
            if(score >= 5){
                check++;
            }
            return;
        }
        for (int i = 0; i < 5; i++) {
            if((depth >= 2) && arr[depth - 1] == arr[depth - 2] && arr[depth - 1] == i) continue;
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
