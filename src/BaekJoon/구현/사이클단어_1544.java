package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 사이클단어_1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        int result = 0;
        for (int i = 0; i < n; i++) {
            // 이 문자열 추가
            String str = br.readLine();
            if(!set.contains(str)){
                result++;
                set.add(str);
                int index = 1;
                for (int j = 0; j < str.length() - 1; j++) {
                    StringBuilder sb = new StringBuilder();
                    int index1 = index;
                    for (int k = 0; k < str.length(); k++) {
                        if(index1 == str.length()){
                            index1 = 0;
                        }
                        sb.append(str.charAt(index1));
                        index1++;
                    }
                    set.add(sb.toString());
                    index++;
                }
            }
        }

        System.out.println(result);
    }
}
