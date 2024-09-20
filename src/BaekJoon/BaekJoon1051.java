package BaekJoon;

import java.util.Scanner;

public class BaekJoon1051 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(a + b);
    }
}
//        Scanner sc = new Scanner(System.in);
//        int sum=0;
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        sc.nextLine();
//        char[][] arr = new char[a][b];
//        for (int i = 0; i < a; i++) {
//            String line = sc.nextLine();
//            for (int j = 0; j < b; j++) {
//                arr[i][j] = line.charAt(j);
//            }
//        }
//        if(a>b){
//            for(int z=0; z<b; z++){
//                for (int i = 0; i <a - z; i++) {
//                    for (int j = 0; j < b-z; j++) {
//                        if(arr[i][j]==arr[i][j+z]&&
//                                arr[i][j]==arr[i+z][j]&&
//                                    arr[i+z][j+z]==arr[i][j+z]&&
//                                        arr[i+z][j+z]==arr[i+z][j]){
//                                            if(sum<(z+1)*(z+1)){
//                                                sum=(z+1)*(z+1);
//                                            }
//                        }
//                    }
//                }
//            }
//
//        }else{
//            for(int z=0; z<a; z++){
//                for (int i = 0; i <a-z; i++) {
//                    for (int j = 0; j < b-z; j++) {
//                        if(arr[i][j]==arr[i][j+z]&&
//                                arr[i][j]==arr[i+z][j]&&
//                                arr[i+z][j+z]==arr[i][j+z]&&
//                                arr[i+z][j+z]==arr[i+z][j]){
//                            if(sum<(z+1)*(z+1)){
//                                sum=(z+1)*(z+1);
//                            }
//                        }
//                    }
//                }
//            }
//            }
//
//        if(sum==0){
//            sum=1;
//        }
//        System.out.println(sum);
//        }


