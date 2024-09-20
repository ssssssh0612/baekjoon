package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문장_속_단어_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String result = "";
        int indexNumber = st.countTokens();
        for (int i = 0; i < indexNumber; i++) {
            String a = st.nextToken();
            if( i == 0 ){
                result = a;
            }else{
                if( result.length() < a.length() ){
                    result = a ;
                }
            }
        }
        System.out.println(result);

    }

}
