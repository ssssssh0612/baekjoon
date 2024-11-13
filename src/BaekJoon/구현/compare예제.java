package BaekJoon.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class compare예제 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{3,4,5});
        list.add(new int[]{1,2,3});
        list.add(new int[]{2,3,4});
        list.add(new int[]{5,6,3});
        list.add(new int[]{4,2,1});
        list.add(new int[]{5,2,9});

        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o2[0] - o1[0];
                if(result != 0){
                    return result;
                }
                result = o1[1] - o2[1];
                if(result != 0){
                    return result;
                }
                result = o1[2] - o2[2];
                if(result != 0){
                    return result;
                }
                return result;
            }
        };
        Collections.sort(list , comparator);
        for( int [] arr : list){
            System.out.println(arr[0]+" , "+arr[1] +" ," + arr[2]);
        }
    }
}
