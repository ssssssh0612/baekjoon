package BaekJoon.programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장많이받은선물 {
    static class Node {
        String name;
        Map<String, Integer> give;
        Map<String, Integer> accept;
        int count;

        public Node(String name
                , Map<String, Integer> give
                , Map<String, Integer> accept) {
            this.name = name;
            this.give = give;
            this.accept = accept;
            this.count = 0;
        }
    }

    static Map<String, Integer> result = new HashMap<>();
    static Map<String, Integer> result1 = new HashMap<>();
    static Map<String, Node> map = new HashMap<>();

    public int solution(String[] friends, String[] gifts) {

        for (int i = 0; i < friends.length; i++) {
            String name = friends[i];
            Map<String, Integer> give = new HashMap<>();
            Map<String, Integer> accept = new HashMap<>();
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    give.put(friends[j], 0);
                    accept.put(friends[j], 0);
                }
            }
            map.put(name, new Node(name, give, accept));
        }

        for (int i = 0; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i], " ");
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            Node node1 = map.get(name1);
            Node node2 = map.get(name2);
            node1.give.put(name2, node1.give.getOrDefault(name2, 0) + 1);
            node2.accept.put(name1, node2.accept.getOrDefault(name1, 0) + 1);
        }

        for (int i = 0; i < friends.length; i++) {
            Node node = map.get(friends[i]);
            Map<String, Integer> give = node.give;
            Map<String, Integer> accept = node.accept;
            int giveCount = 0;
            int acceptCount = 0;
            for (String name : give.keySet()) {
                giveCount += give.get(name);
                acceptCount += accept.get(name);
            }
            node.count = giveCount - acceptCount;
        }

        for (int i = 0; i < friends.length; i++) {
            Node node = map.get(friends[i]);
            Map<String, Integer> give = node.give;
            Map<String, Integer> accept = node.accept;
            for (String name : give.keySet()) {
                int giveNum = give.get(name);
                int acceptNum = accept.get(name);
                if (giveNum > acceptNum) {
                    result.put(friends[i],
                            result.getOrDefault(friends[i], 0) + 1);
                } else if (giveNum == acceptNum) {
                    int count1 = node.count;
                    int count2 = map.get(name).count;
                    if (count1 > count2) {
                        result.put(friends[i],
                                result.getOrDefault(friends[i], 0) + 1);
                    }
                }
            }
        }
        int max = 0;
        for (String name : result.keySet()) {
            int num = result.get(name);
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}
