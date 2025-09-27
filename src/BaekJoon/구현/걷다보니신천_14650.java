package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 걷다보니신천_14650 {
    static int length;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2; i++) {
            dfs(new StringBuilder().append(i));
        }
        System.out.println(result);
    }
    public static void dfs(StringBuilder sb){
        if(length == sb.length()){
            int num = Integer.parseInt(sb.toString());
            if(num % 3 == 0){
                result++;
            }
            return;
        }
        StringBuilder sb1 = new StringBuilder(sb.toString()).append("0");
        dfs(sb1);
        StringBuilder sb2 = new StringBuilder(sb.toString()).append("1");
        dfs(sb2);
        StringBuilder sb3 = new StringBuilder(sb.toString()).append("2");
        dfs(sb3);
    }
}
