package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_빈도수_14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char ch = st.nextToken().charAt(0);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String value = String.valueOf(i);
            int size = value.length();
            for (int j = 0; j < size; j++) {
                if(value.charAt(j) == ch){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
