package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 아이폰9S_5883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        for (int i = 0; i < n  ; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            set.add(num);
        }
        int result = 0;

        for(Integer num : set){
            int max = 1;
            int beforeNum = -1;
            for (int i = 0; i < n; i++) {
                int nowNum = arr[i];
                if(nowNum == num) continue;
                if(beforeNum == nowNum){
                    max++;
                }else{
                    max = 1;
                    beforeNum = nowNum;
                }
                result = Math.max(max, result);
            }
        }
        System.out.println(result);
    }
}
