package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 리모컨_1107 {
    static String num;
    static String nowNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = br.readLine();
        nowNum = "100";
        int length = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10];
        StringTokenizer st = null;
        if (length != 0) {
            st = new StringTokenizer(br.readLine());
        }
        Arrays.fill(check, true);
        for (int i = 0; i < length; i++) {
            check[Integer.parseInt(st.nextToken())] = false;
        }
        // true인 숫자들만 골라서 숫자를 만들면됨
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 10; j++) {
                // 1 - 9 까지 현재 숫자를 고르고
                if (check[j]) {
                    StringBuilder sb = new StringBuilder().append(j);
                    step(check, sb, i);
                }
            }
        }
        // 이 결과값에
        int addLength = nowNum.length();

        for (int i = 0; i < nowNum.length(); i++) {
            if(i == 0 && nowNum.charAt(i) == '0' && nowNum.length() != 1){
                addLength--;
            }else{
                break;
            }

            if(nowNum.charAt(i) == '0'){
                addLength--;
            }else{
                break;
            }
        }

        int result = Math.abs(Integer.parseInt(nowNum) - Integer.parseInt(num)) + addLength;

        // 그리고 100 에서 + - 한 숫자랑 비교하기
        int result1 = Math.abs(100 - Integer.parseInt(num));
        if(result1 < result){
            System.out.println(result1);
        }else{
            System.out.println(result);
        }
    }

    // 숫자만들기
    public static void step(boolean[] check, StringBuilder sb, int length) {
        if (sb.length() == length) {
            int absNum = Math.abs(Integer.parseInt(nowNum) - Integer.parseInt(num));
            // 절대값의 차이가
            int absNewNum = Math.abs(Integer.parseInt(sb.toString()) - Integer.parseInt(num));
            // 둘중 차이가 더 작은것 고르기

            if (absNum > absNewNum) {
                nowNum = sb.toString();
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            // 1 - 9 까지 현재 숫자를 고르고
            if (check[i]) {
                StringBuilder newSb = new StringBuilder().append(sb).append(i);
                step(check, newSb, length);
            }
        }
    }
}
