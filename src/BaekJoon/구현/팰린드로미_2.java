package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드로미_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            int length = str.length();

            int count = 0;
            int num = Integer.parseInt(str);
            if (str.equals("0")) {
                break;
            }

            while (true) {
                if (checking(str)) {
                    break;
                } else {
                    count++;
                    num++;
                    StringBuilder number = new StringBuilder();
                    int loop = length - String.valueOf(num).length();
                    for (int i = 0; i < loop; i++) {
                        number.append("0");
                    }
                    number.append(num);
                    str = number.toString();
                }
            }

            System.out.println(count);
        }
    }

    public static boolean checking(String str) {
        int index = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(index)) {
                return false;
            }
            index--;
        }
        return true;
    }
}
