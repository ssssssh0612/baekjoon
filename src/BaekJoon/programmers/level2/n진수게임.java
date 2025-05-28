package BaekJoon.programmers.level2;

public class n진수게임 {
    static int N;

    public String solution(int n, int t, int m, int p) {
        N = n;
        String answer = "";
        int num = 0;
        int check = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t * m; i++) {
            sb.append(change(i));
        }
        String str = sb.toString();
        StringBuilder result = new StringBuilder();
        while (num < t * m) {
            if (check != p) {
                if (check == m) {
                    check = 1;
                } else {
                    check++;
                }
                num++;
                continue;
            }

            result.append(str.charAt(num));

            if (check == m) {

                check = 1;

            } else {
                check++;
            }

            num++;
        }

        return result.toString().toUpperCase();
    }

    public String change(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= N) {
            int cur = num % N;
            if (cur >= 10) {
                if (cur == 10) sb.append('A');
                else if (cur == 11) sb.append('B');
                else if (cur == 12) sb.append('C');
                else if (cur == 13) sb.append('D');
                else if (cur == 14) sb.append('E');
                else sb.append('F');
            } else sb.append(cur);
            num /= N; // 나누기
        }
        if (num >= 10) {
            if (num == 10) sb.append('A');
            else if (num == 11) sb.append('B');
            else if (num == 12) sb.append('C');
            else if (num == 13) sb.append('D');
            else if (num == 14) sb.append('E');
            else sb.append('F');
        } else sb.append(num);

        return sb.reverse().toString();
    }
}

