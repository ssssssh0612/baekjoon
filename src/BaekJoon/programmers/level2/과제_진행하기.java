package BaekJoon.programmers.level2;

import java.util.*;

public class 과제_진행하기 {
    static class Task {
        String name;
        int startNum;
        int time;

        public Task(String name, int startNum, int time) {
            this.name = name;
            this.startNum = startNum;
            this.time = time;
        }
    }

    public String[] solution(String[][] plans) {

        Comparator<Task> comparator = new Comparator<>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.startNum - t2.startNum;
            }
        };

        PriorityQueue<Task> pq = new PriorityQueue<Task>(comparator);

        for (int i = 0; i < plans.length; i++) {
            String str1 = plans[i][0];
            String str2 = plans[i][1];
            int startNum = convert(str2);
            int time = Integer.parseInt(plans[i][2]);
            pq.add(new Task(str1, startNum, time));
        }

        Stack<Task> stack = new Stack<>();
        List<Task> list = new ArrayList<>();
        Task nowTask = null;
        int time = 0;
        while (time <= 300000) {
            // pq가 null이 아니라면 peek해서 시간 확인하기
            if (!pq.isEmpty() && pq.peek().startNum == time) {
                // 현재 작업중인 작업이 있는지 확인
                if (nowTask == null) {
                    nowTask = pq.poll();
                    nowTask.time--;
                    if (nowTask.time == 0) {
                        list.add(nowTask);
                        nowTask = null;
                    }
                } else {
                    nowTask.time--;
                    if (nowTask.time == 0) {
                        list.add(nowTask);
                        time++;
                        nowTask = pq.poll();
                        continue;
                    }
                    // 현재 작업하던거 Stack에 넣기
                    stack.push(nowTask);
                    nowTask = pq.poll();
                }
            } else {
                if (nowTask == null) {
                    if (!stack.isEmpty()) {
                        nowTask = stack.pop();
                        nowTask.time--;
                        if (nowTask.time == 0) {
                            list.add(nowTask);
                            nowTask = null;
                        }
                    }
                } else {
                    nowTask.time--;
                    if (nowTask.time == 0) {
                        list.add(nowTask);
                        nowTask = null;
                        if (!stack.isEmpty()) {
                            nowTask = stack.pop();
                        }
                    }
                }
            }
            time++;
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).name;
        }
        return answer;
    }

    public static int convert(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int num1 = Integer.parseInt(st.nextToken()) * 60;
        int num2 = Integer.parseInt(st.nextToken());
        return num1 + num2;
    }
}

