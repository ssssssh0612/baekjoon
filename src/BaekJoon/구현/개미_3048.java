package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 개미_3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aLength = Integer.parseInt(st.nextToken());
        int bLength = Integer.parseInt(st.nextToken());

        String str1 = br.readLine();
        String str2 = br.readLine();

        int num = Integer.parseInt(br.readLine());

        char[] arr = new char[aLength + bLength];

        StringBuilder sb = new StringBuilder();

        int index = 0;
        int[] number = new int[aLength + bLength];
        for (int i = str1.length() - 1; i >= 0; i--) {
            arr[index] = str1.charAt(i);
            number[index] = 1;
            index++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[index] = str2.charAt(i);
            number[index] = 2;
            index++;
        }


        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < number.length - 1; j++) {
                if (number[j] == 1 && number[j + 1] == 2) {
                    list.add(j);
                }
            }

            for (int j = 0; j < list.size(); j++) {
                int idx = list.get(j);
                number[idx] = 2;
                number[idx + 1] = 1;
                char ch1 = arr[idx];
                char ch2 = arr[idx + 1];
                arr[idx] = ch2;
                arr[idx + 1] = ch1;
            }
            StringBuilder test = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                test.append(arr[j]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }
        System.out.println(result);

    }


}

