package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 로또_6603 {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            List<Integer> list  = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            visited = new boolean[n];
            arr = new int[6];
            backTracking(0,list,0);
            System.out.println();
        }
    }
    public static void backTracking(int depth, List<Integer> list, int index){
        if(depth == 6){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i]&& index <= i ){
                visited[i] = true;
                arr[depth] = list.get(i);
                backTracking(depth + 1, list,i);
                visited[i] = false;
            }
        }
    }
}
