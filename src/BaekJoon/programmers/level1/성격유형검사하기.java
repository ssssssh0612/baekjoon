package BaekJoon.programmers.level1;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] graph = new char[4][2];
        int[][] result = new int[4][2];
        graph[0][0] = 'T';
        graph[0][1] = 'R';
        graph[1][0] = 'C';
        graph[1][1] = 'F';
        graph[2][0] = 'J';
        graph[2][1] = 'M';
        graph[3][0] = 'A';
        graph[3][1] = 'N';

        for (int i = 0; i < choices.length; i++) {
            int num = choices[i];
            String str = survey[i];
            if (num != 4) {
                // 몇쪽에 몇점을 더해줘야하는지
                int[] check = checking(num);
                int find = (int) str.charAt(check[0]);
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (find == graph[j][k]) {
                            result[j][k] += check[1];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int num1 = result[i][0];
            int num2 = result[i][1];
            char ch1 = graph[i][0];
            char ch2 = graph[i][1];
            if (num1 > num2) {
                sb.append(ch1 + "");
            } else if (num1 < num2) {
                sb.append(ch2 + "");
            } else {
                if (ch1 > ch2) {
                    sb.append(ch2 + "");
                } else {
                    sb.append(ch1 + "");
                }
            }
        }

        return sb.toString();
    }

    public static int[] checking(int num) {
        int[] arr = new int[2];
        if (num > 0 && num < 4) {
            arr[0] = 0;
            if (num == 1) {
                arr[1] = 3;
            } else if (num == 2) {
                arr[1] = 2;
            } else {
                arr[1] = 1;
            }
        } else {
            arr[0] = 1;
            if (num == 5) {
                arr[1] = 1;
            } else if (num == 6) {
                arr[1] = 2;
            } else {
                arr[1] = 3;
            }
        }
        return arr;
    }
}
