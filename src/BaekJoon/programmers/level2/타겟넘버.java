package BaekJoon.programmers.level2;

public class 타겟넘버 {
    static int[] arr;
    static int result;
    static int resultCount = 0;

    public int solution(int[] numbers, int target) {
        arr = numbers;
        result = target;
        int answer = 0;
        dfs(0, -arr[0]);
        dfs(0, arr[0]);
        answer = resultCount;
        return answer / 2;
    }

    public static void dfs(int depth, int number) {
        if (depth == arr.length) {
            if (number == result) {
                resultCount++;
            }
            return;
        } else {
            if (depth + 1 == arr.length) {
                dfs(depth + 1, number);
                dfs(depth + 1, number);
            } else {
                dfs(depth + 1, number + arr[depth + 1]);
                dfs(depth + 1, number + (-arr[depth + 1]));
            }
        }
    }
}

