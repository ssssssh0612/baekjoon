package BaekJoon;

import java.util.Scanner;

public class BaekJoon2742 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int count =0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)==' '&& i!=0 && i!=a.length()-1){
                count++;
            }
        }
        if(a!="")
        System.out.println(count+1);
        else{
            System.out.println(0);
        }
    }
}


