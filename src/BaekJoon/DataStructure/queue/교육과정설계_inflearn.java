package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계_inflearn {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str1 = br.readLine();
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            queue.add(c);
        }
        int length = str.length();
        int index = 0;
        int result = 0;
        while (!queue.isEmpty()){
            char ch = str.charAt(index);
            char checking = queue.poll();
            if (checking == ch){
                result++;
                index++;
            }
            if(index == length){
                System.out.println("YES");
                return;
            }
        }
        if(length == result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
