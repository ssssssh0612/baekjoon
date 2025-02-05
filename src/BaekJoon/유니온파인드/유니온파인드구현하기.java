package BaekJoon.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유니온파인드구현하기 {
    static int rootX;
    static int rootY;

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        arr = new int[k];
        for(int i = 0 ; i < k ; i ++) {
            arr[i] = i;
        }
    }
    public static int[] union(int x , int y){
        if( x > y ){
            arr[x] = y;
        }else{
            arr[y] = x;
        }
        return new int[]{x, y};
    }
    public static boolean find(int x, int y){
        findRootX(x);
        findRootY(y);
        if(rootX == rootY){
            rootX = 0;
            rootY = 0;
            return true;
        }else{
            rootX = 0;
            rootY = 0;
            return false;
        }
    }


    public static void findRootX(int number){
        if(arr[number] == number){
            rootX = number;
            return;
        }
        findRootX(arr[number]);
    }
    public static void findRootY(int number){
        if(arr[number] == number){
            rootY = number;
            return;
        }
        findRootX(arr[number]);
    }

}
