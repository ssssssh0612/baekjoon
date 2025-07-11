package BaekJoon.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        int index = 0;
        // 보조 컨베이어 벨트 Stack
        Stack<Integer> stack = new Stack<>();
        // 컨베이어 벨트 Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            queue.add(i + 1);
        }
        int max = 0;
        while (index < order.length) {
            if (index == 0) {
                // 무조건 뽑아야함
                for (int i = 0; i < order[index]; i++) {
                    int num = queue.poll();
                    stack.push(num);
                }
                max = stack.pop();
                index++;
                answer++;
                continue;
            }
            // 큐만 비어있는경우
            if (queue.isEmpty() && !stack.isEmpty()) {
                // 큐가 비어있으면 뽑을거 다 뽑음
                int num = order[index];
                if (num == stack.peek()) {
                    stack.pop();
                    index++;
                    answer++;
                    continue;
                } else {
                    break;
                }
            }

            // 스택만 비어있는 경우
            if (!queue.isEmpty() && stack.isEmpty()) {
                int num = order[index];
                if (num == queue.peek()) {
                    max = Math.max(queue.poll(), max);
                    answer++;
                    index++;
                    continue;
                }

                if (num > max) {
                    while (true) {
                        int peekNum = queue.peek();
                        if (peekNum == num) {
                            max = queue.poll();
                            answer++;
                            index++;
                            break;
                        } else {
                            stack.add(queue.poll());
                            continue;
                        }
                    }
                    continue;
                }

                break;

            }
            // 안비어있는 경우
            if (!queue.isEmpty() && !stack.isEmpty()) {
                int num = order[index];
                int stackNum = stack.peek();
                int queueNum = queue.peek();

                if (stackNum == num) {
                    max = Math.max(stack.pop(), max);
                    answer++;
                    index++;
                    continue;
                }

                if (queueNum == num) {
                    max = Math.max(queue.poll(), max);
                    answer++;
                    index++;
                    continue;
                }

                if (num > max) {
                    while (true) {
                        int peekNum = queue.peek();
                        if (peekNum == num) {
                            max = queue.poll();
                            answer++;
                            index++;
                            break;
                        } else {
                            stack.add(queue.poll());
                            continue;
                        }
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}

