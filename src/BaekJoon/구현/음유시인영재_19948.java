package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 음유시인영재_19948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = 0;
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            length++;
            list.add(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        int[] charArr = new int[26];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 26; i++) {
            charArr[i] = Integer.parseInt(st.nextToken());
        }
        if(length - 1 > num){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).toUpperCase();
            char before = ' ';
            for (int j = 0; j < str.length(); j++) {

                if(before == str.charAt(j)){
                    continue;
                }
                // 0보다 큰지 검사
                int numCh = str.charAt(j) - 'A';
                if(charArr[numCh] <= 0){
                    System.out.println(-1);
                    return;
                }

                charArr[numCh]--;
                before = str.charAt(j);


                if(j == 0){
                    sb.append(str.charAt(j));
                }
            }
        }

        for (int i = 0; i < sb.toString().length(); i++) {
            int chNum = sb.toString().charAt(i) - 'A';
            if(charArr[chNum] > 0){
                charArr[chNum]--;
            }else{
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb);
    }
}
