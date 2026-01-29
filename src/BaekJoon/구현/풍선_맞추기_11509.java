package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 풍선_맞추기_11509 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAX = 1000000;
        int[] cnt = new int[MAX + 1]; // 높이 h에 대기 중인 화살 개수
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (cnt[h] > 0) {
                cnt[h]--;
                cnt[h - 1]++;
            } else {
                answer++;
                cnt[h - 1]++;
            }
        }

        System.out.println(answer);
    }
}

