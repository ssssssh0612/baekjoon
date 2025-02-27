package BaekJoon.programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    static class Node {
        int number;
        int orderTime;
        int workTime;
        int waitTime;

        public Node(int number, int orderTime, int workTime) {
            this.number = number;
            // 일 요청시간
            this.orderTime = orderTime;
            // 일 하는시간
            this.workTime = workTime;
            this.waitTime = 0;
        }
    }

    static PriorityQueue<Node> waitQueue;
    static PriorityQueue<Node> workQueue;

    public int solution(int[][] jobs) {
        Comparator<Node> comparator1 = new Comparator<>() {
            @Override
            // 작업의 소요시간이 짧은 것
            // 작업의 요청 시각이 빠른 것
            // 작업의 번호가 작은 것 순으로 우선순위가 높습니다
            public int compare(Node n1, Node n2) {
                int result = n1.workTime - n2.workTime;
                if (result != 0) {
                    return result;
                }
                result = n1.orderTime - n2.orderTime;
                if (result != 0) {
                    return result;
                }
                return n1.number - n2.number;
            }
        };

        Comparator<Node> comparator2 = new Comparator<>() {
            @Override
            // 작업의 소요시간이 짧은 것
            // 작업의 요청 시각이 빠른 것
            // 작업의 번호가 작은 것 순으로 우선순위가 높습니다
            public int compare(Node n1, Node n2) {
                return n1.orderTime - n2.orderTime;
            }
        };
        List<Node> list = new ArrayList<>();
        workQueue = new PriorityQueue<>(comparator1);
        waitQueue = new PriorityQueue<>(comparator2);
        for (int i = 0; i < jobs.length; i++) {
            int orderTime = jobs[i][0];
            int workTime = jobs[i][1];
            waitQueue.add(new Node(i, orderTime, workTime));
        }
        int time = 0;
        int resultCount = 0;
        while (true) {
            if (workQueue.isEmpty() && waitQueue.isEmpty() && list.isEmpty()) {
                break;
            }
            // 같다면 추가해주기
            while (!waitQueue.isEmpty()) {
                Node node = waitQueue.peek();
                if (node.orderTime == time) {
                    workQueue.add(waitQueue.poll());
                } else {
                    break;
                }
            }

            if (!list.isEmpty()) {
                Node node = list.get(0);
                if (node.workTime == 0) {
                    resultCount += time - node.orderTime;
                    // System.out.println("time = " + time +
                    // " orderTime = " + node.orderTime);
                    list.remove(0);
                    if (!workQueue.isEmpty()) {
                        list.add(workQueue.poll());
                        Node newNode = list.get(0);
                        workingNode(newNode);
                    }
                } else {
                    workingNode(node);
                }
                // 리스트의 첫번째 값을 참조해서
            } else {
                // workQueue 에서 하나 빼기
                if (!workQueue.isEmpty()) {
                    list.add(workQueue.poll());
                    Node node = list.get(0);
                    workingNode(node);
                }
            }
            int size = workQueue.size();


            // System.out.println("time = " + time + " resultCount = " + resultCount);
            time++;

        }

        return resultCount / jobs.length;
    }

    public static void workingNode(Node node) {
        node.waitTime++;
        node.workTime--;
    }
}
