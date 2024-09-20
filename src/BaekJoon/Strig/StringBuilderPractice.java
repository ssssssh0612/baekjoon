package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringBuilderPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] graph = new int[y][x];
        for (int i = 0; i < y; i++) {
            String a = br.readLine();
            for (int j = 0; j < x; j++) {
                graph[i][j] = a.charAt(j) - '0';
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        List<Integer> list3 = new ArrayList<>();
//        List<Integer> list4 = new ArrayList<>();
//
//        String a = br.readLine();
//        for (int j = 0; j < a.length(); j++) {
//            int f = a.charAt(j) - '0';
//            list1.add(f);
//        }
//        String b = br.readLine();
//        for (int j = 0; j < a.length(); j++) {
//            int f = b.charAt(j) - '0';
//            list2.add(f);
//        }
//        String c = br.readLine();
//        for (int j = 0; j < a.length(); j++) {
//            int f = c.charAt(j) - '0';
//            list3.add(f);
//        }
//        String d = br.readLine();
//        for (int j = 0; j < a.length(); j++) {
//            int f = d.charAt(j) - '0';
//            list4.add(f);
//        }
//
//        // 첫 번째 줄 입력 받기: 전체 입력의 첫 줄에 주어지는 숫자 (5)
//        int n = Integer.parseInt(br.readLine());
//
//        // 나머지 n줄에 대해 반복하여 입력 받기
//        for (int i = 0; i < n; i++) {
//            // 각 줄을 읽고 공백으로 분리
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            // 첫 번째 숫자
//            int x = Integer.parseInt(st.nextToken());
//
//            // 두 번째 숫자
//            int y = Integer.parseInt(st.nextToken());
//        }
//
//

    }
}
