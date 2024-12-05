package BaekJoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long l1, Long l2) {
                // 내림차순: 큰 값이 먼저 나오도록
                long number_1 = Math.abs(l1);
                long number_2 = Math.abs(l2);
                // 절대값이 같을 때 음수 우선 처리
                if (number_1 == number_2) {
                    return Long.compare(l1, l2); // l1이 음수면 우선순위가 높음
                }

                // 절대값이 다를 경우, 절대값을 기준으로 비교
                return Long.compare(number_1, number_2);
            }
        });
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            long number = Long.parseLong(br.readLine());
            if (number == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                pq.add(number);
            }
        }
        System.out.println(sb);
    }
}
