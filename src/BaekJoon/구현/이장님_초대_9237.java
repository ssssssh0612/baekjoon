package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이장님_초대_9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++ ){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Collections.reverseOrder());

        int[] arr = new int[n];
        int index = list.size() - 1;
        for(int i = 0 ; i < list.size(); i++){
            arr[i] = list.get(i);
            arr[i] = arr[i] - index;
            index--;
        }

//        for(int i= 0 ; i < arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }
        int max = Arrays.stream(arr).max().getAsInt();
        int number = list.size() + 1;

        System.out.println(number + max);
    }
}
// 6
// 39 39 38 35 20 9
// 39
// 38 39
// 37 38 38
// 36 37 37 35
// 35 36 36 34 20
// 34 35 35 33 19 8

// 5
// 6 6 6 6 6
// 6
// 5 6
// 4 5 6
// 3 4 5 6
// 2 3 4 5 6


// 4
// 4 3 3 2
// 4
// 3 3
// 2 2 3
// 1 1 2 2

