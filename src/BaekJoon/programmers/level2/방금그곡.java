package BaekJoon.programmers.level2;

import java.util.*;

public class 방금그곡 {
    static class Node {
        String str;
        int length;
        int start;

        public Node(String str, int length, int start) {
            this.str = str;
            this.length = length;
            this.start = start;
        }
    }

    public String solution(String m, String[] musicinfos) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            int startNum = convert(st.nextToken());
            int endNum = convert(st.nextToken());
            String title = st.nextToken();
            String[] strArr = convertSong(st.nextToken());
            // strArr에 맞게 추가해주기
            int index = 0;
            int strIndex = 0;
            int time = Math.abs(startNum - endNum);
            String[] sb = new String[time];
            while (index < time) {
                sb[index] = strArr[strIndex];
                index++;
                strIndex++;
                if (strIndex == strArr.length) {
                    strIndex = 0;
                }
            }
            // System.out.println("!!");
            // for(int j = 0 ; j < sb.length; j++){
            // System.out.print(sb[j] + " ");
            // }
            // System.out.println();
            if (checking(m, sb)) {
                list.add(new Node(title, time, i));
            }
        }

        if (list.size() == 0) {
            return "(None)";
        } else if (list.size() == 1) {
            return list.get(0).str;
        } else {
            Comparator<Node> comparator = new Comparator<>() {
                @Override
                public int compare(Node n1, Node n2) {
                    int result = n2.length - n1.length;
                    if (result != 0) {
                        return result;
                    }
                    return n1.start - n2.start;
                }
            };

            Collections.sort(list, comparator);
            return list.get(0).str;
        }
    }

    public static boolean checking(String m, String[] str) {
        String[] str1 = convertSong(m);

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < str.length - (str1.length) + 1; i++) {
            // a b c d e
            // 0 1 2 3 4
            int count = 0;
            for (int j = 0; j < str1.length; j++) {
                String a = str[i + j];
                String b = str1[j];
                if (a.equals(b)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == str1.length) {
                return true;
            }
        }
        return false;
    }

    public static String[] convertSong(String str) {
        List<String> strList = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            char ch = str.charAt(index);
            if (index != str.length() - 1 && str.charAt(index + 1) == '#') {
                String addStr = ch + "#";
                strList.add(addStr);
                index += 2;
            } else {
                strList.add(ch + "");
                index++;
            }
        }
        String[] result = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            // System.out.print(strList.get(i) + " ");
            result[i] = strList.get(i);
        }
        // System.out.println();
        return result;
    }

    public static int convert(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        int hour = Integer.parseInt(st.nextToken()) * 60;
        int minute = Integer.parseInt(st.nextToken());
        return hour + minute;
    }
}
