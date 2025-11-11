package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<int[]> d = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(st.nextToken());
            int[] arr = {i + 1, num};
            d.add(arr);
        }

        while (d.size() != 1) {
            int[] arr = d.remove();
            sb.append(arr[0]).append(" ");
            int move = arr[1];

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    d.add(d.remove());
                }
            } else {
                for (int i = move; i < 0; i++) {
                    d.addFirst(d.removeLast());
                }
            }
        }
        System.out.println(sb.toString() + d.remove()[0]);
    }
}
