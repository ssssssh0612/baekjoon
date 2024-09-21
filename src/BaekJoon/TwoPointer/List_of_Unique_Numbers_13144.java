package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class List_of_Unique_Numbers_13144 {
    static int result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        arr = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result += a;
        for (int i = 2; i <= arr.length; i++) {
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
        boolean[] visited = new boolean[100001];
        for (int i = start; i <= end; i++) {
            if(!visited[i]) {
                visited[arr[i]] = true;
            }else{
                result++;
            }
        }
        while (checking(start) && checking(end)) {
            visited[arr[start]] = false;
            start++;
            end++;
            if (checking(end) && visited[arr[end]]){
                result++;
            }
        }
    }

    public static boolean checking(int number) {
        return number >= 0 && number < arr.length;
    }

}
