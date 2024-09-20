package BaekJoon이분탐색;

import java.util.Scanner;

public class BaekJoon1300 {
    static int binSearch(int[]a,int n,int key){
        int ps=0;
        int pl = n-1;
        do {
            int pc = (ps + pl) / 2;
            if (a[pc] == key) {
                return 1;
            }
            else if (a[pc] < key)
                ps = pc + 1;
            else
                pl = pc - 1;
        }   while(ps<=pl);
        return 0;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count =0;
        long dp[]= new long[a*a];
        dp[0]=1;
        for(int i=1; i<=a; i++){
            for(int j=1; j<=a; j++){
                if(dp[count]<i*j){
                    count++;
                    dp[count]=i*j;
                }
            }
        }
        for(int i=0; i<a*a; i++){
            System.out.println(dp[i]);
        }

    }
}
