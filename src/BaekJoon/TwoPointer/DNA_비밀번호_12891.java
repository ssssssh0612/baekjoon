package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DNA_비밀번호_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int strLength = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(i == 0){
                map.put('A', num);
            }else if(i == 1){
                map.put('C', num);
            }else if(i == 2){
                map.put('G', num);
            }else{
                map.put('T', num);
            }
        }
        int result = 0;
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            int num = 0;
            if(i == 0){
                alphabet.put('A', num);
            }else if(i == 1){
                alphabet.put('C', num);
            }else if(i == 2){
                alphabet.put('G', num);
            }else{
                alphabet.put('T', num);
            }
        }

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            alphabet.put(ch, alphabet.getOrDefault(ch, 0) + 1);
        }

        if(checking(map, alphabet)){
            result++;
        }

        int start = 0 ;
        int end = length - 1;
        while(end < strLength){
            end++;
            if(end == strLength){
                break;
            }
            char ch = str.charAt(end);
            alphabet.put(ch, alphabet.getOrDefault(ch, 0) + 1);
            char removeCh = str.charAt(start);
            alphabet.put(removeCh, alphabet.getOrDefault(removeCh, 0) - 1);
            start++;
            if(checking(map,alphabet)){
                result++;
            }
        }
        System.out.println(result);
    }
    public static boolean checking(Map<Character, Integer> map, Map<Character, Integer> alphabet){
//        for(Character ch : map.keySet()){
//            System.out.print(ch + " " + map.get(ch) + " ");
//        }
//        System.out.println();
//
//        for(Character ch : alphabet.keySet()){
//            System.out.print(ch + " " + alphabet.get(ch) + " ");
//        }
//        System.out.println();

        if(map.get('A') >  alphabet.get('A')){
            return false;
        }

        if(map.get('C') >  alphabet.get('C')){
            return false;
        }

        if(map.get('G') >  alphabet.get('G')){
            return false;
        }

        if(map.get('T') >  alphabet.get('T')){
            return false;
        }
        return true;
    }
}
