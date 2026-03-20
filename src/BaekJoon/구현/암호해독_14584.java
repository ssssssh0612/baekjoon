package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호해독_14584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String add = br.readLine();
            arr[i] = add;
        }

        for (int i = 1; i <= 26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                int ch = str.charAt(j) - 'a';
                for (int k = 0; k < i; k++) {
                    ch -= 1;
                    if(ch == -1){
                        ch = 25;
                    }
                }
                char newCh = (char)(ch + 'a');
                sb.append(newCh);
            }

            for (String s : arr) {
                if (sb.toString().contains(s)) {
                    System.out.println(sb);
                    return;
                }
            }

        }


    }
}
