package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 응급실_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[n];
        check[m] = true;
        int number = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            int person = Integer.parseInt(st.nextToken());
            if(i==m){
                number = person;
                queue.add(new int[]{person,1});
                list.add(person);
                continue;
            }
            queue.add(new int[]{person,0});
            list.add(person);
        }
        Collections.sort(list);
        int index = list.size() - 1;
        int result = 0;
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
//            System.out.println(person[0] + " " + person[1]);
            if(list.get(index) == person[0]){
                if(person[1] == 1){
                    result++;
                    System.out.println(result);
                    return;
                }else{
                    result++;
                    index--;
                }
            }else{
                queue.add(new int[]{person[0],person[1]});
            }
        }
    }
}
