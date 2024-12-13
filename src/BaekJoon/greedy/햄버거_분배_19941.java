package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거_분배_19941 {
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = input(br);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println(step(arr));

    }
    public static int step(int[] arr){
        boolean[] visited = new boolean[arr.length];
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            // 사람인경우
            boolean flag = false;
            if(arr[i] == 1){
                // 현재 위치에서 k 번 빼기
                // 가장 멀리있는햄버거부터 먹어야함
                for (int j = i - k; j < i ; j++) {
                    if( j >= 0 && j < arr.length && arr[j] == 0 && !visited[j] ){
                        visited[j] = true;
                        result++;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    for(int j = i + 1; j <= i + k; j ++ ){
                        if( j >= 0 && j < arr.length && arr[j] == 0 && !visited[j] ){
                            visited[j] = true;
                            result++;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println();
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(visited[i]+ " ");
//        }
        return result;
    }
    public static int[] input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        int[] arr = new int[length];
        // 20 1
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if( ch == 'H'){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }
        return arr;
    }
}
