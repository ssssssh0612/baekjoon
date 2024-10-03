package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class 모든아나그램찾기_inflearn {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        String result = br.readLine();
        HashMap<Character,Integer> resultMap = new HashMap<>();
        for (int i = 0; i < result.length(); i++) {
            Character ch = result.charAt(i);
            resultMap.put(ch,resultMap.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < result.length() - 1; i++){
            Character ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int start = 0;
        int end = result.length() - 1;
        int answer = 0;
        while( end < str.length()) {
            Character ch = str.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.equals(resultMap)){
                answer++;
            }
            Character startChar = str.charAt(start);
            map.put(startChar, map.getOrDefault(startChar, 0) - 1);
            if(map.get(startChar) == 0){
                map.remove(startChar);
            }
            start++;
            end++;
        }
        System.out.println(answer);
    }
}
