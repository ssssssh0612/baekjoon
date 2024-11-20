package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일차원_정원_14178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            if( n <= m * 2 + 1){
                System.out.println("#"+(i + 1)+" "+1);
                continue;
            }

            for (int j = m; j < n; j = j + (m*2) + 1) {
                count++;
//                System.out.print(j+" ");
                int checkingNum = j + (m * 2) + 1;
                if (checkingNum >= n){
                    if ( n - (j + 1) > m ){
                        count++;
                    }
                }
            }
            System.out.println("#"+(i + 1)+" "+count);
        }
        // 5,1 5,2 100,3


    }
}
