package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 애너그램_6443 {
    static int[] letter = new int[26];
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n  = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr = new int[str.length()];
            letter = new int[26];
            for (int j = 0; j < str.length(); j++) {
                letter[str.charAt(j)-'a']++;
            }
            backTracking(0,str.length(),letter);
        }
        System.out.println(sb);
    }
    public static void backTracking(int depth, int maxDepth, int[] num){
        if(depth == maxDepth){
            for (int i = 0; i < arr.length; i++) {
                char ch = (char)(arr[i] + 'a');
                sb.append(ch);
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(letter[i]>0){
                arr[depth] = i;
                letter[i]--;
                backTracking(depth + 1, maxDepth, num);
                letter[i]++;
            }
        }
    }
}