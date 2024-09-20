package BaekJoon.BFS;

import java.util.*;

public class 맥주_마시면서_걸어가기_9205 {
    static int testCase;
    static boolean happy;
    // 맥주를 파는 편의점의 개수
    // 상근이네 집
    // 편의점
    // 펜타포스 순서
    static Queue<int[]> queue = new LinkedList<>();
    static List<int[]> store = new ArrayList<>();
    // 도착할때까지 반복
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int storeCount = sc.nextInt(); // 편의점 개수
            boolean[] visited = new boolean[storeCount+1];
            int[] home = {sc.nextInt(), sc.nextInt()}; // 현재 위치
            for (int j = 0; j < storeCount; j++) {
                store.add(new int[]{sc.nextInt(), sc.nextInt()}); // 편의점의 위치 저장
            }
            int[] festival = {sc.nextInt(), sc.nextInt()}; // 페스티벌 위치
            queue.add(home);

            while (!queue.isEmpty()) {

                int[] now = queue.poll();

                if (Math.abs((now[0] - festival[0])) + Math.abs((now[1] - festival[1])) <= 1000) {// 현재 나의 위치에 페스티벌이 있는경우
                    happy = true;
                    break;
                }

                for (int k = 0; k < store.size(); k++) {
                    int[] arrXY = store.get(k);
                    if (!visited[k] && Math.abs((now[0] - arrXY[0])) + Math.abs(now[1] - arrXY[1]) <= 1000) {
                        queue.add(arrXY);
                        visited[k] = true;
                    }
                }
            }

            if (happy) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
            store.clear();
            happy = false;
        }
    }
}
