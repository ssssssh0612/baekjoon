package BaekJoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수정렬햐기5_5688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < testCase; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }

}
