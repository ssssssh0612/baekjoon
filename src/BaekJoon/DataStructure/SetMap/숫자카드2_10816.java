package BaekJoon.DataStructure.SetMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자카드2_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        List<Integer> list =  new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int b = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        for (int i = 0; i < a; i++) {
            int key = list.get(i);
            if(map.containsKey(list.get(i))){
                map.put(key, map.get(key) + 1);
                list.remove((Integer)i);
                i = 0;
            }
        }
        for (int i = 0; i < b; i++) {
            System.out.println(map.get(i));
        }
    }
    public static void binarySearch(int[] arr, int target) {

    }

}
