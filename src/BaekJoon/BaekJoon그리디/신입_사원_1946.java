package BaekJoon.BaekJoon그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 신입_사원_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            input(br);
        }
    }
    public static void input(BufferedReader br) throws IOException {
        int number = Integer.parseInt(br.readLine());
        List<int[]> check1 = new ArrayList<>();
        boolean flag = true;
        for(int i = 0 ; i < number; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            // 둘중 하나라도 1이면 저장하기
            if(arr[0] == 1 && arr[1] == 1){
                flag = false;
            }
            check1.add(arr);
        }
        Comparator<int[]> comparator1 = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        };
        Collections.sort(check1, comparator1);
        int num2 = check1.get(0)[1];
        int count = 1;
        for(int i = 0 ; i < check1.size(); i++){
            int[] arr = check1.get(i);
            if(num2 > arr[1]){
                count++;
//                System.out.println("num2 =" + num2 + "arr[1] = " + arr[1]);
                num2 = arr[1];
            }
        }
        System.out.println(count);
    }
}

//1
//5
//1 3
//2 2
//3 4
//4 5
//5 1