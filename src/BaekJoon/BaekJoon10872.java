package BaekJoon;

import java.util.Scanner;
public class BaekJoon10872 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int arr[] = new int[a+1];
            arr[0]=1;
            arr[1]=1;
            arr[2]=1;

            for(int i=3; i<=a; i++){
                arr[i]=arr[i-1]+arr[i-2];
            }
            System.out.println(arr[a]);
    }
}
