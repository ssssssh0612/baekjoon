package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length1 = Integer.parseInt(st.nextToken());
            int length2 = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[length1];
            int[] arr2 = new int[length2];
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < length1; j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < length2; j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int count = check(arr1,arr2);
            sb.append(count).append("\n");

        }
        System.out.print(sb);
    }
    public static int check(int[] arr1, int [] arr2){
        // arr1의 값중 b의 값보다 큰거 개수
        int count = 0 ;
        for(int i = 0 ; i < arr1.length; i++){
            int num1 = arr1[i];
            for(int j = 0 ; j < arr2.length; j++){
                int num2 = arr2[j];
                if(num1 > num2){
                    count++;
                }
            }
        }
        return count;
    }
}
