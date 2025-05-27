package BaekJoon.programmers.level3;

import java.util.*;

public class 기둥과보의설치 {
    static Set<String> bStart = new HashSet<>();
    static Set<String> bEnd = new HashSet<>();
    static Set<String> kStart = new HashSet<>();
    static Set<String> kEnd = new HashSet<>();

    static int N;

    public int[][] solution(int n, int[][] build_frame) {

        // x,y 변경 성공
        N = n;
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = Math.abs(n - build_frame[i][1]);

            build_frame[i][1] = x;
            build_frame[i][0] = y;
        }

        for (int i = 0; i < build_frame.length; i++) {
            if (build_frame[i][2] == 0) {
                // 기둥
                if (build_frame[i][3] == 1) {
                    // 설치
                    addKidoong(build_frame[i][0], build_frame[i][1]);
                } else {
                    // 삭제
                    remove(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
                }
            } else {
                // 보
                if (build_frame[i][3] == 1) {
                    // 설치
                    addBo(build_frame[i][0], build_frame[i][1]);
                } else {
                    // 삭제
                    remove(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
                }
            }
        }

        List<int[]> list = new ArrayList<>();

        for (String str : kStart) {
            StringTokenizer st = new StringTokenizer(str);
            int y = Math.abs(Integer.parseInt(st.nextToken()) - n);
            int x = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y, 0});
        }

        for (String str : bStart) {
            StringTokenizer st = new StringTokenizer(str);
            int y = Math.abs(Integer.parseInt(st.nextToken()) - n);
            int x = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y, 1});
        }


        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[0] - o2[0];
                if (result != 0) {
                    return result;
                }
                result = o1[1] - o2[1];

                if (result != 0) {
                    return result;
                }

                return o1[2] - o2[2];
            }
        };


        list.sort(comparator);

        int[][] answer = new int[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
            answer[i][2] = list.get(i)[2];
        }

        return answer;
    }

    public static void addBo(int y, int x) {
        // 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결
        if (boCheck(y, x)) {
            bStart.add(convert(y, x));
            bEnd.add(convert(y, x + 1));
        }
    }

    public static void addKidoong(int y, int x) {
        // 기둥이 바닥 위 이거나, 다른 기둥 위 이거나, 보의 한쪽 끝 부분이거나 셋중하나 만족

        if (kidoongCheck(y, x)) {
            kStart.add(convert(y, x));
            kEnd.add(convert(y - 1, x));
        }
    }

    public static String convert(int y, int x) {
        return y + " " + x;
    }

    // 기둥의 시작지점 체크
    public static boolean kidoongCheck(int y, int x) {
        if (!(range(y, x) && range(y - 1, x))) {
            return false;
        }
        // 기둥이 바닥 위 이거나,
        // 다른 기둥 위 이거나,
        // 보의 한쪽 끝 부분이거나 셋중하나 만족
        String start = convert(y, x);
        String end = convert(y - 1, x);
        if (y == N) {
            return true;
        }

        if (kEnd.contains(start)) {
            return true;
        }

        if (bStart.contains(start) || bEnd.contains(start)) {
            return true;
        }

        return false;
    }

    public static boolean boCheck(int y, int x) {
        if (!(range(y, x) && range(y, x + 1))) {
            return false;
        }
        String start = convert(y, x);
        String end = convert(y, x + 1);

        // 한쪽 끝 부분이 기둥 위에 있거나,
        if (kEnd.contains(start) || kEnd.contains(end)) {
            return true;
        }
        // 또는 양쪽 끝 부분이 다른 보와 동시에 연결
        if (bEnd.contains(start) && bStart.contains(end)) {
            return true;
        }

        return false;
    }

    public static void remove(int y, int x, int what) {
        // 기둥 삭제
        if (what == 0) {
            // 현재 set에 있는 애들 모두 검사하기
            // 지우기
            String start = convert(y, x);
            String end = convert(y - 1, x);
            kStart.remove(start);
            kEnd.remove(end);
            if (!checking()) {
                kStart.add(start);
                kEnd.add(end);
            }
        } else {
            // 보 삭제
            String start = convert(y, x);
            String end = convert(y, x + 1);
            bStart.remove(start);
            bEnd.remove(end);
            if (!checking()) {
                bStart.add(start);
                bEnd.add(end);
            }
        }
    }

    public static boolean checking() {
        // 모든 보와 모든 기둥 체크하기
        // 기둥 체크
        for (String str : kStart) {
            StringTokenizer st = new StringTokenizer(str);
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (!kidoongCheck(y, x)) {
                return false;
            }
        }

        for (String str : bStart) {
            StringTokenizer st = new StringTokenizer(str);
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (!boCheck(y, x)) {
                return false;
            }
        }
        return true;
    }

    public static boolean range(int y, int x) {
        return y >= 0 && x >= 0 && y <= N && x <= N;
    }
}
