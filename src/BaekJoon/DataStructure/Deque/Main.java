package BaekJoon.DataStructure.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            String b = st.nextToken();
            if(b.equals("push_front")){
                int c = Integer.parseInt(st.nextToken());
                deque.addFirst(c);
            }else if(b.equals("push_back")){
                int c = Integer.parseInt(st.nextToken());
                deque.addLast(c);
            }else if(b.equals("pop_front")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollFirst());
                }
            }else if(b.equals("pop_back")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollLast());
                }
            }else if(b.equals("size")){
                System.out.println(deque.size());
            }else if(b.equals("empty")){
                if(deque.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(b.equals("front")){
                if(!deque.isEmpty()){
                    System.out.println(deque.peekFirst());
                }else{
                    System.out.println(-1);
                }
            }else if(b.equals("back")){
                if(!deque.isEmpty()){
                    System.out.println(deque.peekLast());
                }else{
                    System.out.println(-1);
                }
            }
        }
    }
}
