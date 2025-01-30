package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 창고다각형_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 인덱스
            int a = Integer.parseInt(st.nextToken());
            // 길이
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }

        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1 , int[] o2){
                return o1[0] - o2[0];
            }
        };

        Comparator<int[]> comparatorValue = new Comparator<>(){
            @Override
            public int compare(int[] o1 , int[] o2){
                int result = o2[1] - o1[1];
                if(result != 0){
                    return result;
                }
                return o2[0] - o1[0];
            }
        };
        // 최대 위치 찾기
        Collections.sort(list, comparatorValue);

        int maxIndex = list.get(0)[0];

        Collections.sort(list, comparator);

        int[] arr = new int[1001];
        for(int i = 0 ; i < list.size(); i++){
            int index = list.get(i)[0];
            int value = list.get(i)[1];
            arr[index] = value;
        }
        int result = 0;

        int value = 0;
        for(int i = list.get(0)[0]; i < maxIndex; i++){
            if(value < arr[i]){
                value = arr[i];
                result += value;
                continue;
            }
            result += value;
        }
        result += arr[maxIndex];
        value = 0;
        for(int i = list.get(list.size() - 1)[0]; i > maxIndex; i--){
            if(value < arr[i]){
                value = arr[i];
                result += value;
                continue;
            }
            result += value;
        }

        System.out.println(result);
    }
}
