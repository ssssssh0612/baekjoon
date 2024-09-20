package BaekJoon;

import java.util.Scanner;

public class BaekJoon1463 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int count =0;
        while(true){

             if((a-1)%3==0){
                a=a-1;
                count++;
                a=a/3;
                count++;
            }
            else if(a%2==0){
                    a=a/2;
                    count++;
                }
            else if(a%3==0){
                a=a/3;
                count++;
            }
            else if(a%3==0 && a%2==0){
                a=a/3;
                count++;
            }
            else if(a==1){
                System.out.println(count);
                break;
            }

            else{
                a=a-1;
                count++;
            }

        }
    }
}
