package BaekJoon.구현;

import java.util.Scanner;

public class 그대로_출력하기_718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(1/2);
        boolean flag = true;
        while (flag){
            int count = 0;
            String a = sc.nextLine();
            if(!a.isEmpty()){
                System.out.println(a);
                count++;
                continue;
            }
            if(count == 0){
                flag = false;
                break;
            }
        }
    }
}
