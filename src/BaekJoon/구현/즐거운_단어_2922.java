package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 즐거운_단어_2922 {
    static int[] arr;
    static String str;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                count++;
            }
        }
        arr = new int[count];
        backTracking(0);
        System.out.println(result);
    }

    public static void backTracking(int depth) {
        if (depth == arr.length) {
            // 현재 이 문자열이 가능한 문자열인지 가능한 문자열이 아니면 종료
            if (checking()) {
                long mul = 1; // 곱셈으로 경우의 수 계산
                for (int x : arr) {
                    mul *= (x == 0 ? 20 : x == 1 ? 5 : 1);
                }
                result += mul;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            arr[depth] = i;
            backTracking(depth + 1);
        }
    }

    public static boolean checking() {
        int[] ARR = new int[str.length()];
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = checking(str.charAt(i));
            if(num == 3){
                ARR[i] = arr[index];
                index++;
                continue;
            }
            ARR[i] = num;
        }

        for (int i = 0; i < str.length(); i++) {
            if(ARR[i] == 2){
                flag = true;
                break;
            }
        }

        if (!flag) {
            return false;
        }

        // 같은 숫자 3개가 연속되는가?
        if (ARR.length >= 3) {
            for (int i = 0; i <= ARR.length - 3; i++) {
                int num = ARR[i];
                int check = 1;
                for (int j = i + 1; j < i + 3; j++) {
                    if(num == 0 || num == 2){
                        if(ARR[j] != 1){
                            check++;
                        }
                        continue;
                    }

                    if(num == ARR[j]){
                        check++;
                    }
                }
                if(check == 3){
                    return false;
                }
            }
        }
        return true;
    }

    public static int checking(char ch) {
        if(ch =='_'){
            return 3;
        }

        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return 1;
        } else if (ch == 'L') {
            return 2;
        }
        return 0;
    }
}
