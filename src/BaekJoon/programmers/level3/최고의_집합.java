package BaekJoon.programmers.level3;

public class 최고의_집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int num = s / n;
        int namuji = s % n;

        if (num == 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (namuji > 0) {
                answer[i]++;
                namuji--;
            }
        }

        return answer;
    }
}
