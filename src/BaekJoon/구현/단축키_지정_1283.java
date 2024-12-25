package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단축키_지정_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int strCase = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < strCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());

            }

            // new 가 떠야해
            check1(list, set);
            System.out.println();
        }
        // 먼저 하나의 옵션에 대해 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 살펴본다.
        // 만약 단축키로 아직 지정이 안 되어있다면 그 알파벳을 단축키로 지정한다.

        // 만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
        // 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두며 대소문자를 구분치 않는다.
        // 위의 규칙을 첫 번째 옵션부터 N번째 옵션까지 차례대로 적용한다.
    }

    public static void check1(List<String> list, Set<Character> set) {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).toUpperCase();
            if (!set.contains(str.charAt(0))) {
                set.add(str.charAt(0));
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        StringBuilder sb = new StringBuilder(list.get(j));
                        sb.insert(0, '[');
                        sb.insert(2, ']');
                        System.out.print(sb+ " ");
                    } else {
                        System.out.print(list.get(j) + " ");
                    }
                }
                return;
            }
        }

        // 그럼에도 불구하고 끝나지 않았다면
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).toUpperCase();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                // j가 인덱스
                if(!set.contains(ch)){
                    set.add(ch);
                    for (int k = 0; k < list.size(); k++) {
                        if(i == k){
                            StringBuilder sb = new StringBuilder(list.get(k));
                            // 0 위치를 감싸고 싶을경우
                            sb.insert(j, '[');
                            sb.insert(j + 2, ']');
                            System.out.print(sb + " ");
                        }else{
                            System.out.print(list.get(k) + " ");
                        }
                    }
                    return;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
