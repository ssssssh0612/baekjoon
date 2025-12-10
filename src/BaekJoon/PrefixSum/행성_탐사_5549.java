package BaekJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행성_탐사_5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken()); // M (row)
        int x = Integer.parseInt(st.nextToken()); // N (col)
        int count = Integer.parseInt(br.readLine()); // K

        // 1-indexed로 만드는 게 편함
        int[][] jSum = new int[y + 1][x + 1];
        int[][] oSum = new int[y + 1][x + 1];
        int[][] iSum = new int[y + 1][x + 1];

        // 2D prefix sum 생성
        for (int row = 1; row <= y; row++) {
            String line = br.readLine();
            for (int col = 1; col <= x; col++) {
                char c = line.charAt(col - 1);

                // 기존 값 복사 (위 + 왼쪽 - 대각선)
                jSum[row][col] = jSum[row - 1][col] + jSum[row][col - 1] - jSum[row - 1][col - 1];
                oSum[row][col] = oSum[row - 1][col] + oSum[row][col - 1] - oSum[row - 1][col - 1];
                iSum[row][col] = iSum[row - 1][col] + iSum[row][col - 1] - iSum[row - 1][col - 1];

                // 현재 칸 반영
                if (c == 'J') jSum[row][col]++;
                else if (c == 'O') oSum[row][col]++;
                else iSum[row][col]++; // 'I'
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < count; q++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); 

            int jungle = jSum[c][d] - jSum[a - 1][d] - jSum[c][b - 1] + jSum[a - 1][b - 1];
            int ocean  = oSum[c][d] - oSum[a - 1][d] - oSum[c][b - 1] + oSum[a - 1][b - 1];
            int ice    = iSum[c][d] - iSum[a - 1][d] - iSum[c][b - 1] + iSum[a - 1][b - 1];

            sb.append(jungle).append(' ')
                    .append(ocean).append(' ')
                    .append(ice).append('\n');
        }

        System.out.print(sb);
    }
}
