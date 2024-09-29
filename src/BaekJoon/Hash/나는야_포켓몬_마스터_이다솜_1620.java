package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
//        System.out.println(a+" "+b);
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map1 = new HashMap<>();
        // 도감
        for (int i = 0; i < a; i++) {
            String str = br.readLine();
//            System.out.println(str);
            map.put(str,i+1);
            map1.put(i+1,str);
        }
        // 문제
        for (int i = 0; i < b; i++) {
            String str = br.readLine();
//            System.out.println(str);
            if(Character.isAlphabetic(str.charAt(0))) {
                System.out.println(map.get(str));
            }else{
                int number = Integer.parseInt(str);
                System.out.println(map1.get(number));
            }
        }
    }
}
