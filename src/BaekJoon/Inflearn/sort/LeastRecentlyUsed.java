package BaekJoon.Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LeastRecentlyUsed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);

    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new LinkedList<>();
        int arrLength = Integer.parseInt(st.nextToken());
        int[] arr = new int[arrLength];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < arr.length; i ++){
            int number = arr[i];
            if(queue.isEmpty()){
                queue.add(number);
                continue;
            }

            if(queue.contains(number)){ // 만약 포함한다면 ?
                queue.remove((Integer)number);
                queue.add(number);
            }else{
                // 만약 존재하지 않는다면
                queue.add(number);
            }
            if(queue.size() > length){
                queue.poll();
            }
        }

        while(!queue.isEmpty()){
            System.out.print(queue.pollLast()+" ");
        }
    }
}
