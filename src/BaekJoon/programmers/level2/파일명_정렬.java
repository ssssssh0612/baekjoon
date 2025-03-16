package BaekJoon.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 파일명_정렬 {
    static class Node {
        String head;
        int num;
        int index;

        public Node(String head, int num, int index) {
            this.head = head;
            this.num = num;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String str = files[i];
            Node node = findHead(str, i);
            list.add(node);
        }

        Comparator<Node> comparator = new Comparator<>() {
            @Override
            public int compare(Node n1, Node n2) {
                int result = n1.head.compareTo(n2.head);
                if (result != 0) {
                    return result;
                }
                result = n1.num - n2.num;
                if (result != 0) {
                    return result;
                }
                return n1.index - n2.index;
            }
        };
        Collections.sort(list, comparator);
        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = files[list.get(i).index];
        }

        return answer;
    }

    public Node findHead(String str, int tail) {
        String newStr = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = newStr.charAt(i);
            if ((int) ch >= 48 && (int) ch <= 57) {
                index = i;
                break;
            } else {
                sb.append(ch + "");
            }
        }


        StringBuilder sb1 = new StringBuilder();
        for (int i = index; i < str.length(); i++) {
            char ch = newStr.charAt(i);
            if ((int) ch >= 48 && (int) ch <= 57) {
                sb1.append(ch + "");
            } else {
                break;
            }
        }

        return new Node(sb.toString(), Integer.parseInt(sb1.toString()), tail);

    }

}
