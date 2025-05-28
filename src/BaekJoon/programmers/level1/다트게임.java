package BaekJoon.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 다트게임 {
    public int solution(String dartResult) {
        List<int[]> list = new ArrayList<>();
        // 0번째는 점수
        // 1번째는 곱하는 횟수
        // *은 2
        // #은 -1
        // 없으면 0
        int index = 0;
        while (index < dartResult.length()) {

            int[] arr = new int[4];
            boolean flag = false;
            char ch = dartResult.charAt(index);
            if (ch == '1') {
                // 숫자 1이 나왔는데 index가 작을 수 없음
                // 다음이 0인지 확인
                char check = dartResult.charAt(index + 1);
                if (check == '0') {
                    arr[0] = 10;
                    flag = true;
                } else {
                    arr[0] = 1;
                }
            } else {
                arr[0] = ch - '0';
            }
            if (flag) {
                char newCh = dartResult.charAt(index + 2);
                if (newCh == 'S') {
                    arr[1] = 1;
                } else if (newCh == 'D') {
                    arr[1] = 2;
                } else {
                    arr[1] = 3;
                }

                // 다음이 범위에 안들어오면
                if (index + 3 == dartResult.length()) {
                    // 리스트에 추가하고 종료하기
                    list.add(arr);
                    break;
                }

                char ch2 = dartResult.charAt(index + 3);

                if (ch2 == '*' || ch2 == '#') {
                    // 둘중 하나면 arr에 추가해야함
                    if (ch2 == '*') {
                        arr[2] = 2;
                    } else {
                        arr[2] = -1;
                    }
                    list.add(arr);
                    index = index + 4;
                } else {
                    list.add(arr);
                    index = index + 3;
                }

                continue;
            }


            // 인덱스가 1번째일경우
            char ch1 = dartResult.charAt(index + 1);
            if (ch1 == 'S') {
                arr[1] = 1;
            } else if (ch1 == 'D') {
                arr[1] = 2;
            } else {
                arr[1] = 3;
            }

            // 다음이 범위에 안들어오면
            if (index + 2 == dartResult.length()) {
                // 리스트에 추가하고 종료하기
                list.add(arr);
                break;
            }

            char ch2 = dartResult.charAt(index + 2);

            if (ch2 == '*' || ch2 == '#') {
                // 둘중 하나면 arr에 추가해야함
                if (ch2 == '*') {
                    arr[2] = 2;
                } else {
                    arr[2] = -1;
                }
                list.add(arr);
                index = index + 3;
            } else {
                list.add(arr);
                index = index + 2;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            arr[3] = newNum(arr[0], arr[1]);
            if (arr[2] != 0) {
                if (arr[2] == 2) {
                    // 현재꺼와 저번꺼 2 곱해주기
                    if (i == 0) {
                        arr[3] = arr[3] * 2;
                    } else {
                        arr[3] = arr[3] * 2;
                        list.get(i - 1)[3] = list.get(i - 1)[3] * 2;
                    }
                } else {
                    if (i == 0) {
                        arr[3] = arr[3] * (-1);
                    } else {
                        arr[3] = arr[3] * (-1);
                    }
                }
            }
        }
        int answer = 0;
        for (int[] arr : list) {
            answer += arr[3];
        }

        return answer;
    }

    public static int newNum(int num, int count) {
        if (count == 1) {
            return num;
        } else if (count == 2) {
            return num * num;
        } else {
            return num * num * num;
        }
    }
}
