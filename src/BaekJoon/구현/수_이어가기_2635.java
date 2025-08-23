package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 수_이어가기_2635 {
    static int length;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = num; i >= 1; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            check(list, i);
        }
        System.out.println(length);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }
    public static void check(List<Integer> list, int num){
        int minus = list.get(list.size() - 1);
        if(minus - num >= 0){
            list.add(num);
            check(list, minus - num);
        }else{
            list.add(num);
            if(length < list.size()){
                length = list.size();
                result = list;
            }
        }
    }
}
