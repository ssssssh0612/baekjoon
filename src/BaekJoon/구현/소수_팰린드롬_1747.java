package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수_팰린드롬_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        // N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
        boolean[] arr = new boolean[10_000_000 + 1];
        if(num == 1){
            System.out.println(2);
            return;
        }
        for (int i = 2; i * i <= 10_000_000; i++) {
            if (!arr[i]) { // i가 소수라면
                for (int j = i * i; j <= 10_000_000; j += i) {
                    arr[j] = true; // i의 배수 지우기
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = num; i <= 10_000_000; i++) {
            if (!arr[i]) {
                list.add(String.valueOf(i));
            }
        }

        for (String str : list) {
            int index = str.length() - 1;
            boolean flag = true;
            for (int i = 0; i < str.length()/2; i++) {
                if(str.charAt(i) == str.charAt(index - i)){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(str);
                break;
            }
        }


    }
}
