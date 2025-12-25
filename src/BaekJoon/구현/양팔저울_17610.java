package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양팔저울_17610 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int maxVal = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            maxVal += num[i];
        }
        visited = new boolean[maxVal + 1];

        subset(0, n, num, new int[n]);
        int score = 0;
        for (int i = 1; i <= maxVal; i++) {
            if (!visited[i])
                score++;
        }
        System.out.println(score);
    }

    public static void subset(int depth, int n, int[] num, int[] answer) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += answer[i];
            }
            if (sum <= 0) return; // 합이 음수인 경우는 제외
            visited[sum] = true;
            return;
        }

        answer[depth] = num[depth];
        subset(depth + 1, n, num, answer);

        answer[depth] = -num[depth];
        subset(depth + 1, n, num, answer);

        answer[depth] = 0;
        subset(depth + 1, n, num, answer);

    }
}
