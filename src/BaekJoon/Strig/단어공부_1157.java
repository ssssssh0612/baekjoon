package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int[] visited = new int[256];
        a = a.toUpperCase();
        for (int i = 0; i < a.length(); i++) {
            visited[a.charAt(i)]++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 256; i++) {
            if(max < visited[i]){
                max = visited[i];
            }
        }
        int maxCount = 0;
        for (int i = 0; i < 256; i++) {
            if(visited[i] == max){
                maxCount++;
            }
        }
        if(maxCount >= 2){
            System.out.println("?");
        }else{
            for (int i = 0; i < 256; i++) {
                if(visited[i] == max){
                    char ch = (char)i;
                    System.out.println(ch);
                }
            }
        }
    }
}
