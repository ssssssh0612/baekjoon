package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            sb.append(step(str)).append("\n");
        }
        System.out.print(sb);
    }

    // 회문인지 아닌지 검사
    public static int step(String str) {
        int start = 0;
        int end = str.length() - 1;
        // 하나씩 검사
        while (start <= end) {
            char ch1 = str.charAt(start);
            char ch2 = str.charAt(end);
            if (ch1 == ch2) {
                start++;
                end--;
            } else {
                // 둘중 하나가 true 면 유사회문
                if(step1( start + 1, end, str) || step1(start, end - 1, str)){
                    return 1;
                }else{
                    return 2;
                }
            }
        }
        return 0;
    }

    public static boolean step1(int start, int end, String str) {
        // 유사회문인지 아닌지 확인하기
        // 모두 같아야함
        while(start <= end){
            char ch1 = str.charAt(start);
            char ch2 = str.charAt(end);
            if (ch1 == ch2) {
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

}
