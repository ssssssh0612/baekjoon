package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열합치기_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr1Length = Integer.parseInt(st.nextToken());
        int arr2Length = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[arr1Length];
        int[] arr2 = new int[arr2Length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr1Length; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr2Length; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[arr1Length + arr2Length];

        int pointer1 = 0;
        int pointer2 = 0;

        for(int i = 0; i < arr.length; i++){
            if(checking(arr1, pointer1) && checking(arr2, pointer2)){
                int number1 = arr1[pointer1];
                int number2 = arr2[pointer2];
                // 둘중 더 작은놈을 넣어주기
                if(number1 <= number2){
                    arr[i] = number1;
                    pointer1++;
                }else{
                    arr[i] = number2;
                    pointer2++;
                }
            }else{
                if(checking(arr1, pointer1)){
                    arr[i] = arr1[pointer1];
                    pointer1++;
                }else{
                    arr[i] = arr2[pointer2];
                    pointer2++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static boolean checking(int[] arr, int pointer){
        if(pointer >= arr.length){
            return false;
        }else{
            return true;
        }
    }
}
