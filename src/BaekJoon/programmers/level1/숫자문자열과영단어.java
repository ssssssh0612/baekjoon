package BaekJoon.programmers.level1;

public class 숫자문자열과영단어 {
    static int staticIndex;

    public int solution(String s) {
        int answer = 0;
        // 일단 문자를 3, 4, 5 개로 잘라보기
        int index = 0;
        staticIndex = 0;
        System.out.println((int) '0');
        System.out.println((int) '9');
        StringBuilder sb = new StringBuilder();

        String[] str = new String[]{"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};
        while (index < s.length()) {
            int num = (int) s.charAt(index);
            if (num >= 48 && num <= 57) {
                sb.append(s.charAt(index) + "");
                index++;
                continue;
            }

            // 현재 인덱스에서 3개로 잘라보기
            String s1 = cut(index, 3, s);
            // 현재 인덱스에서 4개로 잘라보기
            String s2 = cut(index, 4, s);
            // 현재 인덱스에서 5개로 잘라보기
            String s3 = cut(index, 5, s);

            // s1, s2, s3와 같은게 있는지 확인하기
            if ((s1 != "") && checking(str, s1)) {
                index += 3;
                sb.append(staticIndex + "");
                continue;
            }

            if ((s2 != "") && checking(str, s2)) {
                index += 4;
                sb.append(staticIndex + "");
                continue;
            }

            if ((s3 != "") && checking(str, s3)) {
                index += 5;
                sb.append(staticIndex + "");
                continue;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static boolean checking(String[] str, String s1) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(s1)) {
                staticIndex = i;
                return true;
            }
        }
        return false;
    }

    public static String cut(int index, int length, String s) {
        if ((index + (length - 1)) >= s.length()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < index + length; i++) {
            sb.append(s.charAt(i) + "");
        }
        return sb.toString();
    }
}