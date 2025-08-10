package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 문자_해독_1593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sLength = Integer.parseInt(st.nextToken());
        int wLength = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String w = br.readLine();

        int[] chArr = new int[52];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            // s의 길이만큼 즉 대문자는 A를
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                chArr[ch - 65]++;
            } else {
                chArr[ch - 97 + 26]++;
            }
            set.add(ch);
        }

//        for (int i = 0; i < chArr.length; i++) {
//            System.out.print(chArr[i] + " ");
//        }
//        System.out.println();
        int[] check = new int[52];

        int count = 0;

        int start = 0;
        int end = 0;
        while(end <= w.length()){
//            System.out.println(start + " " + end);
            if((end - start) == sLength){
//                System.out.println("들어옴");
//                for (int i = 0; i < chArr.length; i++) {
//                    System.out.print(check[i] + " ");
//                }
//                System.out.println();
                boolean flag = true;

                for (int i = 0; i < check.length; i++) {
                    // 하나라도 다르면 다른거임
                    if(check[i] != chArr[i]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    count++;
                }
                char ch = w.charAt(start);
                if (ch >= 65 && ch <= 90) {
                    check[ch - 65]--;
                } else {
                    check[ch - 97 + 26]--;
                }
                start++;
            }

            if(end == w.length()){
                break;
            }
            char ch = w.charAt(end);
            if(set.contains(ch)){
                // 처음 포함되는경우
                if (ch >= 65 && ch <= 90) {
                    check[ch - 65]++;
                } else {
                    check[ch - 97 + 26]++;
                }
                end++;
            }else{
                // 포함 안되면
                end++;
                start = end;
                // 0으로 가득 채우기
                Arrays.fill(check,0);
            }

            // 현재 start - end 길이가 sLength 와 같다면
        }
        System.out.println(count);

    }
}
