package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
//        Queue<Integer> queue = new LinkedList<>();
        List<Integer> queue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                queue.add(number);
            }else if(a.equals("pop")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.get(0));
                    queue.remove(0);
                }
            }else if(a.equals("size")) {
                System.out.println(queue.size());
            }else if(a.equals("empty")) {
                if(queue.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(a.equals("front")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.get(0));
                }
            }else if(a.equals("back")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.get(queue.size()-1));
                }
            }
        }
    }
}
