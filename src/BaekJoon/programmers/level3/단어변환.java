package BaekJoon.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    static class Node {
        String name;
        int count;

        public Node(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public static int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.name.equals(target)) {
                return now.count;
            }
            for (int i = 0; i < words.length; i++) {
                if (checking(now, words[i], i, visited)) {
                    queue.add(new Node(words[i], now.count + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

    public static boolean checking(Node now, String next,
                                   int index, boolean[] visited) {
        boolean checking = false;
        // 현재 now랑 next랑 길이가 같은가
        if (now.name.length() != next.length()) return false;

        int count = 0;

        for (int i = 0; i < next.length(); i++) {
            if (now.name.charAt(i) != next.charAt(i)) {
                count++;
            }
        }

        if (count == 1 && !visited[index]) {
            return true;
        } else {
            return false;
        }
    }
}