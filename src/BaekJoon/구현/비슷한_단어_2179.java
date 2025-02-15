package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 비슷한_단어_2179 {
    static String[] strArr;
    static String[] arr1 = new String[2];
    static int[] arr2 = new int[2];
    static int length = Integer.MIN_VALUE;
    static boolean[] visited;
    static PriorityQueue<Node> pq;
    static class Node{
        String str1;
        String str2;
        int index1;
        int index2;
        public Node(String str1, String str2, int index1, int index2){
            this.str1 = str1;
            this.str2 = str2;
            this.index1 = index1;
            this.index2 = index2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        strArr = new String[number];
        visited = new boolean[number];
        for(int i = 0 ; i < number; i++){
            strArr[i] = br.readLine();
        }
        Comparator<Node> comparator = new Comparator<>(){
            @Override
            public int compare(Node o1, Node o2){
                int result = o1.index1 - o2.index1;
                if(result == 0){
                    return o1.index2 - o2.index2;
                }
                return result;
            }
        };
        pq = new PriorityQueue<>(comparator);
        backTracking(0, 0);
        Node node = pq.poll();
        System.out.println(node.str1);
        System.out.println(node.str2);
    }
    public static void backTracking(int depth, int number){
        if(depth == 2){
            // 길이가 최신화 되면
            String str1 = arr1[0];
            String str2 = arr1[1];
            int index1 = arr2[0];
            int index2 = arr2[1];
            int min = Math.min(str1.length(), str2.length());
            if(min < length){
                return;
            }else{
                // 최신화 하고 리턴
                int newLength = checking(str1, str2, min);
                if(newLength == length){
                    pq.add(new Node(str1, str2, index1, index2));
                }else if(newLength > length){
                    length = newLength;
                    pq.clear();
                    pq.add(new Node(str1, str2, index1, index2));
                }
            }
            return;
        }
        for(int i = 0 ; i < strArr.length; i++){
            if(!visited[i] && i >= number){
                arr1[depth] = strArr[i];
                arr2[depth] = i;
                visited[i] = true;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }
    public static int checking(String str1, String str2, int minLength){
        int index = 0;
        int newLength = 0;
        while(index < minLength){
            char ch1 = str1.charAt(index);
            char ch2 = str2.charAt(index);
            if(ch1 == ch2){
                newLength++;
                index++;
            }else{
                break;
            }
        }
        return newLength;
    }
}
