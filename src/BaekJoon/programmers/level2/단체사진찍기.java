package BaekJoon.programmers.level2;

public class 단체사진찍기 {
    static int[] arr = new int[8];
    static boolean[] visited = new boolean[8];
    static int resultCount = 0;

    static class Node {
        int number1;
        int number2;
        int compare;

        int compareNumber;

        public Node(int number1, int number2,
                    int compare, int compareNumber) {
            this.number1 = number1;
            this.number2 = number2;
            this.compare = compare;
            this.compareNumber = compareNumber;
        }
    }

    public int solution(int n, String[] data) {
        int answer = 0;
        // 0, 1, 2, 3, 4, 5, 6, 7
        Node[] nodeArr = new Node[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < data.length; i++) {
            String str = data[i];
            int number1 = convertNum(str.charAt(0));
            int number2 = convertNum(str.charAt(2));
            int compare = convertNum(str.charAt(3));
            int compareNumber = str.charAt(4) - '0';
            nodeArr[i] = new Node(number1, number2, compare, compareNumber);
        }
        resultCount = 0;
        backTracking(0, nodeArr);

        return resultCount;
    }

    public static int convertNum(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'F') {
            return 2;
        } else if (ch == 'J') {
            return 3;
        } else if (ch == 'M') {
            return 4;
        } else if (ch == 'N') {
            return 5;
        } else if (ch == 'R') {
            return 6;
        } else if (ch == 'T') {
            return 7;
        } else if (ch == '=') {
            return 0;
        } else if (ch == '<') {
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean checking(Node node) {
        int number1Index = 0;
        int number2Index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (node.number1 == arr[i]) {
                number1Index = i;
            }
            if (node.number2 == arr[i]) {
                number2Index = i;
            }
        }
        int number = Math.abs(number1Index - number2Index) - 1;
        // =, <, > || 0, 1, 2
        if (node.compare == 0) {
            if (number == node.compareNumber) {
                return true;
            } else {
                return false;
            }
        } else if (node.compare == 1) {
            if (number < node.compareNumber) {
                return true;
            } else {
                return false;
            }
        } else {
            if (number > node.compareNumber) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void backTracking(int depth, Node[] data) {
        if (depth == 8) {
            for (int i = 0; i < data.length; i++) {
                if (!checking(data[i])) {
                    return;
                }
            }
            resultCount++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backTracking(depth + 1, data);
                visited[i] = false;
            }
        }
    }
}
