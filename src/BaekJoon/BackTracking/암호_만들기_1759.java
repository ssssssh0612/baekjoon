package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 암호_만들기_1759 {
    static int l;
    static int c;
    static List<Character> list = new ArrayList<>();
    static boolean[] visited;
    static char[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 이루어진 갯수
        l = sc.nextInt();
        // 총 개수
        c = sc.nextInt();
        arr = new char[l];
        visited = new boolean[c];
        sc.nextLine();
        String a = sc.nextLine();
        for (int i = 0; i < a.length(); i++) {
            if(!(a.charAt(i) == ' ')){
                list.add(a.charAt(i));
            }
        }
        Collections.sort(list);
        backTracking(0,0);
    }

    public static void backTracking( int depth , int index ){
        if( depth == l){
            if(checking()){
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
                return;
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visited[i] && index <= i){
                visited[i] = true;
                arr[depth] = list.get(i);
                backTracking(depth+1,i);
                visited[i] = false;
            }
        }
    }

    public static boolean checking(){
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            //a, e, i, o, u
            if( arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                count++;
            }else{
                count1++;
            }
        }
        if( count == 0 || count1 <=1 ){
            return false;
        }else{
            return true;
        }
    }
}
