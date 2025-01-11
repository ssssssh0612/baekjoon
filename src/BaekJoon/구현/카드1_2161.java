package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue=new LinkedList();

        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        while( queue.size()!=1 ){
            int s = queue.poll();
            System.out.print(s+" ");
            int queueNumber =queue.poll();
            queue.add(queueNumber);
        }
        System.out.print(queue.poll());
    }
}
