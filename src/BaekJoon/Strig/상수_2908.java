package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String c = "";
        String d = "";
        for (int i = 0; i < 2; i++) {
            if( i == 0 ){
                for (int j = a.length()-1; j >= 0 ; j--) {
                    c = c + a.charAt(j);
                }
            }else{
                for (int j = b.length()-1; j >= 0 ; j--) {
                    d = d + b.charAt(j);
                }
            }
        }
        System.out.println(Math.max(Integer.parseInt(c),Integer.parseInt(d)));
    }
}
