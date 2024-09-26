package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class 학급회장_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        char result = 'a';
        int maxCount = Integer.MIN_VALUE;
        String b = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i),map.getOrDefault(b.charAt(i), 0) + 1 );
        }

        for (Character key : map.keySet()) {
            int count = map.get(key);
            if (count > maxCount) {
                maxCount = Math.max(count, maxCount);
                result = key;
            }
        }
        System.out.println(result);
    }
}
