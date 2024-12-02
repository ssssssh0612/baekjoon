package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266 {
    static int n, m;
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        pos = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }
        loop();
    }

    public static void loop() {
        boolean flag = false;
        for (int i = 0; i <= n; i++) {
            flag = true;
            if (pos[0] - i > 0) {
                flag = false;
            } else if (pos[m - 1] + i < n) {
                flag = false;
            } else {
                for (int j = 1; j < m - 1; j++) {
                    if (pos[j] + i < pos[j + 1] - i) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }
    }

}
