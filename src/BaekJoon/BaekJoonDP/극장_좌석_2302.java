package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 극장_좌석_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 1];
        int[] dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        List<Integer> list = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if(set.contains(i)){
                if(result <= 0){
                    continue;
                }
                list.add(dp[result]);
                result = 0;
            }else{
                result++;
            }
        }
        if(result > 0){
            list.add(dp[result]);
        }
        if(list.isEmpty()){
            System.out.println(1);
            return;
        }
        int finalResult = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            finalResult = finalResult * list.get(i);
        }
        System.out.println(finalResult);


    }
}
