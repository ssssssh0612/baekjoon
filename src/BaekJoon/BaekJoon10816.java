package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;


public class BaekJoon10816 {
    static int binSearch(long[]a,int key){
        int count=0;
        int ps=0;
        int pl = a.length-1;
        do {
            int pc = (ps + pl) / 2;
            if (a[pc] == key) {
                a[pc]=100000000;
                Arrays.sort(a);
                count++;
            }
            else if (a[pc] < key)
                ps = pc + 1;
            else
                pl = pc - 1;
        }   while(ps<=pl);
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long arr[] = new long[a];
        for(int i=0; i<a; i++) {
            arr[i]= sc.nextLong();
        }
        Arrays.sort(arr);
        int b = sc.nextInt();
        int arr1[] = new int[b];
        int count[] = new int[b];
        for(int i=0; i<b; i++){
            arr1[i]= sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            count[i]=binSearch(arr,arr1[i]);
        }
        for(int i=0; i<b; i++){
            System.out.print(count[i]);
        }

    }
}
