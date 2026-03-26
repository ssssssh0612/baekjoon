package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 수학숙제_2870 {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            step(str);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(checking0(list.get(i))){
                result.add("0");
            }else{
                String newAdd = step2(list.get(i));
                result.add(newAdd);
            }
        }
        Comparator<String> comparator = new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                int result = s1.length() - s2.length();
                if(result != 0){
                    return result;
                }

                return s1.compareTo(s2);
            }
        };
        result.sort(comparator);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);

    }

    public static void step(String str) {
        // 알파벳 소문자로 되어있는
        // 002 -> 2
        // 000 -> 0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // 숫자인지 아닌지 확인하기
            char ch = str.charAt(i);
            int num = str.charAt(i);

            if (num < 97) {
                // 숫자
                sb.append(ch);
            } else {
                // 문자열
                if (!sb.isEmpty()) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (!sb.isEmpty()) {
            list.add(sb.toString());
        }
    }
    public static String step2(String str){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0'){
                index = i;
                break;
            }
        }

        for (int i = index; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    public static boolean checking0(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}


