package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단어정렬_181 {
    public static void main(String[] args) throws IOException {
        //길이가 짧은 것부터 길이 내림차순
        //길이가 같으면 사전 순
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // s1 -> s2 오름차순
                int result = Integer.compare(s1.length() , s2.length());
                if(result != 0){
                    return result;
                }
                return s1.compareTo(s2);
            }
        };
        List<String> list = new ArrayList<>();
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            list.add(br.readLine());
        }
        Collections.sort(list , comparator);
        StringBuilder sb = new StringBuilder();

        sb.append(list.get(0)).append("\n");
        String before = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(!before.equals(list.get(i))){
                sb.append(list.get(i)).append("\n");
                before = list.get(i);
            }
        }
        System.out.println(sb);
    }
}
