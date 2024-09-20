package BaekJoon;

import java.util.Scanner;

public class BaekJoon11170 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int count =0;
        for(int i =0; i<a; i++){
            int b=sc.nextInt();
            int c=sc.nextInt();
            for(int j = b; i<c; j++){
                String str = Integer.toString(j);
                if(str.contains("0")){
                    count++;
                }
            }
            System.out.println(count);
            count =0;
        }
    }
}
