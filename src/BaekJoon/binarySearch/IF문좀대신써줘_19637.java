package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IF문좀대신써줘_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] title = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i][0] = st.nextToken();
            title[i][1] = st.nextToken();
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n;
            int mid = 0;

            while (left < right) {
                mid = (left + right) / 2;

                int titleInt = Integer.parseInt(title[mid][1]);
                if (titleInt < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            sb.append(title[left][0]).append("\n");
        }

        System.out.print(sb);
    }
}
