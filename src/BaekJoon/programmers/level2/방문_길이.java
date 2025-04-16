package BaekJoon.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 방문_길이 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int solution(String dirs) {
        int answer = 0;

        int[] now = {0, 0};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            // 현재 0,0 에서 움직이기
            char ch = dirs.charAt(i);
            if (ch == 'U') {
                int nextY = now[0] + dy[0];
                int nextX = now[1] + dx[0];
                if (!checking(nextY, nextX)) {
                    continue;
                }
                String[] str = convert(now[0], now[1], nextY, nextX);
                set.add(str[0]);
                set.add(str[1]);
                now[0] = nextY;
                now[1] = nextX;
            } else if (ch == 'D') {
                int nextY = now[0] + dy[1];
                int nextX = now[1] + dx[1];
                if (!checking(nextY, nextX)) {
                    continue;
                }
                String[] str = convert(now[0], now[1], nextY, nextX);
                set.add(str[0]);
                set.add(str[1]);
                now[0] = nextY;
                now[1] = nextX;
            } else if (ch == 'L') {
                int nextY = now[0] + dy[2];
                int nextX = now[1] + dx[2];
                if (!checking(nextY, nextX)) {
                    continue;
                }
                String[] str = convert(now[0], now[1], nextY, nextX);
                set.add(str[0]);
                set.add(str[1]);
                now[0] = nextY;
                now[1] = nextX;
            } else { // R
                int nextY = now[0] + dy[3];
                int nextX = now[1] + dx[3];
                if (!checking(nextY, nextX)) {
                    continue;
                }
                String[] str = convert(now[0], now[1], nextY, nextX);
                set.add(str[0]);
                set.add(str[1]);
                now[0] = nextY;
                now[1] = nextX;
            }
        }
        return set.size() / 2;
    }

    public static String[] convert(int y1, int x1, int y2, int x2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        String[] str = new String[2];
        sb.append(String.valueOf(y1));
        sb.append(String.valueOf(x1));
        sb.append(" ");
        sb.append(String.valueOf(y2));
        sb.append(String.valueOf(x2));

        sb1.append(String.valueOf(y2));
        sb1.append(String.valueOf(x2));
        sb1.append(" ");
        sb1.append(String.valueOf(y1));
        sb1.append(String.valueOf(x1));


        str[0] = sb.toString();
        str[1] = sb1.toString();

        System.out.println(str[0] + " " + str[1]);
        return str;
    }

    public static boolean checking(int y, int x) {
        return y >= -5 && x >= -5 && y <= 5 && x <= 5;
    }
}
