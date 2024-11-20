package BaekJoon.Inflearn.classString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 문장속단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int result = Integer.compare(s2.length(), s1.length());
                return result;
            }
        };
        Arrays.sort(str, Comparator.reverseOrder());
        for(int i = 0 ; i < str.length; i++){
            System.out.print(str[i]+" ");
        }
        System.out.println();
        Arrays.sort(str);
        for(int i = 0 ; i < str.length; i++){
            System.out.print(str[i]+" ");
        }
    }
}
