package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 할아버지는_유명해_5766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                break;
            }

            StringBuilder sb= new StringBuilder();

            int[] arr= new int[10_001];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[num]++;
                }
            }
            List<int[]> list = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > 0){
                    list.add(new int[]{i,arr[i]});
                }
            }
            Comparator<int[]> comparator = new Comparator<>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return o2[1] - o1[1];
                }
            };
            Collections.sort(list, comparator);

            int num = list.get(1)[1];
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i)[1] == num){
                    sb.append(list.get(i)[0]).append(" ");
                }else{
                    break;
                }
            }
            System.out.println(sb);
        }
    }
}
