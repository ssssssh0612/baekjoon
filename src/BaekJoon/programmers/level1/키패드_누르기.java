package BaekJoon.programmers.level1;

public class 키패드_누르기 {
    static StringBuilder sb = new StringBuilder();
    static int[] leftHand = new int[]{3, 0};
    static int[] rightHand = new int[]{3, 2};
    static int[][] graph = new int[4][3];

    public String solution(int[] numbers, String hand) {
        String hand1 = hand.toUpperCase();
        System.out.println(hand1);
        graph[0][0] = 1;
        graph[0][1] = 2;
        graph[0][2] = 3;
        graph[1][0] = 4;
        graph[1][1] = 5;
        graph[1][2] = 6;
        graph[2][0] = 7;
        graph[2][1] = 8;
        graph[2][2] = 9;
        graph[3][0] = -1;
        graph[3][1] = 0;
        graph[3][2] = -1;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            // 무조건 왼손
            if (num == 1 || num == 4 || num == 7) {
                leftHand = click(num);
                sb.append("L");
                continue;
            }

            if (num == 3 || num == 6 || num == 9) {
                rightHand = click(num);
                sb.append("R");
                continue;
            }

            if (num == 2 || num == 5 || num == 8 || num == 0) {
                int[] pos = click(num);
                int leftNum = dis(pos, leftHand);
                int rightNum = dis(pos, rightHand);
                if (leftNum > rightNum) {
                    rightHand = pos;
                    sb.append("R");
                } else if (leftNum < rightNum) {
                    leftHand = pos;
                    sb.append("L");
                } else {
                    sb.append(hand1.charAt(0) + "");
                    if (hand1.charAt(0) == 'L') {
                        leftHand = pos;
                    } else {
                        rightHand = pos;
                    }
                }
            }

        }

        return sb.toString();
    }

    public static int[] click(int num) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (graph[i][j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int dis(int[] pos1, int[] pos2) {
        int num1 = Math.abs(pos1[0] - pos2[0]);
        int num2 = Math.abs(pos1[1] - pos2[1]);

        return num1 + num2;
    }
}
