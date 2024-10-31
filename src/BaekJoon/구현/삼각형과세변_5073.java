package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼각형과세변_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Equilateral :  세 변의 길이가 모두 같은 경우
        //Isosceles : 두 변의 길이만 같은 경우
        //Scalene : 세 변의 길이가 모두 다른 경우
        //invalid : 삼각형이 되지 않는경우 가장 긴변의 길이보다 나머지 두변의 길이의 합이 길지 않으면
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            int count = 0;
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 0) {
                    count++;
                }
            }
            if (count == 3) {
                break;
            }

            Arrays.sort(arr);
            // invalid 조건 넣기
//            for (int i = 0; i < 3; i++) {
//                System.out.print(arr[i] + " ");
//            }

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Equilateral");
                continue;
            }

            if (arr[2] >= arr[0] + arr[1]) {
                System.out.println("Invalid");
                continue;
            }

            if (arr[0] != arr[1] && arr[1] != arr[2] && arr[2] != arr[0]) {
                System.out.println("Scalene");
                continue;
            }

            if ((arr[0] == arr[1]) ||(arr[1] == arr[2])) {
                System.out.println("Isosceles");
            }
        }
    }
}
