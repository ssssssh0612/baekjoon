package BaekJoon;

import java.util.Scanner;

public class BaekJoon2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                int a=sc.nextInt();
            int arr[]= new int[a];     // 01132 arr
            int result[]= new int[a]; // 12345 result
            int result1[]= new int[a];// 결과값만 집어넣기
            int count = 0;
            for(int i=0; i<a; i++){
                arr[i]=sc.nextInt();
                result[i]=i+1;
                result1[i]=i+1;
            }
        for(int i=0; i<a; i++){
            if(arr[i]<i) {
                for(int j = i; j > arr[i] ; j--){
                        result[j] = result[j-1];
                }
                result[arr[i]] = result1[i];
            }
            else if(arr[i]==i){
                result[arr[i]] = result1[i];
            }
        }
        for(int i=a-1; i>=0; i--){
            System.out.print(result[i]);
        }


    }

}
