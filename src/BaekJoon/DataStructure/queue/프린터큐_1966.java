package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                if(j == number){
                    queue.offer(new int[]{num, 1});
                }else{
                    queue.offer(new int[]{num, 0});
                }
            }
            Collections.sort(list,Collections.reverseOrder());
            int index = 0;
            int count = 0;
            while (!queue.isEmpty()) {
                int num = list.get(index);
                int[] nums = queue.poll();
                if(nums[0] == num){
                    if(nums[1] == 1){
                        System.out.println(++count);
                        break;
                    }else{
                        count++;
                        index++;
                    }
                }else{
                    queue.offer(nums);
                }
            }
        }
    }
}
