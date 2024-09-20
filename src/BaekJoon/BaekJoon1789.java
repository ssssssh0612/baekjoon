package BaekJoon;

import java.util.Scanner;

public class BaekJoon1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long sum =0;
        long i =0;
        long result=0;
        while(true){
            i++;
            sum+=i;
            if(sum>a){
                --i;
            result=i;
            break;
            }
            else if(sum==a){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
}
