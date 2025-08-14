package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 금민수의_개수_1527 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = 0;
        addNum(new StringBuilder());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(start <= num && end >= num){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void addNum(StringBuilder sb){
        // 4 또는 7을 추가해주기
        if(sb.length() == 9){
            return;
        }
        StringBuilder sb1 = new StringBuilder(sb).append("4");
        list.add(Integer.parseInt(sb1.toString()));
        addNum(sb1);
        StringBuilder sb2 = new StringBuilder(sb).append("7");
        list.add(Integer.parseInt(sb2.toString()));
        addNum(sb2);
    }
}
