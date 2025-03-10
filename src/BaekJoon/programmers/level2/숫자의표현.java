package BaekJoon.programmers.level2;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (sum(i, n)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean sum(int startNum, int n) {
        int sum = 0;
        if (startNum == n) {
            return true;
        }
        for (int i = startNum; i <= n; i++) {
            if (sum == n) {
                return true;
            }
            sum += i;
            if (n < sum) {
                return false;
            }
        }
        return false;
    }
}