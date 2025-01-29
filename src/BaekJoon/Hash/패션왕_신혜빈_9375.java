package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕_신혜빈_9375 {
    static int[] count;
    static int result;
    static int depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            Map<String, Integer> map = new HashMap<>();
            int length = Integer.parseInt(br.readLine());
            for (int j = 0; j < length; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String range = st.nextToken();
                map.put(range, map.getOrDefault(range, 1) + 1);
            }

            int[] arr = new int[map.size()];

            int index = 0;
            boolean flag = false;
            result = 0;

            if(map.size() == 1){
                for (String range : map.keySet()) {
                    System.out.println(map.get(range) - 1);
                }
                continue;
            }

            for (String range : map.keySet()) {
                int number = map.get(range);
                if(!flag){
                    result = number;
                    flag = true;
                }else{
                    result *= number;
                }
//                arr[index] = number;
//                index++;
            }
            if(length == 0){
                System.out.println(0);
            }else{
                System.out.println(result - 1);

            }

//            if(map.size() == 1){
//                System.out.println(result);
//                continue;
//            }
//
//            for(int j = 2 ; j <= arr.length; j++){
//                // 길이만큼 돌면서 백트래킹
//                depth = j;
//                count = new int[j];
//                boolean[] visited = new boolean[length];
//                backTracking(0, visited, arr, 0);
//            }
//            System.out.println(result);
        }

    }
    public static void backTracking(int number, boolean[] visited, int[] arr, int checkNum){
        if(depth == number){
            int midCount = 0;
            for(int i = 0 ; i < count.length; i++){
                if(i == 0){
                    midCount = count[i];
                }else{
                    midCount = midCount * count[i];
                }
            }
            result += midCount;
            return;
        }
        for(int i = 0 ; i < arr.length; i++){
            if(!visited[i] && i >= checkNum){
                count[number] = arr[i];
                visited[i] = true;
                backTracking(number + 1, visited, arr, i);
                visited[i] = false;
            }
        }
    }
}
