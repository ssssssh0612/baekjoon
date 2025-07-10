package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 멀티버스2_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int spaceCount = Integer.parseInt(st.nextToken());
        int spaceLength = Integer.parseInt(st.nextToken());
        List<List<int[]>> list = new ArrayList<>();
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        };
        for (int i = 0; i < spaceCount; i++) {
            List<int[]> newList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < spaceLength; j++) {
                int num = Integer.parseInt(st.nextToken());
                newList.add(new int[]{j, num});
            }
            newList.sort(comparator);

            for (int j = 1; j < spaceLength; j++) {
                // 이전 값과 같으면 이전거 인덱스 따르기
                int num1 = newList.get(j)[1];
                int num2 = newList.get(j - 1)[1];
                if(num1 == num2){
                    newList.get(j)[0] = newList.get(j - 1)[0];
                }
            }

            list.add(newList);
        }
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < spaceCount; i++) {
            List<int[]> spaceList = list.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < spaceLength; j++) {
                sb.append(spaceList.get(j)[0]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int result = 0;
        for(String name : map.keySet()){
            if(map.get(name) > 1){
                result += combination(map.get(name));
            }
        }
        System.out.println(result);
    }
    public static int combination(int num){
        return num * (num - 1) / 2;
    }
}

// 2 5
// 1 3 4 1 1
// 1 1 1 3 4

// 1 3 4 1 2
// 1 1 2 3 4
