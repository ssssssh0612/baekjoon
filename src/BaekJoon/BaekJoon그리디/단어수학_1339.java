package BaekJoon.BaekJoon그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어수학_1339 {
    static class Node{
        char ch;
        int num;
        public Node(char ch, int num){
            this.ch = ch;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        Map<Character, Long> map = new HashMap<>();
        for(int i = 0 ; i < number; i++){
            String str = br.readLine();
            int num = 1;
            for(int j = str.length() - 1; j >= 0; j--){
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0L) + number(num));
                num++;
            }
        }
        for(Character ch : map.keySet()){
            list.add(map.get(ch));
        }
        Collections.sort(list);
        long result = 0;
        int index = 9;
        for(int i = list.size() - 1; i >= 0 ; i --){
            result += index * list.get(i);
            index--;
        }
        System.out.println(result);
    }

    public static int number(int num){
        if(num == 1){
            return 1;
        }
        return 10 * number(num - 1);
    }
}
