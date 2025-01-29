package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전구와_스위치_2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        boolean[] result = new boolean[length];

        boolean[] onStart = new boolean[length];
        boolean[] offStart = new boolean[length];

        String st = br.readLine();

        for (int i = 0; i < length; i++) {
            if (st.charAt(i) == '0') {
                onStart[i] = false;
                offStart[i] = false;
            } else {
                onStart[i] = true;
                offStart[i] = true;
            }
        }
        st = br.readLine();
        for (int i = 0; i < length; i++) {
            if (st.charAt(i) == '0') {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }
        // 0번이 켜진경우
        onStart[0] = !onStart[0];
        onStart[1] = !onStart[1];
        int result1 = 1;
        for (int i = 1; i < length; i++) {
            if (i == length - 1) {
                if (onStart[i - 1] != result[i - 1]) {
                    result1++;
                    onStart[i] = !onStart[i];
                    onStart[i - 1] = !onStart[i - 1];
                }
            } else {
                if (onStart[i - 1] != result[i - 1]) {
                    result1++;
                    onStart[i] = !onStart[i];
                    onStart[i - 1] = !onStart[i - 1];
                    onStart[i + 1] = !onStart[i + 1];
                }
            }


        }


        for (int i = 0; i < length; i++) {
            if (onStart[i] != result[i]) {
                result1 = -1;
                break;
            }
        }

        int result2 = 0;
        // 0번이 꺼진경우
        for (int i = 1; i < length; i++) {
            if (i == length - 1) {
                if (offStart[i - 1] != result[i - 1]) {
                    result2++;
                    offStart[i] = !offStart[i];
                    offStart[i - 1] = !offStart[i - 1];
                }
            } else {
                if (offStart[i - 1] != result[i - 1]) {
                    result2++;
                    offStart[i] = !offStart[i];
                    offStart[i - 1] = !offStart[i - 1];
                    offStart[i + 1] = !offStart[i + 1];
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (offStart[i] != result[i]) {
                result2 = -1;
                break;
            }
        }

//        System.out.println("result1 = " + result1);
//        System.out.println("result2 = " + result2);
        if (result1 != -1 && result2 != -1) {
            System.out.println(Math.min(result1, result2));
            return;
        }
        if (result1 == -1 && result2 == -1) {
            System.out.println(-1);
            return;
        }
        if (result1 == -1) {
            System.out.println(result2);
            return;
        }
        System.out.println(result1);
    }
}
