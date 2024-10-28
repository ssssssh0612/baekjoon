package BaekJoon.구현;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class compare예제 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        list.add(new int[]{0,0,0});
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        };
    }
}
