package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        if(str1.length() == str2.length()){
            int count = 0;
            for(int i = 0 ; i < str1.length(); i++){
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(i);
                if(ch1 != ch2){
                    count++;
                }
            }
            System.out.println(count);
        }else{
            int count = Integer.MAX_VALUE;
            for(int i = 0 ; i < str2.length(); i++){
                int check = 0;
                int length = i + str1.length() - 1;
                int index = 0;
                if(length >= str2.length()){
                    break;
                }
                for(int j = i; j <= length; j++){
                    char ch1 = str1.charAt(index);
                    char ch2 = str2.charAt(j);
//                    System.out.println(ch1 + " " + ch2);
                    if(ch1 != ch2){
                        check++;
                    }
                    index++;
                }
                count = Math.min(count, check);
            }
            System.out.println(count);



        }

    }

}
