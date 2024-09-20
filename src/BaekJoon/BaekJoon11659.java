package BaekJoon;

import java.util.Scanner;

public class BaekJoon11659 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int arr[]= new int[a];
        int arrfix[] = new int[a+1];
        for(int i=0; i<a; i++){
            arr[i]= sc.nextInt();
        }
        for(int i=0; i<b; i++){
            int c = sc.nextInt();
            int d = sc.nextInt();
            int sum=0;
            for(int j =c-1; j<d; j++ ){
                sum=sum+arr[j];
            }
            System.out.println(sum);
        }
    }
}
