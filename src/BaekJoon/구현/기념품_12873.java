package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 기념품_12873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 일단 1 - n 까지
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        int nowCount = 0;
        for (int i = 1; i <= n; i++) {
            if(i == n){
                System.out.println(queue.poll());
                return;
            }
            long number = i;

            long newNumber = number * number * number;
            long newNumber2 = (((newNumber - 1) % queue.size()));

            // count 만큼 queue에서 뽑기
            for (int j = 0; j < newNumber2; j++) {
                int num = queue.poll();
                queue.add(num);
            }
            queue.poll();
        }
    }
}

// 2 3 2 3 2 3 2 3
// 2 3 2 3 2 3 2 3