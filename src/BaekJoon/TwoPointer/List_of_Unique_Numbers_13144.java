package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class List_of_Unique_Numbers_13144 {
    static int result = 0;
    static List<Integer> arr = new ArrayList<Integer>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            max = Math.max(max, arr.get(i));
        }
        result += a;
        for (int i = 2; i <= arr.size(); i++) {
            arrLength(i);
        }
        System.out.println(result);
    }

    public static void arrLength(int length) {
        // 만약 길이가 2면
        // 0 1 이 길이가 2니까 length를 1빼야함
        int start = 0;
        int end = length - 1;
        // 내가 보는 구간의 arr이 겹치는지 체크함
        int[] visited = new int[max+1];
        boolean check = true;
        for (int i = start; i <= end; i++) {
            if(visited[arr.get(i)] == 0) {
                visited[arr.get(i)]++;
            }else{
                visited[arr.get(i)]++;
                check = false;
            }
        }
        if (check){
            result++;
        }
        while (checking(start) && checking(end)) {
            visited[arr.get(start)]--;
            start++;
            end++;
            if (checking(end)){
                if(visited[arr.get(end)] == 0){
                    result++;
                    visited[arr.get(end)]++;
                }else{
                    visited[arr.get(end)]++;
                }
            }else{
                break;
            }
        }
    }

    public static boolean checking(int number) {
        return number >= 0 && number < arr.size();
    }

}
