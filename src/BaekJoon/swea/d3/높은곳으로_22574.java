package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 높은곳으로_22574 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int choice = Integer.parseInt(st.nextToken());
            int bomb = Integer.parseInt(st.nextToken());
            int now = 0;
            for (int j = 1; j <= choice; j++) {
                // 가만히 놔 둘 지, 아니면 위로 i층을 올릴지 정할 수 있다.
                int upStair = now + j;
                if(upStair != bomb){
                    now = upStair;
                }
            }
            System.out.println(now);
        }
    }
}

