package BaekJoonDP;

import java.util.Scanner;

public class BaekJoon1003 {
    static int count0;
    static int count1;
    public static int f(int k){
        // 메모이제이션을 배열로 한다
        int dp0[] = new int[k+1]; // 0의 갯수 배열
        int dp1[] = new int[k+1]; // 1의 갯수 배열
        if(k==0){

            count0 =1;
            count1 =0;
        }
        else if(k==1){

            count0=0;
            count1=1;
        }
        else{
            for(int i=2; i<=k; i++){
                dp0[0]=1;
                dp0[1]=0;
                dp1[0]=0;
                dp1[1]=1;
                dp0[i]=dp0[i-1]+dp0[i-2];
                dp1[i]=dp1[i-1]+dp1[i-2];
            }
            count0=dp0[k];
            count1=dp1[k];
        }
        return 0;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        for(int i=0; i<a; i++){
            int b = sc.nextInt();
            f(b);
            System.out.println(count0+" "+count1);
            count0=0;
            count1=0;
        }
    }
}
