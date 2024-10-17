package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘_14226 {
    static boolean[][] visited = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Queue<Pattern> queue = new LinkedList<>();
        queue.add(저장하기(new Pattern(1, 0, 0)));
        queue.add(붙여넣기(new Pattern(1, 0, 0)));
        queue.add(삭제하기(new Pattern(1, 0, 0)));
        while (!queue.isEmpty()) {
            Pattern pattern = queue.poll();
            visited[pattern.screen][pattern.copyClip] = true;
            if (pattern.screen == a) {
                System.out.println(pattern.time);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    Pattern newPattern = new Pattern(저장하기(pattern));
                    if(!visited[newPattern.screen][newPattern.copyClip]) {
                        queue.add(newPattern);
                    }
                } else if (i == 1) {
                    Pattern newPattern = new Pattern(붙여넣기(pattern));
                    if(!visited[newPattern.screen][newPattern.copyClip] && newPattern.copyClip > 0) {
                        queue.add(newPattern);
                    }
                } else if (i == 2 && pattern.screen > 0) {
                    Pattern newPattern = new Pattern(삭제하기(pattern));
                    if(!visited[newPattern.screen][newPattern.copyClip] && newPattern.screen > 0) {
                        queue.add(newPattern);
                    }
                }
            }
        }
    }

    // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
    // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
    // 화면에 있는 이모티콘 중 하나를 삭제한다.
    static class Pattern {
        int screen;
        int copyClip;
        int time;

        public Pattern(int screen, int copyClip, int time) {
            this.screen = screen;
            this.copyClip = copyClip;
            this.time = time;
        }

        public Pattern(Pattern pattern) {
            this.screen = pattern.screen;
            this.copyClip = pattern.copyClip;
            this.time = pattern.time;
        }
    }
    public static Pattern 저장하기(Pattern pattern) {
        pattern.copyClip = pattern.screen;
        pattern.time++;
        return pattern;
    }
    public static Pattern 붙여넣기(Pattern pattern) {
        pattern.screen = pattern.screen + pattern.copyClip;
        pattern.time++;
        return pattern;
    }
    public static Pattern 삭제하기(Pattern pattern) {
        pattern.screen--;
        pattern.time++;
        return pattern;
    }
}
