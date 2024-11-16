package BaekJoon.구현;

import java.util.*;

public class String예제 {
    public static void main(String[] args){
        String str = "algorithm";
        int[] count = new int[26];
        for(int i = 0 ; i < str.length(); i++){
            int number = str.charAt(i) - 'a';
            count[number]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            for(int j = 0 ; j < count[i]; j++){
                sb.append((char) (i + 'a'));
            }
        }
        System.out.println(sb);

        List<String> strList = new ArrayList<>();
        //["sun", "bed", "car"]
        strList.add(new String("sun"));
        strList.add(new String("bed"));
        strList.add(new String("car"));
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int result = s1.charAt(1) - s2.charAt(1);
                if(result != 0){
                    return result;
                }
                return result;
            }
        };
        String[] strings = new String[3];
        strings[0] = "sun";
        strings[1] = "bed";
        strings[2] = "car";
        Arrays.sort(strings, comparator);
        for(int i = 0 ; i < 3; i++){
            System.out.println(strings[i]);
        }
        Collections.sort(strList,comparator);
        for(String str1 : strList){
            System.out.println(str1);
        }
    }
}
