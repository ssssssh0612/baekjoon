package BaekJoon.programmers.level3;

import java.util.Arrays;

public class 숫자_게임 {
    public int solution(int[] a1, int[] a2) {
        int answer = 0;
        Arrays.sort(a1);
        Arrays.sort(a2);
        int length = a1.length;
        int index1 = 0;
        int index2 = 0;
        while (index1 < length || index2 < length) {

            if (index1 >= length || index2 >= length) {
                break;
            }
            // a2가 이길 수 있을때까지 찾기
            int num1 = a1[index1];
            int num2 = a2[index2];
            if (num2 > num1) {
                answer++;
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return answer;
    }
}

