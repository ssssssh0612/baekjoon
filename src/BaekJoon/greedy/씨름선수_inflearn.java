package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 씨름선수_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < number ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new int[]{height, weight});
        }
        int result = 0 ;
        for(int i = 0 ; i < list.size(); i++){
            int[] arr = list.get(i);
            for(int j = 0 ; j < list.size(); j++){
                int[] compare = list.get(j);
                if(arr[0] < compare[0] && arr[1] < compare[1]){
                    result++;
                }
            }
        }
        System.out.println(list.size() - result);
    }
}
