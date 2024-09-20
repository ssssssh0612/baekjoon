package BaekJoon.구현;

import java.util.Scanner;

public class 팩토리얼_10872 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(fac(1,1));
    }
    public static int fac(int count, int result) {
        if(count == 12){
            return result;
        }else if( count == n ){
            return result;
        }else if( n == 0){
            return 1;
        }
        result = result*(count+1);

        return fac(count + 1, result);
    }

}
