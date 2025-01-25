package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표정렬하기_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[0] - o2[0];
                if (result != 0) {
                    return result;
                }
                return o1[1] - o2[1];

            }
        };
        Collections.sort(list, comparator);
        StringBuilder sb = new StringBuilder();
        for (int[] arr : list) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }
        System.out.println(sb);
    }
}
