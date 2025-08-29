package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n + 1];
        int[][] arr = new int[1001][1001];

        StringTokenizer st = null;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            // 색종이가 차지하는 면적을 색종이 번호로 표시함
            for(int j = x; j < (x + width); j++) {
                for(int k = y; k < (y + height); k++) {
                    arr[j][k] = i;
                }
            }
        }

        // 색종이가 차지하고 있는 면적 계산
        for(int i = 0; i < 1001; i++) {
            for(int j = 0; j < 1001; j++) {
                count[arr[i][j]]++;
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(count[i]);
        }
    }
}
