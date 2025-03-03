package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    static int N, W, L;
    static Queue<Integer> bridge = new ArrayDeque<Integer>();
    static int sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        //초기화
        sum = 0;
        int time = 0;

        st = new StringTokenizer(br.readLine());
        int truck = Integer.parseInt(st.nextToken());

        while(true) {
            time++;

            sum-=bridge.poll();

            if(sum+truck <= L) {
                bridge.add(truck);
                sum+=truck;
                if(--N == 0) break;
                truck = Integer.parseInt(st.nextToken());
            }else {
                bridge.add(0);
            }

        }

        time += bridge.size();
        System.out.println(time);
    }
}