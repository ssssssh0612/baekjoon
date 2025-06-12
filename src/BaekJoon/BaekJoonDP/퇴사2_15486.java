package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] day = new int[N + 1]; // 상담에 걸리는 일수
        int[] pay = new int[N + 1]; // 상담 시 얻는 수익
        int[] dp = new int[N + 2]; // dp[i]: i일까지 벌 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 일수 T
            day[i] = Integer.parseInt(st.nextToken());
            // 금액 P
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 이전까지의 최대 수익을 현재에 반영
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int endDay = i + day[i] - 1;

            // 상담을 할 수 있는 경우
            if (endDay <= N) {
                if (dp[endDay + 1] < dp[i] + pay[i]) {
                    System.out.printf("Day %d: 상담함 → 끝나는 날 %d에 수익 %d 반영 (기존: %d → 새로: %d)%n",
                            i, endDay + 1, pay[i], dp[endDay + 1], dp[i] + pay[i]);
                } else {
                    System.out.printf("Day %d: 상담 가능하지만 선택 안 함 (dp[%d]=%d ≥ %d)%n",
                            i, endDay + 1, dp[endDay + 1], dp[i] + pay[i]);
                }
                dp[endDay + 1] = Math.max(dp[endDay + 1], dp[i] + pay[i]);
            } else {
                System.out.printf("Day %d: 상담 못 함 (기간 초과: 종료일 %d > %d일)%n", i, endDay, N);
            }

//             dp[i] 상태 출력
            System.out.printf("→ dp[%d] = %d\n", i, dp[i]);
        }

        // 마지막 날까지 최대 수익 계산
        int ans = 0;
        for (int i = 1; i <= N + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println("\n최종 최대 수익: " + ans);
//        System.out.println(ans);
    }
}
