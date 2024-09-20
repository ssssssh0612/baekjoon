package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;
public class BaekJoon1920 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result=0;
        int a = sc.nextInt();
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int brr[] = new int[b];
        boolean check[] = new boolean[b];
        for (int i = 0; i < b; i++) {
            brr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
            for(int j=0; j<b; j++){
              result = binSearch(arr,arr.length,brr[j]);
              System.out.println(result);
            }





        }

    }

