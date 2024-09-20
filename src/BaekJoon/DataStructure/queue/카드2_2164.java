package BaekJoon.DataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            // 맨 처음 숫자 버리기
            if(queue.size() >= 2) {
                queue.poll();
            }
            if(queue.size() >= 2) {
                int now = queue.poll();
                queue.add(now);
            }

            if(queue.size() == 1) {
                break;
            }
        }
        System.out.println(queue.poll());
    }
}
