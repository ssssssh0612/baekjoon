package BaekJoon.BaekJoon그리디;

import java.util.Scanner;

public class BaekJoon2864 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        char minChar ='5';
        char maxChar ='6';
        StringBuilder sb = new StringBuilder(a);
        StringBuilder sb1 = new StringBuilder(b);
        int max =0;
        int min =0;
        int max1 = 0;
        int min1 = 0;
        // 최소로 볼때는 5로 바꾸고
        // 최대로 볼때도 6으로 바꾸고
        // 5와 6이 없으면 그 두 숫자 그냥 출력
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)==5){  // 최대
                sb.setCharAt(i,maxChar);
            }
            else if(a.charAt(i)==6){ // 최소
                sb.setCharAt(i,maxChar);
            }
            else{
             max = Integer.parseInt(a);
             min = Integer.parseInt(b);
            }
        }
        for(int j=0; j<b.length(); j++){
            if(a.charAt(j)==5){  // 최대
                sb.setCharAt(j,maxChar);
            }
            else if(a.charAt(j)==6){ // 최소
                sb.setCharAt(j,maxChar);
            }
            else{
                max = Integer.parseInt(a);
                min = Integer.parseInt(b);
            }
        }




        System.out.println(min+" "+max);

    }
}
