package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class 아나그램_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            hashMap.put(ch,hashMap.getOrDefault(ch,0)-1);
        }
        for(Character ch:hashMap.keySet()){
            if(hashMap.get(ch)!=0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");















//        HashMap<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i < a.length(); i++) {
//            char character = a.charAt(i);
//            map.put(character, map.getOrDefault(character,0)+1);
//        }
//        for (int i = 0; i < b.length(); i++) {
//            char character = b.charAt(i);
//            if(!map.containsKey(character) || map.get(character) == null){
//                System.out.println("NO");
//                return;
//            }else{
//                map.put(character, map.get(character)-1);
//            }
//        }
//        System.out.println("YES");
    }
}