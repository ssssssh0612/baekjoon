package Inflearn.classString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        String findStr = br.readLine().toUpperCase();
        int[] count = new int[26];
        for(int i = 0 ; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            count[index]++;
        }
        int findStrIndex = findStr.charAt(0) - 'A';
        System.out.println(count[findStrIndex]);
    }
}
