package BaekJoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            pq.add(number);
        }

        if( testCase == 1 ){
            System.out.println(0);
        }else if(testCase == 2){
            System.out.println(pq.poll() + pq.poll());
        }else{
            int result = 0;
            while (!pq.isEmpty()) {
                if(pq.size() == 2){
                    int number_1 = pq.poll();
                    int number_2 = pq.poll();
                    result +=  number_1 + number_2;
                    break;
                }
                int number_1 = pq.poll();
                int number_2 = pq.poll();
                pq.add(number_1 + number_2);
                result += number_1 + number_2;
            }
            System.out.println(result);
        }
    }
}
