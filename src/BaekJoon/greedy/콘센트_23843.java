package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class 콘센트_23843 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int queueSize = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        list.sort(reverseOrder());

        if (queueSize > length) {
            System.out.println(list.get(0));
            return;
        }
        int index = 0;
        for (int i = 0; i < queueSize; i++) {
            queue.add(list.get(index));
            index++;
        }


        int time = 0;
        while (index < length || !queue.isEmpty()) {
            if (queue.size() != queueSize && index < length) {
                queue.add(list.get(index));
                index++;
                continue;
            }
            // queue 돌면서 숫자 1씩 빼고 0인애들이 있으면 0을 빼주기
            List<Integer> newList = new ArrayList<>();
            time++;
            for (int i = 0; i < queue.size(); i++) {
                int num = queue.get(i) - 1;
                if (num != 0) {
                    newList.add(num);
                }
            }
            queue = newList;
//            System.out.println("index = " + index);
//            for (int i = 0; i < queue.size(); i++) {
//                int num = queue.get(i);
//                System.out.print(num + " ");
//            }
//            System.out.println();


        }
        System.out.println(time);
    }
}

