package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 차집합_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length1 = Integer.parseInt(st.nextToken());
        int length2 = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length1; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length2; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)){
                set.remove(num);
            }
        }
        if(set.isEmpty()){
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println(list.size());
        for(Integer num : list){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
