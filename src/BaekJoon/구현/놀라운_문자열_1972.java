package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 놀라운_문자열_1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("*")) {
                break;
            }
            boolean flag = true;
            for (int i = 0; i < str.length() - 2; i++) {
                Set<String> set = new HashSet<>();
                int count = 0;
                for (int j = 0; j < str.length(); j++) {
                    StringBuilder add = new StringBuilder();
                    add.append(str.charAt(j));
                    int index = (1 + i) + j;
                    if (index >= str.length()) {
                        break;
                    }
                    add.append(str.charAt(index));
                    set.add(add.toString());
                    count++;
                }
                if (count != set.size()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(str).append(" is ").append("surprising.").append("\n");

            } else {
                sb.append(str).append(" is NOT ").append("surprising.").append("\n");
            }
        }
        System.out.println(sb);
    }
}
