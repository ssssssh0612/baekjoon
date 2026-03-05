package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자놀이_1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        Map<Character, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("zero", "0");
        map1.put("one", "1");
        map1.put("two", "2");
        map1.put("three", "3");
        map1.put("four", "4");
        map1.put("five", "5");
        map1.put("six", "6");
        map1.put("seven", "7");
        map1.put("eight", "8");
        map1.put("nine", "9");

        map.put('0', "zero");
        map.put('1', "one");
        map.put('2', "two");
        map.put('3', "three");
        map.put('4', "four");
        map.put('5', "five");
        map.put('6', "six");
        map.put('7', "seven");
        map.put('8', "eight");
        map.put('9', "nine");
        List<String> list = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            String number = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < number.length(); j++) {
                char ch = number.charAt(j);
                sb.append(map.get(ch));
                if(j == number.length() - 1){
                    break;
                }else{
                    sb.append(" ");
                }
            }
            list.add(sb.toString());
        }
        Collections.sort(list);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(index == 10){
                result.append("\n");
                index = 0;
            }
            st = new StringTokenizer(list.get(i));
            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()){
                sb.append(map1.get(st.nextToken()));
            }
            result.append(sb).append(" ");
            index++;
        }
        System.out.println(result);

    }
}
