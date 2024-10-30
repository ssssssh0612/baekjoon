package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 등수구하기_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int maxLength = Integer.parseInt(st.nextToken());
        if(length == 0){
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // 꽉 차있는지 아닌지
        if(length == maxLength){
            // 꽉 차있는 경우
            int minNum = list.get(length - 1);
            if(minNum >= number){
                System.out.println(-1);
                return;
            }

            if(number >= list.get(0)){
                System.out.println(1);
                return;
            }

            for (int i = 0; i < list.size(); i++) {
                int nowNum = list.get(i);
                if(nowNum <= number){
                    list.remove(list.size() - 1);
                    list.add(i,number);
                }
            }
            int[] result = new int[list.size()];
            result[0] = 1;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) == list.get(i - 1)){
                    result[i] = result[i - 1];
                }else{
                    result[i] = i + 1;
                }
                if(list.get(i) == number){
                    System.out.println(result[i]);
                    return;
                }
            }
        }else{
            // 꽉 차 있지 않다면
            boolean flag = false;

            if(list.get(0) <= number){
                System.out.println(1);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                int nowNum = list.get(i);
                if(nowNum <= number){
                    flag = true;
                    list.remove(list.size() - 1);
                    list.add(i,number);
                }
            }
            if(!flag){
                list.add(number);
            }

            int[] result = new int[list.size()];
            result[0] = 1;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) == list.get(i - 1)){
                    result[i] = result[i - 1];
                }else{
                    result[i] = i + 1;
                }
                if(list.get(i) == number){
                    System.out.println(result[i]);
                    return;
                }
            }
        }
    }
}
