package BaekJoon.programmers.level3;

public class 정수삼각형 {
    static int[] dy = {1, 1};
    static int[] dx = {0, 1};

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        dp[0][0] = triangle[0][0];
        dp[dy[0]][dx[0]] = dp[0][0] + triangle[dy[0]][dx[0]];
        dp[dy[1]][dx[1]] = dp[0][0] + triangle[dy[1]][dx[1]];

        for (int i = 1; i < triangle.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k < 2; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    dp[nextY][nextX] = Math.max(dp[i][j] + triangle[nextY][nextX], dp[nextY][nextX]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < triangle.length; i++) {
            max = Math.max(dp[triangle.length - 1][i], max);
        }

        int answer = max;
        return answer;
    }
}
