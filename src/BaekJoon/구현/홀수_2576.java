package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 홀수_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int number = Integer.parseInt(br.readLine());
            if( number % 2 != 0 ){
                list.add(number);
                sum += number;
            }
        }
        if(list.isEmpty()){
            System.out.println(-1);
            return;
        }
        Collections.sort(list);
        System.out.println(sum);
        System.out.println(list.get(0));
    }
}
