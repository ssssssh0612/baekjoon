package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 접두사_1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(br.readLine());
        }
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int result = s1.charAt(0) - s2.charAt(0);
                if(result != 0){
                    return result;
                }
                result = s2.length() - s1.length();
                if(result != 0){
                    return result;
                }
                return s1.compareTo(s2);
            }
        };
        list.sort(comparator);

        List<Set<String>> list2 = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            queue.add(list.get(i));
        }
        while(!queue.isEmpty()){
            String str = queue.poll();
            if(list2.isEmpty()){
                Set<String> set = new HashSet<>();
                set.add(str);
                list2.add(set);
            }

//             그리고 list를 돌면서 접두어가 있는지 확인하기 접두어 없으면 set에 들어가고 있으면 새로 만들기
            boolean check = false;
            for (int i = 0; i < list2.size(); i++) {
                int index = 0;
                for(String newStr : list2.get(i)){
                    boolean flag = false;
                    for (int j = 0; j < str.length(); j++) {
                        if(newStr.charAt(j) != str.charAt(j)){
                            break;
                        }
                        if(j == str.length() - 1){
                            // 포함된다는 의미
                            flag = true;
                        }

                    }
                    if(flag){
                        break;
                    }
                    index++;
                }

                if(index == list2.get(i).size()){
                    check = true;
                    list2.get(i).add(str);
                    break;
                }
            }

            // 포함 안되는곳이 있으면 들어가기 만약 하나도 없다면 내가 새로 만들기
            if(!check){
                Set<String> set = new HashSet<>();
                set.add(str);
                list2.add(set);
            }
        }
        int max = 1;
        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).size() > max){
                max = list2.get(i).size();
            }
        }
        System.out.println(max);
    }
}
//6
//a
//b
//cba
//cbc
//cbb
//ccc