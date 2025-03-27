package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 역원소정렬_5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        while(length > 0){
            // 현재 입력받은 첫번째 줄이 마지막 원소 일 수 있고, 다음 토큰이 있는지 없는지 확인하기
            if(st.hasMoreTokens()){
                String str = st.nextToken();
                StringBuilder sb = new StringBuilder(str);
                long num  = Long.parseLong(sb.reverse().toString());
                pq.add(num);
                length--;
            }else{
                st = new StringTokenizer(br.readLine());
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
