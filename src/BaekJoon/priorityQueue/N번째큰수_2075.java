package BaekJoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                int number = Integer.parseInt(st.nextToken());
                pq.add(number);
            }
        }
        for (int i = 0; i < length; i++) {
            if( i == length - 1){
                System.out.println(pq.poll());
            }else{
                pq.poll();
            }
        }
    }
}
