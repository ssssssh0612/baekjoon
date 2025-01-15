package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전_초밥_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int plate = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] plateArr = new int[plate];
        for(int i = 0 ; i < plateArr.length; i++){
            plateArr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        // count 만큼 투 포인터를 돌림
        for(int i = 0 ; i < count; i ++){
            map.put(plateArr[i], map.getOrDefault(plateArr[i], 0) + 1);
        }
        int start = map.size();
        if(!map.containsKey(coupon)){
            start++;
        }

        result = start;

//        System.out.println(result);
        // 7 9 7 30 2 7 9 25
        // 0 1 2 3  4 5 6 7
        for(int i = 1 ; i < plateArr.length; i++){

            map.put(plateArr[i - 1], map.getOrDefault(plateArr[i - 1], 0) - 1);
            if(map.get(plateArr[i - 1]) == 0){
                map.remove(plateArr[i-1]);
            }
            int index = i + count - 1;
            if(index >= plateArr.length){
                index = index - plateArr.length;
            }
            map.put(plateArr[index], map.getOrDefault(plateArr[index], 0) + 1);
            int check = map.size();
            if(!map.containsKey(coupon)){
                check++;
            }
            result = Math.max(result, check);
        }

        System.out.println(result);
    }
}
