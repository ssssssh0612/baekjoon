package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빈도_정렬_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int count = 0;
        // 들어온 순서
        for(int i = 0 ; i < length; i ++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0) + 1);
            if(!map2.containsKey(num)){
                map2.put(num, count);
                count++;
            }
        }
        List<int[]> list = new ArrayList<>();

        for(Integer num : map.keySet()){
            list.add(new int[]{num, map.get(num), map2.get(num)});
        }

        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o2[1] - o1[1];
                if(result != 0){
                    return result;
                }
                return o1[2] - o2[2];
            }
        };
        Collections.sort(list,comparator);

        for(int i = 0 ; i < list.size(); i++){
            int[] arr = list.get(i);
            for(int j = 0 ; j < arr[1]; j++){
                System.out.print(arr[0] + " ");
            }
        }
    }
}
