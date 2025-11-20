package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드놓기_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        int index = n;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1){
                int num = queue.pollFirst();
                result[num - 1] = index;
            }else if(arr[i] == 2){
                int num1 = queue.pollFirst();
                int num2 = queue.pollFirst();

                result[num2 - 1] = index;
                queue.addFirst(num1);
            }else{
                int num = queue.pollLast();
                result[num - 1] = index;
            }
            index--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }

}
