package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPv6_3107 {

    private static String pad4(String g) {
        StringBuilder sb = new StringBuilder(4);
        for (int i = g.length(); i < 4; i++) sb.append('0');
        sb.append(g);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        // "::"이 있는 경우와 없는 경우를 분리 처리
        if (s.contains("::")) {
            String[] halves = s.split("::", -1); // -1: 빈 토큰 유지
            String left = halves[0];
            String right = halves.length == 2 ? halves[1] : "";

            String[] L = left.isEmpty() ? new String[0] : left.split(":", -1);
            String[] R = right.isEmpty() ? new String[0] : right.split(":", -1);

            int zeros = 8 - (L.length + R.length); // 채워야 할 0000의 개수

            StringBuilder out = new StringBuilder(39); // IPv6 풀 표기 최대 길이 39
            // 왼쪽
            for (String g : L) {
                out.append(pad4(g)).append(':');
            }
            // 0000 채우기
            for (int i = 0; i < zeros; i++) {
                out.append("0000").append(':');
            }
            // 오른쪽
            for (String g : R) {
                out.append(pad4(g)).append(':');
            }
            // 마지막 콜론 제거
            if (out.length() > 0) out.setLength(out.length() - 1);

            System.out.println(out.toString());
        } else {
            // "::"이 없는 경우: 정확히 8그룹
            String[] G = s.split(":", -1);
            StringBuilder out = new StringBuilder(39);
            for (int i = 0; i < G.length; i++) {
                out.append(pad4(G[i]));
                if (i < G.length - 1) out.append(':');
            }
            System.out.println(out.toString());
        }
    }
}
