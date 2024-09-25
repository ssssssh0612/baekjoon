package BaekJoon.Hash;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회사에있는사람_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String human = st.nextToken();
            String check = st.nextToken();
            if(check.equals("enter")){
                set.add(human);
            }else if (check.equals("leave") && set.contains(human)){
                set.remove(human);
            }
        }
        // Set을 리스트로 변환하고 역순으로 정렬
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        // 결과 출력
        for (String name : list) {
            System.out.println(name);
        }
    }
}
