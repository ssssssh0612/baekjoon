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
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        if (maxLength == list.size()) {
            // 꽉 차있다면 큰숫자부터 돌면서 number 보다 작거나 같은 숫자가 있는지
            // 가장 작은숫자를 찾아보기
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                }
            }
            if (number == min) {
                System.out.println(-1);
            } else {
                if (number >= list.get(0)) {
                    System.out.println(1);
                } else {
                    int addIndex = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) < number) {
                            list.add(number);
                            break;
                        }
                    }
                    int[] result = new int[list.size()];
                    for (int i = 1; i < list.size(); i++) {
                        if (list.get(i) == list.get(i - 1)) {
                            result[i] = result[i - 1];
                        } else {
                            result[i] = i + 1;
                        }
                    }
                    System.out.println(result[addIndex]);
                }
            }
        } else {
            if (number >= list.get(0)) {
                System.out.println(1);
            } else {
                int[] result = new int[list.size()];
                for (int i = 1; i < list.size(); i++) {
                    if( number >= list.get(i)){
                        list.add(i,number);
                    }
                }
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) == list.get(i - 1)) {
                        result[i] = result[i - 1];
                    } else {
                        result[i] = i + 1;
                    }
                    if(list.get(i) == number){
                        System.out.println(result[i]);
                    }
                }
            }
        }
    }
}
