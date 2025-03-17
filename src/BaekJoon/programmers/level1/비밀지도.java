package BaekJoon.programmers.level1;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // n * n;
        int[][] graph = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            convert(arr1[i], graph, i);
        }
        for (int i = 0; i < arr2.length; i++) {
            convert(arr2[i], graph, i);
        }
        String[] answer = new String[arr1.length];
        for (int i = 0; i < graph.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }


        return answer;
    }

    public static void convert(int num, int[][] graph, int start) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num == 1) {
                sb.append("1");
                break;
            }
            int namuji = num % 2;
            sb.append(namuji + "");
            num = num / 2;
        }
        if (sb.length() != graph.length) {
            int size = graph.length - sb.length();
            for (int i = 0; i < size; i++) {
                sb.append("0");
            }
        }
        sb = sb.reverse();
        // System.out.println(sb);
        for (int i = 0; i < sb.toString().length(); i++) {
            char ch = sb.toString().charAt(i);
            if (ch == '1') {
                graph[start][i] = 1;
            }
        }
    }
}
