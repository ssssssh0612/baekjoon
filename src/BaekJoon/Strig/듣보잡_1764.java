package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 3
//        int m = Integer.parseInt(st.nextToken()); // 4
//        int[] arr = new int[n];
//        List<String> list = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        List<String> result = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
////            list.add(br.readLine());
//            set.add(br.readLine());
//        }
//
//        for (int i = 0; i < m; i++) {
//            String a = br.readLine();
//            int number = set.size();
//            set.add(a);
//            if(number == set.size()){
//                result.add(a);
//            }
//        }
//        System.out.println(result.size());
//        Collections.sort(result);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }
//
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 3
        int m = Integer.parseInt(st.nextToken()); // 4
        Set<String> list = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(list.contains(str)){
                result.add(str);
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
