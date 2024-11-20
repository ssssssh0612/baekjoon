package BaekJoon.Strig;

import BaekJoon.DFS.BFS_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳개수_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int number = str.charAt(i) - 'a';
            count[number]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]+" ");
        }
    }
}
