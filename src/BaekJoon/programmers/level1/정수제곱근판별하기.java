package BaekJoon.programmers.level1;

public class 정수제곱근판별하기 {
    public long solution(long n) {
        long answer = 0;
        long num = (long) Math.sqrt(n);

        if (num * num == n) {
            return (num + 1) * (num + 1);
        } else {
            return -1;
        }
    }
}
