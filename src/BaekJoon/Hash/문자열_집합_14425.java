package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 문자열_집합_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            String str = br.readLine();
            map.put(str,map.getOrDefault(str,0));
        }
        for (int i = 0; i < b; i++) {
            String str = br.readLine();
            if(map.containsKey(str)){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        int result = 0;
        for(String str:map.keySet()){
            if(map.get(str)>0){
                result += map.get(str);
            }
        }
        System.out.println(result);
    }
}
