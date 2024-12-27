package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정보상인호석_22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long result = 0;
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (number == 1) {
                for(int j = 0 ; j < count ; j++){
                    if (!map.containsKey(name)) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(Integer.parseInt(st.nextToken()));
                        map.put(name, pq);
                    } else {
                        map.get(name).add(Integer.parseInt(st.nextToken()));
                    }
                }
            }else {
                if(map.get(name) == null ) continue;
                while(!map.get(name).isEmpty() && count > 0){
                    result += map.get(name).poll();
                    count--;
                }
            }
        }
        System.out.println(result);

    }
}
