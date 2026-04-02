package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Comparator<Integer> com = new Comparator<>(){
            @Override
            public int compare(Integer n1, Integer n2){
                return n2 - n1;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(com);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                if(pq.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
                continue;
            }

            for (int j = 0; j < a; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);

    }
}
