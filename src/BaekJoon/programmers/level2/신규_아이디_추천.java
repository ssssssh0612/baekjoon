package BaekJoon.programmers.level2;

public class 신규_아이디_추천 {
    static String result = "";

    public String solution(String new_id) {
        result = new_id;
        step1();
        step2();
        step3();
        step4();
        step5();
        step6();
        step7();
        return result;
    }

    public static void step1() {
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        result = result.toLowerCase();
    }

    public static void step2() {
        // new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를
        // 제외한 모든 문자를 제거합니다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            int ch = (int) result.charAt(i);
            char ch1 = result.charAt(i);
            if (checking(ch)) {
                sb.append(ch1 + "");
            }
        }
        result = sb.toString();
    }

    public static void step3() {
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        StringBuilder sb = new StringBuilder();
        // 46
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if ((int) result.charAt(i) == 46) {
                count++;
            } else {
                count = 0;
            }
            if (count < 2) {
                sb.append(result.charAt(i) + "");
            }
        }
        result = sb.toString();
    }

    public static void step4() {
        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        System.out.println("result = " + result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if ((i == 0) || (i == result.length() - 1)) {
                if ((int) result.charAt(i) != 46) {
                    sb.append(result.charAt(i) + "");
                }
            } else {
                sb.append(result.charAt(i) + "");
            }
        }
        result = sb.toString();
    }

    public static void step5() {
        if (result.equals("")) {
            result = result + "a";
        }
    }

    // 6단계 new_id의 길이가 16자 이상이면,
    // new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    public static void step6() {
        if (result.length() >= 16) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                if (i == 14) {
                    if ((int) result.charAt(i) == 46) {
                        continue;
                    }
                }
                sb.append(result.charAt(i) + "");
            }

            result = sb.toString();
        }
    }

    // new_id의 길이가 2자 이하라면,
    // new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    public static void step7() {
        if (result.length() <= 2) {
            // 1 또는 2
            if (result.length() == 1) {
                // 그럼 두번 반복
                char ch = result.charAt(0);
                for (int i = 0; i < 2; i++) {
                    result = result + ch;
                }
            } else {
                char ch = result.charAt(1);
                for (int i = 0; i < 1; i++) {
                    result = result + ch;
                }
            }
        }
    }

    public static boolean checking(int num) {
        if ((48 <= num && num <= 57) || (97 <= num && num <= 122)
                || (num == 45) || (num == 46) || (num == 95)) {
            return true;
        } else {
            return false;
        }

    }
}
