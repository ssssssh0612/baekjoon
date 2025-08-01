package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 학생번호_1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }
        int len = input[0].length();

        for (int k = 1; k <= len; k++) {
            for (int i = 0; i < n; i++) {
                set.add(input[i].substring(len - k));
            }
            if (set.size() == n) {
                System.out.println(k);
                return;
            }
            set.clear();
        }
    }
}
