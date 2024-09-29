package BaekJoon.구현;

import java.util.*;

public class 졸려_9519 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        Deque<Integer> queue=new LinkedList<>();
        for(int i = 1; i<=n ;i++){
            queue.add(i);
        }
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            for (int i = 0; i < m; i++) {
                if( i == m - 1){
                    list.add(queue.poll());
                }else{
                    int now = queue.poll();
                    queue.addLast(now);
                }
            }
        }
        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i)+", ");
            }
        }
        System.out.print(">");
    }
}
