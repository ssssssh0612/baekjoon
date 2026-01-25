package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분_문자열_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str == null) break;

            StringTokenizer st = new StringTokenizer(str, " ");
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int index = 0;

            for (int i = 0; i < str2.length(); i++) {
                if(index == str1.length()) break;

                if(str1.charAt(index) == str2.charAt(i)){
                    index++;
                }
            }

            if(index == str1.length()){
                sb.append("Yes").append("\n");
            }else{
                sb.append("No").append("\n");
            }

        }
        System.out.println(sb);
    }
}
