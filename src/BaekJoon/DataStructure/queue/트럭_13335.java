package BaekJoon.DataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트럭_13335 {
    public static class Person implements Cloneable {
        String name;
        public Person(String name){
            this.name = name;
        }
        public Object clone(){
            Object obj = null;
            try {
                obj = super.clone();

            } catch (Exception e){
            }
            return obj;
        }
    }
    public static void main(String[] args) throws IOException {


        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice"));
        list.add(new Person("Bob"));

        List<Person> listClone = new ArrayList<>(list);

        // 원본 리스트의 첫 번째 객체 수정
        list.get(0).name = "Charlie";

        System.out.println("원본 리스트: " + list.get(0).name);        // Charlie
        System.out.println("복제된 리스트: " + listClone.get(0).name); // Charlie

        List<String> list2 = new ArrayList<>();
        list2.add("sanghyen");
        list2.add("doyeon");

        List<String> newList = new ArrayList<>(list2);

        list2.set(0,"민재");
        System.out.println(newList.get(0));


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        Queue<Integer> queue = new LinkedList<>();
//        st = new StringTokenizer(br.readLine());
//        int[] queueArr = new int[n];
//        for (int i = 0; i < n; i++) {
//            queueArr[i] = Integer.parseInt(st.nextToken());
//        }
//        int index = 0;
//        int weight = queueArr[0];
//        queue.add(queueArr[index]);

        // 트럭이 올라갈 수 있으면 올라감
        // 빠지자마자 올라갈 수 있으면 올라감

    }
}
