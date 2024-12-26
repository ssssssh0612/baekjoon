package BaekJoon.DataStructure.Array;

import java.util.*;

public class List_구현 {
    public static void main(String[] args) {
        // 데이터 이동 시간이 생각보다 엄청 오래걸림 탐색비용은 그렇게 크게 들지 않음
        // 근데 cpu

        ArrayList al = new ArrayList();
        LinkedList ll = new LinkedList();

        System.out.println("=====순차적 추가=====");
        System.out.println("ArrayList :" + add1(al));
        System.out.println("LinkedList :" + add1(ll));
        System.out.println();

        System.out.println("=====중간추가=====");
        System.out.println("ArrayList :" + add2(al));
        System.out.println("LinkedList :" + add2(ll));
        System.out.println();

        System.out.println("=====중간삭제=====");
        System.out.println("ArrayList :" + remove2(al));
        System.out.println("LinkedList :" + remove2(ll));
        System.out.println();

        System.out.println("=====순차 삭제=====");
        System.out.println("ArrayList :" + remove1(al));
        System.out.println("LinkedList :" + remove1(ll));
        System.out.println();


//        System.out.println("======탐색=======");
//        System.out.println("ArrayList :" + search(al));
//        System.out.println("LinkedList :" + search(ll));

//        System.out.println("======중간 값 삭제======");
//        System.out.println("ArrayList :" + remove(al));
//        System.out.println("LinkedList :" + remove(ll));

    }
    public static long add1( List list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10_000_000; i++){
            list.add(i+"");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    public static long add2(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(500,"X");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    public static long remove1(List list){
        long start = System.currentTimeMillis();
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove2(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long search(List list){
        long start = System.currentTimeMillis();
        list.get(5_000_000);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove(List list){
        long start = System.currentTimeMillis();
        list.remove(5_000_000);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
