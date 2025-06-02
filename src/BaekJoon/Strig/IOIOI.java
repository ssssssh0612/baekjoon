package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder sb = new StringBuilder("IOI");
        for (int i = 1; i < num; i++) {
            sb.append("OI");
        }

        String compare = sb.toString();

        int start = 0;
        int end = 0;
        int count = 0;
        // 일단 I로 시작하는 애를 찾기
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'I') {
                start = i;
                end = i;
                break;
            }
        }

        while (end < str.length()) {
            int index = end - start;

            if(start == end && (str.charAt(end) != compare.charAt(index))){
                start++;
                end++;
                continue;
            }

            if (index == compare.length()) {
                start += 2;
                count++;
                continue;
            }

            if (str.charAt(end) == compare.charAt(index)) {
                end++;
            }else{
                start = end;
            }

        }
        if(end - start == compare.length()){
            System.out.println(count + 1);
        }else{
            System.out.println(count);
        }

    }
}
