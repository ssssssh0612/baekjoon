package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 끝말잇기_28432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        int index = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if(str.equals("?")){
                index = i;
            }

            strArr[i] = str;
            set.add(str);
        }
        // 이후에 있는 문자이거나 이전에 있는 문자는 안됨
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            if(n == 1){
                if(count - 1 == i){
                    System.out.println(str);
                }
                continue;
            }
            if(index == 0){
                char ch1 = strArr[1].charAt(0);
                char ch2 = str.charAt(str.length() - 1);
                if(ch1 == ch2 && !set.contains(str)){
                    System.out.println(str);
                }
            }else if(index == strArr.length - 1){
                char ch1 = strArr[strArr.length - 2].charAt(strArr[strArr.length - 2].length() - 1);
                char ch2 = str.charAt(0);
                if(ch1 == ch2 && !set.contains(str)){
                    System.out.println(str);
                }
            }else{
                char ch1 = str.charAt(0);
                char ch2 = str.charAt(str.length() - 1);
                char ch3 = strArr[index - 1].charAt(strArr[index - 1].length() - 1);
                char ch4 = strArr[index + 1].charAt(0);
                if(ch1 == ch3 && ch2 == ch4 && !set.contains(str)){
                    System.out.println(str);
                }
            }


        }
    }
}
