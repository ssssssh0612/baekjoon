package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 대칭_차집합_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map1 = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int number = Integer.parseInt(st.nextToken());
            map1.put(number,map1.getOrDefault(number,0) + 1);
        }
//        for(Integer number : map1.keySet()) {
//            System.out.print(number+" ");
//        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int number = Integer.parseInt(st.nextToken());
            map1.put(number,map1.getOrDefault(number,0) + 1);
        }
        int result = 0;
        for(Integer key:map1.keySet()){
//            System.out.print(map1.get(key)+" ");
            if(map1.get(key)==1){
                result++;
            }
        }
        System.out.println(result);


    }
}
