package BaekJoon그리디;

import java.util.Scanner;

public class BaekJoon10162 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        int countA = 0;
        int countB = 0;
        int countC = 0;

        int countA1 = 300;
        int countB1 = 60;
        int countC1 = 10;
        if (a % 10 == 0) {

            while (true) {
                if (a - countA1 >= 0) {
                    a = a - countA1;
                    countA++;
                } else if (a - countB1 >= 0) {
                    a = a - countB1;
                    countB++;
                } else if (a - countC1 >= 0) {
                    a = a - countC1;
                    countC++;
                } else if (a == 0) {
                    break;
                }
            }
            System.out.println(countA+" "+countB+" "+countC);
        }
        else{
            System.out.println(-1);
        }
    }
}
