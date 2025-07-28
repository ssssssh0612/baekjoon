package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 단어나누기_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 세 단어로 나누기

        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i < str.length(); i++) {


            for (int j = i + 1; j < str.length(); j++) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                StringBuilder result = new StringBuilder();
                for (int k = 0; k < i; k++) {
                    sb1.append(str.charAt(k));
                }

                for (int k = i; k < j; k++) {
                    sb2.append(str.charAt(k));
                }

                for (int k = j; k < str.length(); k++) {
                    sb3.append(str.charAt(k));
                }

                sb1.reverse();
                sb2.reverse();
                sb3.reverse();
                result.append(sb1).append(sb2).append(sb3);
                pq.add(result.toString());
            }
        }
        System.out.println(pq.poll());
        // 단어 세개로 자르기
        // m o b i t e l
        // 0 1 2 3 4 5 6

    }
}
