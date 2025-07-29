package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if(x == y){
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = 1_000_000_000;
        int target = (int)((long)y * 100 / x);
        while(left < right){
            int mid = (left + right)/2;
            if(checking(y,x,mid,target)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(left == 1_000_000_000){
            int newY = y + left;
            int newX = x + left;
            double b = (double) newY / newX * 100;
            int newTarget = (int)b;
            if(target != newTarget){
                System.out.println(left);
            }else{
                System.out.println(-1);
            }
        }else{
            System.out.println(left);
        }

    }

    public static boolean checking(int y, int x, int addNum, int target){
        int newY = y + addNum;
        int newX = x + addNum;
        int newTarget = (int)((long)newY * 100 / newX);
        return target != newTarget;
    }
}
