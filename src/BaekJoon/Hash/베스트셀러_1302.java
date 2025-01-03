package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 베스트셀러_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        int resultCount = 0;
        for(int i = 0 ; i < testCase; i ++){
            long number = Long.parseLong(br.readLine());
            map.put(number, map.getOrDefault(number,0) + 1);
            resultCount = Math.max(resultCount, map.get(number));
        }

        List<Long> list = new ArrayList<>();

        for(Long number : map.keySet()){
            if(map.get(number) == resultCount ){
                list.add(number);
            }
        }

        Collections.sort(list);
        // list 정렬의 기본은 오름차순
        System.out.println(list.get(0));

        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.size());
    }
}
