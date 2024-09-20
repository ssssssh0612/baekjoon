package CodeTree.구현.BFS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int[][] graph = new int[3][3];
        graph[0][0] = 9;
        arr[3] = 3;
        change(arr);
        System.out.println(arr[3]);
        change(graph);
        System.out.println(graph[0][0]);

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0});
        list.add(new int[]{0,0});
        list.get(0)[1]= 10;
        System.out.println(list.get(0)[1]);


    }
    public static void change(int[] arr){
        arr[3] = 13;
    }
    public static void change(int[][] arr){
        arr[0][0] = 19;

    }
}
